/**
 * 
 */
package com.icm.pokerhandsorter.winner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.icm.pokerhandsorter.domain.Card;
import com.icm.pokerhandsorter.domain.Player;
import com.icm.pokerhandsorter.domain.Rank;
import com.icm.pokerhandsorter.winner.criterion.FlushCriterion;
import com.icm.pokerhandsorter.winner.criterion.FourOfAKindCriterion;
import com.icm.pokerhandsorter.winner.criterion.FullHouseCriterion;
import com.icm.pokerhandsorter.winner.criterion.PairCriterion;
import com.icm.pokerhandsorter.winner.criterion.RoyalFlushCriterion;
import com.icm.pokerhandsorter.winner.criterion.StraightCriterion;
import com.icm.pokerhandsorter.winner.criterion.StraightFlushCriterion;
import com.icm.pokerhandsorter.winner.criterion.ThreeOfAKindCriterion;
import com.icm.pokerhandsorter.winner.criterion.TwoPairsCriterion;

/**
 * @author VDRKumar
 *
 */
public class DetermineBestHand {
	
	public static Map<Player, Integer> findWinnerAndIncrementScore(Player player1, Player player2){

		int player1WinningCount = 0;
		int player2WinningCount = 0;
		int couldNotDeterWinner = 0;
		System.out.println("PLayer1 cards size = " + player1.getCards().size());
		System.out.println("PLayer2 cards size = " + player2.getCards().size());
		
		//------First assign ranks for the cards that players possess
		assignRanks(player1);
		assignRanks(player2);

		
		List<Rank> ranks1 = player1.getRanks();
		List<Rank> ranks2 = player2.getRanks();
		
		Iterator<Rank> iter1 = ranks1.iterator();
		Iterator<Rank> iter2 = ranks2.iterator();
		
		if(ranks1.size() == ranks2.size()){
			while(iter1.hasNext() && iter2.hasNext()){
				Rank rank1 = iter1.next();
				Rank rank2 = iter2.next();
				
				if(rank1.getRank()>rank2.getRank()){
					player1WinningCount++;
					//System.out.println("player1WinningCount = " + player1WinningCount);
				}
				else if(rank1.getRank()<rank2.getRank()){
					player2WinningCount++;
					//System.out.println("player2WinningCount = " + player2WinningCount);
				}
				else{
					Rank rank = furtherChecksOntheWinningRank(rank1, rank2, rank1.getRank());
					if(rank.getPlayerName().equalsIgnoreCase(player1.getName())){
						player1WinningCount++;
					}
					else{
						player2WinningCount++;
					}
				}
			}
		}
		
		System.out.println("Finally, player1WinningCount=" + player1WinningCount + 
				", player2WinningCount=" + player2WinningCount + ", couldNotDeterWinner=" + couldNotDeterWinner);
		
		return null;
	}
	
	
	private static void assignRanks(Player player){
		List<Card[]> allCards = player.getCards();
		List<Rank> ranks = player.getRanks();
	
		for(Card[] cards : allCards){
			List<Card> fiveCards = Arrays.stream(cards).collect(Collectors.toList());

			if(RoyalFlushCriterion.matches(fiveCards)){
			//-----------------------Rank 10 - Royal Flush Scenario-------------------------------------------------

				Rank rank = new Rank();
				rank.setCorrespondingCards(fiveCards);
				rank.setRank(10);
				rank.setPlayerName(player.getName());
				ranks.add(rank);			
			}
			else if(StraightFlushCriterion.matches(fiveCards)){
			//-----------------------Rank 9 - Straight flush Scenario-------------------------------------------------

				Rank rank = new Rank();
				rank.setCorrespondingCards(fiveCards);
				rank.setRank(9);
				rank.setPlayerName(player.getName());
				ranks.add(rank);			
				
			}
			else if(FourOfAKindCriterion.matches(fiveCards)){
			//-----------------------Rank 8 - Four of a kind Scenario-------------------------------------------------

				Rank rank = new Rank();
				rank.setCorrespondingCards(fiveCards);
				rank.setRank(8);
				rank.setPlayerName(player.getName());
				ranks.add(rank);			
				
			}
			else if(FullHouseCriterion.matches(fiveCards)){
			//-----------------------Rank 7 - Full House Scenario-------------------------------------------------

				Rank rank = new Rank();
				rank.setCorrespondingCards(fiveCards);
				rank.setRank(7);
				rank.setPlayerName(player.getName());
				ranks.add(rank);			
				
			}
			else if(FlushCriterion.matches(fiveCards)){
			//-----------------------Rank 6 - Flush Scenario-------------------------------------------------

				Rank rank = new Rank();
				rank.setCorrespondingCards(fiveCards);
				rank.setRank(6);
				rank.setPlayerName(player.getName());
				ranks.add(rank);			
				
			}
			else if(StraightCriterion.matches(fiveCards)){
			//-----------------------Rank 5 - Straight Scenario-------------------------------------------------

				Rank rank = new Rank();
				rank.setCorrespondingCards(fiveCards);
				rank.setRank(5);
				rank.setPlayerName(player.getName());
				ranks.add(rank);			
				
			}
			else if(ThreeOfAKindCriterion.matches(fiveCards)){
			//-----------------------Rank 4 - Three of a Kind Scenario-------------------------------------------------

				Rank rank = new Rank();
				rank.setCorrespondingCards(fiveCards);
				rank.setRank(4);
				rank.setPlayerName(player.getName());
				ranks.add(rank);			
				
			}
			else if(TwoPairsCriterion.matches(fiveCards)){
			//-----------------------Rank 3 - Two Pairs Scenario-------------------------------------------------		

				Rank rank = new Rank();
				rank.setCorrespondingCards(fiveCards);
				rank.setRank(3);
				rank.setPlayerName(player.getName());
				ranks.add(rank);			
				
			}
			else if(PairCriterion.matches(fiveCards)){
			//-----------------------Rank 2 - Pair Scenario-------------------------------------------------

				Rank rank = new Rank();
				rank.setCorrespondingCards(fiveCards);
				rank.setRank(2);
				rank.setPlayerName(player.getName());
				ranks.add(rank);			
				
			}
			else{
			//-----------------------Rank 1 - High Card Scenario-------------------------------------------------

				Rank rank = new Rank();
				rank.setCorrespondingCards(fiveCards);
				rank.setRank(1);
				rank.setPlayerName(player.getName());
				ranks.add(rank);			
				
			}
			
		}
		
		player.setRanks(ranks);	
	}
	
