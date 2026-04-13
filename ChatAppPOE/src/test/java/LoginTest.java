import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class LoginTest {
    
    // USERNAME TESTS
   
    @Test
    public void testUsernameCorrectlyFormatted() {
        Login login = new Login();
        assertTrue(login.checkUserName("ky_1"));
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        Login login = new Login();
        assertFalse(login.checkUserName("kyle!!!!"));
    }

   
    // PASSWORD TESTS
   
    @Test
    public void testPasswordMeetsComplexity() {
        Login login = new Login();
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        Login login = new Login();
        assertFalse(login.checkPasswordComplexity("password"));
    }

   
    // CELL NUMBER TESTS
    
    @Test
    public void testCellNumberCorrectFormat() {
        Login login = new Login();
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCellNumberIncorrectFormat() {
        Login login = new Login();
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    
    // LOGIN TESTS 
    

    @Test
    public void testLoginSuccessful() {
        Login login = new Login();

        login.registerUser("ky_1", "Ch&&sec@ke99!", "+27838968976", "Jacky", "Serumula");

        boolean result = login.loginUser("ky_1", "Ch&&sec@ke99!");

        assertTrue(result);
    }

    @Test
    public void testLoginFailed() {
        Login login = new Login();

        login.registerUser("ky_1", "Ch&&sec@ke99!", "+27838968976", "Jacky", "Serumula");

        boolean result = login.loginUser("wrong", "wrong");

        assertFalse(result);
    }

    
    // MESSAGE TESTS 
    

    @Test
    public void testRegisterSuccessMessage() {
        Login login = new Login();

        String result = login.registerUser("ky_1", "Ch&&sec@ke99!", "+27838968976", "Jacky", "Serumula");

        assertEquals("User registered successfully.", result);
    }

    @Test
    public void testUsernameErrorMessage() {
        Login login = new Login();

        String result = login.registerUser("kyle!!!!", "Ch&&sec@ke99!", "+27838968976", "Jacky", "Serumula");

        assertEquals("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.", result);
    }

    @Test
    public void testPasswordErrorMessage() {
        Login login = new Login();

        String result = login.registerUser("ky_1", "password", "+27838968976", "Jacky", "Serumula");

        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", result);
    }

    @Test
    public void testCellNumberErrorMessage() {
        Login login = new Login();

        String result = login.registerUser("ky_1", "Ch&&sec@ke99!", "08966553", "Jacky", "Serumula");

        assertEquals("Cell number incorrectly formatted or does not contain an international code; please correct the number and try again.", result);
    }
}