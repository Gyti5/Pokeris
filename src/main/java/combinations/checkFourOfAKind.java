package combinations;

import java.util.ArrayList;

public class checkFourOfAKind {
	public ArrayList<String> hand;
	
	public checkFourOfAKind(ArrayList<String> hand) {
		this.hand = hand;
	}
	
	public String check() {
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
		
		return "";
	}
}
