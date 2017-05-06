package uy.edu.ude.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import uy.edu.ude.data.DataSource;

public class DataSourceTest {
	private DataSource dataSource;

	@Before
	public void init() {
	}

	@Test
	public void shouldGetListWithSize10() {
		int size = 10;
		dataSource = new DataSource(size);
		for (String str : dataSource.getData()) {
			System.out.println(str);
		}
		Assert.assertTrue("No son iguales", size == dataSource.getData().size());
	}
}
