<template>
  <div>
    <p>This step helps you to consider issues like personal data, intellectual property rights and ownership.</p>
    <v-container fluid>
      <BaseYesNoQuestion
        question="Does your data contain personal information?"
        :answer="containsPersonalInformation"
        @selection="setContainsPersonalInformation"
        with-text on-yes
        :text="getContainsPersonalInformationDescription"
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
        question="Is your data sensitive?"
        :answer="isDataSensitive"
        @selection="setIsDataSensitive"
        with-text on-yes
        :text="getDataSensitiveDescription"
        @textchange="setDataSensitiveDescription"
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
        question="Are there any other legal restrictions on how data is processed or shared?"
        :answer="hasLegalIssues"
        @selection="setHasLegalIssues"
        with-text on-yes
        :text="getLegalIssuesDescription"
        @textchange="setLegalIssuesDescription"
      >
      </BaseYesNoQuestion>

      <BaseYesNoQuestion
        question="Are there any ethical issues associated with your research data?"
        :answer="hasEthicalIssues"
        @selection="setHasEthicalIssues"
      >
      </BaseYesNoQuestion>

      <BaseYesNoQuestion
        question="If so, was your plan to deal with these ethical issues approved by the ethics committee?"
        :answer="getApprovedByEthicalBoard"
        @selection="setApprovedByEthicalBoard"
      >
      </BaseYesNoQuestion>

      <v-text-field
        :value="getLinkToEthicsReport"
        @change="setLinkToEthicsReport"
        label="Link to ethics report or related document:"
        box
      ></v-text-field>
      <v-textarea
        :value="getEthicalComplianceStatement"
        @change="setEthicalComplianceStatement"
        name="input-7-1"
        box
        label="Other statement regarding ethical compliance (optional):"
        auto-grow
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
    ...mapGetters('legal', ['containsPersonalInformation', 'getDatasetsWithPersonalInformation',
      'getContainsPersonalInformationDescription', 'isDataSensitive', 'getSensitiveDatasets',
      'getDataSensitiveDescription', 'hasLegalIssues', 'getLegalIssuesDescription', 'hasEthicalIssues',
      'getApprovedByEthicalBoard', 'getLinkToEthicsReport', 'getEthicalComplianceStatement'
    ]),
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
    ...mapActions('legal', ['setContainsPersonalInformation', 'setDatasetsWithPersonalInformation',
      'updateDatasetsWithPersonalInformation', 'setContainsPersonalInformationDescription', 'setIsDataSensitive',
      'setSensitiveDatasets', 'updateSensitiveDatasets', 'setDataSensitiveDescription',
      'setHasLegalIssues', 'setLegalIssuesDescription', 'setHasEthicalIssues', 'setApprovedByEthicalBoard',
      'setLinkToEthicsReport', 'setEthicalComplianceStatement'])
  },
  watch: {
    getDatasets: function (datasets) {
      this.updateSensitiveDatasets(datasets.map(d => d.datasetName))
      this.updateDatasetsWithPersonalInformation(datasets.map(d => d.datasetName))
    }
  }
}
</script>

<style scoped>

</style>
