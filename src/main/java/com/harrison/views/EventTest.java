package com.harrison.views;

import org.junit.Test;

public class EventTest {

	@Test
	public void test() {
		String input = "daaabbbbccccccccpp";
		char[] charArray = input.toCharArray();
		String newString = "";
		int count = 0;
		char last = charArray[0];
		for (int i = 1; i < input.length(); i++) {
			char current = input.charAt(i);
			if (last == current) {
				count++;
			} else {
				count++;
				newString = newString + last + count;
				last = current;
				count = 0;
			}
		}
		System.out.println(newString);
	}

}
