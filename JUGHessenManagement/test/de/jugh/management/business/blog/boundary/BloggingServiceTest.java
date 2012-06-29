/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jugh.management.business.blog.boundary;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class BloggingServiceTest {
    

    
    BloggingService cut;

    EntityManager em;
    EntityTransaction et;
    
    @Before
    public void initialize(){
        this.cut= new BloggingService();
        this.em = Persistence.createEntityManagerFactory("test").createEntityManager();
        this.et = this.em.getTransaction();
    }
    

    @Test
    public void getPost() throws Exception {
        this.et.begin();
        this.et.commit();
    }
}
