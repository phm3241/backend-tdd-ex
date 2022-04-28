package me.jerry.backendtddex.infrastructure.configuration;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class QueryDslConfig {
    @PersistenceContext(unitName = "commandEntityManagerFactory")
    private EntityManager commandEntityManger;

    @Primary
    @Bean
    public JPAQueryFactory commandQueryFactory() {
        return new JPAQueryFactory(commandEntityManger);
    }
}