package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import combinations.*;


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
			
		checkRoyalFlush checkRoyalFlush = new checkRoyalFlush(hand);
		checkStraightFlush checkStraightFlush = new checkStraightFlush(hand);
		checkFourOfAKind checkFourOfAKind = new checkFourOfAKind(hand);
		checkFullHouse checkFullHouse = new checkFullHouse(hand);
		checkFlush checkFlush = new checkFlush(hand);
		checkStraight checkStraight = new checkStraight(hand);
		checkThreeOfAKind checkThreeOfAKind = new checkThreeOfAKind(hand);
		checkTwoPairs checkTwoPairs = new checkTwoPairs(hand);
		checkPair checkPair = new checkPair(hand);

		if(!checkRoyalFlush.check().equals("")) {return checkRoyalFlush.check();}
		if(!checkStraightFlush.check().equals("")) {return checkStraightFlush.check();}
		if(!checkFourOfAKind.check().equals("")) {return checkFourOfAKind.check();}
		if(!checkFullHouse.check().equals("")) {return checkFullHouse.check();}
		if(!checkFlush.check().equals("")) {return checkFlush.check();}
		if(!checkStraight.check().equals("")) {return checkStraight.check();}
		if(!checkThreeOfAKind.check().equals("")) {return checkThreeOfAKind.check();}
		if(!checkTwoPairs.check().equals("")) {return checkTwoPairs.check();}
		if(!checkPair.check().equals("")) {return checkPair.check();}

		return 300-hand.get(0).charAt(0)+String.valueOf(hand.get(0).charAt(0));
	}
}
