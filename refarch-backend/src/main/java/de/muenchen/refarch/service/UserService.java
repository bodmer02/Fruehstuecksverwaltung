package de.muenchen.refarch.service;

import de.muenchen.refarch.common.NotFoundException;
import de.muenchen.refarch.rest.breakfast.UserEntity;
import de.muenchen.refarch.rest.breakfast.UserMapper;
import de.muenchen.refarch.rest.breakfast.UserRepository;
import de.muenchen.refarch.rest.breakfast.dto.UserRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Page<UserEntity> getAllUsers(final int pageNumber, final int pageSize) {
        final Pageable pageRequest = PageRequest.of(pageNumber, pageSize);
        return userRepository.findAll(pageRequest);
    }

    public UserEntity createUser(UserRequestDTO userRequestDTO) {
        if(userRepository.existsByName(userRequestDTO.name())){
            throw new NotFoundException("Username already exists");
        }
        return userRepository.save(userMapper.toEntity(userRequestDTO));
    }
}
