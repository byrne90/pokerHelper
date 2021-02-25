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
	
	

	public MainWindow() {
//		GraphicsDevice[] gds = PokerSignalModel.ge.getScreenDevices();
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
		controlFrame.add(bPanel.getTextPanel());
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
//		signalFrame.setLayout(new FlowLayout());
		signalFrame.setUndecorated(true);
        signalFrame.setBackground(new Color(0, 0, 0, 0));
		signalFrame.setVisible(true);
		signalFrame.setAlwaysOnTop(rootPaneCheckingEnabled);
		System.out.println(PokerSignalModel.rect);
		System.out.println(PokerSignalModel.HERO_CARDS_INDICATOR_SIZE.height);
		System.out.println(PokerSignalModel.HERO_CARDS_INDICATOR_SIZE.width);

		signalFrame.setLocation(PokerSignalModel.HERO_CARDS_INDICATOR_SIZE.height, PokerSignalModel.HERO_CARDS_INDICATOR_SIZE.width);
		signalFrame.setSize(PokerSignalModel.POKER_LIGHT_PANEL_SIZE.height,PokerSignalModel.POKER_LIGHT_PANEL_SIZE.width);
		tsPanel = new PokerSignalPanel();
		bPanel.setPokerSignalPanel(tsPanel);
		signalFrame.add(tsPanel.getTextPanel());
	}

	public void exitProcedure() {
		controlFrame.dispose();
		System.exit(0);
	}

	public JFrame getFrame() {
		return controlFrame;
	}

}