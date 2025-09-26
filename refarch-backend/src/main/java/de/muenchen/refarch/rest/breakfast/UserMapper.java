package de.muenchen.refarch.rest.breakfast;

import de.muenchen.refarch.rest.breakfast.dto.UserRequestDTO;
import de.muenchen.refarch.rest.breakfast.dto.UserResponseDTO;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity(UserRequestDTO userRequestDTO);
    UserResponseDTO toDTO(UserEntity userEntity);
}
