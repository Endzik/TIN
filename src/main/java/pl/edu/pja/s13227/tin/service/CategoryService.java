package pl.edu.pja.s13227.tin.service;

import pl.edu.pja.s13227.tin.model.Category;

import java.util.List;

public interface CategoryService {

    Category findById(Long id);
    Category findByName(String name);
    List<Category> findAll();
    void save(Category category);
}
