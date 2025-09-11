import {
    defaultResponseHandler,
    postConfig,
} from "@/api/fetch-utils.ts";

export interface BreakfastRequest {
    name: string;
    product: string;
    price: number;
}

export function addBreakfast (
    breakfast: BreakfastRequest,): Promise<void> {
    return fetch("api/backend-service/breakfast", postConfig(breakfast))
        .then((response) => {
            defaultResponseHandler(response);
            return;
        })
        .catch((err) => {
            defaultResponseHandler(err);
        });
}