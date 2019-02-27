<template>
  <div class="new-dmp-left-align">
    <h2>Create a new DMP</h2>
    <v-stepper vertical>
      <v-stepper-step :complete="projectSelected" editable step="1">
        Select project(s)
      </v-stepper-step>
      <v-stepper-content step="1">
        <ProjectSelection step="1"></ProjectSelection>
      </v-stepper-content>

      <v-stepper-step :complete="dataManagementStaffDefined" editable step="2">
        People involved in data management
      </v-stepper-step>
      <v-stepper-content step="2">
        <DMStaffSelection step="2"></DMStaffSelection>
      </v-stepper-content>

      <v-stepper-step :complete="researchDataSpecified" editable step="3">
        Specify your research data
      </v-stepper-step>
      <v-stepper-content step="3">
        TODO
      </v-stepper-content>
    </v-stepper>
  </div>
</template>

<script>
import { mapState, mapGetters } from 'vuex'
import ProjectSelection from '../components/ProjectSelection'
import DMStaffSelection from '../components/DMStaffSelection'

export default {
  name: 'DmpCreate',
  components: { DMStaffSelection, ProjectSelection },
  computed: {
    ...mapState(['dmp', 'user']),
    ...mapGetters('user', ['getFullName']),
    ...mapGetters('project', ['getSelectedProjectsCount']),
    projectSelected () {
      return this.getSelectedProjectsCount > 0
    },
    dataManagementStaffDefined () {
      return false
    },
    researchDataSpecified () {
      return false
    }
  }
}
</script>

<style scoped>
.new-dmp-left-align{
  text-align: left;
  padding: 20px;
}
</style>
