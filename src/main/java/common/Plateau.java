package common;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

public class Plateau {
	private Vector2D p1;

	// Constructor for a plateau from a line in a file
	public Plateau(String input) {
		String[] parts = input.split(" ");
		try {
			this.p1 = new Vector2D(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
		} catch (Exception e) {
			System.out.println("Unable to construct plateau [" + input + "] is not a valid plateau format.");
		}
	}

	public Vector2D getUpperBound() {
		return this.p1;
	}

}
