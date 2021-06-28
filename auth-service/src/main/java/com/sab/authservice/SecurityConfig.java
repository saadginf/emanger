package com.sab.authservice;

import java.util.ArrayList;
import java.util.Collection;

import com.sab.authservice.entities.AppUser;
import com.sab.authservice.filter.JwtAuthFilter;
import com.sab.authservice.filter.JwtAutoriFilter;
import com.sab.authservice.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AccountService acService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailsService() {

            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

                AppUser appUser = acService.loadUserByUsername(username);
                Collection<GrantedAuthority> auths = new ArrayList<>();
                appUser.getAppRoles().forEach(r -> {
                    auths.add(new SimpleGrantedAuthority(r.getRoleName()));
                });
                return new User(appUser.getUsername(), appUser.getPassword(), auths);
            }

        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        // http.cors().configurationSource(corsConfigurationSource());
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/auth/**").hasAuthority("admin");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/auth/**").hasAuthority("admin");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new JwtAuthFilter(authenticationManagerBean()));
        http.addFilterBefore(new JwtAutoriFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    // @Bean
    // CorsConfigurationSource corsConfigurationSource() {
    // CorsConfiguration configuration = new CorsConfiguration();
    // configuration.setAllowedOrigins(Arrays.asList("*"));
    // configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
    // configuration.setAllowCredentials(true);
    // // the below three lines will add the relevant CORS response headers
    // configuration.addAllowedOrigin("*");
    // configuration.addAllowedHeader("*");
    // configuration.addAllowedMethod("*");
    // UrlBasedCorsConfigurationSource source = new
    // UrlBasedCorsConfigurationSource();
    // source.registerCorsConfiguration("/**", configuration);
    // return source;
    // }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        // TODO Auto-generated method stub
        return super.authenticationManagerBean();
    }

}