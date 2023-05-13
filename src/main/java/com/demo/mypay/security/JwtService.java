//package com.demo.mypay.security;
//
//import com.demo.mypay.domain.User;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.security.Key;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//@Service
//@RequiredArgsConstructor
//public class JwtService {
//
//    @Value("jwt.secret")
//    private final String SECRET_KEY;
//
//    @Value("${application.security.jwt.expiration}")
//    private long jwtExpiration;
//    @Value("${application.security.jwt.refresh-token.expiration}")
//    private long refreshExpiration;
//
//    public String extractPhoneNo(String token) {
//        return getClaimFromToken(token, Claims::getSubject);
//    }
//
//    public Date extractIssuedAtDate(String token) {
//        return getClaimFromToken(token, Claims::getIssuedAt);
//    }
//
//    public Date extractExpirationDate(String token) {
//        return getClaimFromToken(token, Claims::getExpiration);
//    }
//
//    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = getAllClaimsFromToken(token);
//        return claimsResolver.apply(claims);
//    }
//
//    private Claims getAllClaimsFromToken(String token) {
//        return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
//    }
//    private Key getSignInKey(){
//        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));
//    }
//
//    public String generateToken(UserDetails userDetails) {
//        return generateToken(null, userDetails);
//    }
//    public String generateToken(
//            Map<String, Object> extraClaims,
//            UserDetails userDetails
//    ) {
//        return buildToken(extraClaims, userDetails, jwtExpiration);
//    }
//
//    private String buildToken(
//            Map<String, Object> extraClaims,
//            UserDetails userDetails,
//            long expiration
//    ) {
//        return Jwts
//                .builder()
//                .setClaims(extraClaims)
//                .setSubject(userDetails.getUsername())
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + expiration))
//                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
//                .compact();
//    }
//
//    public Boolean validate(String token, UserDetails userDetails) {
//        final String username = extractPhoneNo(token);
//        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
//    }
//
//    private Boolean isTokenExpired(String token) {
//        final Date expiration = extractExpirationDate(token);
//        return expiration.before(new Date());
//    }
//
//}
//
