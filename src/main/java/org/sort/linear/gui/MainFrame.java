package org.sort.linear.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

@Path("/main")
public class MainFrame {
	private static final int WIDTH = 720;
	private static final int HEIGHT = 480;
	private JFrame frame;
	private static final String FRAME_TITLE = "Beathoven";

	public MainFrame() {
		frame = new JFrame(FRAME_TITLE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		setDefaultLookAndFeel(frame);
		frame.setJMenuBar(MenuBarFactory.createMenu());
		frame.add(new PadsPanel(), BorderLayout.CENTER);
		frame.setVisible(true);
		frame.requestFocus();
	}

	public static void setDefaultLookAndFeel(JFrame frame) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				MainFrame mainFrame = new MainFrame();

			}
		});
	}

}