package poker;

import javax.swing.SwingUtilities;

public class PokerRunCycle extends Thread {

	protected boolean isRunning;
	protected boolean isFinished;

	protected PokerSignalPanel tsPanel;

	public PokerRunCycle(PokerSignalPanel tsPanel) {
		this.tsPanel = tsPanel;
		this.isRunning = true;
		this.isFinished = false;
	}

	@Override
	public void run() {
		while (isRunning) {
			signalLightOn(tsPanel.getGreenLight(), PokerSignalModel.GREEN_LIGHT_TIME);
			signalLightOn(tsPanel.getYellowLight(), PokerSignalModel.YELLOW_LIGHT_TIME);
			signalLightOn(tsPanel.getRedLight(), PokerSignalModel.RED_LIGHT_TIME);
		}
		this.isFinished = true;
	}

	protected void signalLightOn(PokerLightPanel light, int seconds) {
		if (isRunning) {
			setLightOn(light, true);
		}

		for (int i = 0; i < 1000 && isRunning; i++) {
			try {
				Thread.sleep(1L * seconds);
			} catch (InterruptedException e) {
			}
		}
		setLightOn(light, false);
	}

	protected void setLightOn(final PokerLightPanel light, final boolean isLightOn) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				light.setLightOn(isLightOn);

			}
		});
	}

	public void stopRunning() {
		this.isRunning = false;
		while (!isFinished) {
			try {
				Thread.sleep(10L);
			} catch (InterruptedException e) {
			}
		}
	}

}
