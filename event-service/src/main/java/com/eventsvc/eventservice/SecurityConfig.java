package com.eventsvc.eventservice;

import com.eventsvc.eventservice.filter.JwtAutoriFilter;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // @Autowired
    // AccountService acService;

    // @Override
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception
    // {
    // auth.userDetailsService(new UserDetailsService() {

    // @Override
    // public UserDetails loadUserByUsername(String username) throws
    // UsernameNotFoundException {

    // AppUser appUser = acService.loadUserByUsername(username);
    // Collection<GrantedAuthority> auths = new ArrayList<>();
    // appUser.getAppRoles().forEach(r -> {
    // auths.add(new SimpleGrantedAuthority(r.getRoleName()));
    // });
    // return new User(appUser.getUsername(), appUser.getPassword(), auths);
    // }

    // });
    // }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // http.authorizeRequests().antMatchers(HttpMethod.GET,
        // "/auth/**").hasAuthority("admin");
        // http.authorizeRequests().antMatchers(HttpMethod.POST,
        // "/auth/**").hasAuthority("admin");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilterBefore(new JwtAutoriFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}