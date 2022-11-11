package Test_Automation;

import java.util.Arrays;
import java.util.StringTokenizer;

public class CheckSimple {

	public static void main(String[] args) {
		checkAnagram("vijay sankar", "");

	}

	private static void checkAnagram(String in1, String in2) {
		char[] in1Arr = in1.toLowerCase().toCharArray();
		char[] in2Arr = in1.toLowerCase().toCharArray();

		String[] check = in1.split(" ");

		for (int i = 0; i < check.length; i++) {
			String temp = "";
			for (int j = check[i].length() - 1; j >= 0; j--) {
				temp = temp + check[i].charAt(j);
			}
			check[i] = temp;
			System.out.println(temp);
		}

//		Arrays.sort(in1Arr);
//		Arrays.sort(in2Arr);
		System.out.println(Arrays.toString(check));
		System.out.println(Arrays.equals(in1Arr, in2Arr));
		System.out.println(Math.random() * 10);
	}

}
