package combinations;

import java.util.ArrayList;

public class CheckThreeOfAKind {
	public ArrayList<String> hand;
	
	public CheckThreeOfAKind(ArrayList<String> hand) {
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
			else {
				lastChar = a.charAt(0);
				sameCount = 1;
				}
			if (sameCount == 3) 
				       return 294+String.valueOf(card); 
		}
		
		return "";
	}
}
