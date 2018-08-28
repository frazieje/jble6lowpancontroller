<template>
  <div id="public">
    {{ msg }}
  </div>
</template>

<script>
export default {
  name: 'Remote',
  data: () => {
    return {
      msg: 'Remote Settings'
    }
  }
}
</script>
