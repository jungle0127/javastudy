package org.security.symmetric.des;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Hex;

public class TrippleDES {
	public static String plainText = "ps";
	public static void main(String[] args) {
		jdk3DES();
	}
	public static void jdk3DES() {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
//			keyGenerator.init(112);
			keyGenerator.init(new SecureRandom());
			System.out.println(keyGenerator.getProvider().getName());
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] byteKey = secretKey.getEncoded();
			
			
			DESedeKeySpec desKeySpec = new  DESedeKeySpec(byteKey);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
			SecretKey converteSecretKey = factory.generateSecret(desKeySpec);
			
			Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, converteSecretKey);
			byte[] bytes = cipher.doFinal(plainText.getBytes());
			System.out.println("JDK DES Encrypt:" + Hex.encodeHexString(bytes));
			
			//De
			cipher.init(Cipher.DECRYPT_MODE, converteSecretKey);
			bytes = cipher.doFinal(bytes);
			System.out.println("PlainText:" + new String(bytes));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	private static void bc3DES() {
		
	}
}
