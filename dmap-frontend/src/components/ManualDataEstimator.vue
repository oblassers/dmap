<template>
  <div>
    <v-toolbar flat color="white">
      <v-toolbar-title>Manual Data Estimation</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-dialog v-model="showDialog" max-width="500px">
        <template v-slot:activator="{ on }">
          <v-btn small v-on="on">
            <v-icon small>add_circle</v-icon><span class="add-btn">Specify new data</span>
          </v-btn>
        </template>
        <v-card>
          <v-card-title>
            <span class="headline">{{ formTitle }}</span>
          </v-card-title>

          <v-card-text>
            <v-form ref="form" v-model="formValid" lazy-validation>
            <v-container grid-list-md>
              <v-layout wrap>
                <v-flex xs12 sm12 md12>
                  <v-select
                    v-model="editedItem.estimatedType"
                    :items="researchDataTypes"
                    item-text="label"
                    return-object
                    label="Estimated type"
                    :rules="estimatedTypeRules"
                    required
                    class="px-0"
                  >
                    <template slot="selection" slot-scope="data">
                      <v-list-tile-content>
                        <v-list-tile-title>{{ data.item.label }}</v-list-tile-title>
                        <v-list-tile-sub-title v-if="data.item.description">({{ data.item.description }})</v-list-tile-sub-title>
                      </v-list-tile-content>
                    </template>
                    <template slot="item" slot-scope="data">
                      <v-list-tile-content>
                        <v-list-tile-title>{{ data.item.label }}</v-list-tile-title>
                        <v-list-tile-sub-title v-if="data.item.description">({{ data.item.description }})</v-list-tile-sub-title>
                      </v-list-tile-content>
                    </template>
                  </v-select>
                </v-flex>
                <v-flex xs12 sm6 md6>
                  <v-select
                    v-model="editedItem.estimatedSize"
                    :items="sizes"
                    item-text="label"
                    return-object
                    label="Estimated size"
                    :rules="estimatedSizeRules"
                    required
                    class="px-0"
                  >
                  </v-select>
                </v-flex>
                <v-flex xs12 sm6 md6>
                  <v-select
                    v-model="editedItem.selectedDataset"
                    :items="getDatasetNames"
                    :disabled="getDatasetNames.length === 0"
                    label="Belongs to dataset"
                    class="px-0"
                  >
                  </v-select>
                </v-flex>
                <v-flex xs12 sm12 md12>
                  <v-text-field
                    v-model="editedItem.comment"
                    label="Comment"
                    box
                  ></v-text-field>
                </v-flex>
              </v-layout>
            </v-container>
            </v-form>
          </v-card-text>

          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="blue darken-1" flat @click="close">Cancel</v-btn>
            <v-btn color="blue darken-1" flat @click="save" :disabled="!formValid">Save</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-toolbar>

    <v-data-table
      :headers="headers"
      :items="getDataEstimations"
      v-if="getDataEstimations.length > 0"
    >
      <template v-slot:items="props">
        <td>{{ props.item.estimatedType.label }}</td>
        <td class="text-xs-right">{{ props.item.estimatedSize.label }}</td>
        <td class="text-xs-center">{{ props.item.selectedDataset }}</td>
        <td class="text-xs-left">{{ props.item.comment }}</td>
        <td class="justify-center layout px-0">
          <v-icon
            small
            class="mr-2"
            @click="editItem(props.item)"
          >
            edit
          </v-icon>
          <v-icon
            small
            @click="deleteItem(props.item)"
          >
            delete
          </v-icon>
        </td>
      </template>
    </v-data-table>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
import * as ct from '@/constants/content-types'

