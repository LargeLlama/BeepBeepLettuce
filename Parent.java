public class Parent implements Login{

    //login info
    private String _email;
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

	_email = "jdoe@gmail.com";
	_password = "_password";

	_childFirstName = "Johnnie";
	_childLastName = "Doe";
	_childMiddleInitial = "Jr.";

	_childStudentID = "";
	
	_firstName = "John";
	_lastName = "Doe";
	_middleInitial = "";

    }
    
}//end class
