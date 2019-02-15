<template>
  <div>
    <p>Please select the project(s) you want to create a DMP for.</p>
    <v-expansion-panel expand>
      <v-expansion-panel-content v-for="(project, i) in projectSuggestions" :key="i">
        <ProjectHeaderCard slot="header" :project="project"></ProjectHeaderCard>
        <ProjectDetailsCard :project-id="project.projectId"></ProjectDetailsCard>
      </v-expansion-panel-content>
    </v-expansion-panel>
    <div class="text-xs-center">
      <v-pagination v-model="page" :length="paginationLength">
      </v-pagination>
    </div>
    <div class="search-div">
      <p>Not in the list? Try to find it with the search function.
      <span><v-text-field
        v-model="projectSearchTerm"
        append-icon="search"
        label="Search projects..."
        single-line
        hide-details
        ></v-text-field></span>
      </p>
    </div>
  </div>
</template>

<script>
import ProjectHeaderCard from './ProjectHeaderCard'
import ProjectDetailsCard from './ProjectDetailsCard'
import store from '@/store/store'
import { mapState, mapGetters } from 'vuex'

function getProjectSuggestions () {
  store.dispatch('project/fetchProjectSuggestions')
}

export default {
  name: 'ProjectSelection',
  components: { ProjectHeaderCard, ProjectDetailsCard },
  computed: {
    ...mapState(['project']),
    ...mapGetters('project', ['getProjectSuggestionsPerPage', 'getProjectSuggestionsTotal']),
    projectSuggestions () {
      return this.getProjectSuggestionsPerPage(this.page, this.perPage)
    },
    paginationLength () {
      return Math.ceil(this.getProjectSuggestionsTotal / this.perPage) || 1
    }
  },
  data () {
    return {
      projectSearchTerm: '',
      page: 1,
      perPage: 5
    }
  },
  created () {
    getProjectSuggestions()
  }
}

</script>

<style scoped>
.search-div{
  padding-top: 20px;
  float: left;
}
</style>
