<template>
  <div>
    <div class="project-overview">
      <h4>{{ project.title }} ({{ project.shortDescription }})</h4>
      <span>Project duration: {{ project.begin | formatDate }} - {{ project.end | formatDate}}</span>

    </div>
    <div class="select-btn">
      <v-btn small>Select</v-btn>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ProjectOverviewCard',
  props: {
    project: {
      type: Object,
      required: true
    }
  }
}
</script>

<style scoped>
  .project-overview{
    text-align: left;
    float: left;
  }

  .select-btn{
    text-align: left;
    float: right;
  }
</style>
