package pl.edu.pja.s13227.tin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pja.s13227.tin.service.BlogService;
import pl.edu.pja.s13227.tin.service.CategoryService;

@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/")
    public String index(Model model) {
        LOGGER.info("Opening home page...");
        model.addAttribute("blogs", blogService.findAll());
        return "redirect:/blogs";
    }

}
