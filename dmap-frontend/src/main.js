import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store/store'
import loader from './loader'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import 'nprogress/nprogress.css'
import filters from './filters/filters'

Vue.use(Vuetify)

for (let name in filters) {
  Vue.filter(name, filters[name])
}

Vue.config.productionTip = false

new Vue({
  router,
  store,
  loader,
  render: h => h(App)
}).$mount('#app')
