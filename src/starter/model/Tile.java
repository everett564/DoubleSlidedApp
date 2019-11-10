package starter.model;

public class Tile {

	final int up;      // top number
	final int down;    // bottom number
	boolean isUp;      // if the tile is flipped or not
	Location location; // location of the tile

	/**
	 * Tile Constructor
	 * 
	 * @param up:   the top number
	 * @param down: the bottom number
	 * @param isUp: if the tile is flipped or not
	 * @param loc:  the location of the tile
	 */
	public Tile(int up, int down, boolean isUp, Location loc) {
		this.up = up;
		this.down = down;
		this.isUp = isUp;
		this.location = loc;
	}

	/**
	 * Sets the location of the tile
	 * 
	 * @param loc: the new location of the tile
	 * @return void
	 */
	public void setLocation(Location loc) {
		this.location = loc;
	}

	/**
	 * Gets the location of the tile
	 * 
	 * @return Location: the location of the tile
	 */
	public Location getLocation() {
		return this.location;
	}

	/**
	 * Gets the visible digit on the tile
	 * 
	 * @return int: the visible digit on the tile
	 */
	public int visibleDigit() {
		if (this.isUp) {
			return this.up;
		} else {
			return this.down;
		}
	}

	/**
	 * Checks if the tile is face up
	 * 
	 * @return boolean: if it is up
	 */
	public boolean isUp() {
		return !this.isUp;
	}

	/**
	 * Flips the tile
	 * 
	 * @return void
	 */
	public void flipTile() {
		this.isUp = !this.isUp;
	}

}
