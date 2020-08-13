package serialization.deserialization;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		Square square = new Square (10,15);
	SerializationClass.SerializeToFile(square, "squarSerialized");
		// after running this we should refresh our projict and at the end Square serliation will be created.
	
	//  deserialize the above fiel using below.
	
	Square deserializeSquare = (Square)DeserializationClass.DeserializeFromFileToObject("squarSerialized");
	
	System.out.println("Square area is : "+  deserializeSquare.Area());
	
	}

}
