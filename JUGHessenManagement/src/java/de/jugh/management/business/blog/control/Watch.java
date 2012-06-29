package de.jugh.management.business.blog.control;

import java.util.Date;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class Watch {
    
    private boolean precision;
    
    public Watch(boolean precision){
        this.precision = precision;
    }

    public String getTime(){
        return new Date() + "Precize: " + precision; 
    }
}
