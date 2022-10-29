package Test_Automation;

import java.util.Arrays;

public class CheckSimple {

	public static void main(String[] args) {
		checkAnagram("", "");

	}

	private static void checkAnagram(String in1, String in2) {
		char[] in1Arr = in1.toLowerCase().toCharArray();
		char[] in2Arr = in1.toLowerCase().toCharArray();

		Arrays.sort(in1Arr);
		Arrays.sort(in2Arr);

		System.out.println(Arrays.equals(in1Arr, in2Arr));

	}

}
