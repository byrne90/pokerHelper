package poker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PokerSignalPanel {

	protected JPanel textPanel;

	protected PokerLightPanel lightPanel;
	protected PokerCardPanel cardPanel;

	public PokerSignalPanel() {
		createPartControl();
	}

	protected void createPartControl() {

		lightPanel = new PokerLightPanel();
		lightPanel.setPreferredSize(new Dimension(PokerSignalModel.LIGHT_SIZE.height, PokerSignalModel.LIGHT_SIZE.height));

		cardPanel = new PokerCardPanel("??");
		cardPanel.setForeground(Color.BLACK);
		cardPanel.setPreferredSize(PokerSignalModel.LIGHT_SIZE);
		
		textPanel = new JPanel();
		textPanel.setOpaque(false);
		textPanel.setLayout(new FlowLayout());
//		textPanel.setLocation(300, 300);
		textPanel.setVisible(true);
		textPanel.setPreferredSize(new Dimension(PokerSignalModel.LIGHT_SIZE.height*2, PokerSignalModel.LIGHT_SIZE.height*2));

		textPanel.add(lightPanel);
		textPanel.add(cardPanel);
	}

	public JPanel getTextPanel() {
		return textPanel;
	}

	public PokerLightPanel getLightPanel() {
		return lightPanel;
	}
	
	public PokerCardPanel getCardPanel() {
		return cardPanel;
	}

}
