package starter.model;

public class EmptyTile {
	Location loc; // location of the empty tile

	/**
	 * The Empty Tile constructor
	 * 
	 * @param loc: the location of the empty tile
	 */
	public EmptyTile(Location loc) {
		this.loc = loc;
	}

	/**
	 * Gets the location of the empty tile
	 * 
	 * @param Location: the location
	 */
	public Location getLocation() {
		return this.loc;
	}

	/**
	 * Sets the location of the Empty Tile
	 * 
	 * @param new_loc: the new location
	 * @return void
	 */
	public void setLocation(Location new_loc) {
		this.loc = new_loc;
	}
}
