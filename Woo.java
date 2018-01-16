import login.Login;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import accounts.*;

public class Woo {

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
						System.out.println("1. View Grades\n2. View Assignments\n3. Logout");
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
					} else {
						System.out.println("INVALID INPUT! Try again!");
						System.out.println("1. View Grades\n2. View Assignments\n3. Logout");
						choice = scanner.nextLine();
					}

				}
	
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
