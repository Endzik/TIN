package pl.edu.pja.s13227.tin.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Blog extends TimestampedEntity {

//    user owner
    @Column(unique = true)
    private String name;
    private String description;

    @ManyToMany
    @JoinTable
    private Set<Category> categories = new HashSet<>();

    public Blog(){}

    public Blog(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Blog(String name, String description, Set<Category> categories) {
        this.name = name;
        this.description = description;
        this.categories = categories;
    }

    public Blog(String name, String description, Category... categories) {
        this.name = name;
        this.description = description;
        this.categories = new HashSet<>(Arrays.asList(categories));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}


/*

COMMENT

id
author
post
content

 */