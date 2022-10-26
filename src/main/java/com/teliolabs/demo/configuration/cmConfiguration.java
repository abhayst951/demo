package com.teliolabs.demo.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.teliolabs.demo.repository",
entityManagerFactoryRef = "cmEntityManagerFactory",
transactionManagerRef = "cmTransactionManager")
public class cmConfiguration {
    @Bean
    @ConfigurationProperties("spring.datasource.cm")
    public DataSourceProperties cmDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.cm.configuration")
    public DataSource cmDataSource() {
        return cmDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }


    @Bean(name = "cmEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean cmEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder.dataSource(cmDataSource()).packages("com.teliolabs.demo.dao").build();
    }

    
    @Bean 
    public PlatformTransactionManager cmTransactionManager(
            final @Qualifier("cmEntityManagerFactory") LocalContainerEntityManagerFactoryBean cmEntityManagerFactory) {
        return new JpaTransactionManager(cmEntityManagerFactory.getObject());
    }
}
