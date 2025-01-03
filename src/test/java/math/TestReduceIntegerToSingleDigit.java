package math;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestReduceIntegerToSingleDigit {

    @Test
    public void test_ReduceIntegerToSingleDigit(){
        int result = ReduceIntegerToSingleDigit.reduce(732732);
        Assert.assertEquals(6, result);
    }

    @Test
    public void test_ReduceIntegerToSingleDigit_Recursive(){
        int result = ReduceIntegerToSingleDigit.reduceRecursion(1256723);
        Assert.assertEquals(8, result);
    }
}
