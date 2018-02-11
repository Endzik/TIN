package pl.edu.pja.s13227.tin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pja.s13227.tin.model.Blog;
import pl.edu.pja.s13227.tin.persistence.BlogRepository;
import pl.edu.pja.s13227.tin.persistence.PostRepository;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogServiceImpl.class);

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public Blog findById(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public Blog findByName(String name) {
        return blogRepository.findByName(name);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
        LOGGER.info("Saved blog: {}", blog);
    }

    @Override
    public void delete(Blog blog) {
        blog.getPosts().forEach(postRepository::delete);
        blogRepository.delete(blog);
    }
}
