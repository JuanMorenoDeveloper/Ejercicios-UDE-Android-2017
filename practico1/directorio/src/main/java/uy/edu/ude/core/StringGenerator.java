package uy.edu.ude.core;

import java.security.SecureRandom;
import java.util.UUID;

public class StringGenerator {
	private int bytesForData = 15;

	public StringGenerator() {
	}

	public String randomStringByUUID() {
		return UUID.randomUUID().toString();
	}

	public String randomStringBySecureRandom() {
		SecureRandom random = new SecureRandom();
		int value = random.nextInt(bytesForData);
		return String.valueOf(value);
	}

}
