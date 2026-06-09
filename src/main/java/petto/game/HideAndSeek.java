package petto.game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import petto.util.ChangeStatus;
import petto.util.Pet;

public class HideAndSeek {
	public static void hideAndSeek(Scanner scanner, String secretString, Pet pet) {
		System.out.println("Hide and Seek!");

		String hiddenFilePath = createRandomFile(secretString, pet);

		System.out.print("Answer: ");
		String answer = scanner.nextLine();
		if (answer.equals(secretString)) {
			System.out.println("Correct!");
			ChangeStatus.applyHideAndSeekWin(pet);
		} else {
			System.out.println("wrong -o-");
			System.out.println("It was at " + hiddenFilePath);
			ChangeStatus.applyHideAndSeekLoss(pet);
		}
	}

	public static String createRandomFile(String secretString, Pet pet) {
		String userHome = System.getProperty("user.home");
		File startDirectory = new File(userHome);
		List<File> directory = new ArrayList<>();
		getAllDirectory(startDirectory, directory, 0, 5);

		if (directory.isEmpty()) {
			directory.add(startDirectory);
		}
		Random random = new Random();
		File randomDirectory = directory.get(random.nextInt(directory.size()));
		File targetFile = new File(randomDirectory, "findme.txt");

		try (FileWriter writer = new FileWriter(targetFile)) {
			writer.write(secretString);
			System.out.println(pet.getName() + " hide find name findme.txt some where on your system.");
			System.out.println("Try find it :3");
			return targetFile.getAbsolutePath();
		} catch (Exception e) {
			System.out.println("Error");
			try (FileWriter fallbackWriter = new FileWriter("findme.txt")) {
				fallbackWriter.write(secretString);
				return new File("findme.txt").getAbsolutePath();
			} catch (IOException ex) {
				return "Error";
			}
		}
	}

	private static void getAllDirectory(File currentDirectory, List<File> resultList, int currentDepth, int maxDepth) {
		if (currentDepth > maxDepth || currentDirectory == null || !currentDirectory.exists()) {
			return;
		}

		File[] files = currentDirectory.listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.isDirectory() && file.isHidden() && file.canWrite()) {
					resultList.add(file);
					getAllDirectory(file, resultList, currentDepth + 1, maxDepth);
				}
			}
		}
	}
}
