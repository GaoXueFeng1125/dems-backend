package edu.sugon.demsbackend.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtService {

//    @Value("${jwt.secret}")
    private String secret;
    private long expiration;
    /**
     * 生成jwt
     *      *@param userId
     * @param userNo
     * @return
     */
    public String generateToken(String userId,String userNo){
        Map<String,Object> claims = new HashMap<>();
        claims.put("userId",userId);
        return createToken(claims,userNo);
    }
    /**
     * 生成jwt
     *      *@param claims
     * @param subject
     * @return
     */
    public String createToken(Map<String,Object> claims,String subject){
        return Jwts.builder().setClaims(claims).setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .signWith(SignatureAlgorithm.ES512,secret).compact();
    }

}
