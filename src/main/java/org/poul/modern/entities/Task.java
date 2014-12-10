package org.poul.modern.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity @Table(name = "Tasks") @XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Task.findByIdTask", query = "SELECT t FROM Task t WHERE t.idTask = :idTask"),
    @NamedQuery(name = "Task.findBySlug"  , query = "SELECT t FROM Task t WHERE t.slug = :slug"),
    @NamedQuery(name = "Task.findByDone"  , query = "SELECT t FROM Task t WHERE t.done = :done"),
    @NamedQuery(name = "Task.findAll"     , query = "SELECT t FROM Task t")
})
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @Column(name = "idTask") @GeneratedValue(strategy = GenerationType.IDENTITY) @Basic(optional = false) 
    private Integer idTask;

    @Column(name = "title") @Basic(optional = false) @NotNull @Lob @Size(min = 1, max = 65535) 
    private String title;

    @Column(name = "body") @Lob @Size(max = 65535)
    private String body;
    
    @Basic(optional = false) @NotNull @Size(min = 1, max = 45) @Column(name = "slug")
    private String slug;
    
    @Column(name = "done")
    private Boolean done;

    public Task(String title, String slug) {
        this.idTask = null;
        this.title = title;
        this.slug = slug;
    }

    public Integer getIdTask() {
        return idTask;
    }

    public void setIdTask(Integer idTask) {
        this.idTask = idTask;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTask != null ? idTask.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.idTask == null && other.idTask != null) || (this.idTask != null && !this.idTask.equals(other.idTask))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.poul.modern.Task[ idTask=" + idTask + " ]";
    }
}
