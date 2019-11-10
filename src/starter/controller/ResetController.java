package starter.controller;

import starter.model.Model;
import starter.view.DoubleSlidedApp;

public class ResetController {
	Model model; // The model
	DoubleSlidedApp app; // The application

	/**
	 * Constructor for the reset Controller
	 * 
	 * @param app:   the application
	 * @param model: the model
	 */
	public ResetController(DoubleSlidedApp app, Model model) {
		this.app = app;
		this.model = model;
	}

	/**
	 * Resets the board
	 * 
	 * @return void
	 */
	public void reset() {
		model.reset();
		app.numberMovesLabel.setText(""+ model.getMoves());
		app.repaint();
	}
}