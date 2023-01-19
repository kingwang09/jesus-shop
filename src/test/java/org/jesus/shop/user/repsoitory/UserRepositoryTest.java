package org.jesus.shop.user.repsoitory;

import lombok.extern.slf4j.Slf4j;
import org.jesus.shop.domain.user.entity.User;
import org.jesus.shop.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User jesusUser = User.builder()
            .userName("jesus@heaven.com")
            .age(30)
            .build();

    private User loveUser = User.builder()
            .userName("loveandpeace@heaven.com")
            .age(60)
            .build();

    @Test
    public void 사용자_추가(){
        //given & when
        User user1 = userRepository.save(jesusUser);
        User user2 = userRepository.save(loveUser);

        log.debug("user1 & jesus: {}", user1);
        log.debug("user2 & love&peace: {}", user2);

        //then
        Assertions.assertEquals(jesusUser.getUserName(), user1.getUserName());
        Assertions.assertNotNull(user1.getId());

        Assertions.assertEquals(loveUser.getUserName(), user2.getUserName());
        Assertions.assertNotNull(user2.getId());
    }
}
