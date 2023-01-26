package org.jesus.shop.domain.product.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jesus.shop.domain.product.entity.Product;
import org.jesus.shop.domain.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public Product add(String name, int price, int initialStockCount){
        Product newProduct = Product.builder()
                .name(name)
                .price(price)
                .stockCount(initialStockCount)
                .build();
        return productRepository.save(newProduct);
    }
}
