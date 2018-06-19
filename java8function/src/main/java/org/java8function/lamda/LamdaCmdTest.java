package org.java8function.lamda;

import java.util.function.BinaryOperator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LamdaCmdTest implements CommandLineRunner{

	public void run(String... args) throws Exception {
		Runnable noArgs = () -> System.out.println("TEST 1!");
		System.out.println("Running....");
		BinaryOperator<Long> add = (x, y) -> x + y;
		new Thread(noArgs).start();
		System.out.println(add.apply(2L, 5L));
	}

}
