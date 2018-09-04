package com.ps.spring.runner;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@Component
public class PasswordEncoderRunner implements CommandLineRunner {
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	@Override
	public void run(String... args) throws Exception {
		String originalPwd = "lotus";
		String firstEncodedPwd = this.passwordEncoder.encode(originalPwd);
		TimeUnit.SECONDS.sleep(1L);
		String secondEncodedPwd = this.passwordEncoder.encode(originalPwd);
		System.out.println(String.format("%s,%s", firstEncodedPwd,secondEncodedPwd));
		System.out.println(this.passwordEncoder.matches(originalPwd, firstEncodedPwd));
		System.out.println(this.passwordEncoder.matches(originalPwd, secondEncodedPwd));
	}

}
