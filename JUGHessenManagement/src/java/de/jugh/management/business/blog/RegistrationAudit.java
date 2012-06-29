package de.jugh.management.business.blog;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author adam bien, adam-bien.com
 */
public class RegistrationAudit {

    @Inject
    private String audit;

    @AroundInvoke
    public Object audit(InvocationContext ic) throws Exception{
        long start = System.currentTimeMillis();
        try{
            return ic.proceed();
        }finally{
            System.out.println(audit + ic.getMethod() + " in " + (System.currentTimeMillis()-start));
        }
        
    }
}
