package main;
/*
 *reformatuotas kortu rankoje sarasas, tam kad butu galima paprasciau isrikiuoti.
 *dauguma pokerio kombinaciju pasimato isrikiavus kortas didejimo tvarka, todel kombinacijos
 *susidaro is gretimu kortu, taip tampa paprasciau aptikti koki stipriausia derini
 *zmogus turi rankoje.
 */
public class ReformatHand {
	private String hand;
	
	public ReformatHand(String hand) {
		this.hand = hand;
	}
	
	public String getReformatedHand(){
		hand = hand.replace('2', 'm');
		hand = hand.replace('3', 'l');
		hand = hand.replace('4', 'k');
		hand = hand.replace('5', 'j');
		hand = hand.replace('6', 'i');
		hand = hand.replace('7', 'h');
		hand = hand.replace('8', 'g');
		hand = hand.replace('9', 'f');
		hand = hand.replace('T', 'e');
		hand = hand.replace('J', 'd');
		hand = hand.replace('Q', 'c');
		hand = hand.replace('K', 'b');
		hand = hand.replace('A', 'a');
		
		return hand;
	}
}