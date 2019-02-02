<template>
  <div>
    <p>Please select the project(s) you want to create a DMP for.</p>
    <v-expansion-panel expand>
      <v-expansion-panel-content v-for="(project, i) in project.projects" :key="i">
        <div slot="header">
          <ProjectOverviewCard :project="project"></ProjectOverviewCard>
        </div>
        <ProjectDetailsCard></ProjectDetailsCard>
      </v-expansion-panel-content>
    </v-expansion-panel>
    <div class="search-div">
      <p>Not in the list? Try to find it with the search function.</p>
    </div>
  </div>
</template>

<script>
import ProjectOverviewCard from './ProjectOverviewCard'
import ProjectDetailsCard from './ProjectDetailsCard'
import { mapState } from 'vuex'

export default {
  name: 'ProjectSelection',
  components: { ProjectOverviewCard, ProjectDetailsCard },
  computed: {
    ...mapState(['project'])
  }
}

</script>

<style scoped>
.search-div{
  padding-top: 20px
}

</style>
