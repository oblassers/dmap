<template>
  <div>
    <p>{{ projectDetails }}</p>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'ProjectDetailsCard',
  props: {
    projectId: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapGetters('project', ['getProjectDetailsById']),
    projectDetails () {
      return this.getProjectDetailsById(this.projectId)
    }
  }
}
</script>

<style scoped>

</style>
