package de.muenchen.refarch.rest.breakfast;

import de.muenchen.refarch.theentity.TheEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BreakfastRepository extends PagingAndSortingRepository<BreakfastEntity, UUID>, CrudRepository<BreakfastEntity, UUID> {

}
