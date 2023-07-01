package com.example.restservice.equipmentData;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
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
        basePackages = "com.example.restservice.equipmentData.equipmentRepos",
        entityManagerFactoryRef = "equipmentEntityManager",
        transactionManagerRef = "equipmentTransactionManager"
)
public class EquipmentDBConfig {
    @Autowired
    private Environment env;

    @Value("${equipment.flyway.locations}")
    private String flywayLocations;

    @Bean
    @Primary
    @ConfigurationProperties(prefix="equipment.datasource")
    public DataSource equipmentDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean equipmentEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(equipmentDataSource());
        em.setPackagesToScan(
                new String[] { "com.example.restservice.equipmentData.equipmentDomain" });

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

    @Primary
    @Bean
    public PlatformTransactionManager equipmentTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                equipmentEntityManager().getObject());
        return transactionManager;
    }

    @Primary
    @Bean
    public Flyway equipmentflyway() {
        return Flyway.configure()
                .dataSource(equipmentDataSource())
                .locations(flywayLocations)
                .baselineVersion("0.0")
                .baselineOnMigrate(true)
                .load();
    }

    @Primary
    @Bean
    public FlywayMigrationInitializer equipmentFlywayMigrationInitializer() {
        return new FlywayMigrationInitializer(equipmentflyway());
    }
}