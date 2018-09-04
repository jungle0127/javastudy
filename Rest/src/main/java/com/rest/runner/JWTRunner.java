package com.rest.runner;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.SignatureException;

@Component
public class JWTRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
//		String base64Secret = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=";
//		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Secret);
		byte[] apiKeySecretBytes = "welcometounitedstatesofamericaandhaveagoodday|welcometopeoplesrepublicofchinaandhaveagoodday".getBytes();
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS512.getJcaName());
		String token = Jwts.builder().setSubject("username")
				.setHeaderParam("head", "value")
				.claim("claim", "value")
				.setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000))
				.signWith(signingKey, SignatureAlgorithm.HS512).compact();
		System.out.println(String.format("token:%s", token));

		try {
			//Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(base64Secret))
			Claims claims = Jwts.parser().setSigningKey(apiKeySecretBytes)
					.parseClaimsJws(token).getBody();
			String claimKey = claims.get("claim", String.class);
			System.out.println("claimKey:" + claimKey);
			System.out.println("subject:" + claims.getSubject());
		} catch (SignatureException | MalformedJwtException ex) {
			System.out.println("JWT can not be trusted." + ex.getMessage());
		} catch(ExpiredJwtException e) {
			System.out.println("Token expired.");
		}
	}

}
