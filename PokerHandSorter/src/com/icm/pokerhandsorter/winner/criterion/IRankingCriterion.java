/**
 * 
 */
package com.icm.pokerhandsorter.winner.criterion;

import java.util.List;

import com.icm.pokerhandsorter.domain.Card;

/**
 * @author VDRKumar
 *
 */
public interface IRankingCriterion {
	
	public static boolean matches(List<Card> playerCards){
		return true;
	}

}
