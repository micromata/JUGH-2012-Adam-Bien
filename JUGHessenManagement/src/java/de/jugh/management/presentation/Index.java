package de.jugh.management.presentation;

import de.jugh.management.business.blog.boundary.BloggingService;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class Index {
    
    @Inject 
    BloggingService bs;
    
    @PostConstruct
    public void init(){
        System.out.println("Creating index");
    }
    
    public String getMessage(){
        return this.bs.getPost();
    }
    
}
