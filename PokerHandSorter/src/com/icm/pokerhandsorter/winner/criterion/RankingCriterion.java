/**
 * 
 */
package com.icm.pokerhandsorter.winner.criterion;

import com.icm.pokerhandsorter.domain.Player;

/**
 * @author VDRKumar
 *
 */
public interface RankingCriterion {
	
	public void assignRanks(Player player);

}
