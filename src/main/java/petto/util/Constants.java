package petto.util;

public class Constants {
	private Constants() {
	}

	// default
	public static final int DEFAULT_HUNGER = 100;
	public static final int DEFAULT_HAPPINESS = 60;
	public static final int DEFAULT_KIBBLE = 20;
	public static final int DEFAULT_MONEY = 0;
	public static final int DEFAULT_CARROT = 0;
	public static final int DEFAULT_POTATO = 0;
	public static final int DEFAULT_CORN = 0;
	public static final int DEFAULT_SEEDS = 0;
	public static final int DEFAULT_FERTILIZER = 0;
	public static final int DEFAULT_CARROT_SOUP = 0;
	public static final int DEFAULT_FRENCH_FRIES = 0;
	public static final int DEFAULT_POPCORN = 0;
	// ---

	// gain-loss-cost
	public static final int HIDE_AND_SEEK_HUNGER_COST = 15;
	public static final int HIDE_AND_SEEK_HAPPINESS_GAIN = 10;
	public static final int HIDE_AND_SEEK_HAPPINESS_LOSS = 15;

	public static final int COIN_FLIP_HAPPINESS_LOSS = 10;
	public static final int COIN_FLIP_HAPPINESS_GAIN = 5;
	public static final int COIN_FLIP_HUNGER_COST = 5;

	public static final int WORK_CASHIER_GAIN = 6;

	// ---

	// min-max
	public static final int STAT_MIN = 0;
	public static final int STAT_MAX = 100;

	public static final int FOOD_MIN = 0;
	public static final int FOOD_MAX = 30;

	public static final int MONEY_MIN = 0;
	public static final int MONEY_MAX = 1000000;

	public static final int SEEDS_MIN = 0;
	public static final int FERTILIZER_MIN = 0;
	public static final int SEEDS_MAX = 10;
	public static final int FERTILIZER_MAX = 20;
	// ---

	// food
	public static final int FOOD_KIBBLE_GAIN = 5;
	public static final int FOOD_KIBBLE_COST = 10;
	public static final int FOOD_PLANT_GAIN = 10;
	public static final int FOOD_PLANT_COST = 5;
	public static final int FOOD_COOK_GAIN = 15;
	// ---
	
	public static final int BASIC_COST = 1;
	public static final int BASIC_GAIN = 1;
	public static final int COOK_COST = 3;
}