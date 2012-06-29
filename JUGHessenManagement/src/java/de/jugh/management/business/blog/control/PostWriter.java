/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jugh.management.business.blog.control;

import de.jugh.management.business.blog.boundary.BloggingService;
import java.util.Date;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 *
 * @author adam bien, adam-bien.com
 */
@Stateless
public class PostWriter {
    
    @Asynchronous
    public Future<String> post(String message){
        System.out.println("Got message " + new Date());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(BloggingService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new AsyncResult<String>("42");
    }

}
