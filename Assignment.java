/***
 *  Assignment Class
 *  TYPE: Superclass
 *  - Test extends Assignment
 *  - Quiz extends Assignment
 *  - Homework extends Assignment
 *  - Project extends Assignment
 ***/

public class Assignment {

    // INSTANCE VARIABLES

    public String name; // name of the assignment
    public String status; // "incomplete" or "complete"
    public float grade; // decimal value of the grade given for assignment

    // DEFAULT CONSTRUCTOR

    public Assignment() {

	name = "New Assignment";
	status = "incomplete"; 
	grade = 100.00;

    }

    // OVERLOADED CONSTRUCTORS

    public Assignment( String newName ) {

	name = newName;	
	status = "incomplete";
	grade = 100.00;

    }

    public Assignment( float newGrade ) {

	name = "New Assignment";
	status = "incomplete";
	grade = newGrade;

    }

    public Assignment( String newName, float newGrade ) {

	name = newName;
	status = "incomplete";
	grade = newGrade;

    }

    // METHODS

    // toString()
    public String toString() {

	String returnString = "";
	returnString += "Assignment Name: " + name;
	returnString += "Status: " + status;
	if ( status == "complete" ) {

	    returnString += "Grade: " + grade;

	}
	return returnString;
	
    }

    // setName( String )
    public static void setName( String inputName ) {

	name = inputName;

    }

    // setGrade( float )
    public static void setGrade( float inputGrade ) {

        grade = inputGrade;

    }

    // setStatus( String )
    public static void setGrade( String inputStatus ) {

        status = inputStatus;

    }

} // end of class Assignment
	
