<template>
  <div>
    <h1>MyDMPs</h1>
    <ul>
      <li v-for="dmp in dmp.dmps" :key="dmp.id" :dmp="dmp">{{ dmp }}</li>
    </ul>
  </div>
</template>

<script>
import store from '@/store/store'
import { mapState } from 'vuex'

function getDmps (routeTo, next) {
  store.dispatch('dmp/fetchDmps')
    .then(() => {
      next()
    })
}

export default {
  name: 'MyDmps',
  beforeRouteEnter (routeTo, routeFrom, next) {
    getDmps(routeTo, next)
  },
  beforeRouteUpdate (routeTo, routeFrom, next) {
    getDmps(routeTo, next)
  },
  computed: {
    ...mapState(['dmp'])
  }
}
</script>

<style scoped>

</style>
