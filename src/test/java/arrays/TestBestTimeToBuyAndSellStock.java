package arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestBestTimeToBuyAndSellStock {
    @Test
    public void testStockBuyLowSellHigh() {
        int[] prices = {2,66,22,1,4,55};
        int min_price = prices[0];
        int maxprof = 0;

        for(int i=1;i<prices.length;i++){
            maxprof = Math.max(maxprof,prices[i]-min_price);
            min_price = Math.min(prices[i],min_price);
        }
        Assert.assertEquals(64, maxprof);
        System.out.printf("Min Price: %d Max Profit: %d",min_price,maxprof);
    }
}
