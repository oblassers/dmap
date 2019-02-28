<template>
  <v-card
    class="mx-auto"
    color="#f5f5f5"
  >
    <v-card-title>
      <div class="project-title">
        <span><h4>{{ project.titleEn }} ({{ project.shortDescription }})</h4></span>
        <div class="d-inline-block">
          <v-icon small>date_range</v-icon><span> {{ project.begin | formatDate }} - {{ project.end | formatDate}}</span>
        </div>
      </div>
      <v-spacer></v-spacer>
      <v-btn flat icon @click="removeProjectFromSelection(project)">
        <v-icon>cancel</v-icon>
      </v-btn>
    </v-card-title>
  </v-card>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'ProjectSelected',
  props: {
    project: {
      type: Object,
      required: true
    }
  },
  methods: {
    ...mapActions('project', ['removeProjectFromSelection'])
  }
}
</script>

<style scoped>
.project-title{
  width: 80%;
}
</style>
