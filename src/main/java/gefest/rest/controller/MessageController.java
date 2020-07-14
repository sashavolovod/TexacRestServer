package gefest.rest.controller;

import gefest.rest.domain.Message;
import gefest.rest.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class MessageController {

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping
    public Iterable<Message> getMessageList()
    {
        return messageRepo.findAll();
    }


    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") long messageId) {
        return messageRepo.findById(messageId);
    }

    @PostMapping
    public Message addMessage(@RequestBody Message message) {
        return messageRepo.save(message);
    }

}
