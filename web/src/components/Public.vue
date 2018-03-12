<template>
  <div id="public">
    {{ msg }}
  </div>
</template>

<script>
export default {
  name: 'Public',
  data: () => {
    return {
      msg: 'Public Settings'
    }
  }
}
</script>
