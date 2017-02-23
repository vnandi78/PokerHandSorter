/**
 * 
 */
package com.icm.pokerhandsorter.domain;

/**
 * @author VDRKumar
 *
 */
public class Card {
	
	String number;	
	String suite;
	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
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
