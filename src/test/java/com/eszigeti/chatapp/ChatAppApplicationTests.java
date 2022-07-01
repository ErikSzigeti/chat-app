package com.eszigeti.chatapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles(profiles = "dev")
class ChatAppApplicationTests {

    @Test
    void contextLoads() {
    }

}
