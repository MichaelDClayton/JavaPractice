package jdk8stream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(JUnit4.class)
public class MapTest {
    @Test
    public void test_ConvertToSortedIntegerListUsingMap() {
        List<String> stringList = Arrays.asList("456","123", "789");
        List<Integer> integerList = stringList.stream().sorted().map(Integer::parseInt).toList();
        assert (integerList.equals(Arrays.asList(123, 456, 789)));
    }

    @Test
    public void test_SortedItems() {
        List<Integer> integerList = Arrays.asList(33, 5, 903, 5, 1);
        List<Integer> sorted = integerList.stream().sorted().toList();
        Assert.assertEquals(Optional.of(1), Optional.of(sorted.getFirst()));
        int medianNumber = sorted.get(sorted.size() / 2);
        Assert.assertEquals(5, medianNumber);
    }

    @Test
    public void test_SortStrings(){
        List<String> stringList = Arrays.asList("apple", "cherry", "banana");
        List<String> sorted = stringList.stream().sorted().toList();
        Assert.assertEquals(Optional.of("apple"), Optional.of(sorted.getFirst()));
    }

}
