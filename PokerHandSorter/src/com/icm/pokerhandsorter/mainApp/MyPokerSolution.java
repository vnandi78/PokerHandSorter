package com.icm.pokerhandsorter.mainApp;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import com.icm.pokerhandsorter.cards.Card;
import com.icm.pokerhandsorter.players.Player;
import com.icm.pokerhandsorter.winner.DetermineBestHand;

public class MyPokerSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// input expected =  AH 9S 4D TD 8S 4H JS 3C TC 8D
				
		Scanner scanner = new Scanner(System.in);
		
		Player player1 = new Player();
		player1.setName("Player1");
		
		Player player2 = new Player();
		player2.setName("Player2");
		
		ArrayList<Card> player1cards = new ArrayList<Card>();
		ArrayList<Card> player2cards = new ArrayList<Card>();
		
		while(scanner.hasNextLine()){
			String line = scanner.nextLine().trim();
			String[] inputArray = line.split("\\s");
			System.out.println("inputArray = " + inputArray);
			
			int i=0;
			
			for(String input: inputArray){
				Card card = new Card();
				card.setNumber(input.substring(0,1));
				card.setSuite(input.substring(1));
		
				if(i<5){
					player1cards.add(card);
				}
				else if(i>4 && i<10){
					player2cards.add(card);					
				}
				else{
					i = 0;
				}
			
				i++;
			}
		}

		player1.setCards(player1cards);
		player2.setCards(player2cards);
		
		//------------------------------------Determine the best hand and get their scores-------------------
		
		Map<Player, Integer> mapOfResults = DetermineBestHand.findWinnerAndIncrementScore(player1, player2);
		
		scanner.close();

	}

}
