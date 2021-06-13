package com.eventsvc.eventservice.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAutoriFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authToken = request.getHeader("Authorization");
        System.out.println(authToken);
        if (authToken != null && authToken.startsWith("Bearer ")) {

            try {
                String jwt = authToken.substring(7);
                Algorithm algo = Algorithm.HMAC256("najiTag");
                JWTVerifier jwtVerifier = JWT.require(algo).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(jwt);
                String username = decodedJWT.getSubject();
                String[] roles = decodedJWT.getClaim("role").asArray(String.class);
                Collection<GrantedAuthority> authorities = new ArrayList<>();
                for (String r : roles) {

                    authorities.add(new SimpleGrantedAuthority(r));
                }
                UsernamePasswordAuthenticationToken verifToken = new UsernamePasswordAuthenticationToken(username, null,
                        authorities);
                SecurityContextHolder.getContext().setAuthentication(verifToken);
                filterChain.doFilter(request, response);
            } catch (Exception e) {
                // TODO: handle exception
                response.setHeader("error-message", "Erreur Serveur Fatale");
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
            }

        } else {
            filterChain.doFilter(request, response);
        }

    }

}