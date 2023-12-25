package com.example.restservice.workshopData;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@EnableAutoConfiguration
@EnableJpaRepositories(
        basePackages = "com.example.restservice.workshopData.workshopRepos",
        entityManagerFactoryRef = "workshopEntityManager",
        transactionManagerRef = "workshopTransactionManager"
)
public class WorkshopDBConfig {

    @Autowired
    private Environment env;

    @Value("${workshop.flyway.locations}")
    private String flywayLocations;

    @Bean
    @Qualifier("workshopDataSource")
    @ConfigurationProperties(prefix="workshop.datasource")
    public DataSource workshopDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean workshopEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(workshopDataSource());
        em.setPackagesToScan(
                new String[] { "com.example.restservice.workshopData.workshopDomain" });

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
    public PlatformTransactionManager workshopTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                workshopEntityManager().getObject());
        return transactionManager;
    }

    @Bean
    public Flyway workshopFlyway() {
        return Flyway.configure()
                .dataSource(workshopDataSource())
                .locations(flywayLocations)
                .baselineVersion("0.0")
                .baselineOnMigrate(true)
                .load();
    }

    @Bean
    public FlywayMigrationInitializer workshopFlywayMigrationInitializer() {
        return new FlywayMigrationInitializer(workshopFlyway());
    }
}
