package com.call.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.call.application.repository.base.SimpleBaseRepository;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.call.application.repository", repositoryBaseClass = SimpleBaseRepository.class, repositoryFactoryBeanClass = JpaRepositoryFactoryBean.class)
@EnableJpaAuditing
public class PersistenceConfiguration {
	
}
