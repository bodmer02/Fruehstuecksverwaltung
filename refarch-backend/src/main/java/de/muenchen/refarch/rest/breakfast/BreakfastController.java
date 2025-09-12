package de.muenchen.refarch.rest.breakfast;

import de.muenchen.refarch.rest.breakfast.dto.BreakfastRequestDTO;
import de.muenchen.refarch.rest.breakfast.dto.BreakfastResponseDTO;
import de.muenchen.refarch.service.BreakfastService;
import de.muenchen.refarch.theentity.TheEntity;
import de.muenchen.refarch.theentity.dto.TheEntityRequestDTO;
import de.muenchen.refarch.theentity.dto.TheEntityResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/breakfast")
public class BreakfastController {

    private final BreakfastService breakfastService;
    private final BreakfastMapper breakfastMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<BreakfastResponseDTO> getBreakfasts(@RequestParam(defaultValue = "0") final int pageNumber,
                                                    @RequestParam(defaultValue = "10") final int pageSize) {
        final Page<BreakfastEntity> page = breakfastService.getAllBreakfasts(pageNumber, pageSize);
        final List<BreakfastResponseDTO> content = page.getContent().stream().map(breakfastMapper::toDTO).toList();
        return new PageImpl<>(content, page.getPageable(), page.getTotalElements());
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBreakfast(@Valid @RequestBody final BreakfastRequestDTO breakfastRequestDTO) {
       breakfastService.createBreakfast(breakfastRequestDTO);
    }
}
