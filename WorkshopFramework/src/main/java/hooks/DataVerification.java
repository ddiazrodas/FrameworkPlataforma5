package hooks;

public class DataVerification {
	
	public static void verificationMessage(String username, String password ) {
		if (username.contains("standard_user") && password.contains("secret_sauce")) {
			System.out.println("LOG IN WILL BE SUCCESSFULL - Welcome user: " + username + "\n Password: " + password);
		} else {
			System.out.println("LOG IN WILL FAIL - Wrong xpath " + username + " \n password: " + password);
		}
	}
}
