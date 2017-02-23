/**
 * 
 */
package com.icm.pokerhandsorter.winner.criterion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import com.icm.pokerhandsorter.domain.Card;
import com.icm.pokerhandsorter.domain.Player;
import com.icm.pokerhandsorter.domain.Rank;

/**
 * @author VDRKumar
 *
 */
public class RoyalFlushCriterion implements IRankingCriterion{
	
	private boolean isItRoyalFlushScenario(List<Card> playerCards){
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

	public void assignRanks(Player player){
		
		List<Card[]> allCards = player.getCards();
		List<Rank> ranks = new ArrayList<Rank>();
	
		for(Card[] cards : allCards){
			List<Card> fiveCards = Arrays.stream(cards).collect(Collectors.toList());
			
			//--If royal flush scenario is true for player 1 then return him to winning podium
			if(isItRoyalFlushScenario(fiveCards)){
				Rank rank = new Rank();
				rank.setCorrespondingCards(fiveCards);
				rank.setRank(10);
				rank.setPlayerName(player.getName());
				ranks.add(rank);
			}
		}
		
		player.setRanks(ranks);	
		
	}

}
