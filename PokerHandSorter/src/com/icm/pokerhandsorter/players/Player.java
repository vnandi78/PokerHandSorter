/**
 * 
 */
package com.icm.pokerhandsorter.players;

import java.util.List;

import com.icm.pokerhandsorter.cards.Card;

/**
 * @author VDRKumar
 *
 */
public class Player {
	
	String name;
	List<Card> cards;
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
	public List<Card> getCards() {
		return cards;
	}
	/**
	 * @param cards the cards to set
	 */
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

}
