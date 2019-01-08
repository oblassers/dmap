<template>
  <div id="nav">
    <router-link :to="{ name: 'home' }">DMap</router-link> |
    <router-link :to="{ name: 'mydmps' }">MyDMPs</router-link> |
    <router-link :to="{ name: 'login' }">Login</router-link>
  </div>
</template>

<script>
export default {
  name: 'NavBar'
}
</script>

<style scoped>
.nav {
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 60px;
}
.nav > .brand {
  font-family: 'Montserrat', sans-serif;
  font-weight: 700;
  font-size: 1.5em;
  color: #006699;
  text-decoration: none;
}
.nav .nav-item {
  box-sizing: border-box;
  margin: 0 5px;
  color: rgba(0, 0, 0, 0.5);
  text-decoration: none;
}
.nav .nav-item.router-link-exact-active {
  color: #006699;
  border-bottom: solid 2px #006699;
}
</style>
