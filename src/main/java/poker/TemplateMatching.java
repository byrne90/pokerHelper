package poker;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TemplateMatching {

	private File[] deckOfCards = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\cards\\")
			.listFiles();
	private String firstCard = null;
	private String secondCard = null;
	private String firstCardFlop = null;
	private String secondCardFlop = null;
	private String thirdCardFlop = null;

	private String turn = null;
	private String river = null;

	private String compareCardPixels(String fileName) throws IOException {
		double percentage = 100;
		String currentCard = null;

		for (int z = 0; z < deckOfCards.length; z++) {
			BufferedImage img1 = ImageIO.read(new File(fileName));
			BufferedImage img2 = ImageIO.read(deckOfCards[z]);
			int w1 = img1.getWidth();
			int w2 = img2.getWidth();
			int h1 = img1.getHeight();
			int h2 = img2.getHeight();
			if ((w1 != w2) || (h1 != h2)) {
				System.out.println("Both images should have same dimwnsions");
			} else {
				long diff = 0;
				for (int j = 0; j < h1; j++) {
					for (int i = 0; i < w1; i++) {
						// Getting the RGB values of a pixel
						int pixel1 = img1.getRGB(i, j);
						Color color1 = new Color(pixel1, true);
						int r1 = color1.getRed();
						int g1 = color1.getGreen();
						int b1 = color1.getBlue();
						int pixel2 = img2.getRGB(i, j);
						Color color2 = new Color(pixel2, true);
						int r2 = color2.getRed();
						int g2 = color2.getGreen();
						int b2 = color2.getBlue();
						// sum of differences of RGB values of the two images
						long data = Math.abs(r1 - r2) + Math.abs(g1 - g2) + Math.abs(b1 - b2);
						diff = diff + data;
					}
				}
				double avg = diff / (w1 * h1 * 3);
				double tempPercentage = (avg / 255) * 100;
				if (percentage > tempPercentage) {
					percentage = tempPercentage;
					currentCard = deckOfCards[z].getName();
					System.out.println(currentCard);
					System.out.println("Difference: " + percentage);

				}
			}
		}
		System.out.println("Current card: " + currentCard);
		if (percentage > 1.5) {
			return "??";
		}
		return currentCard.substring(0,currentCard.indexOf("."));
	}

	public void compareFirstCard(String pathToCardImage) {
		firstCard = (compareCard(pathToCardImage));
	}

	public void compareSecondCard(String pathToCardImage) {
		secondCard = (compareCard(pathToCardImage));
	}
	
	public void compareFirstCardFlop(String pathToCardImage) {
		firstCardFlop = (compareCard(pathToCardImage));
	}
	
	public void compareSecondCardFlop(String pathToCardImage) {
		secondCardFlop = (compareCard(pathToCardImage));
	}
	
	public void compareThirdCardFlop(String pathToCardImage) {
		thirdCardFlop = (compareCard(pathToCardImage));
	}
	
	public void compareTurn(String pathToCardImage) {
		turn = (compareCard(pathToCardImage));
	}
	
	public void compareRiver(String pathToCardImage) {
		river = (compareCard(pathToCardImage));
	}

	public String compareCard(String pathToCardImage) {
		try {
			return compareCardPixels(pathToCardImage);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("WRONG PATH?");
			return null;
		}
	}

	public String getFirstCard() {
		return firstCard;
	}

	public String getSecondCard() {
		return secondCard;
	}

	public String getFirstCardFlop() {
		return firstCardFlop;
	}

	public String getSecondCardFlop() {
		return secondCardFlop;
	}

	public String getThirdCardFlop() {
		return thirdCardFlop;
	}

	public String getTurnCard() {
		return turn;
	}

	public String getRiverCard() {
		return river;
	}

}
