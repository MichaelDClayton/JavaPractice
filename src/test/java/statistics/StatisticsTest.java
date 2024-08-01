package statistics;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

@RunWith(JUnit4.class)
public class StatisticsTest {

    private final int[] evenLengthArray = {1,5,3,8,45,9};//1,3,5,8,9,45
    private final int[] oddLengthArray = {1,45,3,8,2,99,2};//1,2,2,3,8,45,99

    @Test
    public void test_Median(){
        int median = findMedian(evenLengthArray);
        Assert.assertEquals(6, median);

        median = findMedian(oddLengthArray);
        Assert.assertEquals(3, median);
    }

    public int findMedian(int[] numbers){
        Arrays.sort(numbers);
        int median;
        if(numbers.length % 2 == 0){
            int a = numbers[(numbers.length/2)-1];
            int b = numbers[(numbers.length/2)];
            median = (a+b)/2;
        }else {
            median = numbers[numbers.length/2];
        }
        return median;
    }




}
