package pl.edu.pja.s13227.tin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pja.s13227.tin.model.Blog;
import pl.edu.pja.s13227.tin.persistence.BlogRepository;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog findById(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }
}
