package com.mgi.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class JWTUtil {
    public static Properties properties = null;

    public static FileInputStream in = null;
    public static String username;
    public static String password;


    /**
     * token秘钥，请勿泄露，请勿随便修改 backups:JKKLJOoasdlfj
     */
    public static final String SECRET = "mgimgi";
    /**
     * token 过期时间: 10天
     */
    public static final int calendarField = Calendar.DATE;
    public static final int calendarInterval = 10;

    /**
     * JWT生成Token.<br/>
     * <p>
     * JWT构成: header, payload, signature
     */
    public static String createToken() throws Exception {
        properties = new Properties();
        InputStream in = null;
        try {
            in = JWTUtil.class.getResourceAsStream("/properties/info.properties");
            properties.load(in);
            username = properties.getProperty("uname").trim();
            password = properties.getProperty("upassword").trim();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
            Date iatDate = new Date();
            // expire time
            Calendar nowTime = Calendar.getInstance();

        nowTime.add(Calendar.DATE, 2);
            Date expiresDate = nowTime.getTime();

            // header Map
            Map<String, Object> map = new HashMap();
            map.put("alg", "HS256");
            map.put("typ", "JWT");
            String token = JWT.create().withHeader(map) // header
                    .withClaim("username", username) // payload
                    .withClaim("password", password)
                    .withClaim("roal", "customer")
                    .withIssuedAt(iatDate) // sign time
                    .withExpiresAt(expiresDate) // expire time
                    .sign(Algorithm.HMAC256(SECRET)); // signature

            return token;
        }
    

        /**
         * 解密Token
         *
         * @param token
         * @return
         * @throws Exception
         */
        public static Map<String, Claim> verifyToken (String token) throws UnsupportedEncodingException {
            DecodedJWT jwt = null;
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(token);

            return jwt.getClaims();
        }


    }
