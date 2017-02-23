/**
 * 
 */
package com.icm.pokerhandsorter.winner.criterion;

import java.util.LinkedHashSet;
import java.util.List;

import com.icm.pokerhandsorter.cards.Card;
import com.icm.pokerhandsorter.players.Player;

/**
 * @author VDRKumar
 *
 */
public class RoyalFlushCriterion {
	
	public static boolean isItRoyalFlushScenario(List<Card> playerCards){
		LinkedHashSet<String> suiteSet = new LinkedHashSet<String>();
		LinkedHashSet<String> numberSet = new LinkedHashSet<String>();
		
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
			if(numberSet.contains("A") 
				&& numberSet.contains("Q") 
				&& numberSet.contains("K") 
				&& numberSet.contains("J") 
				&& numberSet.contains("10")){
				System.out.println("hurray!! he is lucky, a gold flush found......");
				return true;
			}
		}
		
		return false;
	}

	public static Player determineRoyalFlushWinner(Player player1, Player player2){
		
		//--If royal flush scenario is true for player 1 then return him to winning podium
		if(isItRoyalFlushScenario(player1.getCards())){
			return player1;
		}
		//--If royal flush scenario is true for player 2 then return him to winning podium
		else if(isItRoyalFlushScenario(player2.getCards())){
			return player2;
		}
		
		return null;
	}

}
