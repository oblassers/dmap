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

      <v-stepper-step :complete="researchDataFurtherDescribed" editable step="4">
        Further describe your research data
      </v-stepper-step>
      <v-stepper-content step="4">
        <BaseStepContent previous-step="3" next-step="5" @gotoStep="gotoStep">
          <DescribeResearchData></DescribeResearchData>
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

      <v-stepper-step :complete="repositoriesSpecified" editable step="6">
        Specify repository/repositories
      </v-stepper-step>
      <v-stepper-content step="6">
        <BaseStepContent previous-step="5" @gotoStep="gotoStep">
          <SpecifyRepositories></SpecifyRepositories>
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
import DescribeResearchData from '@/components/DescribeResearchData'
import LegalAndEthicalAspects from '@/components/LegalAndEthicalAspects'
import SpecifyRepositories from '@/components/SpecifyRepositories'
import BaseStepContent from '../components/BaseStepContent'

export default {
  name: 'DmpCreate',
  components: {
    BaseStepContent,
    SpecifyRepositories,
    LegalAndEthicalAspects,
    DescribeResearchData,
    SpecifyResearchData,
    DMStaffSelection,
    ProjectSelection },
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
    ...mapGetters('data', ['getFurtherDataDescription', 'getDataEstimationsCount']),
    ...mapGetters('legal', ['getLegalAndEthicalInfoProvided']),
    projectSelected () {
      return this.getSelectedProjectsCount > 0
    },
    dataManagementStaffDefined () {
      return this.getDataManagementStaffMembersCount > 0
    },
    researchDataSpecified () {
      return this.getDataEstimationsCount > 0
    },
    researchDataFurtherDescribed () {
      return this.getFurtherDataDescription !== ''
    },
    repositoriesSpecified () {
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
