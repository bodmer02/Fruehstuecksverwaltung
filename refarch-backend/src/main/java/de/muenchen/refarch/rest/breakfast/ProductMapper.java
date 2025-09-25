package de.muenchen.refarch.rest.breakfast;

import de.muenchen.refarch.rest.breakfast.dto.ProductRequestDTO;
import de.muenchen.refarch.rest.breakfast.dto.ProductResponseDTO;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface ProductMapper {

    ProductEntity toEntity(ProductRequestDTO productRequestDTO);
    ProductResponseDTO toDTO(ProductEntity productEntity);
}
