package ro.rocknrolla.portal_auto.entities;


import ro.rocknrolla.portal_auto.security.CurrentAuthenticatedUser;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractEntity<U> {

    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    private String lastModifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    public String getCreatedBy() {

        return createdBy;
    }

    public void setCreatedBy(final String createdBy) {

        this.createdBy = createdBy;
    }

    @PreUpdate
    public void preUpdate() {
        this.lastModifiedBy = CurrentAuthenticatedUser.getUsername();
        this.lastModifiedDate = new Date();
    }

    @PrePersist
    public void prePersist() {
        this.createdBy = CurrentAuthenticatedUser.getUsername();
        this.lastModifiedBy = CurrentAuthenticatedUser.getUsername();
        this.createdDate = new Date();
        this.lastModifiedDate = new Date();
    }

    public Date getCreatedDate() {

        return null == createdDate ? null : createdDate;
    }

    public void setCreatedDate(final Date createdDate) {

        this.createdDate = null == createdDate ? null : createdDate;
    }

    public String getLastModifiedBy() {

        return lastModifiedBy;
    }

    public void setLastModifiedBy(final String lastModifiedBy) {

        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {

        return null == lastModifiedDate ? null : lastModifiedDate;
    }

    public void setLastModifiedDate(final Date lastModifiedDate) {

        this.lastModifiedDate = null == lastModifiedDate ? null : lastModifiedDate;
    }
}
