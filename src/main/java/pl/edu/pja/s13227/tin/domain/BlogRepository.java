package pl.edu.pja.s13227.tin.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findAll();

    List<Blog> findByNameStartsWithIgnoreCase(String name);

}
