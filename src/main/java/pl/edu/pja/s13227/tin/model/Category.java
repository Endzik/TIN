package pl.edu.pja.s13227.tin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Category extends IdEntity {

    @Column(unique = true)
    private String name;

    @JsonIgnore
    @ManyToMany
    private Set<Blog> blogs;

    @JsonIgnore
    @ManyToMany
    private Set<Post> posts;

    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
