package common;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

public class Plateau {
	private Vector2D p0 = new Vector2D(0, 0);
	private Vector2D p1;
	private List<MarsRover> rovers = new ArrayList<>();

	public Plateau(String input) {
		String[] parts = input.split(" ");
		try {
			this.p1 = new Vector2D(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
		} catch (Exception e) {
			System.out.println("Unable to construct plateau [" + input + "] is not a valid plateau format.");
		}
	}

//	public void addRover(String input) {
//		String[] parts = input.split(" ");
//		try {
//			Vector2D roverPos = new Vector2D(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
//			rovers.add(new MarsRover(roverPos, Cardinality.valueOf(parts[2])));
//		} catch (Exception e) {
//			System.out.println("Unable to add rover [" + input + "] is not a valid rover format.");
//		}
//
//	}

	public static boolean canMove(MarsRover rover, Vector2D upperBound, Vector2D newPos) {
		Rectangle rect = new Rectangle(0, 0, (int) upperBound.getX(), (int) upperBound.getY());
		Vector2D toMove = rover.getPos().add(newPos);
		return rect.contains((int) toMove.getX(), (int) toMove.getY());
	}

	public Vector2D getUpperBound() {
		return this.p1;
	}

}
