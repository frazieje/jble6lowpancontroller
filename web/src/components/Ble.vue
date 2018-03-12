<template>
  <div id="ble">
    <md-list class="md-double-line">
      <md-list-item>
        <md-icon class="md-primary">bluetooth_connected</md-icon>

        <div class="md-list-item-text">
          <span>Door Lock</span>
          <span>00:AA:BB:CC:DD:EE</span>
        </div>

        <md-button class="md-icon-button md-list-action">
          <md-icon>more_horiz</md-icon>
        </md-button>
      </md-list-item>

      <md-list-item class="md-double-line">
        <md-icon class="md-secondary">bluetooth_searching</md-icon>

        <div class="md-list-item-text">
          <span>Unknown</span>
          <span>00:A2:FF:CC:D4:E7</span>
        </div>

        <md-button class="md-icon-button md-list-action">
          <md-icon>more_horiz</md-icon>
        </md-button>
      </md-list-item>
    </md-list>
  </div>
</template>

<script>
export default {
  name: 'Ble',
  data: () => {
    return {
      msg: 'Bluetooth'
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
</style>
