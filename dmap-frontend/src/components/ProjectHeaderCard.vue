<template>
  <div>
    <div class="project-overview">
      <h4>{{ project.titleEn }} ({{ project.shortDescription }})</h4>
      <span>Project duration: {{ project.begin | formatDate }} - {{ project.end | formatDate}}</span>
    </div>
    <div class="select-btn" @click.stop="selectProject(project)">
      <v-btn small>Select</v-btn>
    </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'ProjectHeaderCard',
  props: {
    project: {
      type: Object,
      required: true
    }
  },
  methods: {
    ...mapActions('project', ['selectProject'])
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
