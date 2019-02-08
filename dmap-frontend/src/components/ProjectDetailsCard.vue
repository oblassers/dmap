<template>
  <div>TODO: Load project details from API when expanded</div>
</template>

<script>
export default {
  name: 'ProjectDetailsCard',
  props: {
    projectId: {
      type: String,
      required: true
    }
  },
  created () {
    console.log('I AM HERE ' + this.projectId)
  }
}
</script>

<style scoped>

</style>
