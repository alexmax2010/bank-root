package com.base.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.alexcan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * BaseConfiguration.
 *
 * @author alex on 06/08/2022
 * @version 1.0
 * @since 1.0.0
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.base"})
@EntityScan(basePackages = {"com.base"})
@alexcan(basePackages = {"com.base"})
@EnableTransactionManagement
public class BaseConfiguration {

}
