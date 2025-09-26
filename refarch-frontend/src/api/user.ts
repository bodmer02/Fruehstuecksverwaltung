import type User from "@/types/User2.ts";

import {
  defaultCatchHandler,
  defaultResponseHandler,
  getConfig,
  postConfig,
} from "@/api/fetch-utils.ts";

export interface UserRequest {
  name: string;
}

export interface Page<T> {
  content: T[];
  totalElements: number;
}

export function getUsers(pageNumber = 0, pageSize = 10): Promise<Page<User>> {
  return fetch(
    `api/backend-service/user?pageNumber=${pageNumber}&pageSize=${pageSize}`,
    getConfig()
  )
    .then((response) => {
      defaultResponseHandler(response);
      return response.json();
    })
    .catch((err) => defaultCatchHandler(err));
}

export function addUser(user: UserRequest): Promise<void> {
  return fetch("api/backend-service/user", postConfig(user))
    .then((response) => {
      defaultResponseHandler(response);
      return;
    })
    .catch((err) => defaultCatchHandler(err));
}
