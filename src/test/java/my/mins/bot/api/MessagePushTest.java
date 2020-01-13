package my.mins.bot.api;

import my.mins.bot.app.MessageDTO;
import my.mins.bot.app.impl.LINEService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MessagePushTest {

    @Autowired
    private LINEService lineService;

    @Test
    public void sendMessage() {


        MessageDTO message = new MessageDTO();

        message.setMessages("징아 뭐 먹고싶은게 있니???");
        message.setTo("Cc8132e37b4f6d7eb457858802d3d9f45");

        lineService.send(message);

        Assert.assertTrue(true);
    }
}