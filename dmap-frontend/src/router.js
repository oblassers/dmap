import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import MyDmps from './views/MyDmps.vue'
import Login from './views/Login.vue'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/mydmps',
      name: 'mydmps',
      component: MyDmps
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    }
  ]
})

export default router
