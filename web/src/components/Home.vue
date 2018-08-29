<template>
  <div id="home">
    <div id="graph">
      <svg :width="gwidth" :height="gheight" class="connections-graph">
        <g>
          <line class="axis" :x1="yaxis.x1" :y1="yaxis.y1" :x2="yaxis.x2" :y2="yaxis.y2"></line>
          <line class="axis" :x1="xaxis.x1" :y1="xaxis.y1" :x2="xaxis.x2" :y2="xaxis.y2"></line>
          <polygon :points="points"></polygon>
        </g>
      </svg>
    </div>
  </div>
</template>

<script>

const apiURL = process.env.API_BASE_URL

export default {
  name: 'Home',
  data: () => {
    return {
      msg: 'Status / Overview',
      gwidth: 0,
      gheight: 0,
      maxClients: 0,
      values: [],
      startTime: new Date(),
      timer: 0
    }
  },
  mounted () {
    this.$nextTick(function () {
      let graph = document.getElementById('graph')
      this.gwidth = graph.clientWidth
      this.gheight = graph.clientWidth
    })
    this.fetchData()
    this.timer = setInterval(function () {
      this.fetchData()
    }.bind(this), 5000)
  },
  updated () {
    let graph = document.getElementById('graph')
    this.gwidth = graph.clientWidth
    this.gheight = graph.clientWidth
  },
  beforeDestroy () {
    clearInterval(this.timer)
  },
  computed: {
    // a computed property for the polygon's points
    points: function () {
      const self = this
      const heightEach = this.gheight / (this.maxClients || 1)
      const count = this.values.length
      const widthEach = count > 0 ? (this.gwidth / count) : 0
      return [
        {x: 0, y: this.gheight - ((this.values[0] || 0) * heightEach)}
      ].concat(this.values.map(function (value, i) {
        return {x: ((i + 1) * widthEach), y: self.gheight - (value * heightEach)}
      })).concat([{x: (count * widthEach), y: self.gheight}, {x: 0, y: self.gheight}]).map(function (stat) {
        return stat.x + ',' + stat.y
      }).join(' ')
    },
    yaxis: function () {
      return {
        maxValue: this.maxClients,
        x1: 0,
        y1: 0,
        x2: 0,
        y2: this.gheight
      }
    },
    xaxis: function () {
      return {
        x1: 0,
        y1: this.gheight,
        x2: this.gwidth,
        y2: this.gheight
      }
    }
  },
  methods: {
    fetchData: function () {
      const xhr = new XMLHttpRequest()
      const self = this
      xhr.open('GET', apiURL)
      xhr.onload = function () {
        const status = JSON.parse(xhr.responseText)
        let connected = status.connectedDevices.length
        self.maxClients = connected > self.maxClients ? connected * 1.25 + 1 : self.maxClients
        self.values.push(connected)
        if (self.values.length > 6) {
          self.values = self.values.slice(self.values.length - 6)
        }
      }
      xhr.send()
    }
  }
}
</script>

<style scoped>
.connections-graph {
  width: 100%;
  height: 100%;
}

#graph {
  width: 60%;
  margin-left:auto;
  margin-right:auto;
}

circle {
  fill: transparent;
  stroke: #999;
}

polygon {
  fill: #42b983;
  opacity: .75;
}

.axis {
  stroke:#111111;
  stroke-width:2;
}
</style>
