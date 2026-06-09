package petto;

import java.util.Scanner;
import petto.util.ChangeStatus;
import petto.util.Pet;

public class Feed {
	public static void choice(Scanner scanner, Pet pet) {
		System.out.println("=== Feed ===");
		System.out.println("You have " + pet.getKibble() + " kibble");
		System.out.println("------------");
		System.out.println("You have " + pet.getCarrot() + " carrot");
		System.out.println("You have " + pet.getPotato() + " potato");
		System.out.println("You have " + pet.getCorn() + " corn");
		System.out.println("------------");
		System.out.println("You have " + pet.getCarrotsoup() + " carrot soup");
		System.out.println("You have " + pet.getFrenchfries() + " french fries");
		System.out.println("You have " + pet.getPopcorn() + " popcorn");
		System.out.println("------------");
		System.out.print("What to fed: ");
		String choice = scanner.nextLine();

	    FoodType foodType = FoodType.from(choice);
	    if (foodType == null) {
	        System.out.println();
	        return;
	    }

	    ChangeStatus.applyFeed(pet, foodType);
	}
	
	public enum FoodType {
		KIBBLE, CARROT, POTATO, CORN;
		
		public static FoodType from(String choice) {
			try {
				return valueOf(choice.toUpperCase());
			} catch (IllegalArgumentException e) {
				return null;
			}
		}
	}
}
