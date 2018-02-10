package pl.edu.pja.s13227.tin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.pja.s13227.tin.model.Category;
import pl.edu.pja.s13227.tin.service.CategoryService;

import javax.validation.Valid;

@Controller
@RequestMapping({"/categories", "/categories/"})
public class CategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @RequestMapping
    public String categories(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("categories", categoryService.findAll());
        return "categories";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
        if(result.hasErrors()) {
            result.getAllErrors().forEach(e -> LOGGER.warn("Error: {}", e));
            return "redirect:/categories";
        }
        if(categoryService.findByName(category.getName()) == null) {
            categoryService.save(category);
        }
        return "redirect:/categories";
    }


}
