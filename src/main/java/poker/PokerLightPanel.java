package poker;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PokerLightPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	protected String colorToDisplay;

	public void setColor(String color) {
		this.colorToDisplay = color;
		this.repaint();
	}

	@Override
    public void paintComponent(Graphics g) {
        if(colorToDisplay==null) {
            g.setColor(Color.GRAY);
        } else if (colorToDisplay.equals("red")) {
            g.setColor(Color.RED);
        } else if(colorToDisplay.equals("yellow")){
        	g.setColor(Color.YELLOW);
        }else if(colorToDisplay.equals("green")) {
        	g.setColor(Color.GREEN);
        }
        else {
            g.setColor(Color.BLACK);
        }
        g.fillRect(0, 0, getWidth(), getHeight());

    }

}
