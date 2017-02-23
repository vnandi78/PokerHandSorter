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
public class StraightFlushCriterion implements RankingCriterion {

	private boolean isItStraightFlushScenario(List<Card> playerCards){
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
		
		if(suiteSet.size()==1 && numberSet.size()==5){
			if(numberSet.contains("A")){
				if(numberSet.contains("K") && numberSet.contains("Q") && numberSet.contains("J") && numberSet.contains("10")){
					return true;
				}
			}
			else if(numberSet.contains("K")){
				if(numberSet.contains("Q") && numberSet.contains("J") && numberSet.contains("10") && numberSet.contains("9")){
					return true;
				}
			}
			else if(numberSet.contains("Q")){
				if(numberSet.contains("J") && numberSet.contains("10") && numberSet.contains("9") && numberSet.contains("8")){
					return true;
				}
			}
			else if(numberSet.contains("J")){
				if(numberSet.contains("10") && numberSet.contains("9") && numberSet.contains("8") && numberSet.contains("7")){
					return true;
				}
			}
			else{
				numberSet.stream().sorted();
				String number = numberSet.iterator().next();
				boolean inSeries = true;
				int num = Integer.parseInt(number);
				for(int i=0; i<3; i++){
					if(!numberSet.contains(num+1)){
						inSeries = false;
						return inSeries;
					}
				}
				
				return inSeries;
			}
		}
		
		return false;
	}

	public void assignRanks(Player player){
		List<Card[]> allCards = player.getCards();
		List<Rank> ranks = new ArrayList<Rank>();
	
		for(Card[] cards : allCards){
			List<Card> fiveCards = Arrays.stream(cards).collect(Collectors.toList());
			
			//--If straight flush scenario is true for player 1 then return him to winning podium
			if(isItStraightFlushScenario(fiveCards)){
				Rank rank = new Rank();
				rank.setCorrespondingCards(fiveCards);
				rank.setRank(9);
				rank.setPlayerName(player.getName());
				ranks.add(rank);				
			}	

		}
		
		player.setRanks(ranks);	
	}
}
