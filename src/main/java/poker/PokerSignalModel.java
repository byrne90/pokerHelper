package poker;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

public class PokerSignalModel {
	
	public final static GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	public final static GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
	public final static Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
	
    public static final Dimension LIGHT_SIZE = new Dimension(32, 32);
    public static final Dimension COMMON_CARDS_SIZE = new Dimension(75,200);
    public static final Dimension COMMON_CARDS_TEXT_SIZE = new Dimension(150,20);
    public static final Dimension USER_MONITOR_RES = new Dimension(defaultScreen.getDisplayMode().getHeight(),defaultScreen.getDisplayMode().getWidth());
    public static final Dimension POKER_LIGHT_PANEL_SIZE = new Dimension(90,100);
    public static final Dimension HERO_CARDS_INDICATOR_LOCATION = new Dimension((int)(rect.getHeight()*0.77), (int)(rect.getWidth()*0.43));
    public static final Dimension COMMON_CARDS_INDICATOR_LOCATION = new Dimension((int)(rect.getHeight()*0.45), (int)(rect.getWidth()*0.37));

    
   
}
