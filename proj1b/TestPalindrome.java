import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();
    static CharacterComparator offBy5 = new OffByN(5);
    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";

        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class.


    @Test
    public void testisPalindrom(){

    assertFalse(palindrome.isPalindrome("kitty"));
    assertTrue(palindrome.isPalindrome("deified"));
    assertTrue(palindrome.isPalindrome("acefdb",offByOne));
    assertTrue(palindrome.isPalindrome("acefdb",offByOne));
    assertTrue(palindrome.isPalindrome("abcgf",offBy5));
    assertFalse(palindrome.isPalindrome("acefdb",offBy5));
    }



}
