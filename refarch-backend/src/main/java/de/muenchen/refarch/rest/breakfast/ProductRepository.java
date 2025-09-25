package de.muenchen.refarch.rest.breakfast;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<ProductEntity, UUID>, CrudRepository<ProductEntity, UUID> {

}
