import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByN {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static OffByN offBy5 = new OffByN(5);

    // Your tests go here.
    @Test
    public void testNequalChars() {

        assertTrue(offBy5.equalChars('a', 'f'));  // true
        assertTrue(offBy5.equalChars('f', 'a'));  // true
        assertFalse(offBy5.equalChars('f', 'h'));  // false

    }

    // Uncomment this class once you've created your CharacterComparator interface and OffByOne class.
}
