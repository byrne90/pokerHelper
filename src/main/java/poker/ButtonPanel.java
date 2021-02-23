package poker;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel {

	protected JButton startButton;
	protected JButton stopButton;

	protected JPanel panel;

	protected PokerRunCycle thread;

	protected PokerSignalPanel pokerPanel;

	public ButtonPanel() {
		this.thread = null;
		createPartControl();
	}

	protected void createPartControl() {
		panel = new JPanel();
		panel.setLayout(new FlowLayout());

		startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (thread != null) {
					thread.stopRunning();
				}
				pokerPanel.getLightPanel().setColor("xxx");
				thread = new PokerRunCycle(pokerPanel);
				thread.start();
			}
		});

		panel.add(startButton);

		stopButton = new JButton("Stop");
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (thread != null) {
					thread.stopRunning();
					pokerPanel.getLightPanel().setColor("xxx");
					thread = null;
				}
			}
		});

		panel.add(stopButton);

		setButtonSizes(startButton, stopButton);
	}

	protected void setButtonSizes(JButton... buttons) {
		Dimension preferredSize = new Dimension();
		for (JButton button : buttons) {
			Dimension d = button.getPreferredSize();
			preferredSize = setLarger(preferredSize, d);
		}
		for (JButton button : buttons) {
			button.setPreferredSize(preferredSize);
		}
	}

	protected Dimension setLarger(Dimension a, Dimension b) {
		Dimension d = new Dimension();
		d.height = Math.max(a.height, b.height);
		d.width = Math.max(a.width, b.width);
		return d;
	}

	public void setPokerSignalPanel(PokerSignalPanel tsPanel) {
		this.pokerPanel = tsPanel;
	}

	public JPanel getTextPanel() {
		return panel;
	}
}
