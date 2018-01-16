package login;

import java.io.*;
import java.util.ArrayList;

public class Login {
	
	private String _username;
	private String _password;
	private String _fileName;
	private ArrayList<String> _usernames;
	private int _userLocation;

	public Login() {
		_userLocation = -1;
		_username = "user";
		_password = "password";
		_fileName = "data.txt";
		_usernames = new ArrayList<String>();
	}

	public Login(String fileName) {
		this();
		_fileName = fileName;
	}
	
	public Login(String user, String pass, String fileName) {
		this(fileName);
		_username = user;
		_password = pass;
	}
	
	//sets the path to the file to look for info in
	public void setPath(String path) {
		_fileName = path;
	}

	//when performing actions that require you to re-verify your credentials
	public boolean checkUser(String user) {
		return user.equals(_username);
	}

	public boolean checkPass(String pass) {
		return pass.equals(_password);
	}

	//set the _username intance variable once its confirmed it exists
	private void setUser(String user) {
		_username = user;
	}

	//set the _password instance variable once its verified 
	private void setPass(String pass) {
		_password = pass;
	}

	//checks for the existence of a user
	public boolean checkUserExists(String user) throws IOException {
		String line = null;

		try {
			FileReader fr = new FileReader(_fileName);
			BufferedReader file = new BufferedReader(fr);

			while ((line = file.readLine()) != null) {
				_usernames.add(line);
			}

			//uncoment to print out the contents of the file, for debugging and testing purposes
			/*for (int i = 0; i < _usernames.size(); i++) {
				System.out.println(_usernames.get(i));
			} */

			_userLocation = _usernames.indexOf(user);

			return _usernames.indexOf(user) != -1;

		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND ERROR");
			return false;
		}
	}

	public boolean verifyPassword(String pass) throws IOException {
		String line = null;
		ArrayList<String> passwords = new ArrayList<String>();

		try {
		
			FileReader fr = new FileReader(_fileName);
			BufferedReader file = new BufferedReader(fr);

			while((line = file.readLine()) != null) {
				passwords.add(line);
			}

			String correctPass = passwords.get(_userLocation);

			return correctPass.equals(pass);
			
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND ERROR");
			return false;
		}


	}

	public static void main(String[] args) throws IOException {
		Login test = new Login("test", "test", "data.txt");
		boolean meme = test.checkUserExists("test");
		System.out.println(meme);
	}
}

