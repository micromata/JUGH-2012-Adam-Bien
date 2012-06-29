/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jugh.management.business.blog.control;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Specializes;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class CustomWatchFactory extends WatchFactory{

    @Override @Produces @Specializes
    public Watch hugo() {
        return new Watch(false);
    }
    
    
}
