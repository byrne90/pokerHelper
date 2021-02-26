package poker;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageData extends PictureCapturing {
	
	private static final File[] targetImages = new File(System.getProperty("user.dir") + "\\target\\").listFiles();

	private String heroFirstCardPath = null;
	private String heroSecondCardPath = null;
	private String firstFlopCardPath = null;
	private String secondFlopCardPath = null;
	private String thirdFlopCardPath = null;
	private String turnCardPath = null;
	private String riverCardPath = null;
	
	private String heroButtonPosition = null;
	private String heroPlusOneButtonPosition = null;
	private String heroPlusTwoButtonPosition = null;
	private String heroPlusThreeButtonPosition = null;
	private String heroPlusFourButtonPosition = null;
	private String heroPlusFiveButtonPosition = null;


	public String getHeroFirstCardPath() {
		return heroFirstCardPath;
	}

	public String getHeroSecondCard() {
		return heroSecondCardPath;
	}

	public String getFirstFlopCard() {
		return firstFlopCardPath;
	}

	public String getSecondFlopCard() {
		return secondFlopCardPath;
	}

	public String getThirdFlopCard() {
		return thirdFlopCardPath;
	}

	public String getTurnCard() {
		return turnCardPath;
	}

	public String getRiverCard() {
		return riverCardPath;
	}
	
	public String getHeroButtonPosition() {
		return heroButtonPosition;
	}

	public String getHeroPlusOneButtonPosition() {
		return heroPlusOneButtonPosition;
	}

	public String getHeroPlusTwoButtonPosition() {
		return heroPlusTwoButtonPosition;
	}

	public String getHeroPlusThreeButtonPosition() {
		return heroPlusThreeButtonPosition;
	}

	public String getHeroPlusFourButtonPosition() {
		return heroPlusFourButtonPosition;
	}

	public String getHeroPlusFiveButtonPosition() {
		return heroPlusFiveButtonPosition;
	}

	public void getCroppedImage(String screenPath) {
		Image src;
		try {
			src = ImageIO.read(new File(screenPath));
			screenPath = screenPath.substring(0, screenPath.indexOf("."));
//			System.out.println("getCroppedImage " + screenPath);
			getButtonPosition(src, screenPath);
			getHeroCards(src, screenPath);
			getFlopCards(src, screenPath);
			getTurnCard(src, screenPath);
			getRiverCard(src, screenPath);
		} catch (IOException e) {
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
//		System.out.println("firstHeroCardPath: " + heroFirstCardPath);
	}

	private void getSecondHeroCard(Image src, String screenName) throws IOException {
		int x = 961, y = 651, w = 91, h = 63;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png", new File(screenName + "SecondCard.png"));
		heroSecondCardPath = screenName + "SecondCard.png";
//		System.out.println("second hero card: " + heroSecondCard);
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
		firstFlopCardPath = screenName + "1stFlopCard.png";
	}

	private void getSecondFlopCard(Image src, String screenName) throws IOException {
		int x = 816, y = 356, w = 91, h = 63;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png", new File(screenName + "2ndFlopCard.png"));
		secondFlopCardPath = screenName + "2ndFlopCard.png";
	}

	private void getThirdFlopCard(Image src, String screenName) throws IOException {
		int x = 914, y = 356, w = 91, h = 63;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png", new File(screenName + "3rdFlopCard.png"));
		thirdFlopCardPath = screenName + "3rdFlopCard.png";
	}

	private void getTurnCard(Image src, String screenName) throws IOException {
		int x = 1013, y = 356, w = 91, h = 63;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png", new File(screenName + "TurnCard.png"));
		turnCardPath = screenName + "TurnCard.png";
	}

	private void getRiverCard(Image src, String screenName) throws IOException {
		int x = 1112, y = 356, w = 91, h = 63;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png", new File(screenName + "RiverCard.png"));
		riverCardPath = screenName + "RiverCard.png";
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
		heroButtonPosition = screenName + "HeroButton.png";
	}

	private void getButtonPositionOnHeroPlusOne(Image src, String screenName) throws IOException {
		int x = 512, y = 475, w = 45, h = 39;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png", new File(screenName + "HeroPlusOneButton.png"));
		heroPlusOneButtonPosition = screenName + "HeroPlusOneButton.png";
	}

	private void getButtonPositionOnHeroPlusTwo(Image src, String screenName) throws IOException {
		int x = 672, y = 265, w = 45, h = 39;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png", new File(screenName + "HeroPlusTwoButton.png"));
		heroPlusTwoButtonPosition = screenName + "HeroPlusTwoButton.png";
	}

	private void getButtonPositionOnHeroPlusThree(Image src, String screenName) throws IOException {
		int x = 1002, y = 257, w = 45, h = 39;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png", new File(screenName + "HeroPlusThreeButton.png"));
		heroPlusThreeButtonPosition = screenName + "HeroPlusThreeButton.png";
	}

	private void getButtonPositionOnHeroPlusFour(Image src, String screenName) throws IOException {
		int x = 1356, y = 340, w = 45, h = 39;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png", new File(screenName + "HeroPlusFourButton.png"));
		heroPlusFourButtonPosition = screenName + "HeroPlusFourButton.png";
	}

	private void getButtonPositionOnHeroPlusFive(Image src, String screenName) throws IOException {
		int x = 1284, y = 578, w = 45, h = 39;
		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);
		ImageIO.write(dst, "png", new File(screenName + "HeroPlusFiveButton.png"));
		heroPlusFiveButtonPosition = screenName + "HeroPlusFiveButton.png";
	}
	
	public void deleteAllImagesFromCycle(String mainImage) {
		deleteImage(mainImage);
		deleteImage(heroFirstCardPath);
		deleteImage(heroSecondCardPath);
		
		deleteImage(heroButtonPosition);
		deleteImage(heroPlusOneButtonPosition);
		deleteImage(heroPlusTwoButtonPosition);
		deleteImage(heroPlusThreeButtonPosition);
		deleteImage(heroPlusFourButtonPosition);
		deleteImage(heroPlusFiveButtonPosition);

		deleteImage(firstFlopCardPath);
		deleteImage(secondFlopCardPath);
		deleteImage(thirdFlopCardPath);
		deleteImage(turnCardPath);
		deleteImage(riverCardPath);
	}
	
	private static void deleteImage(String pathToImage) {
		File file = new File(pathToImage); 
        
        if(file.delete()) 
        { 
//            System.out.println("File deleted successfully"); 
        } 
        else
        { 
//            System.out.println("Failed to delete the file"); 
        } 
	}

	public static void deleteAllPngsFromTarget() {
		for(int i = 0; i<targetImages.length; i++) {
			if(targetImages[i].getName().contains(".png")) {
				deleteImage(targetImages[i].getAbsolutePath());
			}
		}
	}
}
