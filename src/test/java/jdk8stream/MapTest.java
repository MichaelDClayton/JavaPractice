package jdk8stream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RunWith(JUnit4.class)
public class MapTest {
    @Test
    public void test_ConvertToIntegerUsingMap() {
        List<String> stringList = Arrays.asList("123", "456", "789");
        List<Integer> integerList = stringList.stream().map(Integer::parseInt).collect(Collectors.toList());
        assert (integerList.equals(Arrays.asList(123, 456, 789)));
    }

    @Test
    public void test_SortedItems() {
        List<Integer> integerList = Arrays.asList(33, 5, 903, 5, 1);
        List<Integer> sorted = integerList.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(Optional.of(1), Optional.of(sorted.get(0)));
        int medianNumber = sorted.get(sorted.size() / 2);
        Assert.assertEquals(5, medianNumber);
    }

}
