package com.learning.logicalprograms;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MoneyDenominations {

	public static void main(String[] args) {
		System.out.println("A Program to calculate Denomination for Given Amount!");
		int amount = 1676;

		List<Integer> availableDenominationsList = Arrays.asList(2000, 1000, 50, 200, 100, 500, 20, 10, 5, 1);

		/*
		 * Performing Sorting in descending order so that highest denomination used
		 * first Else random denominations given in the list will be taken and that will
		 * be taken first.
		 */

		Collections.sort(availableDenominationsList);
		Collections.reverse(availableDenominationsList);

		Map<Integer, Integer> requiredDenominations = getRequiredDenominationsAmt(amount, availableDenominationsList);

		System.out.println("Final Denomination with Values Required :" + requiredDenominations);

	}

	private static Map<Integer, Integer> getRequiredDenominationsAmt(int amount,
			List<Integer> availableDenominationsList) {

		// Invalid Amount check & Faily Early
		if (amount <= 0) {
			throw new InvalidParameterException(
					String.format("Please provide valid amount! Invalid Amount provided : %d", amount));
		}

		Map<Integer, Integer> requiredDenominations = new LinkedHashMap<>();
		for (Integer each : availableDenominationsList) {
			if (amount >= each) {
				System.out.println("Denomination Value :" + each);
				System.out.println("Denomination Count :" + amount / each);
				requiredDenominations.put(Integer.valueOf(each), Integer.valueOf(amount / each));
				amount = amount % each;
				System.out.println("Remaining Amount :" + amount);
			}
		}

		return requiredDenominations;
	}

}
