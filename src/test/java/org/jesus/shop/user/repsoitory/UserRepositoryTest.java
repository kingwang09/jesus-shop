package org.jesus.shop.user.repsoitory;

import lombok.extern.slf4j.Slf4j;
import org.jesus.shop.domain.user.entity.User;
import org.jesus.shop.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
        log.debug("user1 save: {}", jesusUser);
        userRepository.save(jesusUser);
        log.debug("user1 after save: {}", jesusUser);

        log.debug("user2 save: {}", loveUser);
        userRepository.save(loveUser);
        log.debug("user2 after save: {}", loveUser);

        log.debug("user1 & jesus: {}", jesusUser);
        log.debug("user2 & love&peace: {}", loveUser);

        //then
        Assertions.assertEquals("jesus@heaven.com", jesusUser.getUserName());
        Assertions.assertNotNull(jesusUser.getId());

        Assertions.assertEquals("loveandpeace@heaven.com", loveUser.getUserName());
        Assertions.assertNotNull(loveUser.getId());
    }

    @Transactional
    @Test
    public void 사용자_변경(){
        log.debug("user1 save: {}", jesusUser);
        userRepository.save(jesusUser);
        log.debug("user1 after save: {}", jesusUser);

        jesusUser.changeAge(33);
        log.debug("user1 after change age: {}", jesusUser);
    }
}