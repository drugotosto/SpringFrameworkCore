package com.ferrero.config;

import com.ferrero.dao.BookDao;
import com.ferrero.dao.BookDaoJpaImpl;
import com.ferrero.dao.StudentDaoJpaImpl;
import com.ferrero.service.BookService;
import com.ferrero.service.BookServiceImpl;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by drugo on 31/05/2017.
 */
@Configuration
@ComponentScan (basePackages = {"com.ferrero"})
@EnableTransactionManagement
public class Ch5Configuration {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/beginningspringdb");
        dataSource.setUsername("drugo");
        dataSource.setPassword("Juventus84");
        return dataSource;
    }

    private Map<String,?> jpaProperties() {
        Map<String,String> jpaPropertiesMap = new HashMap<String,String>();
        jpaPropertiesMap.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        jpaPropertiesMap.put("hibernate.hbm2ddl.auto", "update");
        return jpaPropertiesMap;
    }

    @Bean
    @Autowired
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("com.ferrero");
        factoryBean.setJpaPropertyMap(jpaProperties());
        return factoryBean;
    }

    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
