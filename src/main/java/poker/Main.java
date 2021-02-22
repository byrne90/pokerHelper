package poker;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) throws IOException, AWTException, InterruptedException {
		System.out.println("start");
//PictureCapturing pictureCapturing = new PictureCapturing();
//pictureCapturing.getScreenshoot();
		ImageData imageData = new ImageData();
		imageData.getCroppedImage("TEST2021-02-22 16-28-35.png");
		TemplateMatching templateMatching = new TemplateMatching();
//templateMatching.compareFirstCard(System.getProperty("user.dir")+"\\target\\"+"TEST2021-02-22 16-28-35"+"FirstCard.png");
		templateMatching.compareSecondCard(
				System.getProperty("user.dir") + "\\target\\" + "TEST2021-02-22 16-28-35" + "SecondCard.png");

		System.out.println("END");
	}
}
