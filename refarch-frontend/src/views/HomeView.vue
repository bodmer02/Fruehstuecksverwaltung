<template>
  <v-container>
    <v-row class="text-center">
      <v-col cols="12">
        <v-img
          src="@/assets/logo.png"
          class="my-3"
          height="200"
        />
      </v-col>

      <v-col class="mb-4">
        <h1 class="text-h3 font-weight-bold mb-3">
          {{ t("views.home.header") }}
        </h1>
        <p>
          {{ t("views.home.apiGatewayStatus") }}
          <span :class="status">{{ status }}</span>
        </p>
        <router-link to="/getstarted">
          <button>Zur Frühstücksplanung</button>
        </router-link>
        <v-data-table-server
          :headers="headers"
          :items="users"
          :items-length="totalItems"
          :loading="loading"
          item-value="name"
          @update:options = "loadUsers"
        ></v-data-table-server>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup lang="ts">
import type User2 from "@/types/User2.ts";
import { onMounted, ref } from "vue";
import { useI18n } from "vue-i18n";

import { checkHealth } from "@/api/health-client";
import { useSnackbarStore } from "@/stores/snackbar";
import HealthState from "@/types/HealthState";
import {getUsers, type Page} from "@/api/user.ts";


const { t } = useI18n();

const snackbarStore = useSnackbarStore();
const status = ref("DOWN");



const headers = ref([
  { title: 'ID'},
  { title: 'Name'},
])
const users = ref<User2[]>([]);
const loading = ref(true)
const totalItems = ref(0)

async function loadUsers () {
  const page: Page<User2> = await getUsers();
  users.value = page.content;

}

onMounted(() => {
  checkHealth()
    .then((content: HealthState) => (status.value = content.status))
    .catch((error) => {
      snackbarStore.showMessage(error);
    });
});
</script>

<style scoped>
.UP {
  color: limegreen;
}

.DOWN {
  color: lightcoral;
}

button {
  margin-top: 5rem;
  margin-left: 0rem;
  padding: 2rem 4rem;
  background: grey;
  color: white;
  border-radius: 4px;
}
</style>
