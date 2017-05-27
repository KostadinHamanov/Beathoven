package org.sort.linear.gui;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

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
		start.addMenuListener(new MenuListener() {

			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
				try {
					SoundParser.parse(PadsPanel.getButtons());
				} catch (MidiUnavailableException | InterruptedException exception) {
					// TODO Auto-generated catch block
					exception.printStackTrace();
				}

			}

			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub

			}
		});

		return menuBar;
	}

}
