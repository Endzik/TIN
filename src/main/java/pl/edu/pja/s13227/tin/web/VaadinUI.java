package pl.edu.pja.s13227.tin.web;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.pja.s13227.tin.domain.Blog;
import pl.edu.pja.s13227.tin.domain.BlogRepository;
import pl.edu.pja.s13227.tin.web.component.BlogEditor;

@SpringUI
public class VaadinUI extends UI {

    private final BlogRepository blogRepository;

    private final BlogEditor editor;

    final Grid<Blog> grid;
    final TextField filter;

    private final Button createButton;

    @Autowired
    public VaadinUI(BlogRepository repository, BlogEditor editor) {
        this.blogRepository = repository;
        this.editor = editor;
        this.grid = new Grid<>(Blog.class);
        this.filter = new TextField();
        this.createButton = new Button("New blog", VaadinIcons.PLUS_CIRCLE);
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        HorizontalLayout actions = new HorizontalLayout(filter, createButton);
        VerticalLayout mainLayout = new VerticalLayout(actions, grid, editor);
        setContent(mainLayout);

        grid.setHeight(300, Unit.PIXELS);
        grid.setColumns("id", "name", "description");

        filter.setPlaceholder("Filter by blog name");
        filter.setValueChangeMode(ValueChangeMode.LAZY);
        filter.addValueChangeListener(e -> listFilteredBlogs(e.getValue()));

        grid.asSingleSelect().addValueChangeListener(e -> editor.editBlog(e.getValue()));

        createButton.addClickListener(e -> editor.editBlog(new Blog()));

        editor.setChangeHandler(() -> {
            editor.setVisible(false);
            listFilteredBlogs(filter.getValue());
        });

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
