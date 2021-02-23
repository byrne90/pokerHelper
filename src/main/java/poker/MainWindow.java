package poker;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class MainWindow extends JFrame {

	protected ButtonPanel bPanel;

	protected PokerSignalPanel tsPanel;

	protected JFrame frame;

	public MainWindow() {
		createPartControl();
	}

	protected void createPartControl() {
		tsPanel = new PokerSignalPanel();
		bPanel = new ButtonPanel();

		bPanel.setTrafficSignalPanel(tsPanel);

		frame = new JFrame();
		frame.setTitle("Traffic Signal");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				exitProcedure();
			}
		});

		frame.setLayout(new FlowLayout());
		frame.add(bPanel.getPanel());
		frame.add(tsPanel.getPanel());
		frame.pack();
//	      frame.setBounds(100, 100, 400, 200);
		frame.setVisible(true);
	}

	public void exitProcedure() {
		frame.dispose();
		System.exit(0);
	}

	public JFrame getFrame() {
		return frame;
	}

}