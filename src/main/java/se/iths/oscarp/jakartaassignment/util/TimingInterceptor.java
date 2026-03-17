package se.iths.oscarp.jakartaassignment.util;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.util.logging.Logger;

@Timed
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class TimingInterceptor {

    @AroundInvoke
    public Object measureTime(InvocationContext ctx) throws Throwable {
        Logger logger = Logger.getLogger(ctx.getMethod().getDeclaringClass()
                .getName());

        long startTime = System.currentTimeMillis();
        Object result = ctx.proceed();
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        logger.info("Execution time for " + ctx.getMethod().getName()
                + ": " + (duration) + " ms");
        return result;
    }
}
