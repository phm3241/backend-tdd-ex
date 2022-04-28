package me.jerry.backendtddex.infrastructure.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"me.jerry"},
        entityManagerFactoryRef = "commandEntityManagerFactory",
        transactionManagerRef = "commandTransactionManager"
)
public class CommandDbConfig {
        @Primary
        @Bean
        @ConfigurationProperties("spring.datasource.hikari")
        public DataSource primaryDataSource() {
            return DataSourceBuilder
                    .create()
                    .type(HikariDataSource.class)
                    .build();
        }

        @Primary
        @Bean(name = "commandEntityManagerFactory")
        public LocalContainerEntityManagerFactoryBean commandEntityManagerFactory(EntityManagerFactoryBuilder builder) {
            return builder
                    .dataSource(primaryDataSource())
                    .packages("me.kevin") // fixme: entity position
                    .build();
        }

        @Primary
        @Bean(name = "commandTransactionManager")
        public PlatformTransactionManager commandTransactionManager(EntityManagerFactoryBuilder builder) {
            return new JpaTransactionManager(Objects.requireNonNull(commandEntityManagerFactory(builder).getObject()));
        }
}
