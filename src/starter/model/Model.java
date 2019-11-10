package starter.model;

public class Model {

	Tile tiles[] = new Tile[8]; // Tiles
	EmptyTile emptyTile; // The single Empty Tile
	int numberMoves = 0; // The number of moves made by the player

	/**
	 * Constructs the Model
	 */
	public Model() {

		tiles[0] = new Tile(4, 1, false, new Location(0, 0));
		tiles[1] = new Tile(2, 3, true, new Location(0, 1));
		tiles[2] = new Tile(2, 3, true, new Location(1, 0));
		tiles[3] = new Tile(3, 2, true, new Location(1, 1));
		tiles[4] = new Tile(1, 4, false, new Location(1, 2));
		tiles[5] = new Tile(4, 1, false, new Location(2, 0));
		tiles[6] = new Tile(3, 2, false, new Location(2, 1));
		tiles[7] = new Tile(1, 4, true, new Location(2, 2));

		emptyTile = new EmptyTile(new Location(0, 2));
	}

	/**
	 * Gets all of the tiles
	 * 
	 * @return Tile[]: returns the tiles array
	 */
	public Tile[] getTiles() {
		return tiles;
	}

	/**
	 * Gets the empty tile
	 * 
	 * @return EmptyTile: returns the emptyTile object
	 */
	public EmptyTile getEmpty() {
		return emptyTile;
	}

	/**
	 * Checks to see if the tile that was clicked neighbors the empty tile.
	 * 
	 * @param tile: the tile we are checking
	 * @return boolean: returns true if the given tile neighbors the empty tile
	 *         returns false if the given tile does not neighbor the empty tile
	 */
	public boolean neighboringEmpty(Tile tile) {
		int row = tile.location.row;
		int col = tile.location.col;

		// System.out.print(row);
		// System.out.print(col);

		int emp_row = emptyTile.loc.row;
		int emp_col = emptyTile.loc.col;

		// System.out.print(emp_row);
		// System.out.print(emp_col);

		if ((emp_row + 1 == row & emp_col == col) | (emp_row == row & emp_col + 1 == col)
				| (emp_row - 1 == row & emp_col == col) | (emp_row == row & emp_col - 1 == col)) {
			// System.out.print("True");
			return true;
		} else {
			// System.out.print("It was false");
			return false;
		}
	}

	/**
	 * Determines which tile has the given location
	 * 
	 * @param loc: a given location on the board
	 * @return Tile: returns which tile is found at that given location if one is
	 *         found returns null if a tile is not found
	 */
	public Tile whichTile(Location loc) {
		for (int i = 0; i < tiles.length; i++) {
			if (tiles[i].location.row == loc.row & tiles[i].location.col == loc.col) {
				return tiles[i];

			}
		}
		return null;
	}

	/**
	 * resets the board to the starting configuration
	 * 
	 * @return void
	 */
	public void reset() {

		tiles[0] = new Tile(4, 1, false, new Location(0, 0));
		tiles[1] = new Tile(2, 3, true, new Location(0, 1));
		tiles[2] = new Tile(2, 3, true, new Location(1, 0));
		tiles[3] = new Tile(3, 2, true, new Location(1, 1));
		tiles[4] = new Tile(1, 4, false, new Location(1, 2));
		tiles[5] = new Tile(4, 1, false, new Location(2, 0));
		tiles[6] = new Tile(3, 2, false, new Location(2, 1));
		tiles[7] = new Tile(1, 4, true, new Location(2, 2));

		emptyTile = new EmptyTile(new Location(0, 2));

		numberMoves = 0;
	}

	/**
	 * gets the current number of moves made
	 * 
	 * @return int: the total number of moves made
	 */
	public int getMoves() {
		return numberMoves;
	}

	/**
	 * increments the total number of moves
	 * 
	 * @return void
	 */
	public void incremMoves() {
		this.numberMoves = numberMoves + 1;
	}

	/**
	 * moves the tile from the empty space to a non empty space
	 * 
	 * @param tile: a given Tile
	 * @return void
	 */
	public void moveTile(Tile tile) {

		int tile_x = tile.location.row;
		int tile_y = tile.location.col;

		// move the tile given
		tile.location.setLocation(emptyTile.loc.row, emptyTile.loc.col);

		// flip the tile
		tile.flipTile();

		// move the empty tile
		emptyTile.loc.row = tile_x;
		emptyTile.loc.col = tile_y;

		// add one to the number of moves
		incremMoves();
	}

	/**
	 * Checks if the player won
	 * 
	 * @param tiles: the current board setup
	 * @param emp:   the empty tile
	 * @return boolean: true if the player won and false if they did not
	 */
	public boolean didWin(Tile[] tiles, EmptyTile emp) {
		// Answer
		Tile[] anstiles = new Tile[8];

		anstiles[0] = new Tile(4, 1, false, new Location(0, 0));
		anstiles[1] = new Tile(3, 2, false, new Location(0, 1));
		anstiles[2] = new Tile(2, 3, false, new Location(0, 2));
		anstiles[3] = new Tile(4, 1, true, new Location(1, 0));
		anstiles[4] = new Tile(1, 4, false, new Location(1, 2));
		anstiles[5] = new Tile(3, 2, true, new Location(2, 0));
		anstiles[6] = new Tile(2, 3, true, new Location(2, 1));
		anstiles[7] = new Tile(1, 4, true, new Location(2, 2));

		boolean val1 = false;
		boolean val2 = true;

		// check to make sure that the empty tile is in the center
		if (emp.loc.row == 1 && emp.loc.col == 1) {
			val1 = true;
		}
		// check the rest of the tiles
		for (int i = 0; i < anstiles.length; i++) {
			Location temp = anstiles[i].getLocation();
			Tile t = whichTile(temp);
			if(t == null) {
				val2 = false;
			}else if(areSame(t, anstiles[i])) {
				
			}else {
				val2 = false;
			}
		}
		return val1 & val2;
	}

	/**
	 * Checks if the player lost
	 * 
	 * @param tiles: the current board setup
	 * @return boolean: returns true if the player lost, returns false if they have
	 *         not lost
	 */
	public boolean didLose(Tile[] tiles) {
		int numone = 0;
		int numtwo = 0;
		int numthree = 0;
		int numfour = 0;
		int num = 0;

		for (int i = 0; i < tiles.length; i++) {
			num = tiles[i].visibleDigit();

			if (num == 1) {
				numone++;
			} else if (num == 2) {
				numtwo++;
			} else if (num == 3) {
				numthree++;
			} else {
				numfour++;
			}
		}

		if (numone > 3 || numtwo > 3 || numthree > 3 || numfour > 3) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if two tiles are the same
	 * 
	 * @param tile1: the first tile
	 * @param tile2: the second tile
	 * @return boolean: returns true if same, false if not
	 */
	public boolean areSame(Tile tile1, Tile tile2) {

		if (tile1.isUp == tile2.isUp & tile1.visibleDigit() == tile2.visibleDigit()) {
			return true;
		}

		return false;
	}
}
