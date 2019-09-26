<template>
  <div>
    <p>{{ introductoryText }}</p>
    <v-container fluid>
      <BaseYesNoQuestion
        question="Does your data contain personal information?" with-text on-yes
        @selection="setContainsPersonalInformation"
        @textchange="setContainsPersonalInformationDescription"
      >
      </BaseYesNoQuestion>
      <BaseYesNoQuestion
        question="Is your data sensitive?" with-text on-yes
        @selection="setIsDataSensitive"
        @textchange="setIsDataSensitiveDescription"
      >
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
  data () {
    return {
      introductoryText: 'Did you consider issues like personal data, intellectual property rights and ownership?'
    }
  },
  computed: {
    ...mapGetters('legal', ['hasEthicalIssues'])
  },
  methods: {
    ...mapActions('legal', ['setIsDataSensitive', 'setIsDataSensitiveDescription',
      'setContainsPersonalInformation', 'setContainsPersonalInformationDescription',
      'setHasLegalIssues', 'setHasLegalIssuesDescription',
      'setHasEthicalIssues', 'setApprovedByEthicalBoard',
      'setLinkToEthicsReport', 'setEthicalComplianceStatement'])
  }
}
</script>

<style scoped>

</style>
