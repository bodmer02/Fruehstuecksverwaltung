<script setup lang="ts">
import {onMounted, ref} from "vue";
import {getBreakfasts, type Page} from "@/api/product.ts";
import type Product from "@/types/Product.ts";

const breakfasts = ref<Product[]>([]);

const search = ref("");
const headers = [
  {title: 'Name', align: 'center', value: 'name'},
  {
    title: 'Rechnung',
    align: 'center',
    children: [
      {title: 'Ausgaben', value: 'price'},
      {title: 'Differenz zum Durchschnitt', value: 'base'},
      {title: 'Summe', value: 'volume'},
    ],
  },
]
const ueberschrift = [
  {title: 'Name', value: 'name'},
  {title: '', value: 'schulden'},
  {title: 'Name', value: 'constructionDate'},
  {
    title: 'Rechnung', value: 'betrag'
  },
]

const uebersicht = [
  {
    name: 'Great Pyramid of Giza',
    schulden: 'schuldet',
    constructionDate: 'c. 2580–2560 BC',
    betrag: '3.50',
  },
  {
    name: 'Pyramid of Khafre',
    schulden: 'schuldet',
    height: '136.4',
    base: '215.3',
    volume: '1477485',
    constructionDate: 'c. 2570 BC',
  },

]

function loadBreakfasts() {
  getBreakfasts().then((content: Page<Product>) => (breakfasts.value = content.content));
}

onMounted(loadBreakfasts);
</script>

<template>
  <v-row class="text-center">
    <v-col class="mb-4">
      <h1 class="text-h3 font-weight-bold mb-3">
        Abrechnung
      </h1>
      <v-card>
        <v-text-field
            v-model="search"
            label="Search"
            prepend-inner-icon="mdi-magnify"
            variant="outlined"
            hide-details
            single-line
        ></v-text-field>


        <v-data-table
            :headers="headers"
            :items="breakfasts"
            :search="search"
            @update:options="loadBreakfasts"
        ></v-data-table>
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