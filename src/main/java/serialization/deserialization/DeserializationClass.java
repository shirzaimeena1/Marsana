package serialization.deserialization;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
public class DeserializationClass {
	public static Object DeserializeFromFileToObject(String fileName) {
		try {
			// step 1 create a FileInputStream obj to read from serialized content
			FileInputStream fileStream = new FileInputStream(new File(fileName));
			// step 2 create a ObjectInputStream obj to so the content of file can be
			// converted to Square object
			ObjectInputStream objectStream = new ObjectInputStream(fileStream);
			// step 3 Read the content of the stream and convert it into object
			Object deserializeObject = objectStream.readObject();
			// step 4 close all the resources
			objectStream.close();
			fileStream.close();
			return deserializeObject;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}