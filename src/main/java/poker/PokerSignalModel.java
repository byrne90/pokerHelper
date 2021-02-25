package poker;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

public class PokerSignalModel {
	
	public final static GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	public final static GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
	public final static Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
	
    public static final Dimension LIGHT_SIZE = new Dimension(64, 32);
    public static final Dimension USER_MONITOR_RES = new Dimension(defaultScreen.getDisplayMode().getHeight(),defaultScreen.getDisplayMode().getWidth());
    public static final Dimension POKER_LIGHT_PANEL_SIZE = new Dimension(80,120);
    public static final Dimension HERO_CARDS_INDICATOR_SIZE = new Dimension((int)(rect.getHeight()*0.77), (int)(rect.getWidth()*0.43));
    
   
}
