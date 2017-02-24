/**
 * 
 */
package com.icm.pokerhandsorter.junit.testcase.winner.criterion;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.icm.pokerhandsorter.domain.Card;
import com.icm.pokerhandsorter.winner.criterion.StraightFlushCriterion;

/**
 * @author VDRKumar
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StraightFlushCriterionTest {

	@Test
	public void testIsStraightFlushSuccess() {
		List<Card> successCards = new LinkedList<Card>();
	
		Card card1 = new Card();
		card1.setNumber(9);
		card1.setSuite("C");
		
		Card card2 = new Card();
		card2.setNumber(13);
		card2.setSuite("C");

		Card card3 = new Card();
		card3.setNumber(12);
		card3.setSuite("C");

		Card card4 = new Card();
		card4.setNumber(11);
		card4.setSuite("C");

		Card card5 = new Card();
		card5.setNumber(10);
		card5.setSuite("C");
		
		successCards.add(card1);
		successCards.add(card2);
		successCards.add(card3);
		successCards.add(card4);
		successCards.add(card5);
		
		StraightFlushCriterion straightFlushCrit = new StraightFlushCriterion();
		assertEquals("StraightFlushCriterion Met : ", true, straightFlushCrit.matches(successCards));
		
	}
	
	@Test
	public void testIsStraightFlushFailure() {
		
		List<Card> failureCards = new LinkedList<Card>();
		
		Card card1 = new Card();
		Card card2 = new Card();
		Card card3 = new Card();
		Card card4 = new Card();
		Card card5 = new Card();

		card1.setNumber(14);
		card1.setSuite("C");
		
		card2.setNumber(13);
		card2.setSuite("C");

		card3.setNumber(12);
		card3.setSuite("C");

		card4.setNumber(11);
		card4.setSuite("C");

		card5.setNumber(6);
		card5.setSuite("C");
		
		failureCards.add(card1);
		failureCards.add(card2);
		failureCards.add(card3);
		failureCards.add(card4);
		failureCards.add(card5);
		
		StraightFlushCriterion straightFlushCrit = new StraightFlushCriterion();
		assertEquals("StraightFlushCriterion Not Met : ", false, straightFlushCrit.matches(failureCards));
		
	}

}
