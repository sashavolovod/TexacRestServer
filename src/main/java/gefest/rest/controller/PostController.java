package gefest.rest.controller;

import gefest.rest.domain.Comment;
import gefest.rest.domain.MyPost;
import gefest.rest.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")

public class PostController {
    @Autowired
    private PostRepo postRepo;

    @GetMapping
    public Iterable<MyPost> getPosts()
    {

        return postRepo.findAll();
    }

    @PostMapping
    public MyPost addPost(@RequestBody MyPost p) {
        return postRepo.save(p);
    }
}
