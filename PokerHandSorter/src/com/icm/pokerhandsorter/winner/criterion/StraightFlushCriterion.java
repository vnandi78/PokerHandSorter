/**
 * 
 */
package com.icm.pokerhandsorter.winner.criterion;

import java.util.LinkedHashSet;
import java.util.List;
import com.icm.pokerhandsorter.domain.Card;


/**
 * @author VDRKumar
 *
 */
public class StraightFlushCriterion implements IRankingCriterion {

	public boolean matches(List<Card> playerCards){
		LinkedHashSet<String> suiteSet = new LinkedHashSet<String>();
		LinkedHashSet<Integer> numberSet = new LinkedHashSet<Integer>();
		
		for(Card card: playerCards){
			//----Take all the card suites into a set, that will eliminate all duplicates, 
			//----resulting to finding that all cards have same suite
			suiteSet.add(card.getSuite());
			
			//----Similarly, Take all the card numbers into a set, that will eliminate all duplicates, 
			//----resulting to finding that all cards have unique number
			numberSet.add(card.getNumber());
		}
		
		if(suiteSet.size()==1 && numberSet.size()==5){
				numberSet.stream().sorted();
				int number = numberSet.iterator().next();
				boolean inSeries = true;
				for(int i=0; i<3; i++){
					if(!numberSet.contains(number+1)){
						inSeries = false;
						return inSeries;
					}
				}
				
				return inSeries;
		}
		
		return false;
	}

}
