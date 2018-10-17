package org.security.bcrypthash.runner;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import sun.misc.BASE64Decoder;
@Component
public class HashRunner implements CommandLineRunner {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public void run(String... args) throws Exception{
		String plainText = "lotus";
		System.out.println(passwordEncoder.encode(plainText));
		TimeUnit.SECONDS.sleep(1L);
		System.out.println(passwordEncoder.encode(plainText));
		
		String cipherText1 = "$2a$10$fr/jbNF76twCZG29Wfm9g.N5XYW0voUv3ljFSRwfl.iEFdPIaBnyO";
		String cipherText2 = "$2a$10$5lisaMlN5Tf841nCJYY9veXpka00HA36MGMJfC2yMWEJgN7COzdg2";
		BASE64Decoder decoder = new BASE64Decoder();
		System.out.println(new String(decoder.decodeBuffer("5lisaMlN5Tf841nCJYY9ve")));
		System.out.println(new String(decoder.decodeBuffer(cipherText2)));
	}
}
