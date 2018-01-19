package pl.edu.pja.s13227.tin.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Blog {

    @Id
    @GeneratedValue
    private Long id;

    private Date created;
//    user owner
//    category category
    @Column(unique = true)
    private String name;
    private String description;

    private Blog(){}

    public Blog(String name, String description) {
        this.created = new Date();
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Date getCreated() {
        return created;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}


/*
POST

id
created
blog
author
category (enum)
title
content

BLOG

id
created
owner
category
name

COMMENT

id
author
post
content

 */