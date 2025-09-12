package de.muenchen.refarch.rest.breakfast;

import de.muenchen.refarch.rest.breakfast.dto.BreakfastRequestDTO;
import de.muenchen.refarch.rest.breakfast.dto.BreakfastResponseDTO;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface BreakfastMapper {

    BreakfastEntity toEntity(BreakfastRequestDTO breakfastRequestDTO);
    BreakfastResponseDTO toDTO(BreakfastEntity breakfastEntity);
}
