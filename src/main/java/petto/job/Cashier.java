package petto.job;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

import petto.util.ChangeStatus;
import petto.util.Pet;

public class Cashier {
	public static void cashier(Scanner scanner, Pet pet) {
		int z;
		String symbol;

		Random random = new Random();
		boolean i = random.nextBoolean();
		int x = random.nextInt(1001);
		int y = random.nextInt(1001);

		if (i) {
			z = x + y;
			symbol = "+";
		} else {
			z = x - y;
			symbol = "-";
		}
		
		AtomicBoolean isTimeout = new AtomicBoolean(false);
		Timer timer = startTimeoutTask(isTimeout);

		System.out.println(x + " " + symbol + " " + y + " = ?");
		System.out.print("Answer: ");
		String answer = scanner.nextLine();
		
		if (isTimeout.get()) {
			System.out.println("Timeout!");
			System.out.println("The answer is " + z);
			return;
		}
		timer.cancel();

		if (answer.equals(String.valueOf(z))) {
			System.out.println("Correct!");
			ChangeStatus.applyCashier(pet);

		} else {
			System.out.println("Wrong");
			System.out.println("The answer is " + z);
		}

	}
	public static Timer startTimeoutTask(AtomicBoolean isTimeout) {
		Timer timer = new Timer();
		TimerTask timertask = new TimerTask() {
			@Override
			public void run() {
				isTimeout.set(true);
				timer.cancel();
			}
		};
		timer.schedule(timertask, 20000);
		return timer;
	}

}
