package poker;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageData extends PictureCapturing {

	private String heroFirstCardPath = null;
	private String heroSecondCard = null;
	private String firstFlopCard = null;
	private String secondFlopCard = null;
	private String thirdFlopCard = null;
	private String turnCard = null;
	private String riverCard = null;

	public String getHeroFirstCardPath() {
		return heroFirstCardPath;
	}

	public String getHeroSecondCard() {
		return heroSecondCard;
	}

	public String getFirstFlopCard() {
		return firstFlopCard;
	}

	public String getSecondFlopCard() {
		return secondFlopCard;
	}

	public String getThirdFlopCard() {
		return thirdFlopCard;
	}

	public String getTurnCard() {
		return turnCard;
	}

	public String getRiverCard() {
		return riverCard;
	}

	public void getCroppedImage(String screenPath) {
		Image src;
		try {
			src = ImageIO.read(new File(screenPath));
			screenPath = screenPath.substring(0, screenPath.indexOf("."));
			System.out.println("getCroppedImage " + screenPath);
			getButtonPosition(src, screenPath);
			getHeroCards(src, screenPath);
			getFlopCards(src, screenPath);
			getTurnCard(src, screenPath);
			getRiverCard(src, screenPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void getHeroCards(Image src, String screenName) throws IOException {
		getFirstHeroCard(src, screenName);
		getSecondHeroCard(src, screenName);
	}

	private void getFirstHeroCard(Image src, String screenName) throws IOException {
		int x = 868, y = 651, w = 91, h = 63;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png", new File(screenName + "FirstCard.png"));
		heroFirstCardPath = screenName + "FirstCard.png";
		System.out.println("firstHeroCardPath: " + heroFirstCardPath);
	}

	private void getSecondHeroCard(Image src, String screenName) throws IOException {
		System.out.println(screenName);
		int x = 961, y = 651, w = 91, h = 63;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png", new File(screenName + "SecondCard.png"));
		heroSecondCard = screenName + "SecondCard.png";
		System.out.println("second hero card: " + heroSecondCard);
	}

	private void getFlopCards(Image src, String screenName) throws IOException {
		getFirstFlopCard(src, screenName);
		getSecondFlopCard(src, screenName);
		getThirdFlopCard(src, screenName);
	}

	private void getFirstFlopCard(Image src, String screenName) throws IOException {
		int x = 717, y = 356, w = 91, h = 63;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png", new File(screenName + "1stFlopCard.png"));
		firstFlopCard = screenName + "1stFlopCard.png";
	}

	private void getSecondFlopCard(Image src, String screenName) throws IOException {
		int x = 816, y = 356, w = 91, h = 63;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png", new File(screenName + "2ndFlopCard.png"));
		secondFlopCard = screenName + "2ndFlopCard.png";
	}

	private void getThirdFlopCard(Image src, String screenName) throws IOException {
		int x = 914, y = 356, w = 91, h = 63;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png", new File(screenName + "3rdFlopCard.png"));
		thirdFlopCard = screenName + "3rdFlopCard.png";
	}

	private void getTurnCard(Image src, String screenName) throws IOException {
		int x = 1012, y = 356, w = 91, h = 63;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png", new File(screenName + "TurnCard.png"));
		turnCard = screenName + "TurnCard.png";
	}

	private void getRiverCard(Image src, String screenName) throws IOException {
		int x = 1111, y = 356, w = 91, h = 63;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png", new File(screenName + "RiverCard.png"));
		riverCard = screenName + "RiverCard.png";
	}

	private void getButtonPosition(Image src, String screenName) throws IOException {
		getButtonPositionOnHero(src, screenName);
		getButtonPositionOnHeroPlusOne(src, screenName);
		getButtonPositionOnHeroPlusTwo(src, screenName);
		getButtonPositionOnHeroPlusThree(src, screenName);
		getButtonPositionOnHeroPlusFour(src, screenName);
		getButtonPositionOnHeroPlusFive(src, screenName);
	}

	private void getButtonPositionOnHero(Image src, String screenName) throws IOException {
		int x = 800, y = 631, w = 45, h = 39;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png", new File(screenName + "HeroButton.png"));
	}

	private void getButtonPositionOnHeroPlusOne(Image src, String screenName) throws IOException {
		int x = 512, y = 475, w = 45, h = 39;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png", new File(screenName + "HeroPlusOneButton.png"));
	}

	private void getButtonPositionOnHeroPlusTwo(Image src, String screenName) throws IOException {
		int x = 672, y = 265, w = 45, h = 39;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png", new File(screenName + "HeroPlusTwoButton.png"));
	}

	private void getButtonPositionOnHeroPlusThree(Image src, String screenName) throws IOException {
		int x = 1002, y = 257, w = 45, h = 39;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png", new File(screenName + "HeroPlusThreeButton.png"));
	}

	private void getButtonPositionOnHeroPlusFour(Image src, String screenName) throws IOException {
		int x = 1356, y = 340, w = 45, h = 39;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png", new File(screenName + "HeroPlusFourButton.png"));
	}

	private void getButtonPositionOnHeroPlusFive(Image src, String screenName) throws IOException {
		int x = 1284, y = 578, w = 45, h = 39;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png", new File(screenName + "HeroPlusFiveButton.png"));
	}

}
