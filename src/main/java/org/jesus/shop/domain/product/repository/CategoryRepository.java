package org.jesus.shop.domain.product.repository;

import org.jesus.shop.domain.product.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
