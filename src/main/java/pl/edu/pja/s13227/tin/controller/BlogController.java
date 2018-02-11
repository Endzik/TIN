package pl.edu.pja.s13227.tin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.pja.s13227.tin.model.Blog;
import pl.edu.pja.s13227.tin.model.Post;
import pl.edu.pja.s13227.tin.service.BlogService;
import pl.edu.pja.s13227.tin.service.CategoryService;
import pl.edu.pja.s13227.tin.service.PostService;

import javax.validation.Valid;

@Controller
@RequestMapping({"/blogs", "/blogs/"})
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PostService postService;

    @RequestMapping
    public String blogs(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "blogs";
    }

    @RequestMapping("/{id}")
    public String blog(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("newPost", new Post());
        model.addAttribute("categories", categoryService.findAll());
        return "blog";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String deleteBlog(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        blogService.delete(blog);
        return "redirect:/blogs";
    }

    @RequestMapping("/new")
    public String newBlog(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.findAll());
        return "newBlog";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBlog(@Valid @ModelAttribute("blog") Blog blog, BindingResult result) {
        if(result.hasErrors()) {
            return "redirect:/blogs/new";
        }
        if(blogService.findByName(blog.getName()) == null) {
            blogService.save(blog);
        }
        return "redirect:/blogs";
    }

    @RequestMapping(value = "/{id}/addPost", method = RequestMethod.POST)
    public String addPost(@PathVariable Long id, @Valid @ModelAttribute("newPost") Post newPost, BindingResult result) {
        if(result.hasErrors()) {
            return "redirect:/blogs/"+id;
        }
        Blog blog = blogService.findById(id);
        newPost.setBlog(blog);
        postService.save(newPost);
        return "redirect:/blogs/"+id;
    }

}
