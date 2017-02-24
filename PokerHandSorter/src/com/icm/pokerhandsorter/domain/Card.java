/**
 * 
 */
package com.icm.pokerhandsorter.domain;

/**
 * @author VDRKumar
 *
 */
public class Card {
	
	int number;	
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	String suite;
	
	/**
	 * @return the suite
	 */
	public String getSuite() {
		return suite;
	}
	/**
	 * @param suite the suite to set
	 */
	public void setSuite(String suite) {
		this.suite = suite;
	}
	
	public String toString(){
		return this.getNumber()+this.getSuite();		
	}
	

}
