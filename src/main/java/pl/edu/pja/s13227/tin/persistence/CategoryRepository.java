package pl.edu.pja.s13227.tin.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pja.s13227.tin.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);

}
