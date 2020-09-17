package assignment1;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * @author Nurbala Kaldybayeva
 *
 */
public class PasswordCheckerUtility {
	//illegalPasswords array for keeping illegal passwords; 
	private static ArrayList<String> illegalPasswords;

	/**
	 * Return true if valid password (follows all rules from above). Throws exceptions for invalid passwords.
	 * @param password - string to be checked for validity
	 * @return true if valid password (follows all rules from above), set up to return false if an invalid password, but throws an exception instead.
	 * @throws LengthException - thrown if length is less than 6 characters
	 * @throws NoDigitException - thrown if no digit
	 * @throws NoUpperAlphaException -thrown if no uppercase alphabetic
	 * @throws NoLowerAlphaException - thrown if no lowercase alphabetic
	 * @throws NoSpecialSymbolException - thrown if no special character.
	 * @throws InvalidSequenceException - thrown if more than 2 of same character
	 */
	public static boolean isValidPassword(String password)  throws LengthException,
    NoDigitException,
    NoUpperAlphaException,
    NoLowerAlphaException,
    NoSpecialSymbolException,
    InvalidSequenceException {
//		Pattern patternSpecialChar = Pattern.compile("[a-zA-Z0-9]*");
//		Matcher matcherSpecialChar = patternSpecialChar.matcher(password);
//		
		if(password.length()<6) {
			throw new LengthException("The password must be at least 6 characters long");
		}
//		else if(isWeakPassword(password)) {
//			//throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
//		}
		else if(noUpperCase(password)) {
			throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
		}
		else if (noLowerCase(password)) {
			throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
		}else if (!hasDigit(password)) {
			throw new NoDigitException("The password must contain at least one digit");
		}
		else if (noSpecialChar(password)) {
			throw new NoSpecialSymbolException ("The password must contain at least one special character.");	
		}
		else if (moreThen2SameChar(password)) {
			throw new InvalidSequenceException ("The password cannot contain more than two of the same character in sequence.");	
		}
		return true;
	}
/**
 * Return true if length of password is greater than or equal to 6
 * but less than or equal to 9
 * @param password  - - string to be checked if weak password
 * @return true if length of password is greater than or equal to 6 and less than or equal to 9; false otherwise
 */
	public static boolean isWeakPassword(String password) {
		if(password.length()>=6 && password.length()<=9) {
		return true;
		}
		return false;
	}
	
/**
 * Returns an arraylist of invalid passwords (weak passwords are not considered invalid)
 * @param passwords - arraylist of passwords to check for validity
 * @return arraylist of invalid passwords. It will not return weak passwords.
 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		// an ArrayList to hold all the invalid passwords found
				illegalPasswords = new ArrayList<String>();
				
				// A string that will hold the error status message of an invalid password that is found in the ArrayList
				String errorMessage = null;
				
				// Loop through the ArrayList of passwords and use the isValidPassword method to determine which passwords in the list are invalid.
				// If any are found to be invalid, then display the appropriate error status message after the password. 
				for(int i = 0; i < passwords.size(); i++)	{
					try	{	
						isValidPassword(passwords.get(i));
					}// If a password is found to have a LengthException, then display the password along with its error status message next to it in the errorMessage string. 
					catch (LengthException e)  {
						errorMessage = passwords.get(i) + " The password must be at least 8 characters long.";
						// Add the invalid password into the illegalPasswords ArrayList
		                illegalPasswords.add(errorMessage);
		            }	// If a password is found to have a NoDigitException, then display the password along with its error status message next to it in the errorMessage string. 
		        	catch (NoDigitException e) {
						errorMessage = passwords.get(i) + " The password must contain at least one digit.";
						// Add the invalid password into the illegalPasswords ArrayList
			            illegalPasswords.add(errorMessage);
					}// If a password is found to have a NoUpperAlphaException, then display the password along with its error status message next to it in the errorMessage string. 
		        	catch (NoUpperAlphaException e) {
						errorMessage = passwords.get(i) + " The password must contain at least one uppercase alphabetic character."; 
						// Add the invalid password into the illegalPasswords ArrayList
			            illegalPasswords.add(errorMessage);
					}// If a password is found to have a NoLowerAlphaException, then display the password along with its error status message next to it in the errorMessage string. 
		        	catch (NoLowerAlphaException e) {
						errorMessage = passwords.get(i) + " The password must contain at least one lowercase alphabetic character."; 
						// Add the invalid password into the illegalPasswords ArrayList
			            illegalPasswords.add(errorMessage);
					}
					catch (NoSpecialSymbolException e) {
						errorMessage = passwords.get(i) + " The password must contain special character."; 
						// Add the invalid password into the illegalPasswords ArrayList
			            illegalPasswords.add(errorMessage);
					}
					// If a password is found to have a InvalidSequenceException, then display the password along with its error status message next to it in the errorMessage string. 
		        	catch (InvalidSequenceException e) {
						errorMessage = passwords.get(i) + " The password cannot contain more than two of the same character in sequence."; 
						// Add the invalid password into the illegalPasswords ArrayList
			            illegalPasswords.add(errorMessage);
					}
				}
				
				//Return the ArrayList that contains all the invalid passwords only
				return illegalPasswords;
			}	
	
/**
 * Return true if password does not have at least one upper case  and false if it does.
 * @param password
 * @return true if password does not have upper case and false if it does.
 */
private static boolean noUpperCase(String password) {
	
	for(int i=0; i<password.length();i++) {
		if(Character.isUpperCase(password.charAt(i))) {
			return false;
		}
	}
	return true;
}
/**
 * Return true if password does not have at least one lower case  and false if it does.
 * @param password
 * @return true if password does not have upper case and false if it does.
 */
private static boolean noLowerCase(String password) {
	
	for(int i=0; i<password.length();i++) {
		if(Character.isLowerCase(password.charAt(i) )) {
			return false;
		}
	}
	return true;
}
/**
 * Returns true if password has digit and false if does not 
 * @param password
 * @return true if password has digit and false if does not
 */
private static boolean hasDigit(String password) {
	
	for(int i=0; i<password.length();i++) {
		if(Character.isDigit(password.charAt(i) )) {
			return true;
		}
	}
	return false;
}
/**
 * Returns true if password has more then 2 same Character and false if does not
 * @param password
 * @returntrue if password has more then 2 same Character and false if does not
 */
static boolean moreThen2SameChar(String password) {
	for (int i = 0; i < password.length() - 2; i++){
		if( (password.charAt(i) == password.charAt(i + 1))   &&  (password.charAt(i) == password.charAt(i+2)) )	{
			return true;
		}			
	}
	return false;
	}
/**
 * Returns true if password has no special character and false if it does. 
 * @param password
 * @return true if password has no special character and false if it does
 */
private static boolean noSpecialChar(String password) {
//Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
//Matcher matcher = pattern.matcher(password);
//return (matcher.matches());

	 String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
     for (int i=0; i < password.length() ; i++) {
         char ch = password.charAt(i);
         if(specialCharactersString.contains(Character.toString(ch))) {
            return false;
         } 
	}
     return true;
}
     

}
