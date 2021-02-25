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
			// TODO usuwanie niepotrzbnych zrzutow ekranu
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			PictureCapturing pictureCapturing = new PictureCapturing();
			pictureCapturing.getScreenshoot();
			ImageData imageData = new ImageData();
			imageData.getCroppedImage(pictureCapturing.getScreenName());
			TemplateMatching templateMatching = new TemplateMatching();
			templateMatching.compareFirstCard(imageData.getHeroFirstCardPath());
			templateMatching.compareSecondCard(imageData.getHeroSecondCard());
//			templateMatching.compareFirstCard(imageData.getFirstFlopCard());
//			templateMatching.compareFirstCard(imageData.getSecondFlopCard());
//			templateMatching.compareFirstCard(imageData.getThirdFlopCard());

//			templateMatching.compareFirstCard(imageData.getTurnCard());
//			templateMatching.compareFirstCard(imageData.getRiverCard());

			playerCardsLightOn(tsPanel.getLightPanel(), tsPanel.getCardPanel(), "red", templateMatching.getFirstCard(),
					templateMatching.getSecondCard());
		}
		this.isFinished = true;
	}

	protected void playerCardsLightOn(PokerLightPanel light, PokerCardPanel card, String color, String firstCardText,
			String secondCardText) {
		setLightOn(light, color);
		setTextOn(card, firstCardText, secondCardText);
	}

	protected void setIdleStatus() {
		setLightOn(tsPanel.getLightPanel(), "xxx");
		setTextOn(tsPanel.getCardPanel(), "??", "??");
	}

	protected void setLightOn(final PokerLightPanel light, final String isLightOn) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				light.setColor(isLightOn);
			}
		});
	}

	protected void setTextOn(final PokerCardPanel card, final String firstCard, final String secondCard) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				card.setCardPanelText(firstCard + " " + secondCard);
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
