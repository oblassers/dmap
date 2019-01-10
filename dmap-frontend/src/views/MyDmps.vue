<template>
  <div>
    <p>
      <v-btn color="primary">Create new DMP</v-btn>
    </p>
    <v-card>
      <v-card-title>
        MyDMPs
        <v-spacer></v-spacer>
        <v-text-field
          v-model="search"
          append-icon="search"
          label="Search DMPs"
          single-line
          hide-details
        ></v-text-field>
      </v-card-title>
      <v-data-table
        :headers="headers"
        :items="dmp.dmps"
        :search="search"
        >
        <template slot="items" slot-scope="props">
          <td><a href="">{{ props.item.projectName }}</a></td>
          <td>{{ props.item.projectStart }}</td>
          <td>{{ props.item.projectEnd }}</td>
          <td>{{ props.item.funder }}</td>
          <td>{{ props.item.fundingStatus }}</td>
          <td>{{ props.item.principalInvestigator }}</td>
          <td>{{ props.item.myRole }}</td>
          <td>{{ props.item.created }}</td>
          <td>{{ props.item.modified }}</td>
          <td>{{ props.item.dmpGranularity }}</td>
        </template>
      </v-data-table>
    </v-card>
  </div>
</template>

<script>
import store from '@/store/store'
import { mapState } from 'vuex'

function getDmps (routeTo, next) {
  store.dispatch('dmp/fetchDmps')
    .then(() => {
      next()
    })
}

export default {
  name: 'MyDmps',
  data () {
    return {
      search: '',
      headers: [
        { text: 'Project title', value: 'projectName' },
        { text: 'Project start', value: 'projectStart' },
        { text: 'Project end', value: 'projectEnd' },
        { text: 'Funder', value: 'funder' },
        { text: 'Funding Status', value: 'fundingStatus' },
        { text: 'PI', value: 'principalInvestigator' },
        { text: 'My Role', value: 'myRole' },
        { text: 'Created', value: 'created' },
        { text: 'Modified', value: 'modified' },
        { text: 'DMP Granularity', value: 'dmpGranularity' }
      ]
    }
  },
  beforeRouteEnter (routeTo, routeFrom, next) {
    getDmps(routeTo, next)
  },
  beforeRouteUpdate (routeTo, routeFrom, next) {
    getDmps(routeTo, next)
  },
  computed: {
    ...mapState(['dmp'])
  }
}
</script>

<style scoped>

</style>
