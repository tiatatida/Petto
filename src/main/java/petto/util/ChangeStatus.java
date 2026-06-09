package petto.util;


import static petto.util.Constants.*;

import java.util.Random;

import petto.Cook;
import petto.Feed.FoodType;

public class ChangeStatus {
    public static void applyHideAndSeekWin(Pet pet) {
        pet.setHunger(pet.getHunger() - HIDE_AND_SEEK_HUNGER_COST);
        pet.setHappiness(pet.getHappiness() + HIDE_AND_SEEK_HAPPINESS_GAIN);
        GameState.saveGame(pet);
        System.out
                .println("+" + HIDE_AND_SEEK_HAPPINESS_GAIN + " Happiness");
    }

    public static void applyHideAndSeekLoss(Pet pet) {
        pet.setHunger(pet.getHunger() - HIDE_AND_SEEK_HUNGER_COST);
        pet.setHappiness(pet.getHappiness() - HIDE_AND_SEEK_HAPPINESS_LOSS);
        GameState.saveGame(pet);
        System.out
                .println("-" + HIDE_AND_SEEK_HAPPINESS_LOSS + " Happiness");
    }

    public static void applyCoinFlipWin(Pet pet) {
        pet.setHunger(pet.getHunger() - COIN_FLIP_HUNGER_COST);
        pet.setHappiness(pet.getHappiness() + COIN_FLIP_HAPPINESS_GAIN);
        GameState.saveGame(pet);
        System.out.println("+ " + COIN_FLIP_HAPPINESS_GAIN + " Happiness");

    }

    public static void applyCoinFlipLoss(Pet pet) {
        pet.setHunger(pet.getHunger() - COIN_FLIP_HUNGER_COST);
        pet.setHappiness(pet.getHappiness() + COIN_FLIP_HAPPINESS_LOSS);
        GameState.saveGame(pet);
        System.out.println("- " + COIN_FLIP_HAPPINESS_LOSS + " Happiness");

    }

    public static void applyCashier(Pet pet) {
        pet.setMoney(pet.getMoney() + WORK_CASHIER_GAIN);
        GameState.saveGame(pet);
        System.out.println("+" + WORK_CASHIER_GAIN + " Money");
    }

    public static void applyShop(Pet pet, String[] itemDisplay) {
        String itemName = itemDisplay[0];
        String itemPrice = itemDisplay[1];
        int price = Integer.parseInt(itemPrice);

        if (pet.getMoney() < price) {
            System.out.println("Not enough money!");
            return;
        }

        switch (itemName) {
            case "Seeds" -> {
                pet.setSeeds(pet.getSeeds() + BASIC_GAIN);
                pet.setMoney(pet.getMoney() - price);
                System.out.println("You bought 1x " + itemName);
            }
            case "Fertilizer" -> {
                pet.setFertilizer(pet.getFertilizer() + BASIC_GAIN);
                pet.setMoney(pet.getMoney() - price);
                System.out.println("You bought 1x " + itemName);
            }
            case "Kibble" -> {
                pet.setKibble(pet.getKibble() + BASIC_GAIN);
                pet.setMoney(pet.getMoney() - price);
                System.out.println("You bought 1x " + itemName);
            }
            case "Invest" -> {
                Random random = new Random();
                boolean x = random.nextBoolean();
                boolean o = random.nextBoolean();
                if (x && o) {
                    pet.setMoney(pet.getMoney() * price);
                    System.out.println("You loss " + (pet.getMoney() * price) + " on invest");
                } else {
                    pet.setMoney(pet.getMoney() / price);
                    System.out.println("You gain " + (pet.getMoney() / price) + " on invest");
                }
            }
        }
        GameState.saveGame(pet);
    }

