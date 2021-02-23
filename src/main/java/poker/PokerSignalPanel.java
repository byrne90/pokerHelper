package poker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PokerSignalPanel {

	protected JPanel textPanel;
//	protected JLabel label;

	protected PokerLightPanel lightPanel;
	protected PokerCardPanel cardPanel;

	public PokerSignalPanel() {
		createPartControl();
	}

	protected void createPartControl() {

		lightPanel = new PokerLightPanel();
		lightPanel.setPreferredSize(PokerSignalModel.LIGHT_SIZE);

		cardPanel = new PokerCardPanel("contructor");
		cardPanel.setForeground(Color.BLACK);
		cardPanel.setPreferredSize(PokerSignalModel.DOUBLE_LIGHT_SIZE);
		
		textPanel = new JPanel();
		textPanel.setOpaque(false);
		textPanel.setLayout(new FlowLayout());
		textPanel.setPreferredSize(new Dimension(PokerSignalModel.DOUBLE_LIGHT_SIZE.height, PokerSignalModel.DOUBLE_LIGHT_SIZE.height));
//        textPanel.setPreferredSize(new Dimension(300, 300));


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
