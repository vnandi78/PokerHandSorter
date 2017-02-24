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
public class RoyalFlushCriterion implements IRankingCriterion{
	
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
		
		//-----So, if suite set size is 1, then we can proceed to check the number set to be unique
		if(suiteSet.size()==1 && numberSet.size() == 5){
			//-- If the number set is unique and has all 5 high cards, then Royal Flush met
			if(numberSet.contains(14) 
				&& numberSet.contains(13) 
				&& numberSet.contains(12) 
				&& numberSet.contains(11) 
				&& numberSet.contains(10)){
				return true;
			}
		}
		
		return false;
	}

}
