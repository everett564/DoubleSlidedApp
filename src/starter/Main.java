package starter;

import starter.model.Model;
import starter.view.DoubleSlidedApp;

public class Main {

	/**
	 * Main Method
	 * @param args: Arguments
	 */
	public static void main(String[] args) {
		Model model = new Model();
		DoubleSlidedApp dsa = new DoubleSlidedApp(model);

		dsa.setVisible(true);
	}

}
