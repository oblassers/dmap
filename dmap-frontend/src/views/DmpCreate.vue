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
        <SpecifyResearchData></SpecifyResearchData>
      </v-stepper-content>

      <v-stepper-step :complete="researchDataFurtherDescribed" editable step="4">
        Further describe your research data
      </v-stepper-step>
      <v-stepper-content step="4">
        <DescribeResearchData></DescribeResearchData>
      </v-stepper-content>

      <v-stepper-step :complete="researchDataSpecified" editable step="5">
        Legal and ethical aspects
      </v-stepper-step>
      <v-stepper-content step="5">
        <LegalAndEthicalAspects></LegalAndEthicalAspects>
      </v-stepper-content>
    </v-stepper>
  </div>
</template>

<script>
import { mapState, mapGetters } from 'vuex'
import ProjectSelection from '@/components/ProjectSelection'
import DMStaffSelection from '@/components/DMStaffSelection'
import SpecifyResearchData from '@/components/SpecifyResearchData'
import DescribeResearchData from '@/components/DescribeResearchData'
import LegalAndEthicalAspects from '@/components/LegalAndEthicalAspects'

export default {
  name: 'DmpCreate',
  components: { LegalAndEthicalAspects, DescribeResearchData, SpecifyResearchData, DMStaffSelection, ProjectSelection },
  computed: {
    ...mapState(['dmp', 'user']),
    ...mapGetters('user', ['getFullName']),
    ...mapGetters('project', ['getSelectedProjectsCount']),
    ...mapGetters('people', ['getDataManagementStaffMembersCount']),
    ...mapGetters('data', ['getFurtherDataDescription']),
    projectSelected () {
      return this.getSelectedProjectsCount > 0
    },
    dataManagementStaffDefined () {
      return this.getDataManagementStaffMembersCount > 0
    },
    researchDataSpecified () {
      return false
    },
    researchDataFurtherDescribed () {
      return this.getFurtherDataDescription !== ''
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
