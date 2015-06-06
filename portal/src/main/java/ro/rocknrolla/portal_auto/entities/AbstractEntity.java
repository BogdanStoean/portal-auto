package ro.rocknrolla.portal_auto.entities;



import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractEntity<U> {

    @ManyToOne
    private U createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @ManyToOne
    private U lastModifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

        public U getCreatedBy() {

        return createdBy;
    }

    public void setCreatedBy(final U createdBy) {

        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {

        return null == createdDate ? null : createdDate;
    }

    public void setCreatedDate(final Date createdDate) {

        this.createdDate = null == createdDate ? null : createdDate;
    }

    public U getLastModifiedBy() {

        return lastModifiedBy;
    }

    public void setLastModifiedBy(final U lastModifiedBy) {

        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {

        return null == lastModifiedDate ? null : lastModifiedDate;
    }

    public void setLastModifiedDate(final Date lastModifiedDate) {

        this.lastModifiedDate = null == lastModifiedDate ? null : lastModifiedDate;
    }
}
