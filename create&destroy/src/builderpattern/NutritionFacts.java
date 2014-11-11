package builderpattern;

public class NutritionFacts {
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;
	
	public static class NuBuilder implements Builder<NutritionFacts> {
		// Required parameters
		private final int servingSize;
		private final int servings;
		
		// Optional paramters - initialized to default values;
		private int calories 		= 0;
		private int fat 	 		= 0;
		private int carbohydrate	= 0;
		private int sodium			= 0;
		
		public NuBuilder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings    = servings;
		}
		
		public NuBuilder calories(int val) {
			calories = val; return this;
		}
		public NuBuilder fat(int val) {
			fat = val; return this;
		}
		public NuBuilder carbohydrate(int val) {
			carbohydrate = val; return this;
		}
		public NuBuilder sodium(int val){
			sodium = val; return this;
		}
		
		public NutritionFacts build() {
			return new NutritionFacts(this);
		}
	}
	
	private NutritionFacts(NuBuilder builder) {
		servingSize = builder.servings;
		servings = builder.servings;
		calories = builder.calories;
		fat		 = builder.fat;
		sodium   = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}
	
	public static void main() {
		NutritionFacts cocaCola = new NutritionFacts.NuBuilder(240, 8)
			.calories(100).sodium(35).carbohydrate(27).build();
	}
}
