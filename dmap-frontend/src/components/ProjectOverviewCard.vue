<template>
  <div>
    <div class="project-overview">
      <h4>{{ project.titleEn }} ({{ project.shortDescription }})</h4>
      <span>Project duration: {{ project.begin | formatDate }} - {{ project.end | formatDate}}</span>

    </div>
    <div class="select-btn" @click.stop="selectProject">
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
  },
  methods: {
    selectProject () {
      console.log('Project selected')
    }
  }
}
</script>

<style scoped>
  .project-overview{
    text-align: left;
    float: left;
    width: 80%;
  }

  .select-btn{
    text-align: left;
    float: right;
  }
</style>
