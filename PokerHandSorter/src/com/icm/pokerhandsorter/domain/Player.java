/**
 * 
 */
package com.icm.pokerhandsorter.domain;

import java.util.LinkedList;
import java.util.List;

/**
 * @author VDRKumar
 *
 */
public class Player {
	
	String name;
	List<Card[]> cards;
	List<Rank> ranks;
	
	public Player(){
		ranks = new LinkedList<Rank>();
	}
	
	/**
	 * @return the ranks
	 */
	public List<Rank> getRanks() {
		return ranks;
	}
	/**
	 * @param ranks the ranks to set
	 */
	public void setRanks(List<Rank> ranks) {
		this.ranks = ranks;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the cards
	 */
	public List<Card[]> getCards() {
		return cards;
	}
	/**
	 * @param cards the cards to set
	 */
	public void setCards(List<Card[]> cards) {
		this.cards = cards;
	}
	
	public String toString(){
		return this.getName() + "; " + this.getCards().toString();
		
	}

}
