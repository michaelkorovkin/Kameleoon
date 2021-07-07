package com.kameleoon.test.model;

import com.kameleoon.test.model.dto.User;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.OffsetDateTime;
import java.util.List;

@SpringBootTest
class UserManagerTest {
    /**
     *
     */
    @Autowired
    UserManager userManager;

    @Test
    @Ignore
    public void listAll() {
        List res = userManager.listAll();
        System.out.println("Users count = " + res.size());
        System.out.println("User[0]:"+res.get(0));
    }

    @Test
    @Ignore
    public void getById() {
        User res = userManager.get(4L);
        System.out.println("User:"+res);
    }
    @Test
    @Ignore
    public void saveUser () {
        User user = new User();
        user.setUserName("testUser3");
        user.setUserPassword("passord3");
        user.setComment("Testing user manager");
        user.setCreateDate(OffsetDateTime.now());

        userManager.save(user);
    }
    @Test
    @Ignore
    public void deleteUser () {
        userManager.delete(3L);
    }
}