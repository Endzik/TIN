package pl.edu.pja.s13227.tin.service;

import pl.edu.pja.s13227.tin.model.Blog;

import java.util.List;

public interface BlogService {

    Blog findById(Long id);
    Blog findByName(String name);
    List<Blog> findAll();
    void save(Blog blog);
    void delete(Blog blog);
}
