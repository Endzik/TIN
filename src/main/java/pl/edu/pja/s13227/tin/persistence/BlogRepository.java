package pl.edu.pja.s13227.tin.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pja.s13227.tin.model.Blog;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findAll();

    List<Blog> findByNameStartsWithIgnoreCase(String name);

}
