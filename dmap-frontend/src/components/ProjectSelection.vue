<template>
  <div>
    <p>Please select the project(s) you want to create a DMP for.</p>
    <div>
      <p v-if="getSelectedProjectsCount === 0">Currently you have no projects selected.</p>
      <p v-else>You selected {{ getSelectedProjectsCount }} project(s):</p>
      <ProjectSelected
        v-for="(selectedProject, index) in project.selectedProjects" :key="index"
        :project="selectedProject"
        class="mb-3"
      >
      </ProjectSelected>
    </div>
    <v-expansion-panel v-model="panels" expand>
      <v-expansion-panel-content v-for="(project, index) in projectSuggestions" :key="index">
        <ProjectHeaderCard slot="header" :project="project"></ProjectHeaderCard>
        <ProjectDetailsCard :project-id="project.projectId"></ProjectDetailsCard>
      </v-expansion-panel-content>
    </v-expansion-panel>
    <v-layout v-if="getProjectSuggestionsTotal === 0 && isLoading" row wrap>
      <v-flex mt-2 mb-2 text-xs-center>
        <v-progress-circular indeterminate :size=40 color="primary">
        </v-progress-circular>
      </v-flex>
    </v-layout>
    <div class="text-xs-center">
      <v-alert :value="getProjectSuggestionsTotal === 0 && !isLoading" icon="info" color="info" outline>
        No projects could be suggested. Try to use the search function.
      </v-alert>
      <v-pagination v-if="getProjectSuggestionsTotal > 0" v-model="page" :length="paginationLength">
      </v-pagination>
    </div>
    <div class="search-div">
      <p>Project not in the list? Try to find it with the search function.
      <span><v-text-field
        v-model="projectSearchTerm"
        append-icon="search"
        label="Search projects..."
        single-line
        hide-details
        outline
        ></v-text-field></span>
      </p>
    </div>
  </div>
</template>

<script>
import ProjectHeaderCard from '@/components/ProjectHeaderCard'
import ProjectDetailsCard from '@/components/ProjectDetailsCard'
import store from '@/store/store'
import { mapState, mapGetters } from 'vuex'
import ProjectSelected from '@/components/ProjectSelected'

function clearProjects () {
  store.dispatch('project/clearProjects')
}

function getProjectSuggestions () {
  store.dispatch('project/fetchProjectSuggestions')
}

export default {
  name: 'ProjectSelection',
  components: { ProjectSelected, ProjectHeaderCard, ProjectDetailsCard },
  props: {
    step: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['project']),
    ...mapGetters('project', ['getProjectSuggestionsPerPage', 'getProjectSuggestionsTotal', 'getSelectedProjectsCount']),
    ...mapGetters('loading', ['isLoading']),
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
      perPage: 5,
      panels: []
    }
  },
  watch: {
    page: function () {
      // when page changes, reset the expand states of the panels
      this.panels = []
    }
  },
  created: function () {
    // called when step is opened
    this.$parent.$parent.$parent.$on('input', step => {
      if (step === this.step) {
        clearProjects()
        getProjectSuggestions()
      }
    })
  }
}

</script>

<style scoped>
.search-div{
  padding-top: 20px;
  float: left;
}
</style>
