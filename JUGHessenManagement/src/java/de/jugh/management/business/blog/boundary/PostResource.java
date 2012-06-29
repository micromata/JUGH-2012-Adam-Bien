package de.jugh.management.business.blog.boundary;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("posts")
@Stateless
@Produces(MediaType.TEXT_PLAIN)
public class PostResource {
    
    @Inject
    BloggingService bs;
    
    @GET
    public String getPosts(){
        return bs.getPost();
    }
}
