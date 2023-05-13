package com.example.promotion.tools;
import com.auth0.jwt.*;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.*;

@Component
public class TokenGenerator {
    Algorithm algorithm = Algorithm.HMAC256("doriswu");
    JWTVerifier verifier = JWT.require(algorithm)
                                .build();

    public String generteToken(String email, String password){
        Map<String, String> claimMap = new HashMap<>();
        claimMap.put("email", email);
        claimMap.put("password", password);

        String token = "";
        try{
            token = JWT.create().withClaim("myclaim", claimMap)
                                .withIssuedAt(new Date())
                                .withExpiresAt(new Date(System.currentTimeMillis() + 5000L))
                                .sign(algorithm)
                                .toString();
            
        } catch (Exception e){
            e.printStackTrace();
        }
        return token;
    }

    public Claim parseToken(String token){
        try {
            DecodedJWT decodedJWT = verifier.verify(token);
            Claim claim = decodedJWT.getClaim("myclaim");
            return claim;
        } catch (JWTVerificationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
