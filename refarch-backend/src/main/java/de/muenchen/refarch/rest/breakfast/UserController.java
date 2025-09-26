package de.muenchen.refarch.rest.breakfast;

import de.muenchen.refarch.rest.breakfast.dto.UserRequestDTO;
import de.muenchen.refarch.rest.breakfast.dto.UserResponseDTO;
import de.muenchen.refarch.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<UserResponseDTO> getAllUsers(@RequestParam(defaultValue = "0") final int pageNumber,
                                             @RequestParam(defaultValue = "10")final int pageSize) {
        final Page<UserEntity> page = userService.getAllUsers(pageNumber, pageSize);
        final List<UserResponseDTO> userRequestDTOList = page.getContent().stream().map(userMapper::toDTO).toList();
        return new PageImpl<>(userRequestDTOList, page.getPageable(), page.getTotalElements());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@Valid @RequestBody final UserRequestDTO userRequestDTO) {
        userService.createUser(userRequestDTO);
    }
}
