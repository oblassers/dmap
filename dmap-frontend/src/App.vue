<template>
  <div id="app">
    <v-app>
      <NavBar></NavBar>
      <v-content>
        <v-container fluid>
          <router-view :key="$route.fullPath"/>
        </v-container>
      </v-content>
    </v-app>
  </div>
</template>

<script>
import NavBar from '@/components/NavBar'

export default {
  components: { NavBar }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
