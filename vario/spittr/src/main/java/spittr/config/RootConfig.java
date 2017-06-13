package spittr.config;

/**
 * Created by drugo on 17/05/2017.
 */
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import spittr.aspect.SplittleLoginAspect;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages={"spittr"}, excludeFilters={@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)})
/*
    scans its base package for any interfaces that extend Spring Data JPA’s Repository interface.
*/
@EnableJpaRepositories("spittr.dao")
public class RootConfig {
//    @Bean
//    public SplittleLoginAspect splittleLoginAspect(){
//        return new SplittleLoginAspect();
//    }
}
