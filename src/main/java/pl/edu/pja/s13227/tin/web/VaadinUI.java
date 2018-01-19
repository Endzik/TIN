package pl.edu.pja.s13227.tin.web;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.pja.s13227.tin.domain.Blog;
import pl.edu.pja.s13227.tin.domain.BlogRepository;

@SpringUI
@Theme("valo")
public class VaadinUI extends UI {

    private BlogRepository blogRepository;

    private VerticalLayout mainLayout;

    private Grid<Blog> grid;
    private TextField filter;

    @Autowired
    public VaadinUI(BlogRepository repository) {
        this.blogRepository = repository;
        this.grid = new Grid<>(Blog.class);
        this.filter = new TextField();
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        filter.setPlaceholder("Filter by blog name");
        filter.setValueChangeMode(ValueChangeMode.LAZY);
        filter.addValueChangeListener(e -> listFilteredBlogs(e.getValue()));
        mainLayout = new VerticalLayout(filter, grid);
        setContent(mainLayout);

        listBlogs();
    }

    private void listFilteredBlogs(String filterText) {
        if(filterText.isEmpty()) {
            listBlogs();
        } else {
            grid.setItems(blogRepository.findByNameStartsWithIgnoreCase(filterText));
        }
    }

    private void listBlogs() {
        grid.setItems(blogRepository.findAll());
    }
}
