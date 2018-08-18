package uy.edu.ude.main;

import uy.edu.ude.core.DirectorioComparator;
import uy.edu.ude.data.DataSource;

public class Main {
	public static void main(String[] args) {
		int size = 10;
		DataSource dataSource = new DataSource(size);
		DirectorioComparator comparator = new DirectorioComparator();
		String data = dataSource.getData().get(0);
		System.out.println(comparator.isStringInList("123",
				dataSource.getData()));
		System.out
				.println(comparator.isStringInList(data, dataSource.getData()));
	}
}
