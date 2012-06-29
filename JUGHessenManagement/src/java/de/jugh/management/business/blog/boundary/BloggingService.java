package de.jugh.management.business.blog.boundary;

import de.jugh.management.business.blog.RegistrationAudit;
import de.jugh.management.business.blog.control.PostWriter;
import de.jugh.management.business.blog.control.Watch;
import de.jugh.management.business.blog.entity.BlogPost;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Asynchronous;
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
    
    @Inject
    private String message;
    
    @Inject
    PostWriter writer;
    
    @PostConstruct
    public void init(){
        System.out.println("Creating BloggingService");
    }
    
    public BlogPost getPost(){
        String msg = message+ watch.getTime();
        final BlogPost blogPost = new BlogPost(msg);
        em.persist(blogPost);
        return blogPost;
    }
    
    public void post(String message){
        List<Future<String>> responses = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            Future<String> post = writer.post(message);
            responses.add(post);
        }
        
        for (Future<String> future : responses) {
            try {
                System.out.println("--- " + future.get());
            } catch (InterruptedException ex) {
                Logger.getLogger(BloggingService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(BloggingService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
