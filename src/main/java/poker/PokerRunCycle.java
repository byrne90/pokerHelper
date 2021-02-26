package poker;

import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PokerRunCycle extends Thread {

	protected boolean isRunning;
	protected boolean isFinished;

	protected PokerSignalPanel tsPanel;
	protected CommonCardsSignalPanel commonCardsPanel;

	public PokerRunCycle(PokerSignalPanel tsPanel, CommonCardsSignalPanel commonCardsSignalPanel) {
		this.tsPanel = tsPanel;
		this.commonCardsPanel = commonCardsSignalPanel;
		this.isRunning = true;
		this.isFinished = false;
	}

	@Override
	public void run() {
		ImageData.deleteAllPngsFromTarget();
		while (isRunning) {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			PictureCapturing pictureCapturing = new PictureCapturing();
			pictureCapturing.getScreenshoot();
			ImageData imageData = new ImageData();
			imageData.getCroppedImage(pictureCapturing.getScreenName());
			TemplateMatching templateMatching = new TemplateMatching();

			templateMatching.checkForButtonPosition();

			templateMatching.compareFirstCard(imageData.getHeroFirstCardPath());
			templateMatching.compareSecondCard(imageData.getHeroSecondCard());
			templateMatching.compareFirstCardFlop(imageData.getFirstFlopCard());
			templateMatching.compareSecondCardFlop(imageData.getSecondFlopCard());
			templateMatching.compareThirdCardFlop(imageData.getThirdFlopCard());

			templateMatching.compareTurn(imageData.getTurnCard());
			templateMatching.compareRiver(imageData.getRiverCard());

			playerCardsLightOn(tsPanel.getLightPanel(), tsPanel.getCardPanel(), "red", templateMatching.getFirstCard(),
					templateMatching.getSecondCard(), tsPanel.getButtoPosition(), templateMatching.getButtonPosition());
			commonCardsLightOn(commonCardsPanel.getCommonCardsPanel(),
					templateMatching.getFirstCardFlop() + " " + templateMatching.getSecondCardFlop() + " "
							+ templateMatching.getThirdCardFlop() + " " + templateMatching.getTurnCard() + " "
							+ templateMatching.getRiverCard());

			imageData.deleteAllImagesFromCycle(pictureCapturing.getScreenName());
			templateMatching.resetButtonSettings();
		}
		this.isFinished = true;
	}

	private void commonCardsLightOn(PokerCardPanel commonCardsPanelParam, String cardsText) {
		setCommonCardsTextOn(commonCardsPanelParam, cardsText);
	}

	protected void playerCardsLightOn(PokerLightPanel light, PokerCardPanel card, String color, String firstCardText,
			String secondCardText, PokerCardPanel position, String positionString) {
		setLightOn(light, color);
		setHeroCardsTextOn(card, firstCardText, secondCardText);
		setButtonPositionOn(position, positionString);
	}

	protected void setIdleStatus() {
		setLightOn(tsPanel.getLightPanel(), "xxx");
		setHeroCardsTextOn(tsPanel.getCardPanel(), "??", "??");
		setCommonCardsTextOn(commonCardsPanel.getCommonCardsPanel(), "??");
	}

	protected void setLightOn(final PokerLightPanel light, final String isLightOn) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				light.setColor(isLightOn);
			}
		});
	}

	protected void setHeroCardsTextOn(final PokerCardPanel card, final String firstCard, final String secondCard) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				card.setCardPanelText(firstCard + " " + secondCard);
			}
		});
	}

	protected void setCommonCardsTextOn(final PokerCardPanel card, final String commonCards) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				card.setCardPanelText(commonCards);
			}
		});
	}
	
	private void setButtonPositionOn(final PokerCardPanel position, final String positionString) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				position.setCardPanelText(positionString);
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
