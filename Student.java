public class Student implements Login {

	//Name related stuff
	private String _firstName;
	private String _middleInitial;
	private String _lastName;
	
	//_sex
	private String _sex; //male or female

	//login info
	private String _email;
	private String _password;
	
	//ID
	private int _studentID;
	
	//Time related stuff
	private int _birthMonth; //01 is Jan, 02 is Feb, and so on
	private int _birthDate; //date of the month, two digits
	private int _birthYear; //four digits
	private int _graduatingYear; //four digits
	
	public Student() {
	
		_firstName = "John";
		_lastName = "Doe";
		_middleInitial = "";

		_birthMonth = 01;
		_birthDate = 01;
		_birthYear = 2001;
	
		_graduatingYear = 2019;

		_sex = "male";

		_email = "jdoe@gmail.com";
		_password = "_password";
	
	}

	public Student(String fName, String lName, String maleOrFemale, String user, String pass, int month, int day, int yearborn, int yearGraduate) {

		_firstName = fName;
		_lastName = lName;
		_middleInitial  = "";

		_sex = maleOrFemale;

		_birthMonth = month;
		_birthDate = day;
		_birthYear = yearBorn;
		
		_graduatingYear = yearGraduate;

		_email = user;
		_password = pass;

	}
	
	public Student (String fName, String mInitial, String lName, String maleOrFemale, String user, String pass, int month, int day, int yearBorn, int yearGraduate) {

		this(fName, lName, maleOrFemale, user, pass, month, day, yearBorn, yearGraduate);
				
		_middleInitial = mInitial;
	}	
	
	public static void main (String[] args) {
				
	}

}
