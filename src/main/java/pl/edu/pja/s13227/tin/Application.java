package pl.edu.pja.s13227.tin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.edu.pja.s13227.tin.domain.Blog;
import pl.edu.pja.s13227.tin.domain.BlogRepository;

import java.util.Date;

@SpringBootApplication
public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner initialize(BlogRepository repository) {
        return args -> {
            repository.save(new Blog("Java SE Blog", "o javie"));
            repository.save(new Blog("Python Blog", "ktos to czyta?"));
            repository.save(new Blog("Java EE Blog", "Spring i inne glupoty"));

            LOG.info("Find all:");
            repository.findAll().forEach(b -> LOG.info("{}", b));

            LOG.info("Find by name: \"Java\":");
            repository.findByNameStartsWithIgnoreCase("java").forEach(b -> LOG.info("{}", b));

            LOG.info("Found by id: 1");
            LOG.info("{}", repository.findOne(1L));

            LOG.info("TIN app succesfully started at {}", new Date());
        };
    }

}
