package jdk8stream;

import entity.Person;
import entity.SearchListOfObjects;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ReduceTest {
    @Test
    public void test_IntegerReduce() {
        List<Integer> integerList = Arrays.asList(1, 1);
        Optional<Integer> result = integerList.stream().reduce(Integer::sum);
        assertEquals(Optional.of(2), result);
    }

    @Test
    public void test_StingReduce() {
        List<String> letters = Arrays.asList("A", "B", "C");
        String result = letters.stream().reduce("", String::concat);
        assertEquals("ABC", result);
    }

    @Test
    public void test_ReduceCustomObjects() {
        List<Person> personList = SearchListOfObjects.createListOfObjects();
        Integer result = personList.stream().reduce(0, (partialAgeResul, person) -> partialAgeResul + person.getAge(), Integer::sum);
        assert (result > 150);
    }

    @Test
    public void test_ReduceUsingParallel() {
        List<Integer> integerList = Arrays.asList(5, 9, 23, 7);//sum = 44.
        Optional<Integer> result = integerList.parallelStream().reduce(Integer::sum);
        if (result.isPresent()) {
            Assert.assertEquals(Optional.of(44), result);
        }
        assert result.isPresent();
    }
}