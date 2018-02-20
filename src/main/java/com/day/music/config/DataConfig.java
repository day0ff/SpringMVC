package com.day.music.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Locale;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.day.music")
@PropertySource("classpath:app.properties")
/*@PropertySource({"classpath:app.properties",
        "classpath:WEB-INF/locale/locale_us.properties",
        "classpath:WEB-INF/locale/locale_ru.properties"})*/
@EnableJpaRepositories("com.day.music.repository")
public class DataConfig {

    final static Logger logger = LoggerFactory.getLogger(DataConfig.class);

    @Autowired
    private MessageSource messageSource;

    @Value("${db.driver}")
    private String propDatabaseDriver;

    @Value("${db.password}")
    private String propDatabasePassword;

    @Value("${db.url}")
    private String propDatabaseUrl;

    @Value("${db.username}")
    private String propDatabaseUserName;

    @Value("${db.hibernate.dialect}")
    private String propHibernateDialect;

    @Value("${db.hibernate.show_sql}")
    private String propHibernateShowSql;

    @Value("${db.entitymanager.packages.to.scan}")
    private String propEntityManagerPackagesToScan;

    @Value("${db.hibernate.hbm2ddl.auto}")
    private String propHibernateHbm2ddlAuto;


    @Bean
    public DataSource dataSource() {
        String message = messageSource.getMessage("begin", null,"locale not found", Locale.getDefault())
                 + " " + messageSource.getMessage("config.data.source", null,"locale not found", Locale.getDefault()) ;
        logger.info(message);
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(propDatabaseDriver);
        dataSource.setUrl(propDatabaseUrl);
        dataSource.setUsername(propDatabaseUserName);
        dataSource.setPassword(propDatabasePassword);

        message = messageSource.getMessage("end", null,"locale not found", Locale.getDefault())
                + " " + messageSource.getMessage("config.data.source", null,"locale not found", Locale.getDefault()) ;
        logger.info(message);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        String message = messageSource.getMessage("begin", null,"locale not found", Locale.getDefault())
                + " " + messageSource.getMessage("config.data.entity", null,"locale not found", Locale.getDefault()) ;
        logger.info(message);

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(propEntityManagerPackagesToScan);

        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());

        message = messageSource.getMessage("end", null,"locale not found", Locale.getDefault())
                + " " + messageSource.getMessage("config.data.entity", null,"locale not found", Locale.getDefault()) ;
        logger.info(message);

        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        String message = messageSource.getMessage("begin", null,"locale not found", Locale.getDefault())
                + " " + messageSource.getMessage("config.data.transaction", null,"locale not found", Locale.getDefault()) ;
        logger.info(message);

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        message = messageSource.getMessage("end", null,"locale not found", Locale.getDefault())
                + " " + messageSource.getMessage("config.data.transaction", null,"locale not found", Locale.getDefault()) ;
        logger.info(message);
        return transactionManager;
    }

    private Properties getHibernateProperties() {
        String message = messageSource.getMessage("begin", null,"locale not found", Locale.getDefault())
                + " " + messageSource.getMessage("config.data.properties", null,"locale not found", Locale.getDefault()) ;
        logger.info(message);

        Properties properties = new Properties();
        properties.put(propHibernateDialect, propHibernateDialect);
        properties.put(propHibernateShowSql, propHibernateShowSql);
        properties.put(propHibernateHbm2ddlAuto, propHibernateHbm2ddlAuto);

        message = messageSource.getMessage("end", null,"locale not found", Locale.getDefault())
                + " " + messageSource.getMessage("config.data.properties", null,"locale not found", Locale.getDefault()) ;
        logger.info(message);

        return properties;
    }

}