package combinations;

import java.util.ArrayList;

public class CheckStraight {
	public ArrayList<String> hand;
	
	public CheckStraight(ArrayList<String> hand) {
		this.hand = hand;
	}
	
	public String check() {
		if(hand.get(0).charAt(0) == (char)(hand.get(1).charAt(0)-1) 
				   && hand.get(0).charAt(0) == (char)(hand.get(2).charAt(0)-2) 
				   && hand.get(0).charAt(0) == (char)(hand.get(3).charAt(0)-3) 
				   && hand.get(0).charAt(0) == (char)(hand.get(4).charAt(0)-4)
				   )
		               return 295+String.valueOf(hand.get(0).charAt(0));
		
		return "";
	}
}
