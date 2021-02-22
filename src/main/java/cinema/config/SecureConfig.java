package cinema.config;

import cinema.service.impl.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecureConfig extends WebSecurityConfigurerAdapter {
    private final CustomUserDetailService userDetailService;
    private final PasswordEncoder encoder;

    public SecureConfig(CustomUserDetailService userDetailService, PasswordEncoder encoder) {
        this.userDetailService = userDetailService;
        this.encoder = encoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.userDetailsService(userDetailService);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.PUT, "/movie-sessions/**").access("hasAuthority('ADMIN')")
                .antMatchers(HttpMethod.DELETE, "/movie-sessions/**").access("hasAuthority('ADMIN')")
                .antMatchers("/users/**").access("hasAuthority('ADMIN')")
                .antMatchers(HttpMethod.POST,
                        "/movies/**",
                        "/movie-sessions/**",
                        "/cinema-halls/**").access("hasAuthority('ADMIN')")
                .antMatchers("/orders/**",
                        "/shopping-carts/**").access("hasAuthority('USER')")
                .antMatchers(HttpMethod.GET,
                        "/movies/**",
                        "/movie-sessions/**",
                        "/cinema-halls/**").permitAll()
                .antMatchers("/register/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}
