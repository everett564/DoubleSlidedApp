package starter.controller;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import starter.model.Location;
import starter.model.Model;
import starter.model.Tile;
import starter.view.DoubleSlidedApp;

public class FlipController extends MouseAdapter {
	Model model;         // The model
	DoubleSlidedApp app; // The application

	/**
	 * The Flip Controller Constructor
	 * 
	 * @param app:   the Double Sided Application
	 * @param model: the model
	 */
	public FlipController(DoubleSlidedApp app, Model model) {
		this.app = app;
		this.model = model;
	}

	/**
	 * The mousePressed Event
	 * 
	 * @param me:  a Mouse pressed event
	 * @param void
	 */
	public void mousePressed(MouseEvent me) {

		// Determine the location of the click
		Location loc = whichTilePressed(me);

		// Account for if that location exists outside of bounds
		if (loc == null) {

		} else {
			// determine which tile exists in that location
			Tile tile = model.whichTile(loc);
			if (tile == null) {

			} else {

				if (model.neighboringEmpty(tile)) {
					// move the given tile
					if(!model.didLose(model.getTiles()) & !model.didWin(model.getTiles(), model.getEmpty())) {
						model.moveTile(tile);
					}
					// check win/loss
					if(model.didLose(model.getTiles())){
						// run loss condition stuff
						// Is this good coding practice?
						JOptionPane.showMessageDialog(null, "You have lost the game!");
					}else if(model.didWin(model.getTiles(), model.getEmpty())) {
						// run win condition stuff
						// Is this good coding practice?
						JOptionPane.showMessageDialog(null, "Congratulations! You have won the game in " + model.getMoves() +" moves!");

					}
					app.numberMovesLabel.setText(""+ model.getMoves());
					app.repaint();
					//System.out.print("Repainted");
				}
			}

		}

	}

	/**
	 * Determines the location of which tile was pressed in location form
	 * 
	 * @param me: a mouse event
	 * @return Location: the location of the press
	 */
	public Location whichTilePressed(MouseEvent me) {

		// initialize outside of normal bounds
		int row = 5;
		int col = 5;

		// determine click location
		int x = me.getX();
		int y = me.getY();

		Location loc = new Location(5, 5);

		// logic for which area was outside of bounds
		if (x > 0 & x < 425 & y > 0 & y < 425) {

			if (x > 0 & x < 140) {
				col = 0;
			} else if (x >= 140 & x < 285) {
				col = 1;
			} else {
				col = 2;
			}

			if (y > 0 & y < 140) {
				row = 0;
			} else if (y >= 140 & y < 285) {
				row = 1;
			} else {
				row = 2;
			}

			loc.setLocation(row, col);

			return loc;
		}

		return null;
	}
}
