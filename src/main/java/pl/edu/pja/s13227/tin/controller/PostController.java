package pl.edu.pja.s13227.tin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.pja.s13227.tin.model.Blog;
import pl.edu.pja.s13227.tin.model.Post;
import pl.edu.pja.s13227.tin.service.PostService;

@Controller
@RequestMapping({"/posts", "/posts/"})
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String deletePost(@PathVariable Long id) {
        Post post = postService.findById(id);
        Blog blog = post.getBlog();
        postService.delete(post);
        return "redirect:/blogs/"+blog.getId();
    }

}
