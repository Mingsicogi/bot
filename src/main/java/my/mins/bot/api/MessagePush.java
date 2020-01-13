package my.mins.bot.api;

import my.mins.bot.app.MessageDTO;
import my.mins.bot.app.impl.LINEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/send/message")
public class MessagePush {

    @Autowired
    private LINEService lineService;

    @PostMapping("/line")
    @ResponseBody
    public ResponseEntity<String> sendMessage(/*ApiDTO.Req req*/) {

        MessageDTO message = new MessageDTO();

//        message.setMessages(req.getMessage());
        message.setMessages("징아 뭐 먹고 싶오?!");
        message.setTo("Cc8132e37b4f6d7eb457858802d3d9f45");

        return lineService.send(message) ? ResponseEntity.ok("Success") : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
