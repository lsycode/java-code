package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Alth {
	public static Integer[] readAllInts() {
		Scanner s = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		for (;;) {
			String str = s.next();
			if (str.equals("f")) {
				break;
			}
			if (str.matches("^[A-Za-z]*$")) {
				break;
			}
			list.add(Integer.parseInt(str));
		}
		Integer[] in = new Integer[list.size()];
		for (int i = 0; i < in.length; i++) {
			in[i] = list.get(i);
		}
		return in;
	}

	public static String[] readAll() {
		Scanner s = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		for (;;) {
			String str = s.next();
			if (str.matches("/")) {
				break;
			}
			list.add(str);
		}
		String[] in = new String[list.size()];
		for (int i = 0; i < in.length; i++) {
			in[i] = list.get(i);
		}
		return in;
	}
}
