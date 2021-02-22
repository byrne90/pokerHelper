package poker;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageData extends PictureCapturing {

	public void getCroppedImage(String screenName) throws IOException {
		Image src = ImageIO.read(new File(System.getProperty("user.dir") + "\\target\\" + screenName));
		screenName = screenName.substring(0, screenName.indexOf("."));
		getButtonPosition(src, screenName);
		getHeroCards(src, screenName);
		getFlopCards(src, screenName);
		getTurnCard(src, screenName);
		getRiverCard(src, screenName);
	}

	private void getHeroCards(Image src, String screenName) throws IOException {
		getFirstHeroCard(src, screenName);

		getSecondHeroCard(src, screenName);
	}

	private void getFirstHeroCard(Image src, String screenName) throws IOException {
		int x = 870, y = 651, w = 90, h = 60;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png",
				new File(System.getProperty("user.dir") + "\\target\\" + screenName + "FirstCard.png"));
	}

	private void getSecondHeroCard(Image src, String screenName) throws IOException {
		int x = 960, y = 651, w = 90, h = 60;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png",
				new File(System.getProperty("user.dir") + "\\target\\" + screenName + "SecondCard.png"));
	}

	private void getFlopCards(Image src, String screenName) throws IOException {
		getFirstFlopCard(src, screenName);
		getSecondFlopCard(src, screenName);
		getThirdFlopCard(src, screenName);
	}

	private void getFirstFlopCard(Image src, String screenName) throws IOException {
		int x = 718, y = 356, w = 90, h = 60;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png",
				new File(System.getProperty("user.dir") + "\\target\\" + screenName + "1stFlopCard.png"));
	}

	private void getSecondFlopCard(Image src, String screenName) throws IOException {
		int x = 817, y = 356, w = 90, h = 60;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png",
				new File(System.getProperty("user.dir") + "\\target\\" + screenName + "2ndFlopCard.png"));
	}

	private void getThirdFlopCard(Image src, String screenName) throws IOException {
		int x = 915, y = 356, w = 90, h = 60;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png",
				new File(System.getProperty("user.dir") + "\\target\\" + screenName + "3rdFlopCard.png"));
	}

	private void getTurnCard(Image src, String screenName) throws IOException {
		int x = 1013, y = 356, w = 90, h = 60;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png",
				new File(System.getProperty("user.dir") + "\\target\\" + screenName + "TurnCard.png"));
	}

	private void getRiverCard(Image src, String screenName) throws IOException {
		int x = 1111, y = 356, w = 90, h = 60;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png",
				new File(System.getProperty("user.dir") + "\\target\\" + screenName + "RiverCard.png"));
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
		ImageIO.write(dst, "png",
				new File(System.getProperty("user.dir") + "\\target\\" + screenName + "HeroButton.png"));
	}

	private void getButtonPositionOnHeroPlusOne(Image src, String screenName) throws IOException {
		int x = 512, y = 475, w = 45, h = 39;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png",
				new File(System.getProperty("user.dir") + "\\target\\" + screenName + "HeroPlusOneButton.png"));
	}

	private void getButtonPositionOnHeroPlusTwo(Image src, String screenName) throws IOException {
		int x = 672, y = 265, w = 45, h = 39;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png",
				new File(System.getProperty("user.dir") + "\\target\\" + screenName + "HeroPlusTwoButton.png"));
	}

	private void getButtonPositionOnHeroPlusThree(Image src, String screenName) throws IOException {
		int x = 1002, y = 257, w = 45, h = 39;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png",
				new File(System.getProperty("user.dir") + "\\target\\" + screenName + "HeroPlusThreeButton.png"));
	}

	private void getButtonPositionOnHeroPlusFour(Image src, String screenName) throws IOException {
		int x = 1356, y = 340, w = 45, h = 39;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png",
				new File(System.getProperty("user.dir") + "\\target\\" + screenName + "HeroPlusFourButton.png"));
	}

	private void getButtonPositionOnHeroPlusFive(Image src, String screenName) throws IOException {
		int x = 1284, y = 578, w = 45, h = 39;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png",
				new File(System.getProperty("user.dir") + "\\target\\" + screenName + "HeroPlusFiveButton.png"));
	}

}
