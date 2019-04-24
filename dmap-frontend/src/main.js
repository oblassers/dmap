import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store/store'
import loader from './loader'
import upperFirst from 'lodash/upperFirst'
import camelCase from 'lodash/camelCase'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import 'nprogress/nprogress.css'
import filters from './filters/filters'
import Treeselect from '@riophae/vue-treeselect'
import '@riophae/vue-treeselect/dist/vue-treeselect.css'

Vue.use(Vuetify)

for (let name in filters) {
  Vue.filter(name, filters[name])
}

const requireComponent = require.context(
  './components',
  false,
  /Base[A-Z]\w+\.(vue|js)$/
)

requireComponent.keys().forEach(fileName => {
  const componentConfig = requireComponent(fileName)

  const componentName = upperFirst(
    camelCase(fileName.replace(/^\.\/(.*)\.\w+$/, '$1'))
  )

  Vue.component(componentName, componentConfig.default || componentConfig)
})

Vue.component('treeselect', Treeselect)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  loader,
  render: h => h(App)
}).$mount('#app')
