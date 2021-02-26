package poker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class CommonCardsSignalPanel {
	
	protected JPanel textPanel;

	protected PokerCardPanel commonCardsPanel;
	
	public CommonCardsSignalPanel() {
		createCommonCardsPartControl();
	}
	
	public JPanel getTextPanel() {
		return textPanel;
	}

	public PokerCardPanel getCommonCardsPanel() {
		return commonCardsPanel;
	}

	private void createCommonCardsPartControl() {
	
		commonCardsPanel = new PokerCardPanel("TEEEST");
		commonCardsPanel.setForeground(Color.BLACK);
		commonCardsPanel.setPreferredSize(PokerSignalModel.COMMON_CARDS_TEXT_SIZE);
		
		textPanel = new JPanel();
		textPanel.setOpaque(false);
		textPanel.setLayout(new FlowLayout());
//		textPanel.setLocation(0, 0);
		textPanel.setVisible(true);
//		textPanel.setPreferredSize(new Dimension(0, 0));

		textPanel.add(commonCardsPanel);		
	}

}
