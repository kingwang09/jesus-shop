package org.jesus.shop.domain.user.repository;

import org.jesus.shop.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
