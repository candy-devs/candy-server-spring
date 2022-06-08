package candy.server.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    private final CustomOAuth2UserService

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // csrf issue: https://stackoverflow.com/a/38669526/3355656
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests()
                    .mvcMatchers("/", "/article/write", "/article/session").permitAll()
                    .mvcMatchers("/admin").hasRole("ADMIN")
                    .anyRequest().authenticated();
        http.formLogin();
        http.httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("rollrat").password("{noop}1234").roles("USER").and()
                .withUser("admin").password("{noop}1234").roles("ADMIN");
    }
}
