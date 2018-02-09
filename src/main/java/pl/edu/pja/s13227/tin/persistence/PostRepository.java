package pl.edu.pja.s13227.tin.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pja.s13227.tin.model.Blog;
import pl.edu.pja.s13227.tin.model.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByBlog(Blog blog);
}
