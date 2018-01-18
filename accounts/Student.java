package accounts;

import java.io.*;
import java.util.ArrayList;

public class Student {

	//Name related stuff
	private String _firstName;
	private String _middleInitial;
	private String _lastName;
	
	//_sex
	private String _sex; //male or female

	//login info
	private String _user;
	private String _password;
	
	//ID
	private int _studentID;
	
	//Time related stuff
	private int _birthMonth; //01 is Jan, 02 is Feb, and so on
	private int _birthDate; //date of the month, two digits
	private int _birthYear; //four digits
	private int _graduatingYear; //four digits

	//Grades
	private double _scienceGrade;
	private double _mathGrade;
	private double _historyGrade;
	private double _englishGrade;
	private double _computerScienceGrade;

	//Teachers
	private String _scienceTeacher;
	private String _mathTeacher;
	private String _historyTeacher;
	private String _englishTeacher;
	private String _computerScienceTeacher;
	
	//arraylist from files
	private ArrayList<String> _info;
	
	public Student() {
	
		_firstName = "John";
		_lastName = "Doe";
		_middleInitial = "";

		_birthMonth = 01;
		_birthDate = 01;
		_birthYear = 2001;
	
		_graduatingYear = 2019;

		_sex = "male";

		_user = "jdoe1";
		_password = "password";

		_scienceGrade = 99;
		_mathGrade = 99;
		_historyGrade = 99;
		_englishGrade = 99;
		_computerScienceGrade = 99;

		_scienceTeacher = "tbrown";
		_mathTeacher = "tbrown";
		_historyTeacher = "tbrown";
		_englishTeacher = "tbrown";
		_computerScienceTeacher = "tbrown";
	
	}

/*	public Student(String user) {
		this();
		_user = user;	
	}

	public Student(String fName, String lName, String maleOrFemale, String user, String pass, int month, int day, int yearBorn, int yearGraduate) {

		_firstName = fName;
		_lastName = lName;
		_middleInitial  = "";

		_sex = maleOrFemale;

		_birthMonth = month;
		_birthDate = day;
		_birthYear = yearBorn;
		
		_graduatingYear = yearGraduate;

		_user = user;
		_password = pass;

	}*/
	
	public Student (ArrayList<String> info) {
		
		_firstName = info.get(0);
		_middleInitial = info.get(1);
		_lastName = info.get(2);
		
		_sex = info.get(3);
		
		_user = info.get(4);
		_password = info.get(5);
		_studentID = Integer.parseInt(info.get(6));
		
		_birthMonth = Integer.parseInt(info.get(7));
		_birthDate = Integer.parseInt(info.get(8));
		_birthYear = Integer.parseInt(info.get(9));

		_graduatingYear = Integer.parseInt(info.get(10));

		_scienceGrade = Double.parseDouble(info.get(11));
		_mathGrade = Double.parseDouble(info.get(12));
		_historyGrade = Double.parseDouble(info.get(13));
		_englishGrade = Double.parseDouble(info.get(14));
		_computerScienceGrade = Double.parseDouble(info.get(15));
		
		_scienceTeacher = info.get(16);
		_mathTeacher = info.get(17);
		_historyTeacher = info.get(18);
		_englishTeacher = info.get(19);
		_computerScienceTeacher = info.get(20);

		_info = info;
	}	

	public double setGrade(int subject, double newGrade, ArrayList<String> info) throws IOException {

		double temp = Double.parseDouble(info.set((subject + 11), Double.toString(newGrade)));

		try {
			File file = new File("accounts/students/" + _user + "/" + _user + ".txt");
			FileWriter fr = new FileWriter(file);
			BufferedWriter infoFile = new BufferedWriter(fr);

			infoFile.write("");

			for(int i = 0; i < info.size(); i++) {
				if (i == 1 && info.get(i).equals("")){
					infoFile.write("\n");
				}
				else {
					infoFile.write(info.get(i) + "\n");
				}
			}
			infoFile.close();

		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND - incorrect path:");
			System.out.println("accounts/students/" + _user + "/" + _user + ".txt");
		}
		return temp;
	}
	public String getUserName() {
		return _user;
	}
	public double getScienceGrade() {
		return _scienceGrade;
	}
	
	public double getMathGrade() {
		return _mathGrade;
	}

	public double getHistoryGrade() {
		return _historyGrade;
	}

	public double getEnglishGrade() {
		return _englishGrade;
	}

	public double getComputerScienceGrade() {
		return _computerScienceGrade;
	}

	
	public void setTeachers(ArrayList<String> teachers) {
		_scienceTeacher = teachers.get(0);
		_mathTeacher = teachers.get(1);
		_historyTeacher = teachers.get(2);
		_englishTeacher = teachers.get(3);
		_computerScienceTeacher = teachers.get(4);
	}

	public String toString() {
		if (_middleInitial.length() > 0) 
			return _firstName + " " + _middleInitial + " " + _lastName;

		return _firstName + " " + _lastName;
	}

	public static void main (String[] args) {
		Student test = new Student();				
		System.out.println(test);
	}

}
