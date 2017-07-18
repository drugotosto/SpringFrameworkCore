package spittr.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.*;

/**
 * Created by drugo on 12/06/2017.
 */
/*
* Aspect che si preoccupa di fornire delle informazioni di Debug e quindi implementa fuzionalità di Logging tramite
* utilizzo del "logger" (libreria Log4j).
* */
@Aspect
public class SplittleSpitterLoggingAspect {

    static Logger logger = Logger.getLogger(SplittleSpitterLoggingAspect.class);

    /*
    * Pointcut che attraverso l'uso della tale espressione permette di definire su quali metodi azionare/agganciare
      i dati Advice descritti del seguito. In questo caso si è deciso di farlo per tutti!
    * N.B: I JointPoints a cui si fa riferimento devono essere sempre associati ad una interfaccia. In questo caso
    * tale interfaccia risulta essere "SpittleService"
    * */
    @Pointcut("execution(* spittr.service.SpittleService.*(..))")
    public void allMethodsLoggerSpittleService(){}

    //Il tale Advice viene eseguito prima dell'esecuzione del metodo al quale è associato
    @Before("allMethodsLoggerSpittleService()")
    public void printPreInfoSpittleService(){
        logger.debug("Prima di eseguire il metodo di SpittleService!");
    }

    //Il tale Advice viene eseguito dopo l'esecuzione del metodo al quale è associato
    @After("allMethodsLoggerSpittleService()")
    public void printPostInfoSpittleService(){
        logger.debug("Dopo che si è eseguito il metodo di SpittleService!");
    }


    /*
      Viene definito come Pointcut quello relativo ai metodi (tutti) dell'interfaccia "SpitterService"
     */
    @Pointcut("execution(* spittr.service.SpitterService.*(..))")
    public void allMethodsLoggerSpitterService(){}

    @Before("allMethodsLoggerSpitterService()")
    public void printPreInfoSpitterService(){
        logger.debug("Prima di eseguire il metodo di SpitterService!");
    }

    @After("allMethodsLoggerSpitterService()")
    public void printPostInfoSpitterService(){
        logger.debug("Dopo che si è eseguito il metodo di SpitterService!");
    }
}
