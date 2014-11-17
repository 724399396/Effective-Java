package classHierarchy;

// Class hierarchy replacement for a tagged class
abstract class GoodFigure {
	abstract double area();
}

class Circle extends GoodFigure {
	final double radius;
	Circle(double radius) { this.radius = radius; }
	double area() { return Math.PI * (radius * radius); }
}

class Rectangle extends GoodFigure {
	final double length;
	final double width;
	Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	double area() { return length * width; }
}

class Square extends Rectangle {
	Square(double size) {
		super(size, size);
	}
}
