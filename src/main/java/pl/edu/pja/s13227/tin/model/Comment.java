package pl.edu.pja.s13227.tin.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Comment extends TimestampedEntity {

    // author
    @ManyToOne
    private Post post;
    private String contents;

    public Comment() {
    }

    public Comment(Post post, String contents) {
        this.post = post;
        this.contents = contents;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}