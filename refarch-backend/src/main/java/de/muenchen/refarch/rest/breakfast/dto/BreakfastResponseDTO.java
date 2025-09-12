package de.muenchen.refarch.rest.breakfast.dto;

import java.util.List;
import java.util.UUID;

public record BreakfastResponseDTO(UUID id, String name, String product, double price) {
}
