package spittr.config;

import com.mysql.jdbc.Connection;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by drugo on 29/05/2017.
 */

@Configuration
/*
    scans its base package for any interfaces that extend Spring Data JPA’s Repository interface.
*/
@EnableJpaRepositories("spittr.dao")
/*
@EnableTansactionManagement makes Spring recognize @Transactional annotations.
Therefore you put an @Transactional annotation on top of the JpaSpitterRepository, JpaSpittleRepository classes
so that methods defined inside this class are transactional.
*/
@EnableTransactionManagement
public class DataConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spittrdb");
        dataSource.setUsername("drugo");
        dataSource.setPassword("Juventus84");
//        dataSource.setUrl("jdbc:mysql://aa1a4805sbzud1f.ccac28rryomi.eu-central-1.rds.amazonaws.com:3306/ebdb");
//        dataSource.setUsername("admin");
//        dataSource.setPassword("spittr-war");
        return dataSource;
    }

    /*
    Its role is to provide JPA‐specific configuration parameters.
    */
    private Map<String,?> jpaProperties() {
        Map<String,String> jpaPropertiesMap = new HashMap<String,String>();
        jpaPropertiesMap.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
        jpaPropertiesMap.put("hibernate.hbm2ddl.auto", "update");
        return jpaPropertiesMap;
    }

    /*
    LocalContainerEntityManagerFactoryBean is the most powerful and flexible JPA configuration
    approach Spring offers. It gives full control over EntityManagerFactory configuration.
    It enables you to work with a Spring‐managed DataSource, lets you selectively load
    entity classesin your project’s classpath, and so on.
    */
    @Bean
    @Autowired
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPersistenceProviderClass(HibernatePersistence.class);
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("spittr.model");
        factoryBean.setJpaPropertyMap(jpaProperties());
        return factoryBean;
    }

    /*
    You need to configure the PersistenceAnnotationBeanPostProcessor of Spring in order for
    the annotations @EntityManagerFactory or @EntityManager in the repository classes to be processed.
    Spring also advises your DAO beans, catches technology‐specific data access exceptions, and
    translates them to its own DataAccessException hierarchy.
    */
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }


    /*
    Because you need to have an active transaction in order to perform data manipulation
    operations using JPA you have to enable Spring Container–managed transactions.
    Spring’s transaction abstraction model is based on the PlatformTransactionManager interface.
    Different concrete implementations of it exist, and each one corresponds to one particular data access technology.
    JpaTransactionManager: Suitable if you are using JPA. It is also possible to use JDBC at the same time with this implementation.

    Creates a bean from the JpaTransactionManager class and sets the EntityManagerFactory instance taken with autowiring into it.
    That’s enough for you to have an active transaction and use a shared EntityManager instance managed by Spring Container.
    You get an IllegalStateException mentioning that you can only have an active transaction either via Spring or EJB CMT.
    */
    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
