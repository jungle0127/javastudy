package com.ps.spring.spel.runner;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class FTPClientRunner implements CommandLineRunner {

	public void run(String... args) throws Exception {
		FTPClient ftpClient = new FTPClient();
		ftpClient.connect("192.168.1.6", 21);
		ftpClient.login("jinghe", "veritas");
		int replyCode = ftpClient.getReplyCode();
		System.out.println(replyCode);
		FTPFile[] files = ftpClient.listFiles("/");
		for(FTPFile file: files) {
			System.out.println(file.getName());
		}
	}

}
