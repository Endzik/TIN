package pl.edu.pja.s13227.tin.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pja.s13227.tin.model.Comment;
import pl.edu.pja.s13227.tin.model.Post;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPost(Post post);

    List<Comment> findByContentsContainingIgnoreCase(String content);
}
