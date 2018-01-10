import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		String line = null;
	
		File f = new File("test.txt");
		FileReader fr = new FileReader(f); //file reader object takes parameter as location of the plaintext file in the constructor
		BufferedReader test = new BufferedReader(fr); //is a wrapper class for the FileReader that allows more functionality


		while((line = test.readLine()) != null) {	
			System.out.println(line);
		}						
	}
}

