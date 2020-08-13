package serialization.deserialization;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
public class SerializationClass {
	// create a method to serialize obj to Byte 
	public static void SerializeToFile (Object classObJect, String FileName) {
		// step 1. we need to create an object of FileOutPutStream class 
		// this object will used to write the serialized bytes of an object 
		try {
			FileOutputStream fileStream = new FileOutputStream(FileName);
		// step 2. we need to create an object of ObjectOutputStream class 
		// this object will used to convert the object of any type into a byte stream.
			ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
			// Step 3: ObjectOutputStream.writeObject method takes an Object and 
			// converts it into a ByteStream. Then it writes the Byte stream into
			// the file using the File stream that we created in step 1.
			objectStream.writeObject(classObJect);
			objectStream.close();
			fileStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}