package de.jugh.management.business.blog.boundary;

import de.jugh.management.business.blog.entity.BlogPost;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("posts")
@Stateless
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class PostResource {
    
    @Inject
    BloggingService bs;
    
    @GET
    public BlogPost getPosts(){
        return bs.getPost();
    }
}
