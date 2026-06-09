package petto;

import java.util.Random;
import java.util.Scanner;

import petto.util.ChangeStatus;
import petto.util.Pet;

public class Shop {
	public static void choice(Scanner scanner, Pet pet) {
		System.out.println("=== Shop ===");
		String[] item = itemDisplay();
		System.out.println("------------");
		System.out.println("Money : " + pet.getMoney());
		System.out.println("------------");
		System.out.print("Buy (y/n): ");
		String choice = scanner.nextLine();
		if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
			ChangeStatus.applyShop(pet, item);
		} else {
			System.out.println();
		}
	}

	public static String[] itemDisplay() {
		Random random = new Random();
		int x = random.nextInt(4) + 1;
		int y = random.nextInt(100) + 10;
		String[] result = new String[2];
		result[1] = String.valueOf(y);

		switch (x) {
		case 1 -> result[0] = "Seeds";
		case 2 -> result[0] = "Fertilizer";
		case 3 -> result[0] = "Kibble";
		case 4 -> result[0] = "Invest";
		}
		System.out.println(result[0] + " is on sell for " + result[1]);
		return result;
	}

}
