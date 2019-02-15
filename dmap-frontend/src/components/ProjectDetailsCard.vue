<template>
  <div>
    <div v-if="projectDetails">
      Project ID: {{ projectDetails.id }}
    </div>
  </div>
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
