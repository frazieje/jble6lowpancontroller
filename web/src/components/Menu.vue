<template>
  <div id="menu">
    <md-tabs md-sync-route md-alignment="fixed">
      <md-tab id="tab-home" md-icon="pie_chart" to="/"></md-tab>
      <md-tab id="tab-ble" md-icon="bluetooth" to="/ble"></md-tab>
      <md-tab id="tab-wifi" md-icon="wifi" to="/wifi"></md-tab>
      <md-tab id="tab-group" md-icon="group_work" to="/group"></md-tab>
      <md-tab id="tab-public" md-icon="public" to="/public"></md-tab>
    </md-tabs>
  </div>
</template>

<script>
export default {
  name: 'Menu'
}
</script>

<style scoped>
#menu {
  border-bottom:1pt solid #cccccc;
}
</style>
