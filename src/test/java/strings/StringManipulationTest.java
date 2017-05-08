package strings;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringManipulationTest {

    StringManipulation stringManipulation = new StringManipulation();
    
    @Test
    public void testTrue() {
        assertTrue(stringManipulation.isPlanindrome("12121"));
    }

    @Test
    public void testFalse() {
        assertFalse(stringManipulation.isPlanindrome("12123"));
    }
    
    @Test
    public void testTrueReverse() {
        String str = "hello";
        assertTrue("olleh".equals(stringManipulation.reverse(str)));
    }
}
