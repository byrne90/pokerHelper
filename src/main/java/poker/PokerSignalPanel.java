package poker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PokerSignalPanel {

	protected JPanel panel;

	protected PokerLightPanel redLight;
	protected PokerLightPanel yellowLight;
	protected PokerLightPanel greenLight;

	public PokerSignalPanel() {
		createPartControl();
	}

	protected void createPartControl() {

		redLight = new PokerLightPanel(Color.RED);
		redLight.setPreferredSize(PokerSignalModel.LIGHT_SIZE);

		yellowLight = new PokerLightPanel(Color.YELLOW);
		yellowLight.setPreferredSize(PokerSignalModel.LIGHT_SIZE);

		greenLight = new PokerLightPanel(Color.GREEN);
		greenLight.setPreferredSize(PokerSignalModel.LIGHT_SIZE);

		panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new FlowLayout());
		panel.setPreferredSize(
				new Dimension(PokerSignalModel.LIGHT_SIZE.width, PokerSignalModel.LIGHT_SIZE.height ));

		panel.add(redLight);
		panel.add(yellowLight);
		panel.add(greenLight);
		
//		JLabel label = new JLabel("AA");
//		panel.add(label);
	}

	public JPanel getPanel() {
		return panel;
	}

	public PokerLightPanel getRedLight() {
		return redLight;
	}

	public PokerLightPanel getYellowLight() {
		return yellowLight;
	}

	public PokerLightPanel getGreenLight() {
		return greenLight;
	}

}
