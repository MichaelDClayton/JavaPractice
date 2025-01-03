package arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestMaxSubArrayOfLengthK {

    /**
     * Make use of sliding window algorithm.
     */
    @Test
    public void test_maxSumOfSubArrayOfLengthK() {
        int[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        int n = arr.length;

        int max_sum = 0;
        for (int i = 0; i < k; i++) {
            max_sum += arr[i];
        }

        int window_sum = max_sum;
        for (int i = k; i < n; i++) {
            window_sum += arr[i] - arr[i - 4];
            max_sum = Math.max(window_sum, max_sum);
        }
        Assert.assertEquals(24, max_sum);
    }
}
