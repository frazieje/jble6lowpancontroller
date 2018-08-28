import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Ble from '@/components/Ble'
import Wifi from '@/components/Wifi'
import Group from '@/components/Group'
import Remote from '@/components/Remote'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/ble',
      name: 'Ble',
      component: Ble
    },
    {
      path: '/wifi',
      name: 'Wifi',
      component: Wifi
    },
    {
      path: '/group',
      name: 'Group',
      component: Group
    },
    {
      path: '/remote',
      name: 'Remote',
      component: Remote
    }
  ]
})
