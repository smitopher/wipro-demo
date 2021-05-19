package com.cjssolutions.wipro.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@Configuration
@EnableJpaRepositories(basePackages = "com.cjssolutions.wipro.repo") 
@EnableGlobalMethodSecurity(
		  prePostEnabled = true, 
		  securedEnabled = true, 
		  jsr250Enabled = true)public class WiproConfig { //extends WebSecurityConfigurerAdapter  {
}


