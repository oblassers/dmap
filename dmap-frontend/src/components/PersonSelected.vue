<template>
  <v-card
    class="mx-auto"
    color="#f5f5f5"
  >
    <v-card-title>
      <div>
        <span><h4><v-icon>person</v-icon> {{ fullNameWithTitles }}</h4></span>
        <div class="d-inline-block">
          <v-icon small>mail_outline</v-icon>
          <a :href="'mailto:' + person.personDetails.main_email" class="person-contact">{{ person.personDetails.main_email }}</a>
          <v-icon class="person-contact" small>phone</v-icon> {{ person.personDetails.main_phone_number }}
        </div>
      </div>
      <v-spacer></v-spacer>
      <v-combobox v-model="selectedDataManagementRoles" :items="items" label="Assign data management roles" multiple chips></v-combobox>
      <v-btn flat icon @click="removePersonFromDataManagementStaff(person)">
        <v-icon>cancel</v-icon>
      </v-btn>
    </v-card-title>
  </v-card>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'PersonSelected',
  props: {
    person: {
      type: Object,
      required: true
    }
  },
  data () {
    return {
      selectedDataManagementRoles: [],
      items: [
        'PI',
        'Co-PI',
        'Data Manager',
        'Main contact person for DMP',
        'Other'
      ]
    }
  },
  methods: {
    ...mapActions('people', ['removePersonFromDataManagementStaff'])
  },
  computed: {
    fullNameWithTitles () {
      var precedingTitle = this.person.personDetails.preceding_titles
        ? this.person.personDetails.preceding_titles + ' ' : ''
      var postpositionedTitle = this.person.personDetails.postpositioned_titles
        ? ' ' + this.person.personDetails.postpositioned_titles : ''
      return precedingTitle + this.person.personDetails.first_name + ' ' +
        this.person.personDetails.last_name + postpositionedTitle
    }
  }
}
</script>

<style scoped>
.person-contact{
  margin-left: 6px;
}
</style>
