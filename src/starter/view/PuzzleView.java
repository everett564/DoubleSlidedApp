package starter.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import starter.model.EmptyTile;
import starter.model.Location;
import starter.model.Model;
import starter.model.Tile;

public class PuzzleView extends JPanel {

	Model model;
	int sqrLoc = 150;
	int sqrSize = 125;
	int offset_x = 50;
	int offset_y = 75;

	/**
	 * Constructor for PuzzleView Frame
	 * @param model: The model
	 */
	public PuzzleView(Model model) {
		this.model = model;
	}

	@Override
	public void paintComponent(Graphics g) {

		Font font = new Font("Trebuchet", Font.PLAIN, 48);
		g.setFont(font);

		// Empty Tile Construction
		EmptyTile emptyTile = model.getEmpty();
		Location emploc = emptyTile.getLocation();

		int x_emp = emploc.col * sqrLoc;
		int y_emp = emploc.row * sqrLoc;

		g.setColor(Color.orange);
		g.fillRect(x_emp, y_emp, sqrSize, sqrSize);

		// Regular Tiles Construction
		Tile[] tiles = model.getTiles();

		for (int i = 0; i < tiles.length; i++) {

			int digit = tiles[i].visibleDigit();
			Location loc = tiles[i].getLocation();

			int x = loc.col * sqrLoc;
			int y = loc.row * sqrLoc;

			if (tiles[i].isUp()) {
				g.setColor(Color.gray);
				g.fillRect(x, y, sqrSize, sqrSize);
				g.setColor(Color.black);
				g.drawString("" + digit, x + offset_x, y + offset_y);
			} else {
				g.setColor(Color.black);
				g.fillRect(x, y, sqrSize, sqrSize);
				g.setColor(Color.white);
				g.drawString("" + digit, x + offset_x, y + offset_y);

			}

		}
	}

}
