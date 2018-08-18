package uy.edu.ude.data;

import java.util.ArrayList;
import java.util.List;

import uy.edu.ude.core.StringGenerator;

public class DataSource {
	private List<String> data = new ArrayList<>(10);
	private StringGenerator generator = new StringGenerator();

	public DataSource() {
	}

	public DataSource(int size) {
		for (int i = 0; i < size; i++) {
			data.add(generator.randomStringByUUID());
		}
	}

	public List<String> getData() {
		return data;
	}

}
