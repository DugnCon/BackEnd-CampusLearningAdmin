package com.javaweb.service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    //Chuỗi bí mật dùng để ký token
	//Độ dài HS256 >= 32 bytes
    private static final String SECRET_KEY = "my-super-secret-key-123456-my-super-secret-key-123456"; 
    private final SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    //Thời hạn access token
    private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 giờ
    //Thòi hạn refresh token
    private final long REFRESH_EXPIRATION_TIME = 1000L * 60 * 60 * 24 * 7;

    /**
     * Jwts.builder() -> Tạo token
     * setClaims(new Map<String,Object> claims) -> Tạo token cho nhiều object
     * setSubject(new Object) -> Tạo token đơn cho 1 object
     * setIssueAt(new Date()) -> Thời gian tạo token
     * setExpiration() -> Thời gian tồn tại token
     * signWith() -> Ký token, tạo ra hash để mã hóa token gửi lên FE và nó lưu ở trong localStorage hoặc cookie Authoration: Bearer <token>
     * compact() -> Đóng gói header + payload + signature -> tạo ra JWT chuẩn 
     * 
     * GIẢI THÍCH
     * header -> Cho biết ta dùng thuât toán nào để ký: HS256
     * payload -> Là cái sub cái mà ta dùng để nhúng 1 object tạo token
     * signature -> là cái phần bảo mật đảm bảo cho jwt
     * **/
    
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
    //Tạo refresh token
    public String generateRefreshToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + REFRESH_EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
    //Tạo token với claims
    //claims là cái chứa thông tin như id, role, indentifier
    public String generateTokenWithClaims(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject((String) claims.get("identifier")) // lấy từ claims luôn
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
    //parse tọken -> kiểm tra chữ ký và trả về claims -> trả về cho FE check token
    //Jws<Claims> -> claims được trữ bởi Jws
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder() //Cấu hình và giải mã JWT khi muốn lấy các claims
                .setSigningKey(key) //Muốn lấy claims phải cung cấp key để xác minh
                .build() //Set up xong thì cần build ra thì mới lấy được các đoói tượng
                .parseClaimsJws(token) //Khi build xong thì giải mã token FE gửi xuống để lấy được header, payload và signature
                .getBody(); //Phần này là lấy dữ liêuj từ PayLoad
        		//Có cả getHeader và getSignature
    }
    //Kiểm tra thời gian của token
    public boolean isTokenExpired(String token) {
        try {
            Date exp = extractAllClaims(token).getExpiration();
            return exp.before(new Date());
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            return true;
        }
    }
    // Lấy email (subject) từ token
    public String extractEmail(String token) {
        return extractAllClaims(token).getSubject(); //getBody() có nghĩa là lấy từ Payload
        //Có thể lấy các object từ getHeader và getSignature nếu muốn
    }
    // Kiểm tra token hợp lệ
    public boolean validateToken(String token, String email) {
        final String extractedEmail = extractEmail(token);
        return (extractedEmail.equals(email) && !isTokenExpired(token));
    }
    public SecretKey getKey() {
        return key;
    }
    public Claims parseToken(String token) {
        return extractAllClaims(token);
    }

}
