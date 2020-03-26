package combinations;

import java.util.ArrayList;

public class checkTwoPairs {
	public ArrayList<String> hand;
	
	public checkTwoPairs(ArrayList<String> hand) {
		this.hand = hand;
	}
	
	public String check() {
		int sameCount = 1;
		char lastChar = ' ';
		char firstPairChar = ' ';
		char card = ' ';
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
		
		return "";
	}
}
