package petto.util;

import java.util.Random;

public class RandomString {
	public static String generate() {
		String charactor = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		int length = 40;
		Random random = new Random();
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < length; i++) {
			stringBuilder.append(charactor.charAt(random.nextInt(charactor.length())));
		}
		return stringBuilder.toString();
	}

}
