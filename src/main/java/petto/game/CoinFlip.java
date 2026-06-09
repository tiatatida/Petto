package petto.game;

import petto.util.ChangeStatus;
import petto.util.Pet;

import java.util.Random;
import java.util.Scanner;

public class CoinFlip {
    public static void coinFlip(Scanner scanner, Pet pet) {
        System.out.println("Coin Flip!");
        System.out.println(pet.getName() + " just flip the coin try guess it!");
        System.out.print("Answer: ");
        String answer = scanner.nextLine();
        String coin = flipCoin();
        if (answer.equalsIgnoreCase(coin)) {
            System.out.println("correct!");
            ChangeStatus.applyCoinFlipWin(pet);
        } else  {
            System.out.println("wrong");
            ChangeStatus.applyCoinFlipLoss(pet);
        }

    }
    public static String flipCoin() {
        Random random = new Random();
        boolean x = random.nextBoolean();
        if (x) {
            return "head";
        } else  {
            return "tail";
        }
    }
}
