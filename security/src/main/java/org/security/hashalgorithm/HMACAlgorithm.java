package org.security.hashalgorithm;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.bouncycastle.util.encoders.Hex;
import org.security.hashalgorithm.mac.BCMacCoder;
import org.security.hashalgorithm.mac.SunMacCoder;

public class HMACAlgorithm {
	
	public static void main(String[] args) {
		SunMacCoder smc = new SunMacCoder("HmacMD5");
		BCMacCoder bmc = new BCMacCoder("HmacMD5");
		try {
			System.out.println(Hex.toHexString(smc.encodeHmac("lotus")));
			System.out.println(Hex.toHexString(bmc.encodeHmac("lotus")));
			
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
