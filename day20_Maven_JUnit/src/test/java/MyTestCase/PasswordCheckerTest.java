package MyTestCase;

import com.JUnit.PasswordChecker;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class PasswordCheckerTest {
    @Test
    public void isPasswordValid(){
        PasswordChecker passwordChecker = new PasswordChecker();
        assertFalse(passwordChecker.isValidPassword("asBM12"));
        assertFalse(passwordChecker.isValidPassword("!@#$asdQWE123"));
        assertFalse(passwordChecker.isValidPassword("asd123312"));
        assertFalse(passwordChecker.isValidPassword("ASDF12313"));
        assertFalse(passwordChecker.isValidPassword("asdfQWERY"));
        //valid password
        assertTrue(passwordChecker.isValidPassword("asdQWE123"));
        assertTrue(passwordChecker.isValidPassword("QWE123lkj"));
        assertTrue(passwordChecker.isValidPassword("123ertyDFG"));
    }
}
