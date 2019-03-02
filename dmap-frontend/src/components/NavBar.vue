<template>
  <div class="nav">
    <v-toolbar
      color="blue darken-3"
      app
      dark
      fixed
    >
      <router-link :to="{ name: 'home' }" class="brand">
        <v-toolbar-title>DMap</v-toolbar-title>
      </router-link>
      <v-toolbar-items>
        <v-btn :to="{ name: 'mydmps' }" flat class="text-none">My DMP's</v-btn>
        <v-btn :to="{ name: 'dmp-create' }" flat class="text-none">Create DMP</v-btn>
      </v-toolbar-items>
      <v-spacer></v-spacer>
      <v-toolbar-items>
        <v-menu offset-y>
          <template v-slot:activator="{ on }">
            <v-btn v-on="on" flat class="text-none">
              <v-icon>account_circle</v-icon>
              <span class="user">{{ getFullName }}</span>
              <v-icon>arrow_drop_down</v-icon>
            </v-btn>
          </template>
          <v-list>
            <v-list-tile :to="{ name: 'logout' }">
              <v-list-tile-title>
                <v-icon>exit_to_app</v-icon>
                <span class="menu-item">Logout</span>
              </v-list-tile-title>
            </v-list-tile>
          </v-list>
        </v-menu>
      </v-toolbar-items>
    </v-toolbar>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'NavBar',
  computed: {
    ...mapGetters('user', ['getFullName'])
  }
}
</script>

<style scoped>
.nav {
  font-family: 'Montserrat', sans-serif;
}
.nav .brand {
  color: white;
  text-decoration: none;
  margin: 0;
  padding-left: 2em;
  padding-right: 2em;
}
.user{
  margin-left: 6px;
  margin-right: 6px;
}
.menu-item{
  font-family: 'Montserrat', sans-serif;
  font-size: 0.9em;
  margin-left: 6px;
}
</style>
