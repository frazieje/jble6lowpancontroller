<template>
  <div id="app" class="md-elevation-3">
    <Menu></Menu>
    <md-content>
      <router-view/>
    </md-content>
  </div>
</template>

<script>
import Menu from '@/components/Menu'

export default {
  name: 'App',
  components: {
    Menu
  }
}
</script>

<style lang="scss">
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  margin-left:auto;
  margin-right:auto;
  color: #2c3e50;
}
@media (max-width: 12450px) {
  #app {
    width: 60%;
  }
}
@media (max-width: 1800px) {
  #app {
    width: 70%;
  }
}
@media (max-width: 1200px) {
  #app {
    width: 80%;
  }
}
@media (max-width: 900px) {
  #app {
    width: 90%;
  }
}
@media (max-width: 600px) {
  #app {
    width: 100%;
  }
}
</style>
