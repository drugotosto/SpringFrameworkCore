package com.ferrero;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
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
        jpaPropertiesMap.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
        jpaPropertiesMap.put("hibernate.hbm2ddl.auto", "update");
        return jpaPropertiesMap;
    }


	@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("com.ferrero");
        factoryBean.setJpaPropertyMap(jpaProperties());
        return factoryBean;
    }


}
