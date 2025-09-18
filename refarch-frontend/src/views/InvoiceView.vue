<script setup lang="ts">
import {ref} from "vue";
import {type Breakfast, getBreakfasts, type Page} from "@/api/breakfast.ts";

const search = ref("");
const headers = [
  { title: 'Name', align: 'center', value: 'name' },
  {
    title: 'Rechnung',
    align: 'center',
    children: [
      { title: 'Ausgaben', value: 'height' },
      { title: 'Differenz zum Durchschnitt', value: 'base' },
      { title: 'Summe', value: 'volume' },
    ],
  },
]
const ueberschrift = [
  { title: 'Name', value: 'name' },
  { title: '', value: 'schulden' },
  { title: 'Name', value: 'constructionDate' },
  {
    title: 'Rechnung',
    align: 'center',
    children: [
      { title: 'Ausgaben', value: 'height' },
      { title: 'Differenz zum Durchschnitt', value: 'base' },
      { title: 'Summe', value: 'volume' },
    ],
  },
]
const items = [
  {
    name: 'Great Pyramid of Giza',
    schulden: 'schuldet',
    height: '146.6',
    base: '230.4',
    volume: '2583285',
    constructionDate: 'c. 2580–2560 BC',
  },
  {
    name: 'Pyramid of Khafre',
    schulden: 'schuldet',
    height: '136.4',
    base: '215.3',
    volume: '1477485',
    constructionDate: 'c. 2570 BC',
  },
  {
    name: 'Red Pyramid',
    schulden: 'schuldet',
    height: '104',
    base: '220',
    volume: '1602895',
    constructionDate: 'c. 2590 BC',
  },
  {
    name: 'Bent Pyramid',
    schulden: 'schuldet',
    height: '101.1',
    base: '188.6',
    volume: '1200690',
    constructionDate: 'c. 2600 BC',
  },
  {
    name: 'Pyramid of the Sun',
    schulden: 'schuldet',
    height: '65',
    base: '225',
    volume: '1237097',
    constructionDate: 'c. 200 CE',
  },
]

const uebersicht = [
  {
    name: 'Great Pyramid of Giza',
    schulden: 'schuldet',
    height: '146.6',
    base: '230.4',
    volume: '2583285',
    constructionDate: 'c. 2580–2560 BC',
  },
  {
    name: 'Pyramid of Khafre',
    schulden: 'schuldet',
    height: '136.4',
    base: '215.3',
    volume: '1477485',
    constructionDate: 'c. 2570 BC',
  },
  {
    name: 'Red Pyramid',
    schulden: 'schuldet',
    height: '104',
    base: '220',
    volume: '1602895',
    constructionDate: 'c. 2590 BC',
  },
  {
    name: 'Bent Pyramid',
    schulden: 'schuldet',
    height: '101.1',
    base: '188.6',
    volume: '1200690',
    constructionDate: 'c. 2600 BC',
  },
  {
    name: 'Pyramid of the Sun',
    schulden: 'schuldet',
    height: '65',
    base: '225',
    volume: '1237097',
    constructionDate: 'c. 200 CE',
  },
]

async function loadBreakfasts() {
  const page: Page<Breakfast> = await getBreakfasts();
  breakfasts.value = page.content;
}


</script>

<template>
<v-row class="text-center">
  <v-col class="mb-4">
    <h1 class="text-h3 font-weight-bold mb-3">
      Abrechnung
    </h1>
      <v-card
          flat
      >
          <v-text-field
              v-model="search"
              label="Search"
              prepend-inner-icon="mdi-magnify"
              variant="outlined"
              hide-details
              single-line
          ></v-text-field>


        <v-data-table-server
            v-model:items-per-page="itemsPerPage"
            :headers="headers"
            :items="serverItems"
            :items-length="totalItems"
            :loading="loading"
            :search="search"
            item-value="name"
            @update:options="loadBreakfasts"
        ></v-data-table-server>
      </v-card>
  </v-col>
</v-row>
  <v-row class="text-center">
    <v-col class="mb-4">
      <v-card
          flat
      >
        <v-data-table
            :headers="ueberschrift"
            :items="uebersicht"
        ></v-data-table>
      </v-card>
    </v-col>
  </v-row>
</template>

<style scoped>

</style>