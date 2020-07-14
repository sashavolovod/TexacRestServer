package gefest.rest.controller;

import gefest.rest.domain.User;
import gefest.rest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public Iterable<User> getUserList()
    {
        return userRepo.findAll();
    }


    @GetMapping("{id}")
    public Optional<User> getUser(@PathVariable("id") long userId) {
        return userRepo.findById(userId);
    }

    @PostMapping()
    public User addUser(@RequestBody User u) {
        return userRepo.save(u);
    }

}
