package org.security;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;

import javax.crypto.Cipher;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Provider[] providers = Security.getProviders();
    	for(Provider provider: providers) {
    		System.out.println(provider.getInfo());
    		System.out.println("===================");
    	}
        System.out.println( "Hello World!" );
        try {
        	Cipher ci;
			MessageDigest md5 = MessageDigest.getInstance("SHA-512");
			byte[] pwd = md5.digest("jinghe".getBytes("utf-8"));
			BigInteger bi = new BigInteger(1, pwd);
			System.out.println(bi.toString(16));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
