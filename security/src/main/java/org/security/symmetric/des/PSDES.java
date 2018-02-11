package org.security.symmetric.des;

import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
/**
 * 98年后不断的被破解，不再安全
 * Data Encryption Standard
 * 密钥长度：56
 * @author Administrator
 *
 */
public class PSDES {
	public static String plainText = "ps";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jdkDES();
		bouncyCastleDES();
	}
	public static void jdkDES() {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
			keyGenerator.init(56);
			System.out.println(keyGenerator.getProvider().getName());
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] byteKey = secretKey.getEncoded();
			
			
			DESKeySpec desKeySpec = new  DESKeySpec(byteKey);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
			SecretKey converteSecretKey = factory.generateSecret(desKeySpec);
			
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			// ECB:工作模式   PKCS5Padding: 填充方式
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
	
	public static void bouncyCastleDES() {
		Security.addProvider(new BouncyCastleProvider());
		
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES", "BC");
			keyGenerator.init(56);
			//密钥长度
			System.out.println(keyGenerator.getProvider().getName());
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] byteKey = secretKey.getEncoded();
			
			
			DESKeySpec desKeySpec = new  DESKeySpec(byteKey);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
			SecretKey converteSecretKey = factory.generateSecret(desKeySpec);
			
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
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
}
