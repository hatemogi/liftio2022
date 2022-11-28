package liftio2022;

import org.junit.jupiter.api.Test;

import static liftio2022.Palindrome.isPalindrome;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {
    @Test
    public void testPalindrome() {
        assertTrue(isPalindrome("s"));
        assertFalse(isPalindrome("ab"));
        assertTrue(isPalindrome("우영우"));
        assertTrue(isPalindrome("역삼역"));
    }
}
