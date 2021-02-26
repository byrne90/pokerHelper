package poker;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

public class PictureCapturing {

	private String screenName = null;

	public String getScreenName() {
		return this.screenName;
	}

	public void getScreenshoot() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenSize);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		BufferedImage image = robot.createScreenCapture(screenRectangle);
		String currentTime = getCurrentTime();
		screenName = System.getProperty("user.dir") + "\\target\\TEST" + currentTime + ".png";
		try {
			ImageIO.write(image, "png", new File(screenName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getCurrentTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

}
