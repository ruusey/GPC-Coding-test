package common;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

public class MarsRover {
	private Vector2D pos;
	private Cardinality heading;

	public MarsRover(String input) {
		String[] parts = input.split(" ");
		try {
			this.pos = new Vector2D(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
			this.heading = Cardinality.valueOf(parts[2]);
		} catch (Exception e) {
			System.out.println("Unable to construct plateau [" + input + "] is not a valid plateau format.");
		}
	}

	// Take in a line of navigation instructions and attempt to move the rover
	public void navigate(String input, Vector2D upperBound) {
		String[] parts = input.split("");
		List<Rotation> movements = new ArrayList<>();
		for (String part : parts) {
			movements.add(Rotation.valueOf(part));
		}
		moveRover(movements, upperBound);
	}

	// Logic for handling rotation vs moving the rover forward
	private void moveRover(List<Rotation> movements, Vector2D upperBound) {
		for (Rotation movement : movements) {
			if (movement == Rotation.M) {
				if (this.canMove(upperBound, heading.getDirection()))
					this.pos = this.pos.add(heading.getDirection());
				else
					System.out.println("Unable to move rover forward! It would fall off the plateu!");

			} 
			else
				this.heading = this.heading.rotate(movement);
		}
	}

	// Can this instance of MarsRover move forward in the desired direction without
	// falling off the plateau?
	private boolean canMove(Vector2D upperBound, Vector2D newPos) {
		Vector2D toMove = this.pos.add(newPos);
		if (toMove.getX() <= upperBound.getX() && toMove.getX() >= 0 && toMove.getY() <= upperBound.getY()
				&& toMove.getY() >= 0)
			return true;
		else
			return false;
	}
	public Vector2D getPos() {
		return this.pos;
	}

	public void print() {
		System.out.println((int) this.pos.getX() + " " + (int) this.pos.getY() + " " + this.heading.name());
	}

	public String printStr() {
		return ((int) this.pos.getX() + " " + (int) this.pos.getY() + " " + this.heading.name());
	}

}
