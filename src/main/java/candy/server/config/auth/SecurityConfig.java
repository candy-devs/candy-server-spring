package candy.server.config.auth;

import candy.server.domains.user.entity.UserRoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.csrf.CsrfLogoutHandler;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

//    private final CustomOAuth2UserService

    public AccessDecisionManager accessDecisionManager() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_USER > ROLE_GUEST");

        DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
        handler.setRoleHierarchy(roleHierarchy);

        WebExpressionVoter webExpressionVoter = new WebExpressionVoter();
        webExpressionVoter.setExpressionHandler(handler);

        List<AccessDecisionVoter<?>> voters = List.of(webExpressionVoter);
        return new AffirmativeBased(voters);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // csrf issue: https://stackoverflow.com/a/38669526/3355656
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests()
                    .mvcMatchers("/", "/article/write", "/article/session").permitAll()
                    .mvcMatchers("/user/**").permitAll()
                    .mvcMatchers("/admin", "/user/all").hasRole(UserRoleEnum.ADMIN.name())
                    .anyRequest().authenticated()
                    .accessDecisionManager(accessDecisionManager())
                .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true)
                .and()
                    .oauth2Login()
                    .userInfoEndpoint()
                    .userService(customOAuth2UserService);
        http.formLogin();
        http.httpBasic();

//        http.sessionManagement()
////                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .sessionFixation()
//                .changeSessionId()
//                .invalidSessionUrl("/")
//                .maximumSessions(1)
////                    .expiredUrl("/")
//                .maxSessionsPreventsLogin(true);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        String password = passwordEncoder().encode("1234");
//        auth.inMemoryAuthentication()
//                .withUser("rollrat").password(password).roles("USER").and()
//                .withUser("admin").password(password).roles("ADMIN");
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
