<template>
  <v-card v-if="projectDetails">
    <v-card-text>Project ID: {{ projectDetails.id }}</v-card-text>
    <!-- TODO: parse project details and display it nicely -->
    <v-card-text>{{ projectDetails }}</v-card-text>
  </v-card>
</template>

<script>
import { mapGetters } from 'vuex'
import store from '@/store/store'

export default {
  name: 'ProjectDetailsCard',
  props: {
    projectId: {
      type: String,
      required: true
    }
  },
  methods: {
    getProjectDetails () {
      store.dispatch('project/fetchProjectDetails', this.projectId)
    }
  },
  computed: {
    ...mapGetters('project', ['getProjectDetailsById']),
    projectDetails () {
      return this.getProjectDetailsById(this.projectId)
    }
  },
  created: function () {
    this.$parent.$on('input', expanded => {
      if (expanded) {
        this.getProjectDetails()
      }
    })
  }
}
</script>

<style scoped>

</style>
