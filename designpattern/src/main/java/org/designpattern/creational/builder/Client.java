package org.designpattern.creational.builder;

public class Client {

	public static void main(String[] args) {
		NutritionFacts nf = new NutritionFacts.Builder(2,3).calories(4).carbohydrate(5).fat(6).sodium(7).build();
		System.out.println(nf.toString());
	}

}
