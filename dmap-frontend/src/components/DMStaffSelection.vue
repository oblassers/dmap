<template>
  <div>
    <p>Please select the people involved in data management and assign roles.</p>
    <div>
      <p v-if="getDataManagementStaffMembersCount === 0">Currently you have no people selected.</p>
      <p v-else>You selected {{ getDataManagementStaffMembersCount }} person(s):</p>
      <PersonSelected v-for="(person, index) in getDataManagementStaff" :key="index"
                       :person="person"></PersonSelected>
    </div>
    <v-expansion-panel v-model="panels" expand>
      <v-expansion-panel-content v-for="(person, index) in projectsStaff" :key="index">
        <DMStaffHeaderCard slot="header" :person="person"></DMStaffHeaderCard>
        <DMStaffDetailsCard :person="person"></DMStaffDetailsCard>
      </v-expansion-panel-content>
    </v-expansion-panel>
    <v-layout v-if="isLoading" row wrap>
      <v-flex mt-2 mb-2 text-xs-center>
        <v-progress-circular indeterminate :size=40 color="primary">
        </v-progress-circular>
      </v-flex>
    </v-layout>
    <div class="text-xs-center">
      <v-alert :value="getProjectsStaffCount === 0 && !isLoading" icon="info" color="info" outline>
        No people could be suggested. Try to select project(s) first or use the search function.
      </v-alert>
      <v-pagination v-if="getProjectsStaffCount > 0" v-model="page" :length="paginationLength">
      </v-pagination>
    </div>
    <div class="search-div">
      <p>Person not in the list? Try the search function.
        <span><v-text-field
          v-model="personSearchTerm"
          append-icon="search"
          label="Search for person..."
          single-line
          hide-details
          outline
        ></v-text-field></span>
      </p>
    </div>
  </div>
</template>

<script>
import store from '@/store/store'
import { mapGetters } from 'vuex'
import DMStaffHeaderCard from '@/components/DMStaffHeaderCard'
import PersonSelected from '@/components/PersonSelected'
import DMStaffDetailsCard from '@/components/DMStaffDetailsCard'

function clearProjectsStaff () {
  store.dispatch('project/clearProjectsStaff')
}

function getProjectStaffForAllSelectedProjects () {
  store.dispatch('project/fetchProjectStaffForAllSelectedProjects')
}

export default {
  name: 'DMStaffSelection',
  components: { DMStaffDetailsCard, DMStaffHeaderCard, PersonSelected },
  props: {
    step: {
      type: String,
      required: true
    }
  },
  data () {
    return {
      personSearchTerm: '',
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
  computed: {
    ...mapGetters('project', ['getProjectsStaffCount', 'getProjectsStaffPerPage']),
    ...mapGetters('people', ['getDataManagementStaffMembersCount', 'getDataManagementStaff']),
    ...mapGetters('loading', ['isLoading']),
    projectsStaff () {
      return this.getProjectsStaffPerPage(this.page, this.perPage)
    },
    paginationLength () {
      return Math.ceil(this.getProjectsStaffCount / this.perPage) || 1
    }
  },
  created: function () {
    // called when step is opened
    this.$parent.$parent.$parent.$on('input', step => {
      if (step === this.step) {
        clearProjectsStaff()
        getProjectStaffForAllSelectedProjects()
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
