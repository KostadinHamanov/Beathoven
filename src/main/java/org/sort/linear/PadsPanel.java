package org.sort.linear;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class PadsPanel extends JPanel {
	private static final boolean NOT_SELECTED = false;
	private static final String NO_LABEL = "";
	private static final int COLUMNS = 20;
	private static final int ROWS = 6;
	private static final int VERTICAL_GAP = 1;
	private static final int HORIZONTAL_GAP = 0;

	public PadsPanel() {
		setLayout(new GridLayout(ROWS, COLUMNS, HORIZONTAL_GAP, VERTICAL_GAP));
		final int GRID_SIZE = ROWS * COLUMNS;
		for (int i = 0; i < GRID_SIZE; i++) {
			JToggleButton button = new JToggleButton(NO_LABEL, NOT_SELECTED);
			add(button);
		}

	}
}
