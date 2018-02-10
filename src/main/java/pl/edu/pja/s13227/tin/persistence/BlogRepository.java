package pl.edu.pja.s13227.tin.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pja.s13227.tin.model.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long> {

    Blog findByName(String name);

}
