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
			suiteSet.add(card.getSuite());
			numberSet.add(card.getNumber());
		}
		
		if(suiteSet.size()==1 && numberSet.size() == 5){
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
		
		if(isItRoyalFlushScenario(player1.getCards())){
			return player1;
		}
		else if(isItRoyalFlushScenario(player2.getCards())){
			return player2;
		}
		
		return null;
	}

}
