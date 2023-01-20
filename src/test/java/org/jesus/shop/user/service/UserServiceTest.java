package org.jesus.shop.user.service;

import lombok.extern.slf4j.Slf4j;
import org.jesus.shop.domain.user.entity.User;
import org.jesus.shop.domain.user.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    private User jesusUser = User.builder()
            .email("jesus@heaven.com")
            .age(30)
            .build();

    @BeforeEach
    public void init(){
        userService.add(jesusUser);
    }

    @Test
    public void 사용자_나이_수정(){
        log.debug("jesus change age: {}", jesusUser);
        jesusUser = userService.changeUserAge(jesusUser.getId(), 33);//id로 조회할 때 새로운 영속성 객체가 조회되서 수정된다.

        Assertions.assertEquals(33, jesusUser.getAge());
    }

    @Test
    public void 사용자_나이_준영속(){
        log.debug("jesus change age: {}", jesusUser);
        User afterChanged = userService.changeUserAge(jesusUser, 45);//객체로 조회할 때에도 이미 준영속 상태이기 때문에 select쿼리가 나가게 되고 새로운 영속성 객체가 조회되서 수정된다.

        Assertions.assertEquals(45, afterChanged.getAge());
        Assertions.assertEquals(false, afterChanged.equals(jesusUser));
    }

    @Test
    public void 사용자_나이_신규변경(){
        //처음 생성하는 객체인 경우, insert쿼리만 발생
        User newUser = userService.changeUserAge(User.builder()
                .email("loveAndPeace@knou.ac.kr")
                .age(0)
                .build(), 65);//객체로 조회할 때에도 이미 준영속 상태이기 때문에 select쿼리가 나가게 되고 새로운 영속성 객체가 조회되서 수정된다.
        Assertions.assertEquals(65, newUser.getAge());
    }
}
