package poker;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PokerCardPanel extends JLabel{
	
	public PokerCardPanel(String text) {
		this.text=text;
	}
	
	private static final long serialVersionUID = 1L;
	protected String text = "start";

	
	public void setCardPanelText(String text) {
        this.text = text;
        this.setText(text);
    }

}
