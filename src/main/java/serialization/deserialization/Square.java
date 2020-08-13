package serialization.deserialization;

import java.io.Serializable;

public class Square implements Serializable  {  // we have to implement from serializable 
	
	private double height;
	private double width;
	public Square(double height,double width) {
		
		this.height = height;
		this.width = width;
	}

	
	// this method retun  area of square
	public double Area() {
		return height *width;
	}
	
	// 
}
