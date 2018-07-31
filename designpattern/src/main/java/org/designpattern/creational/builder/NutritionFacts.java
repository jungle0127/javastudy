package org.designpattern.creational.builder;
/**
 * Builder pattern demo from <Effective Java> Item 2
 * @author PS. Zhang
 *
 */
public class NutritionFacts {
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;
	public static class Builder implements IBuilder<NutritionFacts>{
		private final int servingSize;
		private final int servings;
		// optional parameters;
		private int calories = 0;
		private int fat = 0;
		private int sodium = 0;
		private int carbohydrate = 0;
		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}
		public Builder calories(int val) {
			this.calories = val;
			return this;
		}
		public Builder fat(int val) {
			this.fat = val;
			return this;
		}
		public Builder sodium(int val) {
			this.sodium = val;
			return this;
		}
		public Builder carbohydrate(int val) {
			this.carbohydrate = val;
			return this;
		}
		public NutritionFacts build() {
			return new NutritionFacts(this);
		}
	}
	private NutritionFacts(Builder builder) {
		this.fat = builder.fat;
		this.calories = builder.calories;
		this.sodium = builder.sodium;
		this.carbohydrate = builder.carbohydrate;
		this.servings = builder.servings;
		this.servingSize = builder.servingSize;
	}
	public String toString() {
		return String.format("%d,%d,%d,%d,%d,%d", this.servings,this.servingSize,this.calories,this.carbohydrate,this.fat,this.sodium);
	}
}
