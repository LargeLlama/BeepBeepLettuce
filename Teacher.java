public class Teacher {
	
	//Name related stuff
	private String _firstName;
	private String _middleInitial;
	private String _lastName;
	
	//_sex
	private String _sex; //male or female

	//login info
	private String _email;
	private String _password;

	public Teacher() {
	
		_firstName = "John";
		_lastName = "Doe";
		_middleInitial = "";

		_sex = "male";

		_email = "jdoe@gmail.com";
		_password = "_password";
	
	}
	
	public Teacher (String fName, String lName, String maleOrFemale, String user, String pass) {

		_firstName = fName;
		_lastName = lName;
		_middleInitial  = "";
		_sex = maleOrFemale;
		_email = user;
		_password = pass;

	}

	public Teacher(String fName, String mInitial, String lName, String maleOrFemale, String user, String pass) {

		this(fName, lName, maleOrFemale, user, pass);

		_middleInitial = mInitial;
	}

	public String toString() {
		if (_middleInitial.length() > 0) 
			return _firstName + " " + _middleInitial + " " + _lastName;
		return _firstName + " " + _lastName;
	}

	public static void main (String[] args) {
		Teacher brown = new Teacher("Topher","Brown", "male", "tbrown@gmail.com", "password123");
		System.out.println(brown);
	}
		
}
