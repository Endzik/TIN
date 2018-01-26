package pl.edu.pja.s13227.tin.web.component;

import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.pja.s13227.tin.domain.Blog;
import pl.edu.pja.s13227.tin.domain.BlogRepository;

@SpringComponent
@UIScope
public class BlogEditor extends VerticalLayout {

    private final BlogRepository repository;

    private Blog blog;

    TextField name = new TextField("Blog name");
    TextField description = new TextField("Blog description");

    Button save = new Button("Save", VaadinIcons.CHECK_CIRCLE);
    Button cancel = new Button("Cancel");
    Button delete = new Button("Delete", VaadinIcons.TRASH);
    CssLayout actions = new CssLayout(save, cancel, delete);

    Binder<Blog> binder = new Binder<>(Blog.class);

    @Autowired
    public BlogEditor(BlogRepository repository) {
        this.repository = repository;

        addComponents(name, description, actions);

        binder.bindInstanceFields(this);

        setSpacing(true);
        actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        save.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        save.addClickListener(e -> repository.save(blog));
        delete.addClickListener(e -> repository.delete(blog));
        cancel.addClickListener(e-> editBlog(blog));
    }

    public interface ChangeHandler {
        void onChange();
    }

    public final void editBlog(Blog b) {
        if(b == null) {
            setVisible(false);
            return;
        }
        final boolean persisted = b.getId() != null;
        if(persisted) {
            blog = repository.findOne(b.getId());
        } else {
            blog = b;
        }
        cancel.setVisible(persisted);
        binder.setBean(blog);
        setVisible(true);
        save.focus();
        name.selectAll();
    }

    public void setChangeHandler(ChangeHandler handler) {
        save.addClickListener(e -> handler.onChange());
        delete.addClickListener(e -> handler.onChange());
    }
}
