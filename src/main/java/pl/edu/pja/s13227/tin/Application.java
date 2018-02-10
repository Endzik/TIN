package pl.edu.pja.s13227.tin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import pl.edu.pja.s13227.tin.model.Blog;
import pl.edu.pja.s13227.tin.model.Category;
import pl.edu.pja.s13227.tin.model.Post;
import pl.edu.pja.s13227.tin.persistence.BlogRepository;
import pl.edu.pja.s13227.tin.persistence.CategoryRepository;
import pl.edu.pja.s13227.tin.persistence.PostRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner initialize(BlogRepository blogRepository,
                                        CategoryRepository categoryRepository,
                                        PostRepository postRepository) {
        return args -> {
            Category programming = new Category("Programowanie");
            Category enterprise = new Category("Enterprise");
            categoryRepository.save(programming);
            categoryRepository.save(enterprise);

            blogRepository.save(new Blog("Java SE Blog", "o javie", programming));
            blogRepository.save(new Blog("Python Blog", "ktos to czyta?", programming));
            blogRepository.save(new Blog("Java EE Blog", "Spring i inne glupoty", programming, enterprise));
            blogRepository.save(new Blog("Gotujemy", "Cooking stuff"));

            Post post = new Post(blogRepository.findOne(1L), "First post");
            post.setCategories(new HashSet<>(Arrays.asList(programming, enterprise)));
            post.setContent("Tresc pierwszego posta");
            postRepository.save(post);

            LOG.info("TIN app succesfully started at {}", new Date());
        };
    }

}
