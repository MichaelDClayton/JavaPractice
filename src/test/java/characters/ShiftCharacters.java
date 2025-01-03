package characters;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ShiftCharacters {

    @Test
    public void shiftByOne() {
        String str = "abcdefz";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i]++; // Increment ASCII value by one
        }

        Assert.assertEquals('b', chars[0]);
        Assert.assertEquals('{', chars[str.length()-1]);

    }
}