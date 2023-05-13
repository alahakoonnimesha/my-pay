//package com.demo.mypay.security;
//
//import com.demo.mypay.businessService.UserBusinessService;
//import com.demo.mypay.domain.User;
//import com.demo.mypay.security.JwtService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.validation.constraints.NotNull;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.web.filter.OncePerRequestFilter;
//import java.io.IOException;
//
//@RequiredArgsConstructor
//public class JwtAuthFilter extends OncePerRequestFilter {
//
//    private final JwtService jwtService;
//
//    private final UserBusinessService userBusinessService;
//    private final UserDetailsService userDetailsService;
//
//    @Override
//    protected void doFilterInternal(@NotNull HttpServletRequest request,
//                                    @NotNull HttpServletResponse response,
//                                    @NotNull FilterChain filterChain) throws ServletException, IOException {
//        StringBuilder requestURL = new StringBuilder(request.getRequestURL().toString());
//        final String header = request.getHeader("Authorization");
//        final String authToken;
//        final String phoneNo;
//
//        if (header == null || !header.startsWith("Bearer ")) {
//            filterChain.doFilter(request,response);
//        }
//        authToken = header.substring(7);
//        phoneNo = jwtService.extractPhoneNo(authToken);
//        UserDetails userDetails = this.userDetailsService.loadUserByUsername(phoneNo);
//        if (jwtService.validate(authToken,userDetails)) {
//            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//                    userDetails, null, userDetails.getAuthorities());
//            usernamePasswordAuthenticationToken
//                    .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//        }
//        filterChain.doFilter(request,response);
//    }
//}
