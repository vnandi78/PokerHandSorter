/**
 * 
 */
package com.icm.pokerhandsorter.winner.criterion;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import com.icm.pokerhandsorter.domain.Card;

/**
 * @author VDRKumar
 *
 */
public class StraightCriterion implements IRankingCriterion{
	
	public boolean matches(List<Card> playerCards){
		LinkedHashSet<Integer> numberSet = new LinkedHashSet<Integer>();
		
		for(Card card: playerCards){
			//----Similarly, Take all the card numbers into a set, that will eliminate all duplicates, 
			//----resulting to finding that all cards have unique number
			numberSet.add(card.getNumber());
		}
		
		if(numberSet.size()==5){
			
			numberSet.stream().sorted();
			int number = numberSet.iterator().next();
			boolean inSeries = true;
			int i=1;
			Iterator<Integer> numbers = numberSet.iterator();
			while(numbers.hasNext()){
				
				int nextNum = numbers.next();
				if(nextNum - number != i){
					return false;
				}
				i++;
			}
				
			return inSeries;

		}
		
		return false;
	}

}
