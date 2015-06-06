package ro.rocknrolla.portal_auto.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;

	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
//                .csrfTokenRepository(csrfTokenRepository())
//            .and()
				.exceptionHandling()
				.authenticationEntryPoint(new AuthenticationEntryPoint())
				.and()
				.formLogin()
				.successHandler(authenticationSuccessHandler)
				.failureHandler(authenticationFailureHandler)
				.and()
				.rememberMe()
				.and()
				.logout()
				.logoutSuccessUrl("/index.html")
				.and()
				.authorizeRequests()
				.antMatchers("/", "/index.html", "/templates/**","/auth/**","/webservice/**").permitAll()
				.antMatchers(HttpMethod.POST, "/user").permitAll()
				.anyRequest().authenticated()
				.and()
				.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery("select email, password, 'true' from Users where email = ?")
				.authoritiesByUsernameQuery("select email, 'ROLE_USER' from Users where email = ?")
				.passwordEncoder(new ShaPasswordEncoder());

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public TextEncryptor textEncryptor() {
		return Encryptors.noOpText();
	}
}
