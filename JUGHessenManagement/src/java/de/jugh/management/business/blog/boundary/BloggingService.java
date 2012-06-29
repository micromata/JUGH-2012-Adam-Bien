package de.jugh.management.business.blog.boundary;

import de.jugh.management.business.blog.RegistrationAudit;
import de.jugh.management.business.blog.control.Watch;
import de.jugh.management.business.blog.entity.BlogPost;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.UserTransaction;

@Interceptors(RegistrationAudit.class)
@Stateless
public class BloggingService {
    
    @PersistenceContext
    EntityManager em;
    
    @Inject
    Watch watch;
    
    @PostConstruct
    public void init(){
        System.out.println("Creating BloggingService");
    }
    
    public BlogPost getPost(){
        String msg = "from db "+ watch.getTime();
        final BlogPost blogPost = new BlogPost(msg);
        em.persist(blogPost);
        return blogPost;
    }
    
}
