package com.OAuth2App;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AuthServer {
	
	@Bean
	public UserDetailsManager userDetailsManager(DataSource datasource) {
		JdbcUserDetailsManager jdbcUserDetailsManager =new JdbcUserDetailsManager(datasource);
		jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT user_id, pw, active FROM members WHERE user_id=?");
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles WHERE user_id=?");
		return jdbcUserDetailsManager;
		
	}
	
   /*
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails john = User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").build();
		UserDetails poojitha = User.builder().username("poojitha").password("{noop}poojitha")
				.roles("EMPLOYEE", "MANAGER").build();
		UserDetails sridher = User.builder().username("sridher").password("{noop}sridher").roles("EMPLOYEE").build();
		UserDetails krishna = User.builder().username("krishna").password("{noop}krishna").roles("EMPLOYEE", "ADMIN")
				.build();
		return new InMemoryUserDetailsManager(john, poojitha, sridher, krishna);

	}*/

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer -> configurer.requestMatchers("/").hasRole("EMPLOYEE")
				.requestMatchers("/leaders/**").hasRole("MANAGER").requestMatchers("/systems/**").hasRole("ADMIN")
				.anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser")
						.permitAll()

				).logout(logout -> logout.permitAll())
				.exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied"));
		return http.build();

	}

}
