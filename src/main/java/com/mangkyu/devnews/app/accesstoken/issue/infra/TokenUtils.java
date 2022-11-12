package com.mangkyu.devnews.app.accesstoken.issue.infra;

import com.mangkyu.devnews.app.accesstoken.AccessTokenProperties;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TokenUtils {

    public static String generateJwtToken(AccessTokenProperties properties) {
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "RS256");
        map.put("typ", "JWT");

        JwtBuilder builder = Jwts.builder()
//                .setHeader(Map.of("alg", "RS256", "typ", "JWT"))
                .setHeader(map)
                .setIssuer(properties.getClientId())
                .setSubject(properties.getServiceAccount())
                .setIssuedAt(new Date())
                .setExpiration(createExpireDateForOneYear())
                .signWith(SignatureAlgorithm.RS256, createSigningKey(properties.getPrivateKey()));

        return builder.compact();
    }

    private static Date createExpireDateForOneYear() {
        // 토큰 만료시간은 30일으로 설정
        Calendar c = Calendar.getInstance();
        c.add(Calendar.HOUR, 1);
        return c.getTime();
    }

    private static Key createSigningKey(String privateKey) {
        try {
            byte[] decodedKey = DatatypeConverter.parseBase64Binary(
                    privateKey.replace("-----BEGIN PRIVATE KEY-----", "")
                            .replace("-----END PRIVATE KEY-----", "")
                            .replaceAll("\\s+", ""));

            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decodedKey);
            KeyFactory fact = KeyFactory.getInstance("RSA");
            return fact.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

}