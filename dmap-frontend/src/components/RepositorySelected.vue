<template>
  <v-card
    class="mx-auto"
    color="#f5f5f5"
  >
    <v-card-title>
      <div class="repository-title">
        <span><h4>{{ repository.name }}</h4></span>
      </div>
      <v-spacer></v-spacer>
      <v-btn flat icon @click="removeRepositoryFromSelection(repository)">
        <v-icon>cancel</v-icon>
      </v-btn>
    </v-card-title>
  </v-card>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'RepositorySelected',
  props: {
    repository: {
      type: Object,
      required: true
    }
  },
  methods: {
    ...mapActions('repository', ['removeRepositoryFromSelection'])
  }
}
</script>

<style scoped>
.repository-title{
  width: 80%;
}
</style>
