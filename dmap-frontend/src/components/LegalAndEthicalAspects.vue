<template>
  <div>
    <p>This step helps you to consider issues like personal data, intellectual property rights and ownership.</p>
    <v-container fluid>
      <BaseYesNoQuestion
        question="Does your data contain personal information?" with-text on-yes
        @selection="setContainsPersonalInformation"
        @textchange="setContainsPersonalInformationDescription"
      >
        <v-select
          v-if="containsPersonalInformation && getDatasets.length > 0"
          v-model="datasetsWithPersonalInformation"
          :items="getDatasets"
          item-value="datasetName"
          item-text="datasetName"
          label="Please indicate which datasets contain personal information"
          multiple chips
          class="pt-0 mt-0"
        ></v-select>
      </BaseYesNoQuestion>

      <BaseYesNoQuestion
        question="Is your data sensitive?" with-text on-yes
        @selection="setIsDataSensitive"
        @textchange="setIsDataSensitiveDescription"
      >
        <v-select
          v-if="isDataSensitive && getDatasets.length > 0"
          v-model="sensitiveDatasets"
          :items="getDatasets"
          item-value="datasetName"
          item-text="datasetName"
          label="Please indicate which datasets contain sensitive data"
          multiple chips
          class="pt-0 mt-0"
        ></v-select>
      </BaseYesNoQuestion>

      <BaseYesNoQuestion
        question="Are there any other legal restrictions on how data is processed or shared?" with-text on-yes
        @selection="setHasLegalIssues"
        @textchange="setHasLegalIssuesDescription"
      >
      </BaseYesNoQuestion>

      <BaseYesNoQuestion
        question="Are there any ethical issues associated with your research data?"
        @selection="setHasEthicalIssues"
      >
      </BaseYesNoQuestion>

      <BaseYesNoQuestion
        question="If so, was your plan to deal with these ethical issues approved by the ethics committee?"
        @selection="setApprovedByEthicalBoard"
      >
      </BaseYesNoQuestion>

      <v-text-field
        label="Link to ethics report or related document:"
        box
        @change="setLinkToEthicsReport"
      ></v-text-field>
      <v-textarea
        name="input-7-1"
        box
        label="Other statement regarding ethical compliance (optional):"
        auto-grow
        @change="setEthicalComplianceStatement"
      ></v-textarea>
    </v-container>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
import BaseYesNoQuestion from '@/components/BaseYesNoQuestion'

export default {
  name: 'LegalAndEthicalAspects',
  components: { BaseYesNoQuestion },
  computed: {
    ...mapGetters('legal', ['hasEthicalIssues', 'containsPersonalInformation', 'getDatasetsWithPersonalInformation',
      'isDataSensitive', 'getSensitiveDatasets']),
    ...mapGetters('data', ['getDatasets']),
    datasetsWithPersonalInformation: {
      set (datasetNames) {
        this.setDatasetsWithPersonalInformation(datasetNames)
      },
      get () {
        return this.getDatasetsWithPersonalInformation
      }
    },
    sensitiveDatasets: {
      set (datasetNames) {
        this.setSensitiveDatasets(datasetNames)
      },
      get () {
        return this.getSensitiveDatasets
      }
    }
  },
  methods: {
    ...mapActions('legal', ['setIsDataSensitive', 'setSensitiveDatasets', 'setIsDataSensitiveDescription',
      'setContainsPersonalInformation', 'setDatasetsWithPersonalInformation',
      'setContainsPersonalInformationDescription',
      'setHasLegalIssues', 'setHasLegalIssuesDescription',
      'setHasEthicalIssues', 'setApprovedByEthicalBoard',
      'setLinkToEthicsReport', 'setEthicalComplianceStatement'])
  }
}
</script>

<style scoped>

</style>
