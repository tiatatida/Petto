package petto;

import java.util.Scanner;
import static petto.util.Constants.*;

import petto.util.ChangeStatus;
import petto.util.Pet;

public class Farm {
	public static void choice(Scanner scanner, Pet pet) {
		System.out.println("=== Farm ===");
		System.out.println("You have " + pet.getSeeds() + "/" + SEEDS_MAX + " random seeds");
		System.out.println("------------");
		System.out.print("Plant? (y/n): ");
		String choice = scanner.nextLine();
		if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
			ChangeStatus.applyFarm(pet);
		} else {
			System.out.println();
		}
	}

}
