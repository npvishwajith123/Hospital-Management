package com.np.hospital.management.utilities;

import com.np.hospital.management.entities.Users;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JWTUtility {

    private final String secret = "testset2323th2f23jfg23hrfg32hfg3h2fgh324fgh34fhg34fg3ffw";
    SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

    public String generateToken(Users user) {
        return Jwts.builder().signWith(key)
                .issuer("NP")
                .subject(user.getUserName())
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime()+30000000))
                .claim("Roles",user.getRole().getRoleName())
                .compact();
    }

    public Boolean validateToken(String jwt) {
       return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(jwt)
                .getPayload()
                .getExpiration().after(new Date());
    }

    public String extractUserName(String jwt) {
        return Jwts.parser()
                .verifyWith(key)
                .build().parseSignedClaims(jwt)
                .getPayload().getSubject();
    }
}
