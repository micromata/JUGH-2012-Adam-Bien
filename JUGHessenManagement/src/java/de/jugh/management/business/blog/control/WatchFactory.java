package de.jugh.management.business.blog.control;

import javax.enterprise.inject.Produces;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class WatchFactory {

    
    @Produces
    public Watch hugo(){
        return new Watch(true);
    }
    
}
