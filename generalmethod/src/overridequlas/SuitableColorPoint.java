package overridequlas;

import java.awt.Color;

// Adds a value component without violating the equals contract
public class SuitableColorPoint {
	private final Point point;
	private final Color color;
	
	public SuitableColorPoint(int x, int y, Color color) {
		if (color == null)
			throw new NullPointerException();
		point = new Point(x, y);
		this.color = color;
	}
	
	/**
	 * Returns the point-view of this color point.
	 */
	public Point asPoint(){
		return point;
	}
	
	@Override public boolean equals(Object o) {
		if (!(o instanceof SuitableColorPoint))
			return false;
		SuitableColorPoint cp = (SuitableColorPoint)o;
		return cp.point.equals(point) && cp.color.equals(color);
	}
}
