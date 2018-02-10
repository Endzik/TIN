package pl.edu.pja.s13227.tin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pja.s13227.tin.model.Comment;
import pl.edu.pja.s13227.tin.persistence.CommentRepository;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment findById(Long id) {
        return commentRepository.findOne(id);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> findByContent(String content) {
        return commentRepository.findByContentsContainingIgnoreCase(content);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }
}
