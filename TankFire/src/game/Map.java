package game; 
import java.awt.Point;

public class Map {
	
	double height = 15; // in km
	double width = 9;	// in km
		
	
	public Map() {
		
	}

	public Map(double height, double width) {
		
		this.height = height;
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}
	
	
	public Point getField(double x,double y) {
		double i = 0;
		int _x = 0,_y = 0;
		i = x/1000;
		_x = (int) (i);
		i = y/1000;
		_y = (int) (i);
		Point point = new Point(_x,_y);
		return point;		
	}
	


}
