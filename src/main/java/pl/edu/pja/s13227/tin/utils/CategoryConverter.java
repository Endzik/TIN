package pl.edu.pja.s13227.tin.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.edu.pja.s13227.tin.model.Category;
import pl.edu.pja.s13227.tin.service.CategoryService;

@Component
public class CategoryConverter implements Converter<Long, Category> {

    @Autowired
    private CategoryService categoryService;

    @Override
    public Category convert(Long id) {
        return categoryService.findById(id);
    }
}
