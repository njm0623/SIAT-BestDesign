package users.command;

public class UserException extends Exception{
	  public UserException(){
	  		super();
	  	}
	  	
	  public UserException(String error){
	  		super( error );
	  	}

}
