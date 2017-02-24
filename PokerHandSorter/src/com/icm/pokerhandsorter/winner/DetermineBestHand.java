/**
 * 
 */
package com.icm.pokerhandsorter.winner;

import java.util.Arrays;
import java.util.Iterator;
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
			System.out.println("SAFE TO PROCEED..............FURTHER on RANK COMPARISON");
			while(iter1.hasNext() && iter2.hasNext()){
				Rank rank1 = iter1.next();
				Rank rank2 = iter2.next();
				
				if(rank1.getRank()>rank2.getRank()){
					player1WinningCount++;
					System.out.println("player1WinningCount = " + player1WinningCount);
				}
				else if(rank1.getRank()<rank2.getRank()){
					player2WinningCount++;
					System.out.println("player2WinningCount = " + player2WinningCount);
				}
				else{
					couldNotDeterWinner++;
					System.out.println("both players have same ranks, player1-rank:" + rank1.getRank() + "; player2-rank:"+ rank2.getRank());
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


			RoyalFlushCriterion royalFlushCriterion = new RoyalFlushCriterion();
			StraightFlushCriterion straightFlushCriterion = new StraightFlushCriterion();
			FourOfAKindCriterion fourOfAKindCriterion = new FourOfAKindCriterion();
			FullHouseCriterion fullHouseCriterion = new FullHouseCriterion();
			FlushCriterion flushCriterion = new FlushCriterion();
			StraightCriterion straightCriterion = new StraightCriterion();
			ThreeOfAKindCriterion threeOfAKindCriterion = new ThreeOfAKindCriterion();
			TwoPairsCriterion twoPairsCriterion = new TwoPairsCriterion();
			PairCriterion pairCriterion = new PairCriterion();
//			HighCardCriterion highCardCriterion = new HighCardCriterion();


			if(royalFlushCriterion.matches(fiveCards)){
			//-----------------------Rank 10 - Royal Flush Scenario-------------------------------------------------

				Rank rank = new Rank();
				rank.setCorrespondingCards(fiveCards);
				rank.setRank(10);
				rank.setPlayerName(player.getName());
				ranks.add(rank);			
			}
			else if(straightFlushCriterion.matches(fiveCards)){
			//-----------------------Rank 9 - Straight flush Scenario-------------------------------------------------

				Rank rank = new Rank();
				rank.setCorrespondingCards(fiveCards);
				rank.setRank(9);
				rank.setPlayerName(player.getName());
				ranks.add(rank);			
				
			}
			else if(fourOfAKindCriterion.matches(fiveCards)){
			//-----------------------Rank 8 - Four of a kind Scenario-------------------------------------------------

				Rank rank = new Rank();
				rank.setCorrespondingCards(fiveCards);
				rank.setRank(8);
				rank.setPlayerName(player.getName());
				ranks.add(rank);			
				
			}
			else if(fullHouseCriterion.matches(fiveCards)){
			//-----------------------Rank 7 - Full House Scenario-------------------------------------------------

				Rank rank = new Rank();
				rank.setCorrespondingCards(fiveCards);
				rank.setRank(7);
				rank.setPlayerName(player.getName());
				ranks.add(rank);			
				
			}
			else if(flushCriterion.matches(fiveCards)){
			//-----------------------Rank 6 - Flush Scenario-------------------------------------------------

				Rank rank = new Rank();
				rank.setCorrespondingCards(fiveCards);
				rank.setRank(6);
				rank.setPlayerName(player.getName());
				ranks.add(rank);			
				
			}
			else if(straightCriterion.matches(fiveCards)){
			//-----------------------Rank 5 - Straight Scenario-------------------------------------------------

				Rank rank = new Rank();
				rank.setCorrespondingCards(fiveCards);
				rank.setRank(5);
				rank.setPlayerName(player.getName());
				ranks.add(rank);			
				
			}
			else if(threeOfAKindCriterion.matches(fiveCards)){
			//-----------------------Rank 4 - Three of a Kind Scenario-------------------------------------------------

				Rank rank = new Rank();
				rank.setCorrespondingCards(fiveCards);
				rank.setRank(4);
				rank.setPlayerName(player.getName());
				ranks.add(rank);			
				
			}
			else if(twoPairsCriterion.matches(fiveCards)){
			//-----------------------Rank 3 - Two Pairs Scenario-------------------------------------------------		

				Rank rank = new Rank();
				rank.setCorrespondingCards(fiveCards);
				rank.setRank(3);
				rank.setPlayerName(player.getName());
				ranks.add(rank);			
				
			}
			else if(pairCriterion.matches(fiveCards)){
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
}
