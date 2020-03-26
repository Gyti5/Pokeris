package combinations;

import java.util.ArrayList;

public class CheckFlush {
	public ArrayList<String> hand;
	
	public CheckFlush(ArrayList<String> hand) {
		this.hand = hand;
	}
	
	public String check() {
		if(hand.get(0).charAt(1) == hand.get(1).charAt(1) 
				   && hand.get(1).charAt(1) == hand.get(2).charAt(1) 
				   && hand.get(2).charAt(1) == hand.get(3).charAt(1) 
				   && hand.get(3).charAt(1) == hand.get(4).charAt(1) 
		           )            
					   return 296+String.valueOf(hand.get(0).charAt(0));
		
		return "";
	}
}
