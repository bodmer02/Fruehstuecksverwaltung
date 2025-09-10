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
          <tr>
            <td>Name aus Datenbank</td>
            <td>Produkt aus Datenbank</td>
            <td>Preis aus Datenbank</td>
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
        <button @click="addBreakfast">
          {{ t("views.getStarted.table.add")}}
        </button>
      </v-col>
    </v-row>
    <yes-no-dialog
      v-model="saveLeaveDialog"
      :dialogtitle="t('views.getStarted.saveLeave.title')"
      :dialogtext="t('views.getStarted.saveLeave.text')"
      @no="cancel"
      @yes="leave"
    />
  </v-container>
</template>

<script setup lang="ts">
import { ref } from "vue";
import { useI18n } from "vue-i18n";

import YesNoDialog from "@/components/common/YesNoDialog.vue";
import { useSaveLeave } from "@/composables/saveLeave";

const { t } = useI18n();
const name = ref("");
const product = ref("");
const price = ref(null);

const documentationClicked = ref(false);
const { cancel, leave, saveLeaveDialog } = useSaveLeave(isDirty);

function isDirty(): boolean {
  return !documentationClicked.value;
}
function addBreakfast(){
  name.value = "";
  product.value = "";
  price.value = null;
}
</script>
<style>
table {
  margin-top: 5rem;
  padding: 2rem 4rem;
  background: lightgrey;
  color: black;
  border-radius: 4px;
}

button {
  margin-top: 2rem;
  margin-left: 103rem;
  padding: 0.5rem 1rem;
  background: grey;
  color: white;
  border-radius: 4px;
}
</style>