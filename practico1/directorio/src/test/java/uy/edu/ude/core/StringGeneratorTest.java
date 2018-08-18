package uy.edu.ude.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringGeneratorTest {
	private StringGenerator data;

	@Before
	public void init() {
		data = new StringGenerator();
	}

	@Test
	public void shouldGetRandomStringByBySecureRandom() {
		String rndString1=data.randomStringBySecureRandom();
		System.out.println(rndString1);
		Assert.assertTrue(rndString1.length()>0);
	}
	@Test
	public void shouldGetRandomStringByUUID() {
		String rndString1=data.randomStringByUUID();
		System.out.println(rndString1);
		Assert.assertTrue(rndString1.length()>0);
	}
}
