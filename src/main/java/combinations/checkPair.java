package combinations;

import java.util.ArrayList;

public class checkPair {
	public ArrayList<String> hand;
	
	public checkPair(ArrayList<String> hand) {
		this.hand = hand;
	}
	
	public String check() {
		int sameCount = 1;
		char lastChar = ' ';
		char card = ' ';
		for(String a : hand) {
			if (a.charAt(0) == lastChar) {
				sameCount++; 
				card = a.charAt(0);
			}
			else lastChar = a.charAt(0);
			if (sameCount == 2) 
				       return 292+String.valueOf(card); 
		}
				
		return "";
	}
}
