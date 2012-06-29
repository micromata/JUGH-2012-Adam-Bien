package de.jugh.management.business.configuration.boundary;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class Configurator {

    
    @Produces
    public String getString(InjectionPoint ip){
        String className = ip.getMember().getDeclaringClass().getName();
        String fieldName = ip.getMember().getName();
        return className + "." + fieldName;
    }
}
