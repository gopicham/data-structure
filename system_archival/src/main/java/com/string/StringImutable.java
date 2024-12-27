/**
 * 
 */
package com.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 
 */
public class StringImutable {

	/**
	 * @param args
	 */
	public static void main(java.lang.String[] args) {
		// duplicates and repeated count in string

		java.lang.String str = "MANJUNATH";
		String[] arr = str.replaceAll("\\s", "").split("");
		String[] rev = new String[arr.length];
		int cout = 0;
		for (int l = arr.length - 1; l >= 0; l--) {
			rev[cout] = arr[l];
			System.out.print(arr[l]);
			cout++;
		}
		final Set<String> repeat = new HashSet<String>();

		List<String> dupl = Arrays.stream(rev).filter(fn -> !repeat.add(fn)).collect(Collectors.toList());
		System.out.println(dupl);

		List<Character> reverStr = str.replaceAll("\\s", "").chars().mapToObj(ch -> (char) ch)
				.collect(Collectors.toList()).reversed();

		Map<String, Long> countChar = Arrays.stream(arr)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(countChar);
		String ch = "bangalore";
//Repeat a specific number of characters for specific number of times from the last part of a string
		String threChar = ch.substring(ch.length() - 2, ch.length());
		System.out.println("last3Char : " + threChar + "::times : " + threChar.repeat(3));

		Set<Integer> filter = new HashSet<>();

		str = "BOTTLE";
		OptionalInt c = str.chars().filter(e -> !filter.add(e)).findFirst();
		System.out.println((char) c.getAsInt());

		char[] in = "manjunath,abc,xyz,you".toCharArray();

		for (int i = 0; i < in.length; i++) {
			for (int k = i + 1; k < in.length; k++) {
				char temp;
				if (in[i] < in[k]) {
					temp = in[i];
					in[i] = in[k];
					in[k] = temp;
				}
			}
		}
		// System.out.print(new String(in));

		String res = "abcdefcg";

		List<String> reversed = Arrays.stream(res.split("")).sorted(Comparator.naturalOrder())
				.collect(Collectors.toList());
		System.out.println(" output :" + reversed);

		long avg = IntStream.range(0, 10).reduce(10, (a, b) -> a + b);

		Stream<Integer> numbers = Stream.of(10, 66, 56, 70, 55, 99, 9, 40, 3);

		Map<Boolean, List<Integer>> data = numbers
				.collect(Collectors.partitioningBy(fn -> fn % 2 != 0, Collectors.toList()));
		System.out.println(data);
		for (Map.Entry<Boolean, List<Integer>> seg : data.entrySet()) {

			if (seg.getKey() == false) {
				System.out.println("even :" + seg.getValue());
			} else {
				System.out.println("oddd :" + seg.getValue());
			}

		}

	}

}
