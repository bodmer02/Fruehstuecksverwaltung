import {
    defaultCatchHandler,
    defaultResponseHandler,
    getConfig,
    postConfig,
} from "@/api/fetch-utils.ts";

export interface BreakfastRequest {
    name: string;
    product: string;
    price: number;
}

export interface Breakfast {
    id: string;
    name: string;
    product: string;
    price: number;
}

export function getBreakfasts(): Promise<Breakfast[]>{
    return fetch("api/backend-service/breakfast", getConfig())
        .then((response) => {
            defaultResponseHandler(response);
            return response.json
        })
        .catch((err) => defaultCatchHandler(err));
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