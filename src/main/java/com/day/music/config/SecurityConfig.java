package com.day.music.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;
import java.util.Locale;

/**
 * The class configure Spring security config
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * property - set logger
     */
    final static Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
    /**
     * property - set MessageSource bean
     */
    @Autowired
    private MessageSource messageSource;
    /**
     * property - set DataSource bean
     */
    @Autowired
    DataSource dataSource;

    /**
     * The method configure a new bean object authentication manager builder
     */
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        String message = messageSource.getMessage("begin", null, "locale not found", Locale.getDefault())
                + " " + messageSource.getMessage("config.security.authentication", null, "locale not found", Locale.getDefault());
        logger.info(message);
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role from user_roles where username=?");
        message = messageSource.getMessage("end", null, "locale not found", Locale.getDefault())
                + " " + messageSource.getMessage("config.security.authentication", null, "locale not found", Locale.getDefault());
        logger.info(message);
    }

    /**
     * The method сreate a new bean password encoder
     *
     * @return NoOpPasswordEncoder
     */
    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        logger.info("Password Encoder");
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
    /**
     * The method configure http authorization request map
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String message = messageSource.getMessage("begin", null, "locale not found", Locale.getDefault())
                + " " + messageSource.getMessage("config.security.http.authorization", null, "locale not found", Locale.getDefault());

        logger.info(message);
        http.authorizeRequests()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .and()
                .formLogin().loginPage("/login").failureUrl("/login?error")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/login?logout")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .csrf();
        message = messageSource.getMessage("end", null, "locale not found", Locale.getDefault())
                + " " + messageSource.getMessage("config.security.http.authorization", null, "locale not found", Locale.getDefault());
        logger.info(message);
    }
}