import java.io.*;

public class FileTest {

	public static void main(String[] args) throws IOException {
		String line = null;
		String[] lines = new String[	

		try {
			FileReader fr = new FileReader("test.txt"); //file reader object takes parameter as location of the plaintext file in the constructor
			BufferedReader test = new BufferedReader(fr); //is a wrapper class for the FileReader that allows more functionality
			
			while ((line = test.readLine()) != null) {
				System.out.println(line);
			}

		} catch (FileNotFoundException e) {
			System.out.println("u dun goofed");
		}


							
	}
}

