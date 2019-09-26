<template>
  <div>
    <v-tooltip top>
      <template v-slot:activator="{ on }">
        <v-btn icon v-on="on">
          <v-icon>assistant</v-icon>
        </v-btn>
      </template>
      <span>Get help from license selection wizard</span>
    </v-tooltip>
  </div>
</template>

<script>
import 'LicenseSelector/license-selector.css'
import 'LicenseSelector/license-selector'

export default {
  name: 'LicenseSelectorWrapper',
  mounted: function () {
    var self = this
    $(this.$el).licenseSelector({ showLabels: true,
      onLicenseSelected: function (license) {
        self.$emit('input', license)
      } })
    self.$emit('license-definitions', $(this.$el).data('license-selector').licensesList.availableLicenses)
  },
  beforeDestroy: function () {
  }
}
</script>

<style scoped>

</style>
