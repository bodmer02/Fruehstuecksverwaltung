package de.muenchen.refarch.rest.breakfast;

import de.muenchen.refarch.rest.breakfast.dto.BreakfastRequestDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BreakfastMapper {

    BreakfastEntity toEntity(BreakfastRequestDTO breakfastRequestDTO);
}
