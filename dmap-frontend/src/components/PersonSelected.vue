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
          <a :href="'mailto:' + person.personDetails.main_email" class="person-contact">
            {{ person.personDetails.main_email }}
          </a>
          <v-icon class="person-contact" small>phone</v-icon> {{ person.personDetails.main_phone_number }}
        </div>
      </div>
      <v-spacer></v-spacer>
      <v-select
        v-model="dataManagementRoles"
        :items="items"
        label="Assign data management roles"
        multiple chips
      >
      </v-select>
      <v-btn flat icon @click="removePersonFromDataManagementStaff(person)">
        <v-icon>cancel</v-icon>
      </v-btn>
    </v-card-title>
  </v-card>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'

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
    ...mapActions('people', ['removePersonFromDataManagementStaff', 'setDataManagementRoles'])
  },
  computed: {
    ...mapGetters('people', ['getDataManagementRoles']),
    fullNameWithTitles () {
      var precedingTitle = this.person.personDetails.preceding_titles
        ? this.person.personDetails.preceding_titles + ' ' : ''
      var postpositionedTitle = this.person.personDetails.postpositioned_titles
        ? ' ' + this.person.personDetails.postpositioned_titles : ''
      return precedingTitle + this.person.personDetails.first_name + ' ' +
        this.person.personDetails.last_name + postpositionedTitle
    },
    dataManagementRoles: {
      set (roles) {
        this.setDataManagementRoles({ oid: this.person.personDetails.oid, roles: roles })
      },
      get () {
        return this.getDataManagementRoles(this.person.personDetails.oid)
      }
    }
  }
}
</script>

<style scoped>
.person-contact{
  margin-left: 6px;
}
</style>
