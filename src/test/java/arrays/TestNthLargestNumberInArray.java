package arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.PriorityQueue;

@RunWith(JUnit4.class)
public class TestNthLargestNumberInArray {

    @Test
    public void test_NthLargestNumberInArray(){
        int[] nums = {3,2,1,6,4,5};
        int k = 2;
        int result = -1;
        int toRemove = nums.length - k;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(Integer n: nums){
            queue.add(n);
        }
        for(int i =0;i<toRemove;i++){
            queue.remove();
        }
        result = queue.poll();
        Assert.assertEquals(5, result);
    }
}
