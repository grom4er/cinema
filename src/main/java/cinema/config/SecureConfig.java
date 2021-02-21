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
                .antMatchers("/register","/inject").permitAll()
                .antMatchers("/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/shopping-carts//movie-sessions","/orders/complete").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}
