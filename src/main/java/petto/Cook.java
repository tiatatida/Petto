package petto;

import petto.util.ChangeStatus;
import petto.util.Pet;

import java.util.Scanner;

public class Cook {
	public static void choice(Pet pet, Scanner scanner) {
		System.out.println("=== Cook ===");
		System.out.println("carrot soup");
		System.out.println("french fries");
		System.out.println("popcorn");
		System.out.println("Need 3 of plants");
		System.out.println("------------");
		System.out.println("What to cook: ");
		String choice = scanner.next();
		CookFood cookFood = CookFood.from(choice);

		if (cookFood == null) {
			System.out.println();
			return;
		}

		ChangeStatus.applyCook(pet, cookFood);

	}
	public enum CookFood {
		CARROT_SOUP, FRENCH_FRIES, POPCORN;
		public static CookFood from(String choice) {
			try {
				return valueOf(choice.toUpperCase());
			} catch (IllegalArgumentException e) {
				return null;
			}
		}
	}

}
