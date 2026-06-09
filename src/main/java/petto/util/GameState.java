package petto.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import static petto.util.Constants.*;

public class GameState {
	private static final String SAVE_FILE = "save.properties";

	public static void newGame(String name) {
		Properties properties = new Properties();
		properties.setProperty("name", name);
		properties.setProperty("hunger", String.valueOf(DEFAULT_HUNGER));
		properties.setProperty("happiness", String.valueOf(DEFAULT_HAPPINESS));
		properties.setProperty("kibble", String.valueOf(DEFAULT_KIBBLE));
		properties.setProperty("money", String.valueOf(DEFAULT_MONEY));
		properties.setProperty("seeds", String.valueOf(DEFAULT_SEEDS));
		properties.setProperty("fertilizer", String.valueOf(DEFAULT_FERTILIZER));
		properties.setProperty("carrot", String.valueOf(DEFAULT_CARROT));
		properties.setProperty("potato", String.valueOf(DEFAULT_POTATO));
		properties.setProperty("corn", String.valueOf(DEFAULT_CORN));
		properties.setProperty("carrotsoup", String.valueOf(DEFAULT_CARROT_SOUP));
		properties.setProperty("frenchfries", String.valueOf(DEFAULT_FRENCH_FRIES));
		properties.setProperty("popcorn", String.valueOf(DEFAULT_POPCORN));

		try (FileOutputStream out = new FileOutputStream(SAVE_FILE)) {
			properties.store(out, "SAVE_DATA");
			System.out.println("Save Created!");
		} catch (IOException e) {
			System.out.println("Error");
		}
	}

	public static Pet loadGame() {
		File file = new File(SAVE_FILE);
		if (!file.exists()) {
			System.out.println("Save not found");
			return null;
		}
		Properties properties = new Properties();
		try (FileInputStream in = new FileInputStream("save.properties")) {
			properties.load(in);
			String name = properties.getProperty("name");
			int hunger = Integer.parseInt(properties.getProperty("hunger"));
			int happiness = Integer.parseInt(properties.getProperty("happiness"));
			int kibble = Integer.parseInt(properties.getProperty("kibble"));
			int money = Integer.parseInt(properties.getProperty("money"));
			int seeds = Integer.parseInt(properties.getProperty("seeds"));
			int fertilizer = Integer.parseInt(properties.getProperty("fertilizer"));
			int carrot = Integer.parseInt(properties.getProperty("carrot"));
			int potato = Integer.parseInt(properties.getProperty("potato"));
			int corn = Integer.parseInt(properties.getProperty("corn"));
			int carrotsoup = Integer.parseInt(properties.getProperty("carrotsoup"));
			int frenchfries = Integer.parseInt(properties.getProperty("frenchfries"));
			int popcorn = Integer.parseInt(properties.getProperty("popcorn"));
			return new Pet(name, hunger, happiness, kibble, money, seeds, fertilizer, carrot, corn, potato, carrotsoup, frenchfries, popcorn);
		} catch (IOException e) {
			System.out.print("Error");
		}
		return null;
	}

	public static void saveGame(Pet pet) {
		Properties properties = new Properties();
		properties.setProperty("name", pet.getName());
		properties.setProperty("hunger", String.valueOf(pet.getHunger()));
		properties.setProperty("happiness", String.valueOf(pet.getHappiness()));
		properties.setProperty("kibble", String.valueOf(pet.getKibble()));
		properties.setProperty("money", String.valueOf(pet.getMoney()));
		properties.setProperty("seeds", String.valueOf(pet.getSeeds()));
		properties.setProperty("fertilizer", String.valueOf(pet.getFertilizer()));
		properties.setProperty("carrot", String.valueOf(pet.getCarrot()));
		properties.setProperty("potato", String.valueOf(pet.getPotato()));
		properties.setProperty("corn", String.valueOf(pet.getCorn()));
		properties.setProperty("carrotsoup", String.valueOf(pet.getCarrotsoup()));
		properties.setProperty("frenchfries", String.valueOf(pet.getFrenchfries()));
		properties.setProperty("popcorn", String.valueOf(pet.getPopcorn()));

		try (FileOutputStream out = new FileOutputStream(SAVE_FILE)) {
			properties.store(out, "SAVE_DATA");
		} catch (IOException e) {
			System.out.println("Error saving game.");
		}
	}
}
