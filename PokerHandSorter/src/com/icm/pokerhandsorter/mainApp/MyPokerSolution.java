package com.icm.pokerhandsorter.mainApp;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import com.icm.pokerhandsorter.domain.Card;
import com.icm.pokerhandsorter.domain.Player;
import com.icm.pokerhandsorter.winner.DetermineBestHand;

public class MyPokerSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// input expected =  AH 9S 4D TD 8S 4H JS 3C TC 8D
				
		Scanner scanner = new Scanner(System.in);
		
		//---Build Player 1
		Player player1 = new Player();
		player1.setName("Player1");
		
		//---Build Player 2
		Player player2 = new Player();
		player2.setName("Player2");
		
		//---Init Cards for Player 1
		ArrayList<Card[]> player1cards = new ArrayList<Card[]>();

		//---Init Cards for Player 2
		ArrayList<Card[]> player2cards = new ArrayList<Card[]>();
		
		int k=1;
		//--Reading input from command line
		while(scanner.hasNextLine()){
			//--Reading each line
			String line = scanner.nextLine();
			
			//--Split each line by space to collect each card information
			String[] inputArray = line.split("\\s");
			
			int i=0;
			int j=0;
			Card[] cards1 = new Card[5];
			Card[] cards2 = new Card[5];
			
			for(String input: inputArray){
				//----build card with the given information
				Card card = new Card();
				//---Assign card the given number
				String number = input.substring(0,1);
				if(number.equalsIgnoreCase("A")){
					number = "14";					
				}
				if(number.equalsIgnoreCase("K")){
					number = "13";
				}
				if(number.equalsIgnoreCase("Q")){
					number = "12";
				}
				if(number.equalsIgnoreCase("J")){
					number = "11";
				}
				if(number.equalsIgnoreCase("T")){
					number = "10";
				}
				
				card.setNumber(Integer.parseInt(number));
				//---Assign card the given suite
				card.setSuite(input.substring(1));
		
				if(i<5){
					//--First 5 cards always belong to Player 1
					cards1[i] = card;
					if(i==4){
						player1cards.add(cards1);
					}
				}
				else if(i>4 && i<10){
					//--Next 5 cards always belong to Player 2
					cards2[j] = card;
					if(i==9){
						player2cards.add(cards2);
						j=0;
					}
					j++;					
				}
				else{
					i = 0;
				}
			
				i++;
			}
			k++;
		}
		//----Assign the complete set of cards for Player 1 from the given input
		player1.setCards(player1cards);
		//----Assign the complete set of cards for Player 2 from the given input
		player2.setCards(player2cards);
		
		//------------------------------------Determine the best hand and get their scores-------------------
		
		Map<Player, Integer> mapOfResults = DetermineBestHand.findWinnerAndIncrementScore(player1, player2);
		
		scanner.close();

	}

}
