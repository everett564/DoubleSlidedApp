package starter.model;

public class Location {
	public int row; // row
	public int col; // column

	/**
	 * The location constructor
	 * 
	 * @param row: the row
	 * @param col: the column
	 */
	public Location(int row, int col) {
		this.row = row;
		this.col = col;
	}

	/**
	 * sets the location
	 * 
	 * @param row: the new row
	 * @param col: the new column
	 * @return void
	 */
	public void setLocation(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
