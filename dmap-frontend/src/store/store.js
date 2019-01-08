import Vue from 'vue'
import Vuex from 'vuex'
import * as dmp from '@/store/modules/dmp.js'
import * as user from '@/store/modules/user.js'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    dmp,
    user
  }
})
