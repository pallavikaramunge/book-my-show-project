package com.example.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private MyUserDetailedService myUserDetailedService;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
		throws ServletException, IOException {
		
		String jwt = null;
         String username = null;
		
		//Authorization  Bearer<token>
String authorizationHeader  = request.getHeader("Authorization");
		if(authorizationHeader!= null && authorizationHeader.startsWith("Bearer")) {
		jwt = authorizationHeader.substring(7);
	    username = jwtUtil.extractUsername(jwt);
		
		}
		
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
	UserDetails userDetails = this.myUserDetailedService.loadUserByUsername(username);
		
	if(jwtUtil.validateToken(jwt, userDetails)) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
		
		token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	SecurityContextHolder.getContext().setAuthentication(token);
	}
		
		}
		
		filterChain.doFilter(request, response);

	}
}