	private static Rank furtherChecksOntheWinningRank(Rank rank1, Rank rank2, int equalizer){
		Rank finalRank = null;
		List<Card> cards1 = rank1.getCorrespondingCards();
		List<Card> cards2 = rank2.getCorrespondingCards();
		
		if(equalizer==1 || equalizer==5 || equalizer == 6){
			cards1.sort((Card c1, Card c2) -> c2.getNumber() - c1.getNumber());
			cards2.sort((Card c1, Card c2) -> c2.getNumber() - c1.getNumber());
			Iterator<Card> iter1 = cards1.iterator();
			Iterator<Card> iter2 = cards2.iterator();
			while(iter1.hasNext() && iter2.hasNext()){
				Card card1 = iter1.next();
				Card card2 = iter2.next();
				if(card1.getNumber()>card2.getNumber()){
					return rank1;
				}
				else if(card1.getNumber()<card2.getNumber()){
					return rank2;
				}
				
			}
		}
		else if(equalizer==2){
			List<Integer> numberList1 = new ArrayList<Integer>();
			List<Integer> numberList2 = new ArrayList<Integer>();
			for(Card card: cards1){
				//----Similarly, Take all the card numbers into a set, that will eliminate all duplicates, 
				//----resulting to finding that all cards have unique number
				numberList1.add(card.getNumber());
			}
			for(Card card: cards2){
				//----Similarly, Take all the card numbers into a set, that will eliminate all duplicates, 
				//----resulting to finding that all cards have unique number
				numberList2.add(card.getNumber());
			}
			
			LinkedHashSet<Integer> pairSet1 = numberList1.stream().filter(i -> Collections.frequency(numberList1, i) == 2)
					.collect(Collectors.toCollection(LinkedHashSet::new));
			
			LinkedHashSet<Integer> pairSet2 = numberList2.stream().filter(i -> Collections.frequency(numberList2, i) == 2)
					.collect(Collectors.toCollection(LinkedHashSet::new));
			
			
			if(pairSet1.iterator().next()>pairSet2.iterator().next()){
				return rank1;
			}
			else if(pairSet1.iterator().next()<pairSet2.iterator().next()){
				return rank2;
			}
			else{
				numberList1.remove(pairSet1.iterator().next());
				numberList1.sort((a,b) -> b - a);
				numberList2.remove(pairSet2.iterator().next());
				numberList2.sort((a,b) -> b - a);
				while(numberList1.iterator().hasNext() && numberList2.iterator().hasNext()){
					if(numberList1.iterator().next()>numberList2.iterator().next()){
						return rank1;
					}
					else if(numberList1.iterator().next()<numberList2.iterator().next()){
						return rank2;
					}
				}
			}

		}
		else if(equalizer==3){
			List<Integer> numberList1 = new ArrayList<Integer>();
			List<Integer> numberList2 = new ArrayList<Integer>();
			for(Card card: cards1){
				//----Similarly, Take all the card numbers into a set, that will eliminate all duplicates, 
				//----resulting to finding that all cards have unique number
				numberList1.add(card.getNumber());
			}
			for(Card card: cards2){
				//----Similarly, Take all the card numbers into a set, that will eliminate all duplicates, 
				//----resulting to finding that all cards have unique number
				numberList2.add(card.getNumber());
			}
			
			LinkedHashSet<Integer> pairSet1 = numberList1.stream().filter(i -> Collections.frequency(numberList1, i) == 2)
					.collect(Collectors.toCollection(LinkedHashSet::new));
			
			LinkedHashSet<Integer> pairSet2 = numberList2.stream().filter(i -> Collections.frequency(numberList2, i) == 2)
					.collect(Collectors.toCollection(LinkedHashSet::new));
			
			
			while(pairSet1.iterator().hasNext() && pairSet2.iterator().hasNext()){
				if(pairSet1.iterator().next()>pairSet2.iterator().next()){
					return rank1;
				}
				else if(pairSet1.iterator().next()<pairSet2.iterator().next()){
					return rank2;
				}				
			}
			while(pairSet1.iterator().hasNext() && pairSet2.iterator().hasNext()){
				numberList1.remove(pairSet1.iterator().next());
				numberList2.remove(pairSet2.iterator().next());
			}
			
			numberList1.sort((a,b) -> b - a);
			
			numberList2.sort((a,b) -> b - a);
			while(numberList1.iterator().hasNext() && numberList2.iterator().hasNext()){
				if(numberList1.iterator().next()>numberList2.iterator().next()){
					return rank1;
				}
				else if(numberList1.iterator().next()<numberList2.iterator().next()){
					return rank2;
				}
			}
		}
		else if(equalizer==4){
			List<Integer> numberList1 = new ArrayList<Integer>();
			List<Integer> numberList2 = new ArrayList<Integer>();
			for(Card card: cards1){
				//----Similarly, Take all the card numbers into a set, that will eliminate all duplicates, 
				//----resulting to finding that all cards have unique number
				numberList1.add(card.getNumber());
			}
			for(Card card: cards2){
				//----Similarly, Take all the card numbers into a set, that will eliminate all duplicates, 
				//----resulting to finding that all cards have unique number
				numberList2.add(card.getNumber());
			}
			
			LinkedHashSet<Integer> pairSet1 = numberList1.stream().filter(i -> Collections.frequency(numberList1, i) == 3)
					.collect(Collectors.toCollection(LinkedHashSet::new));
			
			LinkedHashSet<Integer> pairSet2 = numberList2.stream().filter(i -> Collections.frequency(numberList2, i) == 3)
					.collect(Collectors.toCollection(LinkedHashSet::new));
			
			
			if(pairSet1.iterator().next()>pairSet2.iterator().next()){
				return rank1;
			}
			else if(pairSet1.iterator().next()<pairSet2.iterator().next()){
				return rank2;
			}
			else{
				numberList1.remove(pairSet1.iterator().next());
				numberList1.sort((a,b) -> b - a);
				numberList2.remove(pairSet2.iterator().next());
				numberList2.sort((a,b) -> b - a);
				while(numberList1.iterator().hasNext() && numberList2.iterator().hasNext()){
					if(numberList1.iterator().next()>numberList2.iterator().next()){
						return rank1;
					}
					else if(numberList1.iterator().next()<numberList2.iterator().next()){
						return rank2;
					}
				}
			}
			
		}
		
		return finalRank;
	}
}
