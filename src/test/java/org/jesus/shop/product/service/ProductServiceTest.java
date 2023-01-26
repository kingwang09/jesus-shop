package org.jesus.shop.product.service;

import lombok.extern.slf4j.Slf4j;
import org.jesus.shop.domain.product.entity.Product;
import org.jesus.shop.domain.product.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService service;

    @Test
    public void 상품추가(){
        Product product = service.add("첫번째 상품", 1500, 100);
        log.debug("product: {}", product);

        Assertions.assertNotNull(product.getId());
    }
}
