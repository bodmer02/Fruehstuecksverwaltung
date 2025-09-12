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
          <tr>
            <td><input v-model="name" placeholder="Bitte ausfüllen" /></td>
            <td><input v-model="product" placeholder="Bitte ausfüllen" /></td>
            <td><input v-model.number="price" placeholder="Bitte ausfüllen" /></td>
          </tr>
          </tbody>
        </v-table>
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <button class="button-right" @click="addBreakfast">
          {{ t("views.getStarted.table.add")}}
        </button>
        <router-link to="/invoice">
        <button class="button-middle">
          Zur Abrechnung
        </button>
        </router-link>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup lang="ts">
import { onMounted, ref } from "vue";
import { useI18n } from "vue-i18n";
import { addBreakfast as saveBreakfast, getBreakfasts, type Breakfast, type Page } from "@/api/breakfast";


const { t } = useI18n();
const name = ref("");
const product = ref("");
const price = ref(null);
const breakfasts = ref<Breakfast[]>([]);

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
  return alert("Bitte alle Felder befüllen.");
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
  margin-left: 95%;
  padding: 0.5rem 1rem;
  background: grey;
  color: white;
  border-radius: 4px;
}

.button-middle {
  margin-top: 10rem;
  margin-left: 50%;
  padding: 1rem 2rem;
  background: grey;
  color: white;
  border-radius: 4px;
}
</style>