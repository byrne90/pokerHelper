package poker;

public class PreflopPlay {

	private static boolean areCardsSuited = false;

	public static boolean isAreCardsSuited() {
		return areCardsSuited;
	}

	private boolean checkForSuitedCards(String firstCard, String secondCard) {
		if (firstCard.contains("?") || secondCard.contains("?")) {
			return false;
		}
		String firstCardColor = firstCard.substring(firstCard.length() - 1);
		String secondCardColor = secondCard.substring(secondCard.length() - 1);
		if (firstCardColor.equals(secondCardColor)) {
			return true;
		} else {
			return false;
		}
	}

	private String organizeCardsOnHandInDescendingOrder(String firstCard, String secondCard) {
		String firstCardValue = firstCard.substring(0, firstCard.length() - 1);
		String secondCardValue = secondCard.substring(0, secondCard.length() - 1);

		if (PokerCardsValues.getCardsValues().get(secondCardValue) > PokerCardsValues.getCardsValues()
				.get(firstCardValue)) {
//			System.out.println(firstCardValue + " " + secondCardValue);
			return secondCardValue + firstCardValue;
		} else {
//			System.out.println(firstCardValue + " " + secondCardValue);
			return firstCardValue + secondCardValue;
		}
	}

	public String checkCardsAgainstTheOpeningChart(String firstCard, String secondCard, String buttonPosition,
			BlackRainStartingHands openingCardClass) {
		checkForSuitedCards(firstCard, secondCard);
		String cardsOnHand = organizeCardsOnHandInDescendingOrder(firstCard, secondCard);
		
		if (buttonPosition.contains("UTG")) {
			if (areCardsSuited) {
				if (BlackRainStartingHands.findCardsInChartArray(cardsOnHand, BlackRainStartingHands.getUtgSuited())) {
					return "green";
				} else {
					return "red";
				}
			} else {
				if (BlackRainStartingHands.findCardsInChartArray(cardsOnHand, BlackRainStartingHands.getUtgOffsuited())) {
					return "green";
				} else {
					return "red";
				}
			}

		} else if (buttonPosition.contains("HJ")) {
			if (areCardsSuited) {
				if (BlackRainStartingHands.findCardsInChartArray(cardsOnHand, BlackRainStartingHands.getHjSuited())) {
					return "green";
				} else {
					return "red";
				}
			} else {
				if (BlackRainStartingHands.findCardsInChartArray(cardsOnHand,BlackRainStartingHands.getHjOffsuited())) {
					return "green";
				} else {
					return "red";
				}
			}

		} else if (buttonPosition.contains("CO")) {
			if (areCardsSuited) {
				if (BlackRainStartingHands.findCardsInChartArray(cardsOnHand, BlackRainStartingHands.getCoSuited())) {
					return "green";
				} else {
					return "red";
				}
			} else {
				if (BlackRainStartingHands.findCardsInChartArray(cardsOnHand,BlackRainStartingHands.getCoOffsuited())) {
					return "green";
				} else {
					return "red";
				}
			}

		} else if (buttonPosition.contains("BTN")) {
			if (areCardsSuited) {
				if (BlackRainStartingHands.findCardsInChartArray(cardsOnHand, BlackRainStartingHands.getBtnSuited())) {
					return "green";
				} else {
					return "red";
				}
			} else {
				if (BlackRainStartingHands.findCardsInChartArray(cardsOnHand, BlackRainStartingHands.getBtnOffsuited())) {
					return "green";
				} else {
					return "red";
				}
			}

		} else if (buttonPosition.contains("SB")) {
			if (areCardsSuited) {
				if (BlackRainStartingHands.findCardsInChartArray(cardsOnHand, BlackRainStartingHands.getSbSuited())) {
					return "green";
				} else {
					return "red";
				}
			} else {
				if (BlackRainStartingHands.findCardsInChartArray(cardsOnHand,BlackRainStartingHands.getSbOffsuited())) {
					return "green";
				} else {
					return "red";
				}
			}

		} else if (buttonPosition.contains("BB")) {
			// TODO to be implmeneted with equilab chart (defending agiainst positions)
			return "red";
		} else {
			System.out.println("smth wrong with position handling");
			return "red";
		}
	}

}
