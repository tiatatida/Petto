package petto;

import java.util.Scanner;

import petto.job.Cashier;
import petto.util.Pet;

public class Work {
	public static void choice(Scanner scanner, Pet pet) {
		System.out.println("=== Work ===");
		System.out.println("Cashier   -   require a little math skill");
		System.out.println("------------");
		System.out.print("You want to work as: ");
		String choice = scanner.nextLine();
		if (choice.equalsIgnoreCase("cashier")) {
			Cashier.cashier(scanner, pet); 
		} else {
			System.out.println("Unknow");
		}
		
	}

}
