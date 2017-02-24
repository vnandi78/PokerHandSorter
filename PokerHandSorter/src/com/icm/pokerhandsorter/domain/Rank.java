/**
 * 
 */
package com.icm.pokerhandsorter.domain;

import java.util.List;

/**
 * @author VDRKumar
 *
 */
public class Rank {

	int rank;
	List<Card> correspondingCards;
	String playerName;
	/**
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}
	/**
	 * @param rank the rank to set
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}
	/**
	 * @return the correspondingCards
	 */
	public List<Card> getCorrespondingCards() {
		return correspondingCards;
	}
	/**
	 * @param correspondingCards the correspondingCards to set
	 */
	public void setCorrespondingCards(List<Card> correspondingCards) {
		this.correspondingCards = correspondingCards;
	}
	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}
	/**
	 * @param playerName the playerName to set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public String toString(){
		return this.playerName + "; rank = " + this.getRank()  + " ; corresponding cards : " + this.getCorrespondingCards().toString();
	}
}
