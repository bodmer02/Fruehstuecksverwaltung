package de.muenchen.refarch.rest.breakfast;

import de.muenchen.refarch.rest.breakfast.dto.BreakfastRequestDTO;
import de.muenchen.refarch.service.BreakfastService;
import de.muenchen.refarch.theentity.dto.TheEntityRequestDTO;
import de.muenchen.refarch.theentity.dto.TheEntityResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/breakfast")
public class BreakfastController {

    private final BreakfastService breakfastService;
    private final BreakfastMapper breakfastMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveTheEntity(@Valid @RequestBody final BreakfastRequestDTO breakfastRequestDTO) {
       breakfastService.createTestBreakfast(breakfastRequestDTO);
    }
}
