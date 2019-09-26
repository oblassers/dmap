<template>
  <div class="new-dmp-left-align">
    <h2>Create a new DMP</h2>
    <v-stepper v-model="currentStep" vertical>
      <v-stepper-step :complete="projectSelected" editable step="1">
        Select project(s)
      </v-stepper-step>
      <v-stepper-content step="1">
        <BaseStepContent next-step="2" @gotoStep="gotoStep">
          <ProjectSelection step="1"></ProjectSelection>
        </BaseStepContent>
      </v-stepper-content>

      <v-stepper-step :complete="dataManagementStaffDefined" editable step="2">
        People involved in data management
      </v-stepper-step>
      <v-stepper-content step="2">
        <BaseStepContent previous-step="1" next-step="3" @gotoStep="gotoStep">
          <DMStaffSelection step="2"></DMStaffSelection>
        </BaseStepContent>
      </v-stepper-content>

      <v-stepper-step :complete="researchDataSpecified" editable step="3">
        Specify your research data
      </v-stepper-step>
      <v-stepper-content step="3">
        <BaseStepContent previous-step="2" next-step="4" @gotoStep="gotoStep">
          <SpecifyResearchData></SpecifyResearchData>
        </BaseStepContent>
      </v-stepper-content>

      <v-stepper-step :complete="documentationAndDataQualityDescribed" editable step="4">
        Documentation and data quality
      </v-stepper-step>
      <v-stepper-content step="4">
        <BaseStepContent previous-step="3" next-step="5" @gotoStep="gotoStep">
          <Documentation></Documentation>
        </BaseStepContent>
      </v-stepper-content>

      <v-stepper-step :complete="getLegalAndEthicalInfoProvided" editable step="5">
        Legal and ethical aspects
      </v-stepper-step>
      <v-stepper-content step="5">
        <BaseStepContent previous-step="4" next-step="6" @gotoStep="gotoStep">
          <LegalAndEthicalAspects></LegalAndEthicalAspects>
        </BaseStepContent>
      </v-stepper-content>

      <v-stepper-step :complete="licensingSpecified" editable step="6">
        Specify license(s)
      </v-stepper-step>
      <v-stepper-content step="6">
        <BaseStepContent previous-step="5" next-step="7" @gotoStep="gotoStep">
          <Licensing></Licensing>
        </BaseStepContent>
      </v-stepper-content>

      <v-stepper-step :complete="repositoriesSpecified" editable step="7">
        Specify repository/repositories
      </v-stepper-step>
      <v-stepper-content step="7">
        <BaseStepContent previous-step="6" @gotoStep="gotoStep">
          <SpecifyRepositories step="7"></SpecifyRepositories>
        </BaseStepContent>
      </v-stepper-content>
    </v-stepper>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import ProjectSelection from '@/components/ProjectSelection'
import DMStaffSelection from '@/components/DMStaffSelection'
import SpecifyResearchData from '@/components/SpecifyResearchData'
import Documentation from '@/components/Documentation'
import LegalAndEthicalAspects from '@/components/LegalAndEthicalAspects'
import SpecifyRepositories from '@/components/SpecifyRepositories'
import Licensing from '@/components/Licensing'
import BaseStepContent from '@/components/BaseStepContent'

export default {
  name: 'DmpCreate',
  components: {
    Licensing,
    SpecifyRepositories,
    LegalAndEthicalAspects,
    Documentation,
    SpecifyResearchData,
    DMStaffSelection,
    ProjectSelection,
    BaseStepContent },
  data () {
    return {
      currentStep: '1'
    }
  },
  methods: {
    gotoStep: function (payload) {
      this.currentStep = payload.step
    }
  },
  computed: {
    ...mapGetters('project', ['getSelectedProjectsCount']),
    ...mapGetters('people', ['getDataManagementStaffMembersCount']),
    ...mapGetters('data', ['getDataEstimationsCount', 'getSampleDataEstimationsCount']),
    ...mapGetters('documentation', ['getMetadata', 'getDataGeneration',
      'getStructureAndVersioning', 'getTargetAudience']),
    ...mapGetters('legal', ['getLegalAndEthicalInfoProvided']),
    ...mapGetters('repository', ['getSelectedRepositoriesCount']),
    projectSelected () {
      return this.getSelectedProjectsCount > 0
    },
    dataManagementStaffDefined () {
      return this.getDataManagementStaffMembersCount > 0
    },
    researchDataSpecified () {
      return this.getDataEstimationsCount > 0 || this.getSampleDataEstimationsCount > 0
    },
    documentationAndDataQualityDescribed () {
      return this.getMetadata !== '' || this.getDataGeneration !== '' ||
        this.getStructureAndVersioning !== '' || this.getTargetAudience !== ''
    },
    licensingSpecified () {
      return false
    },
    repositoriesSpecified () {
      return this.getSelectedRepositoriesCount > 0
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
