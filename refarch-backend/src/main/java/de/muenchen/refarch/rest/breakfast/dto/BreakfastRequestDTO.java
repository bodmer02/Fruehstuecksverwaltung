package de.muenchen.refarch.rest.breakfast.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record BreakfastRequestDTO(@NotNull @Size(min = 1, max = 50) String name, @NotNull @Size(min = 1, max = 50) String product, double price) {
}
