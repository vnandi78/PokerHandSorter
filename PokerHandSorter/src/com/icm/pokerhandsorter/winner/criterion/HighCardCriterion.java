/**
 * 
 */
package com.icm.pokerhandsorter.winner.criterion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.icm.pokerhandsorter.domain.Card;
import com.icm.pokerhandsorter.domain.Player;
import com.icm.pokerhandsorter.domain.Rank;

/**
 * @author VDRKumar
 *
 */
public class HighCardCriterion implements IRankingCriterion{

	public boolean matches(List<Card> playerCards){
		
		return true;
	}


/*	public void assignRanks(Player player){
		List<Card[]> allCards = player.getCards();
		List<Rank> ranks = player.getRanks();
	
		for(Card[] cards : allCards){
			List<Card> fiveCards = Arrays.stream(cards).collect(Collectors.toList());
			
			//--If flush scenario is true for player 1 then return him to winning podium
			if(isItHighCardScenario(fiveCards)){
				Rank rank = new Rank();
				rank.setCorrespondingCards(fiveCards);
				rank.setRank(1);
				rank.setPlayerName(player.getName());
				ranks.add(rank);			
			}
		}
		
		player.setRanks(ranks);	
	}		
*/
}
