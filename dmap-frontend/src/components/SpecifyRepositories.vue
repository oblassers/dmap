<template>
  <div>
    <p>Please select the repository/repositories where you plan to deposit your data.</p>
    <div>
      <p v-if="getSelectedRepositoriesCount === 0">Currently you have no repositories selected.</p>
      <p v-else>You selected {{ getSelectedRepositoriesCount }} repository/repositories:</p>
      <RepositorySelected v-for="(selectedRepository, index) in repository.selectedRepositories" :key="index"
                       :repository="selectedRepository"></RepositorySelected>
    </div>
    <v-expansion-panel v-model="panels" expand>
      <v-expansion-panel-content v-for="(repository, index) in repositorySuggestions" :key="index">
        <RepositoryHeaderCard slot="header" :repository="repository"></RepositoryHeaderCard>
        <RepositoryDetailsCard :repository-id="repository.id"></RepositoryDetailsCard>
      </v-expansion-panel-content>
    </v-expansion-panel>
    <v-layout v-if="getRepositorySuggestionsTotal === 0 && isLoading" row wrap>
      <v-flex mt-2 mb-2 text-xs-center>
        <v-progress-circular indeterminate :size=40 color="primary">
        </v-progress-circular>
      </v-flex>
    </v-layout>
    <div class="text-xs-center">
      <v-alert :value="getRepositorySuggestionsTotal === 0 && !isLoading" icon="info" color="info" outline>
        Sorry, no repositories could be suggested.
      </v-alert>
      <v-pagination v-if="getRepositorySuggestionsTotal > 0" v-model="page" :length="paginationLength">
      </v-pagination>
    </div>
  </div>
</template>

<script>
import store from '@/store/store'
import { mapState, mapGetters } from 'vuex'
import RepositorySelected from '@/components/RepositorySelected'
import RepositoryHeaderCard from '@/components/RepositoryHeaderCard'
import RepositoryDetailsCard from '@/components/RepositoryDetailsCard'

function clearRepositories () {
  store.dispatch('repository/clearRepositories')
}

function getRepositorySuggestions () {
  store.dispatch('repository/fetchRepositorySuggestions')
}

export default {
  name: 'SpecifyRepositories',
  components: { RepositoryDetailsCard, RepositoryHeaderCard, RepositorySelected },
  props: {
    step: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['repository']),
    ...mapGetters('repository', ['getRepositorySuggestionsPerPage', 'getRepositorySuggestionsTotal', 'getSelectedRepositoriesCount']),
    ...mapGetters('loading', ['isLoading']),
    repositorySuggestions () {
      return this.getRepositorySuggestionsPerPage(this.page, this.perPage)
    },
    paginationLength () {
      return Math.ceil(this.getRepositorySuggestionsTotal / this.perPage) || 1
    }
  },
  data () {
    return {
      repositorySearchTerm: '',
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
        clearRepositories()
        getRepositorySuggestions()
      }
    })
  }
}
</script>

<style scoped>

</style>
