package poker;

import javax.swing.SwingUtilities;

public class PokerHelper implements Runnable {
	public void run() {
		new MainWindow();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new PokerHelper());
	}

}
