package org.sort.linear.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class SimplePaint extends JApplet {

	private static JFrame window;
	private static SimplePaintPanel content;

	public static void main(String[] args) {
		JMenuBar menuBar = new JMenuBar();
		JMenu save = new JMenu("Save");
		JMenu start = new JMenu("Start");
		menuBar.add(save);
		menuBar.add(start);

		start.addMenuListener(new MenuListener() {

			@Override
			public void menuSelected(MenuEvent arg0) {
				content.getLocation().setLocation(0, 0);
			}

			@Override
			public void menuCanceled(MenuEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void menuDeselected(MenuEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		window = new JFrame("Simple Paint");
		content = new SimplePaintPanel();
		window.setContentPane(content);
		window.setSize(720, 480);
		window.setLocation(100, 100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		window.add(menuBar);

	}

	public void init() {
		setContentPane(new SimplePaintPanel());
	}

	public static class SimplePaintPanel extends JPanel implements MouseListener, MouseMotionListener {

		private final static int BLACK = 0, RED = 1, GREEN = 2, BLUE = 3, MAGENTA = 4, YELLOW = 5;

		private int currentColor = BLACK; // The currently selected drawing
											// color,
											// coded as one of the above
											// constants.

		private int prevX, prevY; // The previous location of the mouse.

		private boolean dragging; // This is set to true while the user is
									// drawing.

		private Graphics graphicsForDrawing; // A graphics context for the panel
		// that is used to draw the user's curve.

		SimplePaintPanel() {
			setBackground(Color.WHITE);
			addMouseListener(this);
			addMouseMotionListener(this);
		}

		public void paintComponent(Graphics g) {

			super.paintComponent(g); // Fill with background color (white).

			int width = getWidth(); // Width of the panel.
			int height = getHeight(); // Height of the panel.

			int colorSpacing = (height - 56) / 6;

			g.setColor(Color.GRAY);
			g.drawRect(0, 0, width - 1, height - 1);
			g.drawRect(1, 1, width - 3, height - 3);
			g.drawRect(2, 2, width - 5, height - 5);

			g.fillRect(width - 56, 0, 56, height);

			g.setColor(Color.WHITE);
			g.fillRect(width - 53, height - 53, 50, 50);
			g.setColor(Color.BLACK);
			g.drawRect(width - 53, height - 53, 49, 49);
			g.drawString("CLEAR", width - 48, height - 23);

			g.setColor(Color.BLACK);
			g.fillRect(width - 53, 3 + 0 * colorSpacing, 50, colorSpacing - 3);
			g.setColor(Color.RED);
			g.fillRect(width - 53, 3 + 1 * colorSpacing, 50, colorSpacing - 3);
			g.setColor(Color.GREEN);
			g.fillRect(width - 53, 3 + 2 * colorSpacing, 50, colorSpacing - 3);
			g.setColor(Color.BLUE);
			g.fillRect(width - 53, 3 + 3 * colorSpacing, 50, colorSpacing - 3);
			g.setColor(Color.MAGENTA);
			g.fillRect(width - 53, 3 + 4 * colorSpacing, 50, colorSpacing - 3);
			g.setColor(Color.YELLOW);
			g.fillRect(width - 53, 3 + 5 * colorSpacing, 50, colorSpacing - 3);

			g.setColor(Color.WHITE);
			g.drawRect(width - 55, 1 + currentColor * colorSpacing, 53, colorSpacing);
			g.drawRect(width - 54, 2 + currentColor * colorSpacing, 51, colorSpacing - 2);

		} // end paintComponent()

		private void changeColor(int y) {

			int width = getWidth(); // Width of applet.
			int height = getHeight(); // Height of applet.
			int colorSpacing = (height - 56) / 6; // Space for one color
													// rectangle.
			int newColor = y / colorSpacing; // Which color number was clicked?

			if (newColor < 0 || newColor > 6) // Make sure the color number is
												// valid.
				return;

			Graphics g = getGraphics();
			g.setColor(Color.GRAY);
			g.drawRect(width - 55, 1 + currentColor * colorSpacing, 53, colorSpacing);
			g.drawRect(width - 54, 2 + currentColor * colorSpacing, 51, colorSpacing - 2);
			currentColor = newColor;
			g.setColor(Color.WHITE);
			g.drawRect(width - 55, 1 + currentColor * colorSpacing, 53, colorSpacing);
			g.drawRect(width - 54, 2 + currentColor * colorSpacing, 51, colorSpacing - 2);
			g.dispose();

		} // end changeColor()

		private void setUpDrawingGraphics() {
			graphicsForDrawing = getGraphics();
			switch (currentColor) {
			case BLACK:
				graphicsForDrawing.setColor(Color.BLACK);
				break;
			case RED:
				graphicsForDrawing.setColor(Color.RED);
				break;
			case GREEN:
				graphicsForDrawing.setColor(Color.GREEN);
				break;
			case BLUE:
				graphicsForDrawing.setColor(Color.BLUE);
				break;
			case MAGENTA:
				graphicsForDrawing.setColor(Color.MAGENTA);
				break;
			case YELLOW:
				graphicsForDrawing.setColor(Color.YELLOW);
				break;
			}
		} // end setUpDrawingGraphics()

		public void mousePressed(MouseEvent evt) {

			int x = evt.getX(); // x-coordinate where the user clicked.
			int y = evt.getY(); // y-coordinate where the user clicked.

			int width = getWidth(); // Width of the panel.
			int height = getHeight(); // Height of the panel.

			if (dragging == true) // Ignore mouse presses that occur
				return; // when user is already drawing a curve.
						// (This can happen if the user presses
						// two mouse buttons at the same time.)

			if (x > width - 53) {
				// User clicked to the right of the drawing area.
				// This click is either on the clear button or
				// on the color palette.
				if (y > height - 53)
					repaint(); // Clicked on "CLEAR button".
				else
					changeColor(y); // Clicked on the color palette.
			} else if (x > 3 && x < width - 56 && y > 3 && y < height - 3) {
				prevX = x;
				prevY = y;
				dragging = true;
				setUpDrawingGraphics();
			}

		} // end mousePressed()

		public void mouseReleased(MouseEvent evt) {
			if (dragging == false)
				return; // Nothing to do because the user isn't drawing.
			dragging = false;
			graphicsForDrawing.dispose();
			graphicsForDrawing = null;
		}

		public void mouseDragged(MouseEvent evt) {

			if (dragging == false)
				return; // Nothing to do because the user isn't drawing.

			int x = evt.getX(); // x-coordinate of mouse.
			int y = evt.getY(); // y-coordinate of mouse.

			if (x < 3) // Adjust the value of x,
				x = 3; // to make sure it's in
			if (x > getWidth() - 57) // the drawing area.
				x = getWidth() - 57;

			if (y < 3) // Adjust the value of y,
				y = 3; // to make sure it's in
			if (y > getHeight() - 4) // the drawing area.
				y = getHeight() - 4;

			graphicsForDrawing.drawLine(prevX, prevY, x, y); // Draw the line.

			prevX = x; // Get ready for the next line segment in the curve.
			prevY = y;

		} // end mouseDragged()

		public void mouseEntered(MouseEvent evt) {
		} // Some empty routines.

		public void mouseExited(MouseEvent evt) {
		} // (Required by the MouseListener

		public void mouseClicked(MouseEvent evt) {
		} // and MouseMotionListener

		public void mouseMoved(MouseEvent evt) {
		} // interfaces).

	} // End class SimplePaintPanel
} // end class SimplePaint