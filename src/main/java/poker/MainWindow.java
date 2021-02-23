package poker;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class MainWindow extends JFrame {

	protected ButtonPanel bPanel;

	protected PokerSignalPanel tsPanel;

	protected JFrame controlFrame;
	protected JFrame signalFrame;
	
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
	Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();

	public MainWindow() {
		GraphicsDevice[] gds = ge.getScreenDevices();
		createPartControl();
		createSignalWindow();
	}

	protected void createPartControl() {
		bPanel = new ButtonPanel();

		controlFrame = new JFrame();
		controlFrame.setAlwaysOnTop(rootPaneCheckingEnabled);
		controlFrame.setTitle("PokerHelper");
		controlFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		controlFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				exitProcedure();
			}
		});

		controlFrame.setLayout(new FlowLayout());
		controlFrame.add(bPanel.getPanel());
//		int y = (int) rect.getMaxX() - controlFrame.getWidth();
//		int x = 0;
		 controlFrame.setLocation(GraphicsEnvironment
                 .getLocalGraphicsEnvironment()
                 .getScreenDevices()[1]
                 .getDefaultConfiguration()
                 .getBounds()
                 .getLocation());
		controlFrame.setSize(150, 75);
		controlFrame.setVisible(true);
	}
	
	protected void createSignalWindow() {
		signalFrame = new JFrame();
		signalFrame.setUndecorated(true);
        signalFrame.setBackground(new Color(0, 0, 0, 0));
		signalFrame.setVisible(true);
//        signalFrame.setLocationRelativeTo(null);
		signalFrame.setAlwaysOnTop(rootPaneCheckingEnabled);
		signalFrame.setSize((int)rect.getMaxX(), (int)rect.getMaxY());
		tsPanel = new PokerSignalPanel();
		bPanel.setPokerSignalPanel(tsPanel);
		signalFrame.add(tsPanel.getPanel());

	}

	public void exitProcedure() {
		controlFrame.dispose();
		System.exit(0);
	}

	public JFrame getFrame() {
		return controlFrame;
	}

}