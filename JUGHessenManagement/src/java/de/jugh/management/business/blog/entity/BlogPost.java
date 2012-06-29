package de.jugh.management.business.blog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author adam bien, adam-bien.com
 */
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
    
    
    
}
