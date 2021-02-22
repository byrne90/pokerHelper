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

	public void getScreenshoot() throws IOException, AWTException {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenSize);
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screenRectangle);
		ImageIO.write(image, "png",
				new File(System.getProperty("user.dir") + "\\target\\TEST" + getCurrentTime() + ".png"));
	}

	private String getCurrentTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		return dtf.format(now);
	}

}