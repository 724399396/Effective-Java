package overridequlas;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

public class ColorPoint extends Point {
	private final Color color;
	
	public ColorPoint(int x, int y, Color color) {
		super(x,y);
		this.color = color;
	}
	
	// Broken - violates transitivity!
	@Override public boolean equals(Object o) {
		if (!(o instanceof Point))
			return false;
		// If o is a normal Point, do a color-blind comparison ºöÂÔÑÕÉ«±È½Ï
		if (!(o instanceof ColorPoint))
			return o.equals(this);
		// o is a ColorPoint; do a full comparison
		return super.equals(o) && ((ColorPoint)o).color == color;
	}
	
	
	// Initialize UnitCircle to contain all Points on the unit circle
	private static final Set<Point> unitCircle;
	static {
		unitCircle = new HashSet<>();
		unitCircle.add(new Point(1, 0));
		unitCircle.add(new Point(0, 1));
		unitCircle.add(new Point(-1, 0));
		unitCircle.add(new Point(0, -1));
	}
	
	public static boolean onUnitCircle(Point p) {
		return unitCircle.contains(p);
	}
	
		
	public static void main(String[] args) {
		Point p = new Point(1, 2);
		ColorPoint cp = new ColorPoint(1, 2, Color.RED);
		System.out.println(p.equals(cp));
		System.out.println(cp.equals(p));
		
		ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
		Point p2 = new Point(1,2);
		ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
		System.out.println(p1.equals(p2));
		System.out.println(p2.equals(p3));
		System.out.println(p1.equals(p3));
	}
}
