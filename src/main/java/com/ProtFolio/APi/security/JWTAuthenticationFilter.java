/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
package com.ProtFolio.APi.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        
        AuthCredentials authCredencials = new  AuthCredentials();
        
        try{
            authCredencials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
        }catch(IOException e){
        }
        UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
                authCredencials.getEmail(),
                authCredencials.getPassword(),
                Collections.emptyList()
        );
        
        
        return getAuthenticationManager().authenticate(usernamePAT);
    
}

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
       
        UserDetailsImpl userDetals = (UserDetailsImpl )authResult.getPrincipal();
        String token = TokenUtils.createToken(userDetals.getNombre(),userDetals.getUsername());
        
        response.addHeader("Authorization", "Bearer " + token);
        response.getWriter().flush();
        
        super.successfulAuthentication(request, response, chain, authResult); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}*/