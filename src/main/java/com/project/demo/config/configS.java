package com.project.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class configS extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    private static final String[] PUBLIC_MATCHERS = {
            "/products"
            ,"/admin/*","/"
            ,"/catalogs"
            ,"/customers"
            ,"/details"
            ,"/producers"
            ,"/promotions"
            ,"/transactions","/product/*/*",


    };
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register","/logoutsucess","/logout_page").permitAll()
                .antMatchers(PUBLIC_MATCHERS).hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error");
        http.authorizeRequests().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout_page")).deleteCookies("remember-me").logoutSuccessUrl("/logoutsucess")
                .and().rememberMe().tokenValiditySeconds(129600);
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
    }

}
