package petto;

import java.util.Scanner;
import petto.util.ClearTerminal;
import petto.util.DateAndTime;
import petto.util.GameState;
import petto.util.Pet;
import static petto.util.Constants.*;

public class Main {
	static void main() {
		System.out.println("Welcome! --- Petto v0.1");
		DateAndTime.welcomeDateAndTime();
		System.out.println();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("Action: ");
			String action = scanner.nextLine();
			if (action.equalsIgnoreCase("exit") || action.equalsIgnoreCase("quit")) {
				System.out.print("Goodbye!");
				break;
			} else if (action.equalsIgnoreCase("new") || action.equals("!")) {
				System.out.print("Name your pet:  ");
				String name = scanner.nextLine();
				GameState.newGame(name);
			} else if (action.equalsIgnoreCase("check")) {
				Pet pet = GameState.loadGame();
				if (pet != null) {
					System.out.println("=== Check ===");
					System.out.println("Name          " + pet.getName());
					System.out.println("------------  -");
					System.out.println("Hunger        " + pet.getHunger() + "/" + STAT_MAX);
					System.out.println("Happiness     " + pet.getHappiness() + "/" + STAT_MAX);
					System.out.println("Money         " + pet.getMoney() + "/" + MONEY_MAX);
					System.out.println("------------  -");
					System.out.println("Kibble        " + pet.getKibble() + "/" + FOOD_MAX);
					System.out.println("Carrot        " + pet.getCarrot() + "/" + FOOD_MAX);
					System.out.println("Potato        " + pet.getPotato() + "/" + FOOD_MAX);
					System.out.println("Corn          " + pet.getCorn() + "/" + FOOD_MAX);
					System.out.println("Carrot soup   " + pet.getCarrot () + "/" + FOOD_MAX);
					System.out.println("French fries  " + pet.getFrenchfries() + "/" + FOOD_MAX);
					System.out.println("Popcorn       " + pet.getPopcorn() + "/" + FOOD_MAX);
					System.out.println("------------  -");
					System.out.println("Seeds         " + pet.getSeeds() + "/" + SEEDS_MAX);
					System.out.println("Fertilizer    " + pet.getFertilizer() + "/" + FERTILIZER_MAX);
				}
			} else if (action.equalsIgnoreCase("help") || action.equals("?")) {
				System.out.println("=== Help ===");
				System.out.println("new     -     New game");
				System.out.println("check   -     Check status");
				System.out.println("work    -     Go to work to get money");
				System.out.println("shop    -     Buy some things from shop");
				System.out.println("play    -     Play random minigame");
				System.out.println("farm    -     Plant crop for your pet");
				System.out.println("cook    -     Cook food for your pet");
				System.out.println("feed    -     Feed your pet pet");
				System.out.println("------------");
				System.out.println("date    -     Check current date");
				System.out.println("time    -     Check current time");
				System.out.println("clear   -     Clear the terminal");
				System.out.println("exit    -     Quit petto.game");
			} else if (action.equalsIgnoreCase("play")) {
				Pet pet = GameState.loadGame();
				if (pet != null) {
					Play.randomGame(scanner, pet);
				}
			} else if (action.equalsIgnoreCase("feed")) {
				Pet pet = GameState.loadGame();
				if (pet != null) {
					Feed.choice(scanner, pet);
				}
			} else if (action.equalsIgnoreCase("farm")) {
				Pet pet = GameState.loadGame();
				if (pet != null) {
					Farm.choice(scanner, pet);
				}
			} else if (action.equalsIgnoreCase("work")) {
				Pet pet = GameState.loadGame();
				if (pet != null) {
					Work.choice(scanner, pet);
				}
			} else if (action.equalsIgnoreCase("clear")) {
				ClearTerminal.clear();
			} else if (action.equalsIgnoreCase("time")) {
				DateAndTime.time();
			} else if (action.equalsIgnoreCase("date")) {
				DateAndTime.date();
			} else if (action.equalsIgnoreCase("shop")) {
				Pet pet = GameState.loadGame();
				if (pet != null) {
					Shop.choice(scanner, pet);
				}
			} else {
				System.out.println("To view all command use help.");
			}
		}
		scanner.close();
	}
}
