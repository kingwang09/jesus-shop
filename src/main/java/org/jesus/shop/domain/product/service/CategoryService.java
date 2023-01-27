package org.jesus.shop.domain.product.service;

import lombok.RequiredArgsConstructor;
import org.jesus.shop.domain.product.entity.Category;
import org.jesus.shop.domain.product.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository repository;

    public Category add(String name){
        return repository.save(Category.builder()
                .name(name)
                .build());
    }

    public Category add(String name, Category parentCategory){
        return repository.save(Category.builder()
                .name(name)
                .parent(parentCategory)
                .build());
    }
}
