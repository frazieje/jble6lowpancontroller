<template>
  <div id="home">
    {{ msg }}
  </div>
</template>

<script>
export default {
  name: 'Home',
  data: () => {
    return {
      msg: 'Status / Overview'
    }
  }
}
</script>
