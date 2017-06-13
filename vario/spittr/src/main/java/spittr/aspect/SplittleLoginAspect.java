package spittr.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by drugo on 12/06/2017.
 */
@Aspect
@Component
public class SplittleLoginAspect {

    static Logger logger = Logger.getLogger(SplittleLoginAspect.class);

    @Pointcut("execution(* spittr.service.LoggerAspectInfo.*(..))")
    public void allMethodsLoggerControllers(){}

    @Around("allMethodsLoggerControllers()")
    public void logging(ProceedingJoinPoint jp){
        try {
            logger.info(String.format("\n\nMessaggio da parte di: %s INIZIO",jp.getTarget().getClass()));
            jp.proceed();
            logger.info(String.format("\n\nMessaggio da parte di: %s FINE",jp.getTarget().getClass()));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
