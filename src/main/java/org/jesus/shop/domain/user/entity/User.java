package org.jesus.shop.domain.user.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ShopUser", uniqueConstraints = {
        @UniqueConstraint(name = "ShopUser_Uk_Email", columnNames = {"email"})
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    private int age;

    public void changeAge(int age){
        if(age >= 0){
            this.age = age;
        }
    }
}
