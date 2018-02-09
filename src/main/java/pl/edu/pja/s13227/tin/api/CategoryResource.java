package pl.edu.pja.s13227.tin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pja.s13227.tin.model.Category;
import pl.edu.pja.s13227.tin.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping({"/api/categories/", "/api/categories"})
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> all() {
        return categoryService.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Category get(@PathVariable long id) {
        return categoryService.findById(id);
    }
}
