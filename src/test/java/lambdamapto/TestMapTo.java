package lambdamapto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

@RunWith(JUnit4.class)
public class TestMapTo {

    @Test
    public void testConvertStringsToIntegers(){

        String[] strNums = {"1", "2", "3", "4", "5"};
        int[] nums = Arrays.stream(strNums).mapToInt(Integer::parseInt).toArray();
        Assert.assertEquals(1, nums[0]);
        }

}
