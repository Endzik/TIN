package pl.edu.pja.s13227.tin.service;

import pl.edu.pja.s13227.tin.model.Blog;
import pl.edu.pja.s13227.tin.model.Category;
import pl.edu.pja.s13227.tin.model.Post;

import java.util.List;

public interface PostService {

    Post findById(Long id);
    List<Post> findAll();
    List<Post> findByBlog(Blog blog);
    List<Post> findByCategory(Category category);
    void save(Post post);
}
