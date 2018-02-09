package pl.edu.pja.s13227.tin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pja.s13227.tin.model.Blog;
import pl.edu.pja.s13227.tin.service.BlogService;

import java.util.List;

@RestController
@RequestMapping({"/api/blogs/", "/api/blogs"})
public class BlogResource {

    @Autowired
    private BlogService blogService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Blog> all() {
        return blogService.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Blog get(@PathVariable long id) {
        return blogService.findById(id);
    }
}
