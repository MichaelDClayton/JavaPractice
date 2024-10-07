package arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestMaxSubArraySum {

    @Test
    public void test_MaxSubArraySum(){
        int[] nums = {4,-1,2,-7,4,3};
        int maxSum = nums[0];
        int currSum = 0;

        for(Integer n : nums){
            currSum = Math.max(currSum, 0);
            currSum+=n;
            maxSum = Math.max(maxSum, currSum);
        }

        Assert.assertEquals(7, maxSum);
    }

}
