package accounts;

import java.io.*;
import java.util.ArrayList;

public class Teacher {
	
	//Name related stuff
	private String _firstName;
	private String _middleInitial;
	private String _lastName;
	
	//_sex
	private String _sex; //male or female

	//login info
	private String _user;
	private String _password;

	//Class list
	private ArrayList<String> _students;

	//Teacher type
	//0 - Science
	//1 - Math
	//2 - History
	//3 - English
	//4 - Computer Science
	private int _subject;

	public Teacher() {
	
		_firstName = "John";
		_lastName = "Doe";
		_middleInitial = "";

		_sex = "male";

		_user = "jdoe1";
		_password = "password";
		_subject = 0;
	}

	public Teacher(ArrayList<String> info) {
	
		_firstName = info.get(0);
		_middleInitial = info.get(1);
		_lastName = info.get(2);

		_sex = info.get(3);

		_user = info.get(4);
		_password = info.get(5);
		
		_subject = Integer.parseInt(info.get(6));
		
		_students = new ArrayList<String>();		

		for (int i = 7; i < info.size(); i++) {
			_students.add(info.get(i));
		}

		
	}
	
/*	public Teacher (String fName, String lName, String maleOrFemale, String user, String pass) {

		_firstName = fName;
		_lastName = lName;
		_middleInitial  = "";
		_sex = maleOrFemale;
		_user = user;
		_password = pass;

	}

	public Teacher(String fName, String mInitial, String lName, String maleOrFemale, String user, String pass) {

		this(fName, lName, maleOrFemale, user, pass);

		_middleInitial = mInitial;
	}
*/
	public String toString() {
		if (_middleInitial.length() > 0) 
			return _firstName + " " + _middleInitial + " " + _lastName;
		return _firstName + " " + _lastName;
	}
		
}
