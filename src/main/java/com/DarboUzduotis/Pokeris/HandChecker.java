package com.DarboUzduotis.Pokeris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class HandChecker {
	private String hands;
	private String[] p1Hand, p2Hand;

	private int winner;
	
	public HandChecker(String hands) {
		this.hands = hands;
		seperate(this.hands);
		this.winner=whoWon(checkHand(this.p1Hand), checkHand(this.p2Hand));
	}
	private void seperate(String hands) {
		
		String[] cards = hands.split(" ");
		this.p1Hand = Arrays.copyOf(cards, 5);
		this.p2Hand = Arrays.copyOfRange(cards, 5, 10);
	}
	
	public int whoWon(String p1, String p2) {
		int p1Score, p2Score;
		char p1HighCard, p2HighCard;
		
		p1Score = Integer.parseInt(p1.substring(0,3));
		p2Score = Integer.parseInt(p2.substring(0,3));
		
		p1HighCard = p1.substring(3,4).charAt(0);
		p2HighCard = p2.substring(3,4).charAt(0);

		if(p1Score > p2Score) return 1;
		if(p1Score < p2Score) return 2;
		if(p1Score == p2Score) {
			if(p2HighCard > p1HighCard) return 1;
			if(p1HighCard < p2HighCard) return 2;
		}
		return 0;
	}
	
	public int getWinner() {
		return winner;
	}
	
	private String checkHand(String[] handArray) {
		
		ArrayList<String> hand = new ArrayList<String>();
		hand.clear();
		
		for(String a : handArray) {
			hand.add(a);
		}
		
		Collections.sort(hand);
			
		//royalflush
		if(hand.get(0).charAt(0) == 'a' 
				   && hand.get(1).charAt(0) == 'b' 
				   && hand.get(2).charAt(0) == 'c' 
				   && hand.get(3).charAt(0) == 'd' 
				   && hand.get(4).charAt(0) == 'e'
				&& (
				   hand.get(0).charAt(1) == hand.get(1).charAt(1) 
				   && hand.get(1).charAt(1) == hand.get(2).charAt(1) 
				   && hand.get(2).charAt(1) == hand.get(3).charAt(1) 
				   && hand.get(3).charAt(1) == hand.get(4).charAt(1) 
				))     return 300+"a";
		
		//straightflush
		if(hand.get(0).charAt(0) == (char)(hand.get(1).charAt(0)-1) 
				   && hand.get(0).charAt(0) == (char)(hand.get(2).charAt(0)-2) 
				   && hand.get(0).charAt(0) == (char)(hand.get(3).charAt(0)-3) 
				   && hand.get(0).charAt(0) == (char)(hand.get(4).charAt(0)-4)
				&& (
				   hand.get(0).charAt(1) == hand.get(1).charAt(1) 
				   && hand.get(1).charAt(1) == hand.get(2).charAt(1) 
				   && hand.get(2).charAt(1) == hand.get(3).charAt(1) 
				   && hand.get(3).charAt(1) == hand.get(4).charAt(1) 
				))     return 299+String.valueOf(hand.get(0).charAt(0));
		
		//fourofakind
		int sameCount = 1;
		char lastChar = ' ';
		char card = ' ';
		for(String a : hand) {
			if (a.charAt(0) == lastChar && (card == a.charAt(0) || card == ' ')) {
				sameCount++; 
				card = a.charAt(0);
			}
			else lastChar = a.charAt(0);
			if (sameCount == 4) 
				       return 298+String.valueOf(card);     
		}
		
		//fullHouse
		sameCount = 1;
		lastChar = ' ';
		for(String a : hand) {
			if(a.charAt(0) != lastChar) sameCount = 1;

			if (a.charAt(0) == lastChar) {
				sameCount++; 
			}
			else lastChar = a.charAt(0);
			if (sameCount == 3) {
				sameCount = 1;
				lastChar = ' ';
				card = a.charAt(0);
				for(String b : hand) {
					if (b.charAt(0) == lastChar && b.charAt(0)!=a.charAt(0)) {
						sameCount++; 
					}
					else lastChar = b.charAt(0);
					if (sameCount == 2) {
					   return 297+String.valueOf(card); 
					}
				}
			}
		}
		
		//Flush
		if(hand.get(0).charAt(1) == hand.get(1).charAt(1) 
				   && hand.get(1).charAt(1) == hand.get(2).charAt(1) 
				   && hand.get(2).charAt(1) == hand.get(3).charAt(1) 
				   && hand.get(3).charAt(1) == hand.get(4).charAt(1) 
		           )            
					   return 296+String.valueOf(hand.get(0).charAt(0));
		
		//straight
		if(hand.get(0).charAt(0) == (char)(hand.get(1).charAt(0)-1) 
				   && hand.get(0).charAt(0) == (char)(hand.get(2).charAt(0)-2) 
				   && hand.get(0).charAt(0) == (char)(hand.get(3).charAt(0)-3) 
				   && hand.get(0).charAt(0) == (char)(hand.get(4).charAt(0)-4)
				   )
		               return 295+String.valueOf(hand.get(0).charAt(0));
		
		//threeofakind
		sameCount = 1;
		lastChar = ' ';
		for(String a : hand) {
			if (a.charAt(0) == lastChar) {
				sameCount++; 
				card = a.charAt(0);
			}
			else {
				lastChar = a.charAt(0);
				sameCount = 1;
				}
			if (sameCount == 3) 
				       return 294+String.valueOf(card); 
		}
		
		//twopairs
		sameCount = 1;
		lastChar = ' ';
		char firstPairChar = ' ';
		ArrayList<String> tmpHand = new ArrayList<String>();
		tmpHand.addAll(hand);
		for(int a = 0; a < tmpHand.size(); a++) {
			if (tmpHand.get(a).charAt(0) == lastChar) {
				sameCount++; 
				firstPairChar = lastChar;
				card = tmpHand.get(a).charAt(0);
				tmpHand.remove(a);
			}
			else lastChar = tmpHand.get(a).charAt(0);
			if (sameCount == 2) {
				sameCount = 1;
				lastChar = ' ';
				for(String b : tmpHand) {
					if ((b.charAt(0) == lastChar)&&b.charAt(0)!=firstPairChar) {
						sameCount++;
					} 
					else lastChar = b.charAt(0);
					if (sameCount == 2) 
					   return 293+String.valueOf(card); 
				}
			}
		}
		
		//pair
		sameCount = 1;
		lastChar = ' ';
		for(String a : hand) {
			if (a.charAt(0) == lastChar) {
				sameCount++; 
				card = a.charAt(0);
			}
			else lastChar = a.charAt(0);
			if (sameCount == 2) 
				       return 292+String.valueOf(card); 
		}
			
					   return 300-hand.get(0).charAt(0)+String.valueOf(hand.get(0).charAt(0));
	}
}
