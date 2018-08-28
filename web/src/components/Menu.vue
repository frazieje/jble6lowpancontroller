<template>
  <div id="menu">
    <md-tabs md-sync-route md-alignment="fixed">

      <md-tab v-if="showLabels" md-label="status" id="tab-home" md-icon="pie_chart" to="/"></md-tab>
      <md-tab v-else id="tab-home" md-icon="pie_chart" to="/"></md-tab>

      <md-tab v-if="showLabels" md-label="bluetooth" id="tab-ble" md-icon="bluetooth" to="/ble"></md-tab>
      <md-tab v-else id="tab-ble" md-icon="bluetooth" to="/ble"></md-tab>

      <md-tab v-if="showLabels" md-label="wifi" id="tab-wifi" md-icon="wifi" to="/wifi"></md-tab>
      <md-tab v-else id="tab-wifi" md-icon="wifi" to="/wifi"></md-tab>

      <md-tab v-if="showLabels" md-label="group" id="tab-group" md-icon="group_work" to="/group"></md-tab>
      <md-tab v-else id="tab-group" md-icon="group_work" to="/group"></md-tab>

      <md-tab v-if="showLabels" md-label="remote" id="tab-remote" md-icon="public" to="/remote"></md-tab>
      <md-tab v-else id="tab-remote" md-icon="public" to="/remote"></md-tab>
    </md-tabs>
  </div>
</template>

<script>
export default {
  name: 'Menu',
  data: () => {
    return {
      showLabels: false
    }
  },
  created: function () {
    let matcher = matchMedia('(max-width: 900px)')
    this.render(matcher)
    matcher.addListener(this.render)
  },
  methods: {
    render: function (matcher) {
      this.showLabels = !matcher.matches
    }
  }
}
</script>

<style scoped>
#menu {
  border-bottom:1pt solid #cccccc;
}
</style>
