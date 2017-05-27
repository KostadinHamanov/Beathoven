package org.sort.linear.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.sort.linear.sound.SoundParser;

public class MenuBarFactory {
	public static JMenuBar createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu shapesMenu = new JMenu("Shapes");
		JMenuItem circleShapeMenuItem = new JMenuItem("Circle");
		JMenuItem rectangleShapeMenuItem = new JMenuItem("Rectangle");
		JMenuItem triangleeShapeMenuItem = new JMenuItem("Triangle");
		JMenu start = new JMenu("Start");
		shapesMenu.add(circleShapeMenuItem);
		shapesMenu.add(rectangleShapeMenuItem);
		shapesMenu.add(triangleeShapeMenuItem);
		menuBar.add(shapesMenu);
		menuBar.add(start);
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					SoundParser.parse(PadsPanel.getButtons());
				} catch (MidiUnavailableException exception) {
					// TODO Auto-generated catch block
					exception.printStackTrace();
				} catch (InterruptedException exception) {
					// TODO Auto-generated catch block
					exception.printStackTrace();
				}
			}
		});
		return menuBar;
	}

}
