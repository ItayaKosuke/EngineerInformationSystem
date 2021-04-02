package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private DataSource dataSource;

	private static final String USER_SQL = "SELECT"
			+ " LOGIN_ID,"
			+ " LOGIN_PASS,"
			+ " true"
			+ " FROM"
			+ " login_data"
			+ " WHERE"
			+ " LOGIN_ID = ?"
			+ " AND IS_DELETED = "
			+ false;

	private static final String ROLE_SQL = "SELECT"
			+ " LOGIN_ID,"
			+ " ROLE"
			+ " FROM"
			+ " login_data"
			+ " WHERE"
			+ " LOGIN_ID = ?"
			+ " AND IS_DELETED = "
			+ false;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/webjars/**", "/css/ **");
		// セキュリティ設定無視の設定
		web.ignoring().antMatchers(
				"/images/**",
				"/css/**" // ←これを追加して解決
		);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/webjars/ **").permitAll()
				.antMatchers("/css/ **").permitAll()
				.antMatchers("/images/ **").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/userMaster").hasAuthority("master")
				.anyRequest().authenticated();

		http
				.formLogin()
				.loginProcessingUrl("/login")
				.loginPage("/login")
				.failureUrl("/login")
				.usernameParameter("LOGIN_ID")
				.passwordParameter("LOGIN_PASS")
				.defaultSuccessUrl("/menu", true);

		http.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login");

		http.csrf().disable();
		http.headers().frameOptions().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery(USER_SQL)
				.authoritiesByUsernameQuery(ROLE_SQL)
				.passwordEncoder(passwordEncoder());
	}
}