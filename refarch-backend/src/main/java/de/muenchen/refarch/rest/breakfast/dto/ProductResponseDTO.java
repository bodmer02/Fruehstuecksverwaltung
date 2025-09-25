package de.muenchen.refarch.rest.breakfast.dto;

import java.util.UUID;

public record ProductResponseDTO(UUID id, String name, String product, double price) {
}
