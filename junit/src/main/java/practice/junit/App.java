package practice.junit;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {
	public String[] prepareMyBag() {
		String[] schoolbag = { "Books", "Notebooks", "Pens" };
		System.out.println("My school bag contains: "
				+ Arrays.toString(schoolbag));
		return schoolbag;
	}

	public String[] addPencils() {
		String[] schoolbag = { "Books", "Notebooks", "Pens", "Pencils" };
		System.out.println("Now my school bag contains: "
				+ Arrays.toString(schoolbag));
		return schoolbag;
	}
}