    public static void applyFarm(Pet pet) {
        if (pet.getSeeds() <= 0) {
            System.out.println("Not enough seeds!");
            return;
        }

        Random random = new Random();
        int x = random.nextInt(3);
        int i = random.nextInt(4) + 1;

        pet.setSeeds(pet.getSeeds() - BASIC_COST);

        switch (x) {
            case 0 -> pet.setCarrot(pet.getCarrot() + i);
            case 1 -> pet.setPotato(pet.getPotato() + i);
            case 2 -> pet.setCorn(pet.getCorn() + i);
        }

        String[] crops = {"carrot", "potato", "corn"};
        System.out.printf("You grew %d %s(s)!%n", i, crops[x]);

        GameState.saveGame(pet);
    }

    public static void applyFeed(Pet pet, FoodType foodType) {
        switch (foodType) {
            case KIBBLE -> {
                if (pet.getKibble() <= 0) {
                    System.out.println("Not enough kibble");
                    return;
                } else {
                    pet.setKibble(pet.getKibble() - BASIC_COST);
                    pet.setHappiness(pet.getHappiness() - FOOD_KIBBLE_COST);
                    pet.setHunger(pet.getHunger() + FOOD_KIBBLE_GAIN);
                    System.out.println("You fed " + pet.getName() + " :3");
                }
            }
            case CARROT -> {
                if (pet.getCarrot() <= 0) {
                    System.out.println("Not enough carrot");
                    return;
                } else {
                    pet.setCarrot(pet.getCarrot() - BASIC_COST);
                    pet.setHappiness(pet.getHappiness() - FOOD_PLANT_COST);
                    pet.setHunger(pet.getHunger() + FOOD_PLANT_GAIN);
                    System.out.println("You fed " + pet.getName() + " :3");
                }
            }
            case POTATO -> {
                if (pet.getPotato() <= 0) {
                    System.out.println("Not enough potato");
                    return;
                } else {
                    pet.setPotato(pet.getPotato() - BASIC_COST);
                    pet.setHappiness(pet.getHappiness() - FOOD_PLANT_COST);
                    pet.setHunger(pet.getHunger() + FOOD_PLANT_GAIN);
                    System.out.println("You fed " + pet.getName() + " :3");
                }

            }
            case CORN -> {
                if (pet.getCorn() <= 0) {
                    System.out.println("Not enough corn");
                    return;
                } else {
                    pet.setPotato(pet.getPotato() - BASIC_COST);
                    pet.setHappiness(pet.getHappiness() - FOOD_PLANT_COST);
                    pet.setHunger(pet.getHunger() + FOOD_PLANT_GAIN);
                    System.out.println("You fed " + pet.getName() + " :3");
                }
            }
        }
        GameState.saveGame(pet);
    }

    public static void applyCook(Pet pet, Cook.CookFood cookFood) {
        switch (cookFood) {
            case CARROT_SOUP -> {
                if (pet.getCarrot() <= COOK_COST) {
                    System.out.println("Not enough carrot");
                } else {
                    pet.setCarrot(pet.getCarrot() - COOK_COST);
                    pet.setHunger(pet.getHunger() + FOOD_COOK_GAIN);
                    System.out.println("You fed " + pet.getName() + " :3");
                }
            }
            case FRENCH_FRIES -> {
                if (pet.getFrenchfries() <= COOK_COST) {
                    System.out.println("Not enough potato");
                } else {
                    pet.setPotato(pet.getPotato() - COOK_COST);
                    pet.setHunger(pet.getHunger() + FOOD_COOK_GAIN);
                    System.out.println("You fed " + pet.getName() + " :3");
                }
            }
            case POPCORN -> {
                if (pet.getPotato() <= COOK_COST) {
                    System.out.println("Not enough corn");
                } else {
                    pet.setPotato(pet.getPotato() - COOK_COST);
                    pet.setHunger(pet.getHunger() + FOOD_COOK_GAIN);
                    System.out.println("You fed " + pet.getName() + " :3");
                }
            }
        }
        GameState.saveGame(pet);
    }

}
