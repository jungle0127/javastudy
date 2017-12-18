package com.javastudy;

import java.awt.List;

public class test {

	public static void main(String[] args) {
		// temp = j; j = j+1;j = temp;
		int j = 0;
		j = j++;
		System.out.println(j);
		test.get(List.class, Integer.class);
	}
	
	public static <T> void get(Class<?> param, Class<T> pp) {
	}
}
