package de.muenchen.refarch.service;

import de.muenchen.refarch.rest.breakfast.BreakfastEntity;
import de.muenchen.refarch.rest.breakfast.BreakfastMapper;
import de.muenchen.refarch.rest.breakfast.BreakfastRepository;
import de.muenchen.refarch.rest.breakfast.dto.BreakfastRequestDTO;
import de.muenchen.refarch.security.Authorities;
import de.muenchen.refarch.theentity.TheEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class BreakfastService {

    private final BreakfastRepository breakfastRepository;
    private final BreakfastMapper breakfastMapper;

    public List<BreakfastEntity> getAllBreakfasts() {
        return StreamSupport.stream(breakfastRepository.findAll().spliterator(), false).toList();
    }

    public void createBreakfast(BreakfastRequestDTO breakfastRequestDTO) {
        breakfastRepository.save(breakfastMapper.toEntity(breakfastRequestDTO));
    }
}
