package pl.edu.pja.s13227.tin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pja.s13227.tin.model.Comment;
import pl.edu.pja.s13227.tin.service.CommentService;

import java.util.List;

@RestController
@RequestMapping({"/api/comments/", "/api/comments"})
public class CommentResource {

    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Comment> all() {
        return commentService.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Comment get(@PathVariable long id) {
        return commentService.findById(id);
    }
}
