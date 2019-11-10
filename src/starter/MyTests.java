package starter;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import org.junit.jupiter.api.Test;

import starter.controller.FlipController;
import starter.controller.ResetController;
import starter.model.EmptyTile;
import starter.model.Location;
import starter.model.Model;
import starter.model.Tile;
import starter.view.DoubleSlidedApp;
import starter.view.PuzzleView;

// REQUIRED CODE COVERAGE: 80%

public class MyTests {

	// Main
	@Test
	public void testMain() {
		Main m = new Main();
	}
	
	// Flip Controller Tests
	@Test
	public void testFlipController() {
		Model m = new Model();
		DoubleSlidedApp app = new DoubleSlidedApp(m);
		FlipController fc = new FlipController(app, m);

		// Standard Mouse Event
		MouseEvent me = new MouseEvent(app, 0, 0, 0, 0, 0, 0, false);
		fc.mousePressed(me);

		// One inside the range
		MouseEvent me1 = new MouseEvent(app, 100, 100, 100, 100, 100, 1, false);
		fc.mousePressed(me1);

		MouseEvent me2 = new MouseEvent(app, 100, 100, 150, 150, 100, 1, false);
		fc.mousePressed(me2);
		
		MouseEvent me3 = new MouseEvent(app, 100, 100, 300, 300, 300, 1, false);
		fc.mousePressed(me3);
		
		MouseEvent me4 = new MouseEvent(app, 100, 100, 250, 250, 250, 1, false);
		fc.mousePressed(me4);
		
		MouseEvent me5 = new MouseEvent(app, 100, 100, 250, 425, 425, 1, false);
		fc.mousePressed(me5);

		MouseEvent me6 = new MouseEvent(app, 100, 100, 285, 285, 285, 1, false);
		fc.mousePressed(me6);
	}

	// Reset Controller Tests
	@Test
	public void testResetController() {
		Model m = new Model();
		DoubleSlidedApp app = new DoubleSlidedApp(m);
		ResetController r = new ResetController(app, m);
	}

	@Test
	public void testResetControllerReset() {
		Model m = new Model();
		DoubleSlidedApp app = new DoubleSlidedApp(m);
		ResetController r = new ResetController(app, m);

		r.reset();
	}

	// DoubleSlidedApp Class Tests
	@Test
	public void testDoubleSlidedApp() {
		Model m = new Model();
		DoubleSlidedApp app = new DoubleSlidedApp(m);

	}

	// Location Class Tests
	@Test
	public void testCheckLocation() {
		Location loc = new Location(3, 5);
		loc.setLocation(4, 4);
		assertTrue(loc.row == 4 & loc.col == 4);
		assertFalse(loc.row == 3);
		assertFalse(loc.col == 5);
	}

	// Empty Tile Class Tests
	@Test
	public void testGetEmptyLocation() {
		EmptyTile emp = new EmptyTile(new Location(1, 2));
		assertTrue(emp.getLocation().row == 1 & emp.getLocation().col == 2);
	}

	// Tile Class Tests
	@Test
	public void testSetLocation() {
		Tile t = new Tile(1, 4, true, new Location(0, 0));

		t.setLocation(new Location(4, 4));

		assertTrue(t.getLocation().row == 4 & t.getLocation().col == 4);
	}

	@Test
	public void testGetLocation() {
		Tile t = new Tile(1, 4, true, new Location(0, 0));

		assertTrue(t.getLocation().row == 0 & t.getLocation().col == 0);
	}

	@Test
	public void testVisibleDigit() {
		Tile t = new Tile(1, 4, true, new Location(0, 0));
		assertTrue(t.visibleDigit() == 1);
		assertFalse(t.visibleDigit() == 4);

		Tile t1 = new Tile(1, 4, false, new Location(0, 0));
		assertTrue(t1.visibleDigit() == 4);
		assertFalse(t1.visibleDigit() == 1);
	}

	@Test
	public void testIsUp() {
		Tile t1 = new Tile(1, 4, false, new Location(0, 0));
		assertTrue(t1.isUp());
		Tile t2 = new Tile(1, 4, true, new Location(0, 0));
		assertTrue(t2.isUp() == false);
	}

	@Test
	public void testFlipTile() {
		Tile t3 = new Tile(1, 4, true, new Location(0, 0));
		t3.flipTile();
		assertTrue(t3.isUp());
		t3.flipTile();
		assertTrue(!t3.isUp());
	}

	// Model Class Tests
	@Test
	public void testNeighboringEmpty() {
		Model m = new Model();

		m.getEmpty().setLocation(new Location(0, 1));
		Tile[] t = m.getTiles();
		t[0].setLocation(new Location(0, 0));

		assertTrue(m.neighboringEmpty(t[0]));
	}
	
//	// PuzzleView Tests
//	@Test
//	public void testPuzzleView() {
//		Model m = new Model();
//		JPanel j = new JPanel();
//		PuzzleView pv = new PuzzleView(m);
//		Graphics g = j.getGraphics();
//		pv.paintComponent(g);
//	}

}
