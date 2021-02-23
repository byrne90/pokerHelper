package poker;

import javax.swing.SwingUtilities;

public class PokerRunCycle extends Thread {

	protected boolean isRunning;
	protected boolean isFinished;

	protected PokerSignalPanel tsPanel;
//	protected PokerCardPanel cardPanel;

	public PokerRunCycle(PokerSignalPanel tsPanel) {
		this.tsPanel = tsPanel;
//		this.cardPanel=cardPanel;
		this.isRunning = true;
		this.isFinished = false;
	}

	@Override
	public void run() {
		while (isRunning) {
			// TODO tutaj impmenetacja czytania kart etc
//			signalLightOn(tsPanel.getGreenLight(), PokerSignalModel.GREEN_LIGHT_TIME);
//			signalLightOn(tsPanel.getYellowLight(), PokerSignalModel.YELLOW_LIGHT_TIME);
			signalLightOn(tsPanel.getLightPanel(), tsPanel.getCardPanel(), "red", "SUKCES");
		}
		this.isFinished = true;
	}

	protected void signalLightOn(PokerLightPanel light, PokerCardPanel card, String color, String cardText) {
		setLightOn(light, color);
		setTextOn(card, cardText);
	}

	protected void setIdleStatus() {
		setLightOn(tsPanel.getLightPanel(), "xxx");
		setTextOn(tsPanel.getCardPanel(), "??");
	}

	protected void setLightOn(final PokerLightPanel light, final String isLightOn) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				light.setColor(isLightOn);
			}
		});
	}

	protected void setTextOn(final PokerCardPanel card, final String text) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				card.setCardPanelText(text);
			}
		});
	}

	public void stopRunning() {
		this.isRunning = false;
		while (!isFinished) {
			setIdleStatus();
			try {
				Thread.sleep(5L);
			} catch (InterruptedException e) {
			}
		}
	}
}
