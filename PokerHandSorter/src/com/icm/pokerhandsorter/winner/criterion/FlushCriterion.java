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
public class FlushCriterion implements IRankingCriterion{
	
	public boolean matches(List<Card> playerCards){
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

/*	public void assignRanks(Player player){
		List<Card[]> allCards = player.getCards();
		List<Rank> ranks = player.getRanks();
	
		for(Card[] cards : allCards){
			List<Card> fiveCards = Arrays.stream(cards).collect(Collectors.toList());
			
			//--If flush scenario is true for player 1 then return him to winning podium
			if(isItFlushScenario(fiveCards)){
				Rank rank = new Rank();
				rank.setCorrespondingCards(fiveCards);
				rank.setRank(6);
				rank.setPlayerName(player.getName());
				ranks.add(rank);			
			}
		}
		
		player.setRanks(ranks);	
	}		*/

}
