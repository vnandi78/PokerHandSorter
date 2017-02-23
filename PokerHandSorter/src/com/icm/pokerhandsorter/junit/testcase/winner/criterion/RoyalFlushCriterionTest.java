/**
 * 
 */
package com.icm.pokerhandsorter.junit.testcase.winner.criterion;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.icm.pokerhandsorter.domain.Card;
import com.icm.pokerhandsorter.winner.criterion.RoyalFlushCriterion;

/**
 * @author VDRKumar
 *
 */
public class RoyalFlushCriterionTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRoyalFlushCriterion() {
		List<Card> successCards = new LinkedList<Card>();
		List<Card> failureCards = new LinkedList<Card>();
		
		Card card1 = new Card();
		card1.setNumber("A");
		card1.setSuite("C");
		
		Card card2 = new Card();
		card2.setNumber("K");
		card2.setSuite("C");

		Card card3 = new Card();
		card3.setNumber("Q");
		card3.setSuite("C");

		Card card4 = new Card();
		card4.setNumber("J");
		card4.setSuite("C");

		Card card5 = new Card();
		card5.setNumber("10");
		card5.setSuite("C");
		
		successCards.add(card1);
		successCards.add(card2);
		successCards.add(card3);
		successCards.add(card4);
		successCards.add(card5);
		
		RoyalFlushCriterion royalFlushCrit = new RoyalFlushCriterion();
		assertEquals("RoyalFlushCriterion Met : ", true, royalFlushCrit.isItRoyalFlushScenario(successCards));
		
		card1.setNumber("A");
		card1.setSuite("C");
		
		card2.setNumber("K");
		card2.setSuite("C");

		card3.setNumber("Q");
		card3.setSuite("C");

		card4.setNumber("J");
		card4.setSuite("C");

		card5.setNumber("6");
		card5.setSuite("C");
		
		failureCards.add(card1);
		failureCards.add(card2);
		failureCards.add(card3);
		failureCards.add(card4);
		failureCards.add(card5);
		
		assertEquals("RoyalFlushCriterion Met : ", false, royalFlushCrit.isItRoyalFlushScenario(failureCards));
		
	}

}
