package characters;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ChangeCaseForLetters {


    @Test
    public void test_transform_Each_Char_To_Different_Case() {
        String inputString = "abcdfz";
        char[] chars = inputString.toCharArray();

        for(int i =0;i<chars.length;i++){
            if(Character.isAlphabetic(chars[i])){
                if(Character.isLowerCase(chars[i])){
                    chars[i]-=32;
                }else{
                    chars[i]+=32;
                }
            }
        }

        Assert.assertEquals('A', chars[0]);
        Assert.assertEquals('Z', chars[inputString.length()-1]);
    }
}
