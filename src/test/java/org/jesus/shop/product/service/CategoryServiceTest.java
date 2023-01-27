package org.jesus.shop.product.service;

import lombok.extern.slf4j.Slf4j;
import org.jesus.shop.domain.product.entity.Category;
import org.jesus.shop.domain.product.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

@Slf4j
@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;


    Category techCategory = Category.builder()
            .name("테크")
            .build();
    Category foodCategory = Category.builder()
            .name("식품")
            .build();

    @Test
    public void 카테고리_추가(){
        Category tech = categoryService.add(techCategory.getName());
        Category food = categoryService.add(foodCategory.getName());

        log.debug("tech: id={}, name={}, parent={}", tech.getId(), tech.getName(), Objects.isNull(tech.getParent()));
        log.debug("food: id={}, name={}, parent={}", food.getId(), food.getName(), Objects.isNull(food.getParent()));

        Assertions.assertNotNull(tech.getId());
        Assertions.assertNotNull(food.getId());
    }
}
