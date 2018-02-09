package pl.edu.pja.s13227.tin.service;

import pl.edu.pja.s13227.tin.model.Comment;

import java.util.List;

public interface CommentService {

    Comment findById(Long id);
    List<Comment> findAll();
    List<Comment> findByContent(String content);
}
