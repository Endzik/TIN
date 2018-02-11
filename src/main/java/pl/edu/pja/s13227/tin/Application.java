package pl.edu.pja.s13227.tin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import pl.edu.pja.s13227.tin.persistence.BlogRepository;
import pl.edu.pja.s13227.tin.persistence.CategoryRepository;
import pl.edu.pja.s13227.tin.persistence.PostRepository;

import java.util.Date;

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
        // Init some data if needed
        return args -> LOG.info("TIN app succesfully started at {}", new Date());
    }

}
