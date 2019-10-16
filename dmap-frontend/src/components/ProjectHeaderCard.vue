<template>
  <div>
    <div class="project-overview">
      <h4>{{ project.titleEn }} ({{ project.shortDescription }})</h4>
      <v-icon small>date_range</v-icon><span> {{ project.begin | formatDate }} - {{ project.end | formatDate}}</span>
    </div>
    <div class="select-btn" @click.stop="selectProjectAndFetchDetails(project)">
      <v-btn :disabled="isSelectedProject(project.projectId)" small>Select</v-btn>
    </div>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'

export default {
  name: 'ProjectHeaderCard',
  props: {
    project: {
      type: Object,
      required: true
    }
  },
  methods: {
    ...mapActions('project', ['selectProject', 'fetchProjectDetails']),
    selectProjectAndFetchDetails (project) {
      this.fetchProjectDetails(project.projectId)
      this.selectProject(project)
    }
  },
  computed: {
    ...mapGetters('project', ['isSelectedProject'])
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
