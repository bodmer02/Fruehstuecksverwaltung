<template>
  <v-container>
    <v-row class="text-center">
      <v-col>
        <h1 class="text-h3 font-weight-bold mb-10">
          {{ t("views.getStarted.docsHeader") }}
        </h1>
        <h3>{{ t("views.getStarted.docsSubtext") }}</h3>
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <v-table>
          <thead>
          <tr>
          <th>
            {{ t("views.getStarted.table.name")}}
          </th>
          <th>
            {{ t("views.getStarted.table.product")}}
          </th>
          <th>
            {{ t("views.getStarted.table.price")}}
          </th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="b in breakfasts" :key="b.id">
            <td>{{b.name}}</td>
            <td>{{b.product}}</td>
            <td>{{b.price}}</td>
          </tr>
          </tbody>
        </v-table>
      </v-col>
    </v-row>
    <v-row>
      <v-col >
        <v-dialog width="500">
          <template v-slot:activator="{ props: activatorProps }">
            <v-btn v-bind="activatorProps">Produkt hinzufügen</v-btn>
          </template>

          <template v-slot:default="{}">
            <v-card
                class="mx-auto"
                title="Produkt hinzufügen"
            >
              <v-container>
                <v-text-field
                    v-model="name"
                    color="primary"
                    label="Name"
                    variant="underlined"
                ></v-text-field>

                <v-text-field
                    v-model="product"
                    color="primary"
                    label="Produkt"
                    variant="underlined"
                ></v-text-field>

                <v-number-input
                    v-model= "price" :precision="2"
                    hide-details="auto"></v-number-input>
              </v-container>

              <v-divider></v-divider>

              <v-card-actions>
                <v-spacer></v-spacer>

                <v-btn color="success" @click="addBreakfast">
                  Produkt hinzufügen

                  <v-icon icon="mdi-chevron-right" end></v-icon>
                </v-btn>
              </v-card-actions>
            </v-card>
          </template>
        </v-dialog>
      </v-col>
      <v-col cols="auto">
        <v-btn :to="ROUTES_INVOICE">
          Zur Abrechnung
        </v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup lang="ts">
import {onMounted, ref} from "vue";
import {useI18n} from "vue-i18n";
import {addBreakfast as saveBreakfast, type Breakfast, getBreakfasts, type Page} from "@/api/breakfast";
import {useSnackbarStore} from "@/stores/snackbar.ts";
import {ROUTES_INVOICE, STATUS_INDICATORS} from "@/constants.ts";


const { t } = useI18n();
const name = ref("");
const product = ref("");
const price = ref(null);
const breakfasts = ref<Breakfast[]>([]);
const snackbarStore = useSnackbarStore();

async function loadBreakfasts() {
  const page: Page<Breakfast> = await getBreakfasts();
  breakfasts.value = page.content;
}

async function addBreakfast(){
  if(name.value !== "" && product.value !== "" && price.value !== null){
    await saveBreakfast({
      name: name.value,
      product: product.value,
      price: price.value,
    });
    await loadBreakfasts();
    name.value = "";
    product.value = "";
    price.value = null;
    return;
  }
  snackbarStore.showMessage({message: "Bitte alle Felder befüllen!", level: STATUS_INDICATORS.WARNING}) //TODO: replace with vcalidation
}
onMounted(loadBreakfasts);
</script>
<style>
table {
  margin-top: 5rem;
  padding: 2rem 4rem;
  background: lightgrey;
  color: black;
  border-radius: 4px;
}

.button-right {
  margin-left: 87%;
  padding: 0.5rem 1rem;
  background: grey;
  color: white;
  border-radius: 4px;
}

.button-middle {
  margin-top: 5rem;
  margin-left: 50%;
  padding: 1rem 2rem;
  background: grey;
  color: white;
  border-radius: 4px;
}
</style>