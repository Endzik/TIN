package pl.edu.pja.s13227.tin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pja.s13227.tin.model.Blog;
import pl.edu.pja.s13227.tin.model.Category;
import pl.edu.pja.s13227.tin.model.Post;
import pl.edu.pja.s13227.tin.persistence.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post findById(Long id) {
        return postRepository.findOne(id);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> findByBlog(Blog blog) {
        return postRepository.findByBlog(blog);
    }

    @Override
    public List<Post> findByCategory(Category category) {
        return postRepository.findAll().stream()
                .filter(p -> p.getCategories().contains(category))
                .collect(Collectors.toList());
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }
}
