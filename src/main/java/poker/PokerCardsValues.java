package poker;

import java.util.HashMap;

public class PokerCardsValues {

	private static final HashMap<String, Integer> CARDS_VALUES = new HashMap<String, Integer>();

	public static HashMap<String, Integer> getCardsValues() {
		return CARDS_VALUES;
	}

	public static void initializePokerCardsValues() {
		CARDS_VALUES.put("??", 1);
		CARDS_VALUES.put("?", 1);
		CARDS_VALUES.put("2", 2);
		CARDS_VALUES.put("3", 3);
		CARDS_VALUES.put("4", 4);
		CARDS_VALUES.put("5", 5);
		CARDS_VALUES.put("6", 6);
		CARDS_VALUES.put("7", 7);
		CARDS_VALUES.put("8", 8);
		CARDS_VALUES.put("9", 9);
		CARDS_VALUES.put("10", 10);
		CARDS_VALUES.put("j", 11);
		CARDS_VALUES.put("q", 12);
		CARDS_VALUES.put("k", 13);
		CARDS_VALUES.put("a", 14);
		System.out.println("size of map: " +CARDS_VALUES.size());
	}
}
