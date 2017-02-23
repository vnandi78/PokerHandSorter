package com.icm.pokerhandsorter.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionsTests {
	
	public static void main(String[] args){
		List<String> numbers = new ArrayList<String>();
		
		numbers.add("J");
		numbers.add("J");
		numbers.add("J");
		numbers.add("J");
		numbers.add("5");
		
		LinkedHashSet<String> numberSet = numbers.stream().filter(i -> Collections.frequency(numbers, i) ==4)
        .collect(Collectors.toCollection(LinkedHashSet::new));
		
		System.out.println("size = " + numberSet.size());
		
	}

}
