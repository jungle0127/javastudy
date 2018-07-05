package org.security.symmetric.des;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jcajce.provider.symmetric.AES.KeyGen;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * 移动通信加密，SSH协议使用
 * 至今官方未有解密方式
 * @author Administrator
 * 密钥长度：128，192，256，默认：128。
 * JDK256位长度密钥限制出口。
 *
 */
public class AES {

	private String plainText = "lotus";
	public void JDKAES() {
		//生成KEY
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//			AESKeyGenerator keyGenerator = new AESKeyGenerator();
			keyGenerator.init(new SecureRandom());
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] keybytes = secretKey.getEncoded();
			// KEY的转换
			Key key = new SecretKeySpec(keybytes, "AES");
			//加密
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] result =cipher.doFinal(plainText.getBytes());
			System.out.println(Base64.encodeBase64String(result));
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, key);
			result = cipher.doFinal(result);
			System.out.println(new String(result));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void BCAES() {
		Security.addProvider(new BouncyCastleProvider());
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(256);
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] keyBytes = secretKey.getEncoded();
			
//			Key key = 
			
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			//cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] result = cipher.doFinal(plainText.getBytes());
			System.out.println(new String(result));
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AES aes = new AES();
		aes.JDKAES();
		aes.BCAES();
	}

}
