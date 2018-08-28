<template>
  <div id="ble">
    <md-list class="md-double-line">
      <md-list-item v-for="device in summary" :key="device.address">

        <md-icon v-if="device.status === 'connected'" class="md-primary">bluetooth_connected</md-icon>
        <md-icon v-else class="md-secondary">bluetooth_searching</md-icon>

        <div class="md-list-item-text">
          <span>{{ device.name }}</span>
          <span>{{ device.address }}</span>
        </div>

        <md-button class="md-icon-button md-list-action">
          <md-icon>more_horiz</md-icon>
        </md-button>
      </md-list-item>
    </md-list>
  </div>
</template>

<script>

const apiURL = process.env.API_BASE_URL

export default {
  name: 'Ble',
  data: () => {
    return {
      msg: 'Bluetooth',
      summary: []
    }
  },
  created: function () {
    this.fetchData()
  },
  methods: {
    fetchData: function () {
      const xhr = new XMLHttpRequest()
      const self = this
      xhr.open('GET', apiURL + '/status')
      xhr.onload = function () {
        const all = JSON.parse(xhr.responseText)
        const summaryData = []
        for (let device of all.connectedDevices) {
          summaryData.push({
            address: device.address,
            name: device.name ? device.name : 'Unknown',
            status: 'connected'
          })
        }
        for (let scan of all.availableDevices) {
          summaryData.push({
            address: scan.address,
            name: scan.name ? scan.name : 'Unknown',
            status: 'available'
          })
        }
        self.summary = summaryData
      }
      xhr.send()
    }
  }
}
</script>

<style scoped>
  .md-list {
    width: 100%;
    max-width: 100%;
    display: inline-block;
    vertical-align: top;
    border: 1px solid rgba(#000, .12);
  }
  .md-list-item {
    border-bottom: 1px solid #cccccc;
  }
  .md-list-item:last-child {
    border-bottom: none;
  }
</style>
