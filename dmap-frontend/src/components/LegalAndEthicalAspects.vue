<template>
  <div>
    <p>{{ introductoryText }}</p>
    <v-container fluid>
      <BaseYesNoQuestion question="Is your data sensitive?" with-text on-yes></BaseYesNoQuestion>
      <BaseYesNoQuestion question="Does your data contain personal information?" with-text on-yes></BaseYesNoQuestion>
      <BaseYesNoQuestion question="Are there any other legal issues on how data is processed or shared?" with-text on-yes></BaseYesNoQuestion>
      <BaseYesNoQuestion question="Are there any ethical issues associated with your research data?"></BaseYesNoQuestion>
      <BaseYesNoQuestion question="Was your plan approved by the ethical board?"></BaseYesNoQuestion>
      <v-text-field
        label="Link to ethics report or related document:"
        box
      ></v-text-field>
      <v-textarea
        name="input-7-1"
        box
        label="Other statement regarding ethical compliance (optional):"
        auto-grow
        v-model="otherStatement"
      ></v-textarea>
    </v-container>
  </div>
</template>

<script>
import BaseYesNoQuestion from './BaseYesNoQuestion'
export default {
  name: 'LegalAndEthicalAspects',
  components: { BaseYesNoQuestion },
  data () {
    return {
      introductoryText: 'Did you consider issues like personal data, intellectual property rights and ownership?',
      otherStatement: ''
    }
  }
}
</script>

<style scoped>

</style>
