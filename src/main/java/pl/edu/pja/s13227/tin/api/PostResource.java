package pl.edu.pja.s13227.tin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pja.s13227.tin.model.Post;
import pl.edu.pja.s13227.tin.service.PostService;

import java.util.List;

@RestController
@RequestMapping({"/api/posts/", "/api/posts"})
public class PostResource {

    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Post> all() {
        return postService.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Post get(@PathVariable long id) {
        return postService.findById(id);
    }
}
