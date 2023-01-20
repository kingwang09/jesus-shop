package org.jesus.shop.domain.user.entity;

import lombok.*;
import org.jesus.shop.domain.user.constant.Role;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name="shop_user",
        uniqueConstraints = {
            @UniqueConstraint(name = "shop_user_uk_email", columnNames = {"email"}),
        },
        indexes = {
            @Index(name = "shop_user_email_idx", columnList = "email")
        }
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    private int age;

    private LocalDateTime registeredAt;

    public void changeAge(int age){
        if(age >= 0){
            this.age = age;
        }
    }
}
