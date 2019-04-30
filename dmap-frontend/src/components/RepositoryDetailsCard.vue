<template>
  <div v-if="repositoryDetails">
    <v-layout row wrap mx-4>
      <v-flex xs12 mb-3>
        {{ repositoryDetails.description }}
      </v-flex>
      <v-flex xs12 mb-2>
        Repository URL: <a :href="repositoryDetails.repositoryUrl">{{ repositoryDetails.repositoryUrl }}</a>
      </v-flex>
      <v-flex xs12>
        Certificates:
        <v-chip v-if="!repositoryDetails.certificates" small>none</v-chip>
        <v-chip v-for="(certificate, index) in repositoryDetails.certificates" :key="index" small>
          {{ certificate }}
        </v-chip>
      </v-flex>
      <v-flex xs12>
        PID systems:
        <v-chip v-if="!repositoryDetails.pidSystems" small>none</v-chip>
        <v-chip v-for="(pidSystem, index) in repositoryDetails.pidSystems" :key="index" small>
        {{ pidSystem }}
        </v-chip>
      </v-flex>
      <v-flex xs12>
        AID systems:
        <v-chip v-if="!repositoryDetails.aidSystems" small>none</v-chip>
        <v-chip v-for="(aidSystem, index) in repositoryDetails.aidSystems" :key="index" small>
          {{ aidSystem }}
        </v-chip>
      </v-flex>
      <v-flex xs12>
        Versioning:
        <v-chip v-if="!repositoryDetails.versioning" small>unknown</v-chip>
        <v-chip v-else small>{{ repositoryDetails.versioning }}</v-chip>
      </v-flex>
      <v-flex xs12>
        Repository access:
        <v-chip small>
          {{ repositoryDetails.databaseAccess.databaseAccessType }}
          <span v-if="repositoryDetails.databaseAccess.databaseAccessRestrictions">
            (<span v-for="(restriction, index) in repositoryDetails.databaseAccess.databaseAccessRestrictions" :key="index"> {{ restriction }} </span>)
          </span>
        </v-chip>
      </v-flex>
      <v-flex xs12>
        Data access:
        <v-chip v-for="(dataAccess, index) in repositoryDetails.dataAccesses" :key="index" small>
          {{ dataAccess.dataAccessType }}
          <span v-if="dataAccess.dataAccessRestrictions">
            (<span v-for="(restriction, index) in dataAccess.dataAccessRestrictions" :key="index"> {{ restriction }} </span>)
          </span>
        </v-chip>
      </v-flex>
      <v-flex xs12>
        Data upload:
        <v-chip v-for="(dataUpload, index) in repositoryDetails.dataUpload" :key="index" small>
          {{ dataUpload.dataUploadType }}
          <span v-if="dataUpload.dataUploadRestrictions">
            (<span v-for="(restriction, index) in dataUpload.dataUploadRestrictions" :key="index"> {{ restriction }} </span>)
          </span>
        </v-chip>
      </v-flex>
      <v-flex xs12>
        Metadata standards:
        <v-chip v-if="!repositoryDetails.metadataStandards" small>none</v-chip>
        <v-chip v-for="(metadataStandard, index) in repositoryDetails.metadataStandards" :key="index" small>
          {{ metadataStandard.metadataStandardName.name }}
        </v-chip>
      </v-flex>
      <v-flex xs12>
        Content types:
        <v-chip v-if="!repositoryDetails.contentTypes" small>unknown</v-chip>
        <v-chip v-for="(contentType, index) in repositoryDetails.contentTypes" :key="index" small>
          {{ contentType }}
        </v-chip>
      </v-flex>
      <v-flex xs12>
        Subjects:
        <v-chip v-if="!repositoryDetails.subjects" small>unknown</v-chip>
        <v-chip v-for="(subject, index) in repositoryDetails.subjects" :key="index" small>
          {{ subject.name | formatSubject }}
        </v-chip>
      </v-flex>
    </v-layout>
  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex'

export default {
  name: 'RepositoryDetailsCard',
  props: {
    repositoryId: {
      type: String,
      required: true
    }
  },
  methods: {
    ...mapActions('repository', ['fetchRepositoryDetails'])
  },
  computed: {
    ...mapGetters('repository', ['getRepositoryDetailsById']),
    repositoryDetails () {
      return this.getRepositoryDetailsById(this.repositoryId)
    }
  },
  created: function () {
    this.$parent.$on('input', expanded => {
      if (expanded) {
        this.fetchRepositoryDetails(this.repositoryId)
      }
    })
  }
}
</script>

<style scoped>

</style>
