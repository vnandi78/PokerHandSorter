/**
 * 
 */
package com.icm.pokerhandsorter.winner.criterion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
public class FourOfAKindCriterion implements RankingCriterion {
	
	private boolean isItFourOfAKindScenario(List<Card> playerCards){
		
		List<String> numberList = new ArrayList<String>();
		
		for(Card card: playerCards){
			//----Similarly, Take all the card numbers into a set, that will eliminate all duplicates, 
			//----resulting to finding that all cards have unique number
			numberList.add(card.getNumber());
		}
		
		LinkedHashSet<String> finalNumberSet = numberList.stream().filter(i -> Collections.frequency(numberList, i) == 4)
		        																.collect(Collectors.toCollection(LinkedHashSet::new));
		
		if(finalNumberSet.size()==1){
			return true;
		}
		
		return false;
	}

	public void assignRanks(Player player){
		List<Card[]> allCards = player.getCards();
		List<Rank> ranks = new ArrayList<Rank>();
	
		for(Card[] cards : allCards){
			List<Card> fiveCards = Arrays.stream(cards).collect(Collectors.toList());
			
			//--If royal flush scenario is true for player 1 then return him to winning podium
			if(isItFourOfAKindScenario(fiveCards)){
				Rank rank = new Rank();
				rank.setCorrespondingCards(fiveCards);
				rank.setRank(8);
				rank.setPlayerName(player.getName());
				ranks.add(rank);				
			}
			
		}
		
		player.setRanks(ranks);	
	}	

}
