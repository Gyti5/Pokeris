package combinations;

import java.util.ArrayList;

public class CheckRoyalFlush {
	public ArrayList<String> hand;
	
	public CheckRoyalFlush(ArrayList<String> hand) {
		this.hand = hand;
	}
	
	public String check() {
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
		
		return "";
	}
}
