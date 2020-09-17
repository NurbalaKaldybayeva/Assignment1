package assignment1;
/**
 * 
 * @author Nurbala Kaldybayeva
 *
 */
public class UnmatchedException extends Exception {
public UnmatchedException() {
		
	}
	
public UnmatchedException(String message) {
	
		super(message);
	
	}

@Override public String getMessage() {
	return  "Password do not match "; 
	}

}
