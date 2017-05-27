package org.sort.linear;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBarFactory {
	public static JMenuBar createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu shapesMenu = new JMenu("Shapes");
		JMenuItem circleShapeMenuItem = new JMenuItem("Circle");
		JMenuItem rectangleShapeMenuItem = new JMenuItem("Rectangle");
		JMenuItem triangleeShapeMenuItem = new JMenuItem("Triangle");
		shapesMenu.add(circleShapeMenuItem);
		shapesMenu.add(rectangleShapeMenuItem);
		shapesMenu.add(triangleeShapeMenuItem);
		menuBar.add(shapesMenu);
		return menuBar;
	}

}