export default {
  name: 'ManualDataEstimator',
  data () {
    return {
      showDialog: false,
      formValid: false,
      estimatedTypeRules: [
        v => !this.isEmpty(v) || 'Estimated type is required'
      ],
      estimatedSizeRules: [
        v => !this.isEmpty(v) || 'Estimated size is required'
      ],
      researchDataTypes: [
        {
          label: ct.STANDARD_OFFICE_DOCUMENTS,
          description: 'text documents, spreadsheets, presentations'
        },
        {
          label: ct.NETWORKBASED_DATA,
          description: 'websites, email, chat history, etc.'
        },
        {
          label: ct.DATABASES,
          description: 'DBASE, MS Access, Oracle, MySQL, etc.'
        },
        {
          label: ct.IMAGES,
          description: 'JPEG, JPEG2000, GIF, TIF, PNG, SVG, etc.'
        },
        {
          label: ct.STRUCTURED_GRAPHICS,
          description: 'CAD, CAM, 3D, VRML, etc.'
        },
        {
          label: ct.AUDIOVISUAL_DATA,
          description: 'WAVE, MP3, MP4, Flash, etc.'
        },
        {
          label: ct.SCIENTIFIC_STATISTICAL_DATA,
          description: 'SPSS, FITS, GIS, etc.'
        },
        {
          label: ct.RAW_DATA,
          description: 'device specific output'
        },
        {
          label: ct.PLAIN_TEXT,
          description: 'TXT in various encodings'
        },
        {
          label: ct.STRUCTURED_TEXT,
          description: 'XML, SGML, etc.'
        },
        {
          label: ct.ARCHIVED_DATA,
          description: 'ZIP, RAR, JAR, etc.'
        },
        {
          label: ct.SOFTWARE_APPLICATIONS,
          description: 'modelling tools, editors, IDE, compilers, etc.'
        },
        {
          label: ct.SOURCE_CODE,
          description: 'scripting, Java, C, C++, Fortran, etc.'
        },
        {
          label: ct.CONFIGURATION_DATA,
          description: 'parameter settings, logs, library files'
        },
        {
          label: ct.OTHER,
          description: ''
        }
      ],
      // TODO: load categories from backend
      // min and max in bytes
      sizes: [
        {
          label: '< 100 MB',
          min: 0,
          max: 100000000
        },
        {
          label: '100 - 1000 MB',
          min: 100000000,
          max: 1000000000
        },
        {
          label: '1 - 5 GB',
          min: 1000000000,
          max: 5000000000
        },
        {
          label: '5 - 20 GB',
          min: 5000000000,
          max: 20000000000
        },
        {
          label: '20 - 50 GB',
          min: 20000000000,
          max: 50000000000
        },
        {
          label: '50 - 100 GB',
          min: 50000000000,
          max: 100000000000
        },
        {
          label: '100 - 500 GB',
          min: 100000000000,
          max: 500000000000
        },
        {
          label: '500 - 1000 GB',
          min: 500000000000,
          max: 1000000000000
        },
        {
          label: '1 - 5 TB',
          min: 1000000000000,
          max: 5000000000000
        },
        {
          label: '5 - 10 TB',
          min: 5000000000000,
          max: 10000000000000
        },
        {
          label: '10 - 100 TB',
          min: 10000000000000,
          max: 100000000000000
        },
        {
          label: '100 - 500 TB',
          min: 100000000000000,
          max: 500000000000000
        },
        {
          label: '500 - 1000 TB',
          min: 500000000000000,
          max: 1000000000000000
        },
        {
          label: '> 1 PB',
          min: 1000000000000000,
          max: undefined
        },
        {
          label: 'Don\'t know',
          min: 0,
          max: 0
        }
      ],
      headers: [
        { text: 'Estimated type', value: 'estimatedType', align: 'left' },
        { text: 'Estimated size', value: 'estimatedSize', align: 'right' },
        { text: 'Dataset', value: 'selectedDataset', align: 'center' },
        { text: 'Comment', value: 'comment', align: 'left' },
        { text: 'Actions', value: 'estimatedType', align: 'center' }
      ]
    }
  },
  computed: {
    ...mapGetters('data', ['getDatasetNames', 'getDataEstimations',
      'getEditedDataEstimationItem', 'beingEdited']),
    formTitle () {
      return this.beingEdited ? 'Edit Data Estimation' : 'New Data Estimation'
    },
    editedItem: {
      set (item) {
        this.setEditedDataEstimationItem(item)
      },
      get () {
        return this.getEditedDataEstimationItem
      }
    }
  },
  methods: {
    ...mapActions('data', ['saveDataEstimation', 'removeDataEstimation',
      'setEditedDataEstimationItem', 'resetEditedDataEstimationItem']),
    editItem (item) {
      this.editedItem = item
      this.showDialog = true
    },
    deleteItem (item) {
      confirm('Are you sure you want to delete this data estimation?') && this.removeDataEstimation(item)
    },
    close () {
      this.showDialog = false
      setTimeout(() => {
        this.resetEditedDataEstimationItem()
        this.$refs.form.resetValidation()
      }, 300)
    },
    save () {
      if (this.$refs.form.validate()) {
        this.saveDataEstimation()
        this.close()
      }
    },
    isEmpty (obj) {
      for (var key in obj) {
        if (obj.hasOwnProperty(key)) {
          return false
        }
      }
      return true
    }
  }
}
</script>

<style scoped>
.add-btn{
  margin-left: 6px;
}
.v-toolbar__title {
  font-size: 14px;
}
</style>
