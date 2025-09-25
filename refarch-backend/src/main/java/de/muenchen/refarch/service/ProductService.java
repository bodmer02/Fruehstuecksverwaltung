package de.muenchen.refarch.service;

import de.muenchen.refarch.rest.breakfast.ProductEntity;
import de.muenchen.refarch.rest.breakfast.ProductMapper;
import de.muenchen.refarch.rest.breakfast.ProductRepository;
import de.muenchen.refarch.rest.breakfast.dto.ProductRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Page<ProductEntity> getAllBreakfasts(final int pageNumber, final int pageSize) {
        final Pageable pageRequest = PageRequest.of(pageNumber, pageSize);
        return productRepository.findAll(pageRequest);
    }

    public void createBreakfast(ProductRequestDTO productRequestDTO) {
        productRepository.save(productMapper.toEntity(productRequestDTO));
    }
}
