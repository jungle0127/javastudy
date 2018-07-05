package org.security.hashalgorithm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.bouncycastle.util.encoders.Hex;

public class MDAlgorithm {
	public static String encodeMD5() {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD2");
			md.update("lotus".getBytes());
			return new String(Hex.encode(md.digest()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String encodeSHA256() {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update("lotus".getBytes());
			return new String(Hex.encode(md.digest()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(MDAlgorithm.encodeMD5());
		System.out.println(MDAlgorithm.encodeSHA256());
	}

}
