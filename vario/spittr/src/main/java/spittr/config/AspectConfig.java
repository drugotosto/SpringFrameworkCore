package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import spittr.aspect.SplittleSpitterLoggingAspect;

/**
 * Created by drugo on 13/06/2017.
 */
@Configuration
/*
    Permette di abilitare l'auto-proxing. Si vanno così a creare i diversi proxies attorno ad ogni bean
    per i quali è stato rilevato un matching tramite pointcuts.
 */
@EnableAspectJAutoProxy
public class AspectConfig {

    /*E' necessario inoltre effettuare sempre la dichiarazione del bean associato all'Aspect*/
    @Bean
    public SplittleSpitterLoggingAspect splittleSpitterLoggingAspect (){
        return new SplittleSpitterLoggingAspect();
    }
}
