package com.kert.compute.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.kert.compute.model.entity.User;

import java.util.Calendar;

public class JWTUtil {
    private static final String SECRET_KEY="3434#2DfJD*hDus^%hsd5dfs$Gds@dfd,.";
    public static String getToken(User user){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR,1);//过期时间为1小时
        return JWT.create()
                .withIssuer(user.getName())
                .withExpiresAt(calendar.getTime())//过期时间
                .sign(Algorithm.HMAC256(SECRET_KEY));//签名用的密钥secret
    }

    public static String flush(String token){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR,1);//过期时间为1小时
        JWTVerifier build = JWT.require(Algorithm.HMAC256(SECRET_KEY)).build();
        String issuer = build.verify(token).getIssuer();
        return JWT.create()
                .withIssuer(issuer)
                .withExpiresAt(calendar.getTime()).sign(Algorithm.HMAC256(SECRET_KEY));
    }

    public static void verify(String token){
        JWTVerifier build = JWT.require(Algorithm.HMAC256(SECRET_KEY)).build();
        build.verify(token);
    }
}
