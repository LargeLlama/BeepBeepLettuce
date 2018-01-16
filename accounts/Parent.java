package accounts;

public class Parent {

    //login info
    private String _user;
    private String _password;
	
    //Child name related info
    private String _childFirstName;
    private String _childMiddleInitial;
    private String _childLastName;

    //Child ID
    private int _childStudentID;
	
    //Parent name info
    private String _firstName;
    private String _middleInitial;
    private String _lastName;
    
    public Parent() {

	_user = "jdoe@gmail.com";
	_password = "_password";

	_childFirstName = "Johnnie";
	_childLastName = "Doe";
	_childMiddleInitial = "Jr.";

	_childStudentID = 0;
	
	_firstName = "John";
	_lastName = "Doe";
	_middleInitial = "";

    }
    
}//end class
