package pl.edu.pja.s13227.tin.model;

import javax.persistence.Basic;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.util.Date;

@MappedSuperclass
public abstract class TimestampedEntity extends IdEntity {

    @Basic(optional = false)
    protected Date created;

    public TimestampedEntity() {
        super();
        this.created = new Date();
    }

    @PrePersist
    protected void persist() {
        if (created == null) {
            created = new Date();
        }
    }

    public Date getCreated() {
        return created;
    }

}
