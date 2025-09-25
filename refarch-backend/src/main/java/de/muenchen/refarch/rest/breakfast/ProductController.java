package de.muenchen.refarch.rest.breakfast;

import de.muenchen.refarch.rest.breakfast.dto.ProductRequestDTO;
import de.muenchen.refarch.rest.breakfast.dto.ProductResponseDTO;
import de.muenchen.refarch.service.ProductService;
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
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ProductResponseDTO> getBreakfasts(@RequestParam(defaultValue = "0") final int pageNumber,
                                                  @RequestParam(defaultValue = "10") final int pageSize) {
        final Page<ProductEntity> page = productService.getAllBreakfasts(pageNumber, pageSize);
        final List<ProductResponseDTO> breakfastRequestDTOList = page.getContent().stream().map(productMapper::toDTO).toList();
        return new PageImpl<>(breakfastRequestDTOList, page.getPageable(), page.getTotalElements());
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBreakfast(@Valid @RequestBody final ProductRequestDTO productRequestDTO) {
       productService.createBreakfast(productRequestDTO);
    }
}
