package org.example.umcmission.service.FoodCategoryService;

import lombok.RequiredArgsConstructor;
import org.example.umcmission.repository.FoodCategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FoodCategoryCommandServiceImpl implements FoodCategoryCommandService {
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public boolean existsById(Long id) {
        return foodCategoryRepository.existsById(id);
    }
}
