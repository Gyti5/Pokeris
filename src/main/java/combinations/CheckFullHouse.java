package combinations;

import java.util.ArrayList;

public class CheckFullHouse {
	public ArrayList<String> hand;
	
	public CheckFullHouse(ArrayList<String> hand) {
		this.hand = hand;
	}
	
	public String check() {
		int sameCount = 1;
		char lastChar = ' ';
		char card = ' ';
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
		
		return "";
	}
}
