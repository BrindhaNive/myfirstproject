package com.bcs.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username,password,enabled from users where username=?")
				.authoritiesByUsernameQuery("select username, role from user_roles where username=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

/*		http.authorizeRequests().antMatchers("/**").authenticated().and().formLogin()
				.loginPage("/login").failureUrl("/login?error").defaultSuccessUrl("/landing").usernameParameter("username")
				.passwordParameter("password").and().logout().logoutSuccessUrl("/login?logout").and()
				.exceptionHandling().accessDeniedPage("/403").and().csrf();
*/
		http.
		authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/login").permitAll()
			.anyRequest()
			.authenticated().and().csrf().disable().formLogin()
			.loginPage("/login").failureUrl("/login?error=true")
			.defaultSuccessUrl("/landing")
			.usernameParameter("username")
			.passwordParameter("password")
			.and().logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/").and().exceptionHandling()
			.accessDeniedPage("/access-denied");
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
		web.debug(true);
	}
	
	@Component
	public class AuthenticationEventListener implements ApplicationListener<AbstractAuthenticationEvent> {

	   @Override
	   public void onApplicationEvent(AbstractAuthenticationEvent authenticationEvent) {
	      if (authenticationEvent instanceof InteractiveAuthenticationSuccessEvent) {
	         // ignores to prevent duplicate logging with AuthenticationSuccessEvent
	         return;
	      }
	      Authentication authentication = authenticationEvent.getAuthentication();
	      String auditMessage = "Login attempt with username: " + authentication.getName() + "\t\tSuccess: " + authentication.isAuthenticated();
	     System.out.println(auditMessage);
	   }

	}
}