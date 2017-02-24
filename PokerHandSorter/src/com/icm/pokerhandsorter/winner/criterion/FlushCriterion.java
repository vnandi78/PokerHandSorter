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
public class FlushCriterion implements IRankingCriterion{
	
	public static boolean matches(List<Card> playerCards){
		LinkedHashSet<String> suiteSet = new LinkedHashSet<String>();
		
		for(Card card: playerCards){
			//----Take all the card suites into a set, that will eliminate all duplicates, 
			//----resulting to finding that all cards have same suite
			suiteSet.add(card.getSuite());
		}

		//-- So if the suite set size is 1, then that means, only one suite present		
		if(suiteSet.size()==1){
			return true;
		}
		return false;
	}

}
