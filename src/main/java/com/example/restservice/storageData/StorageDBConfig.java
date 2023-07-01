package com.example.restservice.storageData;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@PropertySource({ "classpath:application.properties" })
@EnableJpaRepositories(
        basePackages = "com.example.restservice.storageData.storageRepos",
        entityManagerFactoryRef = "storageEntityManager",
        transactionManagerRef = "storageTransactionManager"
)
public class StorageDBConfig {

    @Autowired
    private Environment env;

    @Value("${storage.flyway.locations}")
    private String flywayLocations;

    @Bean
    @Qualifier("storageDataSource")
    @ConfigurationProperties(prefix="storage.datasource")
    public DataSource storageDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean storageEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(storageDataSource());
        em.setPackagesToScan(
                new String[] { "com.example.restservice.storageData.storageDomain" });

        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto",
                env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect",
                env.getProperty("hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    public PlatformTransactionManager storageTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                storageEntityManager().getObject());
        return transactionManager;
    }

    @Bean
    public Flyway storageflyway() {
        return Flyway.configure()
                .dataSource(storageDataSource())
                .locations(flywayLocations)
                .baselineVersion("0.0")
                .baselineOnMigrate(true)
                .load();
    }

    @Bean
    public FlywayMigrationInitializer storageFlywayMigrationInitializer() {
        return new FlywayMigrationInitializer(storageflyway());
    }
}
