package poker;

public class BlackRainStartingHands {

	private static final String[] UTG_SUITED = { "ak", "aq", "aj", "at", "a9", "kq", "kj", "qj" };
	private static final String[] UTG_OFFSUITED = { "ak", "aq", "aj", "kq" };

	private static final String[] HJ_SUITED = { "ak", "aq", "aj", "at", "a9", "a8", "a7", "a6", "a5", "kq", "kj", "qj",
			"k10", "qj", "q10", "j10", "109", "98", "87" };
	private static final String[] HJ_OFFSUITED = { "ak", "aq", "aj", "kq", "kj", "qj" };

	private static final String[] CO_SUITED = { "ak", "aq", "aj", "at", "a9", "a8", "a7", "a6", "a5", "a4", "a3", "a2",
			"kq", "kj", "qj", "k10", "k9", "k8", "k7", "qj", "q10", "q9", "q8", "j10", "j9", "j8", "109", "108", "98",
			"97", "87", "76", "65" };
	private static final String[] CO_OFFSUITED = { "ak", "aq", "aj", "a10", "a9", "a8", "a7", "kq", "kj", "k10", "k9",
			"qj", "q10", "j10" };

	private static final String[] BTN_SUITED = { "ak", "aq", "aj", "at", "a9", "a8", "a7", "a6", "a5", "a4", "a3", "a2",
			"kq", "kj", "qj", "k10", "k9", "k8", "k7", "k6", "k5", "qj", "q10", "q9", "q8", "q7", "j10", "j9", "j8",
			"j7", "109", "108", "107", "98", "97", "87", "86", "76", "75", "65", "54" };
	private static final String[] BTN_OFFSUITED = { "ak", "aq", "aj", "a10", "a9", "a8", "a7", "a6", "a5", "a4", "a3",
			"a2", "kq", "kj", "k10", "k9", "k8", "k7", "qj", "q10", "q9", "j10", "j9", "109", "98", "87" };

	private static final String[] SB_SUITED = { "ak", "aq", "aj", "ay", "a9", "a8", "a7", "a6", "kq", "kj", "k10", "k9",
			"qj", "q10", "q9", "j10", "j9", "j8", "t9", "98", "87", "76" };
	private static final String[] SB_OFFSUITED = { "ak", "aq", "aj", "a10", "kq", "kj", "k10", "k9", "qj", "q10", "q9",
			"j10", "j9" };

	public static String[] getUtgSuited() {
		return UTG_SUITED;
	}

	public static String[] getUtgOffsuited() {
		return UTG_OFFSUITED;
	}

	public static String[] getHjSuited() {
		return HJ_SUITED;
	}

	public static String[] getHjOffsuited() {
		return HJ_OFFSUITED;
	}

	public static String[] getCoSuited() {
		return CO_SUITED;
	}

	public static String[] getCoOffsuited() {
		return CO_OFFSUITED;
	}

	public static String[] getBtnSuited() {
		return BTN_SUITED;
	}

	public static String[] getBtnOffsuited() {
		return BTN_OFFSUITED;
	}

	public static String[] getSbSuited() {
		return SB_SUITED;
	}

	public static String[] getSbOffsuited() {
		return SB_OFFSUITED;
	}

	public static boolean findCardsInChartArray(String bothHeroCards, String[] chartArray) {
		for (String element : chartArray) {
			if (element.equals(bothHeroCards)) {
				return true;
			}
		}
		return false;
	}
}
