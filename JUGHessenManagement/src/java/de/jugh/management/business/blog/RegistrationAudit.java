package de.jugh.management.business.blog;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class RegistrationAudit {


    @AroundInvoke
    public Object audit(InvocationContext ic) throws Exception{
        long start = System.currentTimeMillis();
        try{
            return ic.proceed();
        }finally{
            System.out.println(" " + ic.getMethod() + " in " + (System.currentTimeMillis()-start));
        }
        
    }
}
