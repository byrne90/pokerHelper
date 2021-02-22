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
	private String flop = null;
	private String turn = null;
	private String river = null;

	private String compareCard(String fileName) throws IOException {
		// TODO modify comparison engine RGB and float can not handle it!!!!
		double percentage = 100;
		String currentCard = null;

		for (int z = 0; z < deckOfCards.length; z++) {
			BufferedImage img1 = ImageIO.read(new File(fileName));
//    	System.out.println(deckOfCards[z].getName());
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
				}
//           System.out.println("Difference: "+percentage);
//           System.out.println(z);
			}
		}
		System.out.println("Current card: " + currentCard);
		return currentCard;
	}

	public void compareFirstCard(String pathToFirstCardImage) throws IOException {
		firstCard = (compareCard(pathToFirstCardImage));
	}

	public void compareSecondCard(String pathToSecondCardImage) throws IOException {
		secondCard = (compareCard(pathToSecondCardImage));
	}

}
