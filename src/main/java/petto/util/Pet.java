package petto.util;

import static petto.util.Constants.*;

public class Pet {
	private String name;
	private int hunger;
	private int happiness;
	private int kibble;
	private int money;
	private int seeds;
	private int fertilizer;
	private int carrot;
	private int potato;
	private int corn;
	private int carrotsoup;
	private int frenchfries;
	private int popcorn;

	public Pet(String name) {
		this.name = name;
		this.hunger = DEFAULT_HUNGER;
		this.happiness = DEFAULT_HAPPINESS;
		this.kibble = DEFAULT_KIBBLE;
		this.money = DEFAULT_MONEY;
		this.seeds = DEFAULT_SEEDS;
		this.fertilizer = DEFAULT_FERTILIZER;
		this.carrot = DEFAULT_CARROT;
		this.potato = DEFAULT_POTATO;
		this.corn = DEFAULT_CORN;
		this.carrotsoup = DEFAULT_CARROT_SOUP;
		this.frenchfries = DEFAULT_FRENCH_FRIES;
		this.popcorn = DEFAULT_POPCORN;
	}

	public Pet(String name, int hunger, int happiness, int kibble, int money, int seeds, int fertilizer, int carrot, int potato, int corn, int carrotsoup, int frenchfries, int popcorn) {
		this.name = name;
		this.hunger = hunger;
		this.happiness = happiness;
		this.kibble = kibble;
		this.money = money;
		this.seeds = seeds;
		this.fertilizer = fertilizer;
		this.carrot = carrot;
		this.potato = potato;
		this.corn = corn;
		this.carrotsoup = carrotsoup;
		this.frenchfries = frenchfries;
		this.popcorn = popcorn;
	}

	public String getName() {
		return name;
	}

	public int getHunger() {
		return hunger;
	}

	public int getHappiness() {
		return happiness;
	}
	
	public int getKibble() {
		return kibble;
	}
	
	public int getMoney() {
		return money;
	}
	
	public int getSeeds() {
		return seeds;
	}
	
	public int getFertilizer() {
		return fertilizer;
	}
	
	public int getCarrot() {
		return carrot;
	}
	
	public int getPotato() {
		return potato;
	}

	public int getCorn() {
		return corn;
	}

	public int getCarrotsoup() {return carrotsoup;}
	public int getFrenchfries() {return frenchfries;}
	public int getPopcorn() {return popcorn;}
	
	public void setHunger(int hunger) {
		this.hunger = Math.clamp(hunger, Constants.STAT_MIN, Constants.STAT_MAX);
	}

	public void setHappiness(int happiness) {
		this.happiness = Math.clamp(happiness, Constants.STAT_MIN, Constants.STAT_MAX);
	}
	
	public void setKibble(int kibble) {
		this.kibble = Math.clamp(kibble, Constants.FOOD_MIN, Constants.FOOD_MAX);
	}
	
	public void setMoney(int money) {
		this.money = Math.clamp(money, Constants.MONEY_MIN, Constants.MONEY_MAX);
	}
	
	public void setSeeds(int seeds) {
		this.seeds = Math.clamp(seeds, Constants.SEEDS_MIN, Constants.SEEDS_MAX);
	}
	
	public void setFertilizer(int fertilizer) {
		this.seeds = Math.clamp(fertilizer, Constants.FERTILIZER_MIN, Constants.FERTILIZER_MAX);
	}
	
	public void setCarrot(int carrot) {
		this.carrot = Math.clamp(carrot, Constants.FOOD_MIN, Constants.FOOD_MAX);
	}
	
	public void setPotato(int potato) {
		this.potato = Math.clamp(carrot, Constants.FOOD_MIN, Constants.FOOD_MAX);
	}
	
	public void setCorn(int corn) {
		this.corn = Math.clamp(carrot, Constants.FOOD_MIN, Constants.FOOD_MAX);
	}
}
