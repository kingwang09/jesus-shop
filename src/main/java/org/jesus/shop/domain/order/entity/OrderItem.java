package org.jesus.shop.domain.order.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jesus.shop.domain.product.entity.Product;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="shop_order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="order_id", foreignKey = @ForeignKey(name = "shop_order_item_orderId_fk"))
    private Order order;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    private int orderCount;
}
