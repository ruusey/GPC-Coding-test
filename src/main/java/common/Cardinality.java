package common;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

public enum Cardinality {
	N(new Vector2D(0, 1)), S(new Vector2D(0, -1)), E(new Vector2D(1, 0)), W(new Vector2D(-1, 0));

	private Vector2D direction;

	private Cardinality(Vector2D direction) {
		this.direction = direction;
	}

	public Vector2D getDirection() {
		return this.direction;
	}

	public Cardinality rotate(Rotation rotation) {
		switch (this) {
		case N:
			if (rotation == Rotation.L)
				return W;
			else if (rotation == Rotation.R)
				return E;
			else
				return N;
		case S:
			if (rotation == Rotation.L)
				return E;
			else if (rotation == Rotation.R)
				return W;
			else
				return S;
		case E:
			if (rotation == Rotation.L)
				return N;
			else if (rotation == Rotation.R)
				return S;
			else
				return E;
		case W:
			if (rotation == Rotation.L)
				return S;
			else if (rotation == Rotation.R)
				return N;
			else
				return W;
		default:
			return this;

		}
	}

}
