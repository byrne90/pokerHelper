package poker;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PokerLightPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    
//    protected PokerSignalPanel pokerSignalPanel;

    protected String lightOn;

    protected Color redColor=Color.RED;
    protected Color yellowColor=Color.YELLOW;
    protected Color greenColor=Color.GREEN;
    protected Color darkColor =Color.GREEN;
    protected Color greyColor =Color.GRAY;


//    public PokerLightPanel() {
//        this.lightOn = false;
//    }

	public void setColor(String color) {
        this.lightOn = color;
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        if(lightOn==null) {
            g.setColor(greyColor);
        } else if (lightOn.equals("red")) {
            g.setColor(redColor);
        } else {
            g.setColor(darkColor);
        }
        g.fillRect(0, 0, getWidth(), getHeight());

    }

}
