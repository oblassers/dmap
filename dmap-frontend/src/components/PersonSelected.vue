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
        :items="contributerTypes"
        label="Specify contributer types"
        multiple clearable chips deletable-chips
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
      contributerTypes: [
        {
          text: 'Contact Person',
          value: 'ContactPerson'
        },
        {
          text: 'Data Collector',
          value: 'DataCollector'
        },
        {
          text: 'Data Curator',
          value: 'DataCurator'
        },
        {
          text: 'Data Manager',
          value: 'DataManager'
        },
        {
          text: 'Distributor',
          value: 'Distributor'
        },
        {
          text: 'Editor',
          value: 'Editor'
        },
        {
          text: 'Hosting Institution',
          value: 'HostingInstitution'
        },
        {
          text: 'Producer',
          value: 'Producer'
        },
        {
          text: 'Project Leader',
          value: 'ProjectLeader'
        },
        {
          text: 'Project Manager',
          value: 'ProjectManager'
        },
        {
          text: 'Project Member',
          value: 'ProjectMember'
        },
        {
          text: 'Registration Agency',
          value: 'RegistrationAgency'
        },
        {
          text: 'Registration Authority',
          value: 'RegistrationAuthority'
        },
        {
          text: 'Related Person',
          value: 'RelatedPerson'
        },
        {
          text: 'Researcher',
          value: 'Researcher'
        },
        {
          text: 'Research Group',
          value: 'ResearchGroup'
        },
        {
          text: 'Rights Holder',
          value: 'RightsHolder'
        },
        {
          text: 'Sponsor',
          value: 'Sponsor'
        },
        {
          text: 'Supervisor',
          value: 'Supervisor'
        },
        {
          text: 'Work Package Leader',
          value: 'WorkPackageLeader'
        },
        {
          text: 'Other',
          value: 'Other'
        }
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
