package de.jugh.management.business.blog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adam bien, adam-bien.com
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Entity
public class BlogPost {
    
    @Id
    @GeneratedValue
    private long id;
    private String title;

    public BlogPost(String title) {
        this.title = title;
    }

    public BlogPost() {
    }

    @Override
    public String toString() {
        return "BlogPost{" + "id=" + id + ", title=" + title + '}';
    }
    
    
    
}
