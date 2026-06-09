package petto;

import java.util.Random;
import java.util.Scanner;

import petto.game.CoinFlip;
import petto.game.HideAndSeek;
import petto.util.Pet;
import petto.util.RandomString;

public class Play {
    public static void randomGame(Scanner scanner, Pet pet) {
        Random random = new Random();
        boolean x = random.nextBoolean();

        if (x) {
            String secretString = RandomString.generate();
            HideAndSeek.hideAndSeek(scanner, secretString, pet);
        } else {
            CoinFlip.coinFlip(scanner, pet);
        }
    }
}
