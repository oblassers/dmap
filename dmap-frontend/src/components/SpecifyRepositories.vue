<template>
  <v-layout row wrap>
    <v-flex xs12 mb-3>
      <p>Please select the repository/repositories where you plan to deposit your data.</p>
      <p v-if="getSelectedRepositoriesCount === 0">Currently you have no repositories selected.</p>
      <p v-else>You selected {{ getSelectedRepositoriesCount }} repository/repositories:</p>
      <RepositorySelected
        v-for="(selectedRepository, index) in repository.selectedRepositories" :key="index"
        :repository="selectedRepository"
        class="mb-3"
      >
      </RepositorySelected>
    </v-flex>
    <v-flex xs4 pr-4>
      <RepositoriesFilter></RepositoriesFilter>
    </v-flex>
    <v-flex xs8>
      <v-layout row wrap>
        <v-flex xs12 mb-3>
          <v-text-field
            :value="getFilterSearchQuery"
            append-icon="search"
            label="Search repositories..."
            single-line
            hide-details
            clearable
            @change="setFilterSearchQuery"
            @click:clear="setFilterSearchQuery('')"
            :loading="isLoading"
            outline
          ></v-text-field>
        </v-flex>
        <v-flex xs12>
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
              Sorry, no matching repositories could be suggested.
            </v-alert>
            <div v-if="getRepositorySuggestionsTotal > 0">
              <v-pagination  v-model="page" :length="paginationLength">
              </v-pagination>
              <p>{{ getRepositorySuggestionsTotal }} repositories found</p>
            </div>
          </div>
        </v-flex>
      </v-layout>
    </v-flex>
  </v-layout>
</template>

<script>
import store from '@/store/store'
import { mapState, mapGetters, mapActions } from 'vuex'
import RepositorySelected from '@/components/RepositorySelected'
import RepositoryHeaderCard from '@/components/RepositoryHeaderCard'
import RepositoryDetailsCard from '@/components/RepositoryDetailsCard'
import RepositoriesFilter from '@/components/RepositoriesFilter'

function clearRepositories () {
  store.dispatch('repository/clearRepositories')
}

function getRepositorySuggestions () {
  store.dispatch('repository/fetchRepositorySuggestions')
}

export default {
  name: 'SpecifyRepositories',
  components: { RepositoriesFilter, RepositoryDetailsCard, RepositoryHeaderCard, RepositorySelected },
  props: {
    step: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['repository']),
    ...mapGetters('repository', [
      'getRepositorySuggestionsPerPage',
      'getRepositorySuggestionsTotal',
      'getSelectedRepositoriesCount',
      'getFilterParams',
      'getFilterSearchQuery']),
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
      page: 1,
      perPage: 8,
      panels: []
    }
  },
  methods: {
    ...mapActions('repository', ['setFilterSearchQuery'])
  },
  watch: {
    // when page changes, reset the expand states of the panels
    page: function () {
      this.panels = []
    },
    // update repository suggestions when filter params change
    getFilterParams: {
      handler () {
        getRepositorySuggestions()
      },
      deep: true
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
