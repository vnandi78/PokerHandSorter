/**
 * 
 */
package com.icm.pokerhandsorter.winner.criterion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import com.icm.pokerhandsorter.domain.Card;


/**
 * @author VDRKumar
 *
 */
public class FullHouseCriterion implements IRankingCriterion{
	
	public static boolean matches(List<Card> playerCards){
		List<Integer> numberList = new ArrayList<Integer>();
		
		for(Card card: playerCards){
			//----Similarly, Take all the card numbers into a set, that will eliminate all duplicates, 
			//----resulting to finding that all cards have unique number
			numberList.add(card.getNumber());
		}
		
		LinkedHashSet<Integer> firstNumberSet = numberList.stream().filter(i -> Collections.frequency(numberList, i) == 3)
		        																.collect(Collectors.toCollection(LinkedHashSet::new));
		
		LinkedHashSet<Integer> secondNumberSet = numberList.stream().filter(i -> Collections.frequency(numberList, i) == 2)
				.collect(Collectors.toCollection(LinkedHashSet::new));

		if(firstNumberSet.size()==1 && secondNumberSet.size()==1){
			return true;
		}
		
		return false;
	}


}
