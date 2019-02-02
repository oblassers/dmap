<template>
  <div>
      <h1>{{ welcomeTitle }}</h1>
      <h2>{{ welcomeSubtitle }}</h2>
      <p>{{ description }}</p>
      <v-btn color="primary" large :to="{ name: 'mydmps' }">Get started</v-btn>
  </div>
</template>

<script>
export default {
  name: 'home',
  data () {
    return {
      welcomeTitle: 'Welcome to DMap',
      welcomeSubtitle: 'The Machine-actionable Data Management planning application',
      description: 'DMap assists you in creating Data Management Plans (DMPs) for your research projects.'
    }
  }
}
</script>
