package arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

@RunWith(JUnit4.class)
public class TestNthLargestNumberInArray {

    @Test
    public void test_NthLargestNumberInArray(){
        int[] nums = {3,2,1,6,4,5};
        int k = 2;
        Arrays.sort(nums);
        int result = nums[nums.length - k];
        Assert.assertEquals(5, result);
    }
}
