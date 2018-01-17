import login.Login;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import accounts.*;
import calculate.*;

public class Woo {

    public static boolean isNumeric(String str) {  
	try {  
	    double d = Double.parseDouble(str);  

	} catch(NumberFormatException e){  
		  
	    return false;  

	}  
	  
	return true;  
    }

    public static int mainMenu(Scanner scanner) {
		
	int code = -1;		
	String choice = "";

	while(true) {
	
	    System.out.println("1. Student\n2. Teacher\n3. Parent");
	    choice = scanner.nextLine();
			
	    if (choice.equals("1") || choice.equals("2") || choice.equals("3")) {
		code = Integer.parseInt(choice);
		break;

	    } else {
		System.out.println("Invalid Option! Try again!");
	    }
	}
	return code;
    }

    public static void main(String[] args) throws IOException {

	Console console = System.console();

	System.out.println("Welcome to your Gradebook!");
	System.out.println("Are you a student, teacher, or a parent?");

	Scanner scanner = new Scanner(System.in);
		
	int code = mainMenu(scanner);

	if(code == 1) {
			
	    Login login = new Login("login/students/studentUsernames.txt");

	    System.out.println("Welcome Student! Type in your username below, or type EXIT to exit");
			
	    String user = scanner.nextLine();
			
	    if (user.equals("EXIT")) {
		return;
	    }	

	    while (login.checkUserExists(user) == false) {
		System.out.println("User does not exist! Try again, or type EXIT to exit!");
		user = scanner.nextLine();	
	    }

	    System.out.println("User found! Type in your password " + user);
			
	    char[] passString = console.readPassword();
	    String password = new String(passString); 
		
	    login.setPath("login/students/.studentPasswords.txt");
	    int counter = 0;

	    while (login.verifyPassword(password) == false) {
				
		if (counter >= 5) {
		    System.out.println("Maximum number of attempts tried! Locked out!");
		    return;
		}

		System.out.println("Wrong password! You have " + (5 - counter) + " attempt(s) left");
		counter ++;
				
		passString = console.readPassword();
		password = new String(passString);

	    }
			
	    System.out.println("Login Successful!");
	    ArrayList<String> info = new ArrayList<String>();

	    try {
		File file = new File("accounts/students/" + user + "/" + user + ".txt");
		FileReader fr = new FileReader(file);
		BufferedReader student = new BufferedReader(fr);	

		String line = null;
				
		while ((line = student.readLine()) != null) {
		    info.add(line);
		}
				
			
	    } catch (FileNotFoundException e) {
		System.out.println("FILE NOT FOUND ERROR");
	    }
	    Student loggedIn = new Student(info);
			
	    System.out.println("Welcome " + info.get(0) + "! What would you like to do?");
	    System.out.println("1. View Grades\n2. View Assignments\n3. Logout");
				
	    String choice = scanner.nextLine();

	    while (true) {

		if (choice.equals("1")) {

		    System.out.println("\nHere are your grades!\n");

		    System.out.println("Science: " + loggedIn.getScienceGrade());
		    System.out.println("Math: " + loggedIn.getMathGrade());
		    System.out.println("History: " + loggedIn.getHistoryGrade());
		    System.out.println("English: " + loggedIn.getEnglishGrade());
		    System.out.println("Computer Science: " + loggedIn.getComputerScienceGrade() + "\n");

		    System.out.println("\nPress ENTER to go back");
				
		    scanner.nextLine();

		    System.out.println("Welcome " + info.get(0) + "! What would you like to do?");
		    System.out.println("1. View Grades\n2. View Assignments\n3. Logout\n");
		    choice = scanner.nextLine();
						
		} else if (choice.equals("2")) {
		    System.out.println("FEATURE UNDER DEVELOPMENT");
		    System.out.println("\nPress ENTER to go back");
				
		    scanner.nextLine();

		    System.out.println("Welcome " + info.get(0) + "! What would you like to do?");
		    System.out.println("1. View Grades\n2. View Assignments\n3. Logout");
		    choice = scanner.nextLine();

		} else if (choice.equals("3")) {
		    System.out.println("Bye Bye " + info.get(0));
		    break;

		} else if (choice.equals("4")) {
		    System.out.println(loggedIn.setFirstName("Test"));
					
		    System.out.println("Welcome " + info.get(0) + "! What would you like to do?");
		    System.out.println("1. View Grades\n2. View Assignments\n3. Logout");
		    choice = scanner.nextLine();

		} else {
		    System.out.println("INVALID INPUT! Try again!");
		    System.out.println("1. View Grades\n2. View Assignments\n3. Logout");
		    choice = scanner.nextLine();
		}

	    }
	}

//~~~~~TEACHER CODE~~~~~	
	if(code == 2) {
				
	    Login login = new Login("login/teachers/teacherUsernames.txt");

	    System.out.println("Welcome Teacher! Type in your username below, or type EXIT to exit");
			
	    String user = scanner.nextLine();
				
	    if (user.equals("EXIT")) {
		return;
	    }

	    while (login.checkUserExists(user) == false) {
		System.out.println("User does not exist! Try again, or type EXIT to exit");
		user = scanner.nextLine();	
	    }

	    System.out.println("User found! Type in your password " + user);

	    char[] passString = console.readPassword();
	    String password = new String(passString); 
		
	    login.setPath("login/teachers/.teacherPasswords.txt");
	    int counter = 0;

	    while (login.verifyPassword(password) == false) {
				
		if (counter >= 5) {
		    System.out.println("Maximum number of attempts tried! EXITING!");
		    return;
		}

		System.out.println("Wrong password! You have " + (5 - counter) + " attempt(s) left");
		counter ++;

		passString = console.readPassword();
		password = new String(passString);
	    }
			
	    System.out.println("Login Successful!");
	    ArrayList<String> info = new ArrayList<String>();

	    try {
		File file = new File("accounts/teachers/" + user + "/" + user + ".txt");
		FileReader fr = new FileReader(file);
		BufferedReader teacher = new BufferedReader(fr);	

		String line = null;
				
		while ((line = teacher.readLine()) != null) {
		    info.add(line);
		}
			 	
			
	    } catch (FileNotFoundException e) {
		System.out.println("FILE NOT FOUND ERROR");
	    }

	    Teacher loggedIn = new Teacher(info);
		int subject = Integer.parseInt(info.get(6));
	    System.out.println("Welcome " + info.get(0) + "! What would you like to do?");
	    System.out.println("\n1. Change a student's grade\n2. Assign new assignment\n3. Grade an assignment\n4. See stats for your class\n5. Logout\n");

	    String choice = scanner.nextLine();
			
	    while(true) {
			if (choice.equals("1")) {
				System.out.println("Here are all of your students");
				System.out.println("Type the number corressponding to their username to change their grade, or type EXIT to go back to the menu");
				counter = 1;
				
				for (int i = 7; i < info.size(); i+= 2) {	
					System.out.println( counter + ". "  + info.get(i));
					counter ++;
				}
				
				ArrayList<String> students = loggedIn.getStudents();
				ArrayList<String> userNames = new ArrayList<String>();
				
				for (int i = 0; i < students.size(); i+=2) {
					userNames.add(students.get(i));
				}
				choice = scanner.nextLine();

				if (isNumeric(choice)) {
				ArrayList<String> studentInfo = new ArrayList<String>();

				int studentChosen = Integer.parseInt(choice);
				String studentUser = userNames.get(studentChosen - 1);
			
				try {
					File file = new File("accounts/students/" + studentUser + "/" + studentUser + ".txt");
					FileReader fr = new FileReader(file);
					BufferedReader student = new BufferedReader(fr);	

					String line = null;
							
					while ((line = student.readLine()) != null) {
					studentInfo.add(line);
					}

						
				} catch (FileNotFoundException e) {
					System.out.println("FILE NOT FOUND ERROR");
				}

				Student chosenStudent = new Student(studentInfo);
				System.out.println("Here is your grade for " + studentInfo.get(0));
				
				double oldGrade = Double.parseDouble(studentInfo.get((Integer.parseInt(info.get(6)) + 11)));
				System.out.println(oldGrade);

				System.out.println("What would you like to change it to?");
				String grade = scanner.nextLine();

				while(true) {
					try {
						double newGrade = Double.parseDouble(grade);
						System.out.println("Changing " + studentInfo.get(0) + "'s grade from " + oldGrade + " to " + newGrade);
						chosenStudent.setGrade(Integer.parseInt(info.get(6)), newGrade, studentInfo);
						loggedIn.changeGrade(newGrade, studentInfo.get(4), info);
						break;
					} catch (Exception e) {
						System.out.println("Invalid input! Try again!");
						grade = scanner.nextLine();
					}
				}
				System.out.println("Success!\nReturning to main menu...\n");
			  }
			} else if (choice.equals("2")) {
				System.out.println("FEATURE UNDER DEVELOPMENT!");
			}
			else if (choice.equals("3")) {
				System.out.println("FEATURE UNDER DEVELOPMENT!");
			}
			else if (choice.equals("4")) {
				System.out.println("Here are all of your students and their grades");

				ArrayList<Double> studentGrades = new ArrayList<Double>();
				double[] grades = new double[(int)Math.floor((info.size() - 6) / 2)];

				ArrayList<String> students = new ArrayList<String>();

				for (int i = 0; i < loggedIn.getStudents().size(); i++) {
					students.add(loggedIn.getStudents().get(i));
				}

				for (int i = 1; i < students.size(); i += 2) {
					studentGrades.add(Double.parseDouble(students.get(i)));
				}
	
				for (int i = 0; i < grades.length; i++) {
					grades[i] = studentGrades.get(i);
				}
				ArrayList<String> studentNames = new ArrayList<String>();

				for (int i = 0; i < students.size(); i += 2) {
					studentNames.add(students.get(i));
				}

				for (int i = 0; i < grades.length; i++) {
					System.out.println(studentNames.get(i) + ": " + grades[i]);
				
				}

				System.out.println("What would you like to calculate?");
				System.out.println("1. Mean\n2. Max\n3.Minimum\n4. Standard Deviation\n5. Median\n6. 1st Quartile\n7. 3rd Quartile\n8. IQR\n9. Outliers\n10. Histogram");



			}
			else if (choice.equals("5")) {
				System.out.println("Bye Bye " + info.get(0));
				return;
			}
			else {
				System.out.println("Invalid input! Try again");
			}
			System.out.println("Welcome " + info.get(0) + "! What would you like to do?");
	    	System.out.println("\n1. Change a student's grade\n2. Assign new assignment\n3. Grade an assignment\n4. Check stats for grades\n5. Logout\n");

	    	choice = scanner.nextLine();

			}
		}

	

	if(code == 3) {
				
	    Login login = new Login("login/parents/parentUsernames.txt");

	    System.out.println("Welcome Parent! Type in your username below, or type EXIT to exit");
			
	    String user = scanner.nextLine();
				
	    if (user.equals("EXIT")) {
		return;
	    }

	    while (login.checkUserExists(user) == false) {
		System.out.println("User does not exist! Try again, or type EXIT to exit");
		user = scanner.nextLine();	
	    }

	    System.out.println("User found! Type in your password " + user);

	    char[] passString = console.readPassword();
	    String password = new String(passString); 
		
	    login.setPath("login/parents/.parentPasswords.txt");
	    int counter = 0;

	    while (login.verifyPassword(password) == false) {
				
		if (counter >= 5) {
		    System.out.println("Maximum number of attempts tried! EXITING!");
		    return;
		}

		System.out.println("Wrong password! You have " + (5 - counter) + " attempt(s) left");
		counter ++;

		passString = console.readPassword();
		password = new String(passString);

	    }
			
	    System.out.println("Login Successful!");
	}
    }
}
		
	  
   	


