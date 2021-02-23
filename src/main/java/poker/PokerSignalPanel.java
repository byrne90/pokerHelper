package poker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
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
		Border border = BorderFactory.createLineBorder(Color.BLACK, 4);

		redLight = new PokerLightPanel(Color.RED);
		redLight.setBorder(border);
		redLight.setPreferredSize(PokerSignalModel.LIGHT_SIZE);

		yellowLight = new PokerLightPanel(Color.YELLOW);
		yellowLight.setBorder(border);
		yellowLight.setPreferredSize(PokerSignalModel.LIGHT_SIZE);

		greenLight = new PokerLightPanel(Color.GREEN);
		greenLight.setBorder(border);
		greenLight.setPreferredSize(PokerSignalModel.LIGHT_SIZE);

		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setPreferredSize(
				new Dimension(PokerSignalModel.LIGHT_SIZE.width + 10, PokerSignalModel.LIGHT_SIZE.height * 3 + 25));

		panel.add(redLight);
		panel.add(yellowLight);
		panel.add(greenLight);
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
