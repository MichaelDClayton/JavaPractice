package lambdasyntax;

import entity.Person;
import entity.SearchListOfObjects;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@RunWith(JUnit4.class)
public class TestLambdaAndStreamWithArrayList {
    public interface IntegerFunction {
        Integer run(Integer x);
    }

    @Test
    public void testLargestItem() {
        List<Integer> numbers = Arrays.asList(1, 34, 3, 5, 67, 94, 10);
        Optional<Integer> max = numbers.stream().max(Comparator.naturalOrder());
        max.ifPresent(integer -> Assert.assertEquals(94, integer.intValue()));
    }

    @Test
    public void testSecondSmallestNumber() {
        List<Integer> numbers = Arrays.asList(1, 34, 3, 5, 67, 94, 10);
        Optional<Integer> secondLargestNumber = numbers
                .stream()
                .sorted(Comparator.reverseOrder())
                .skip(4)
                .findFirst();
        Assert.assertEquals(5, secondLargestNumber.get().intValue());
    }

    @Test
    public void test_LambdaSyntax() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        Consumer<Integer> integerConsumer = System.out::println;
        numbers.forEach(integerConsumer);
    }

    @Test
    public void test_LambdaSyntaxWithMultiply() {
        IntegerFunction add = (n) -> n * 10;
        Integer result = add.run(10);
        Assert.assertEquals(Optional.of(100), Optional.of(result));
    }

    @Test
    public void test_OrderByAgeUsingLambda() {
        List<Person> personList = SearchListOfObjects.createListOfObjects();
        //System.out.println(personList);
        personList.sort((p1, p2) -> p2.getAge() - p1.getAge());
        //System.out.println(personList);
        Assert.assertEquals(60, personList.getFirst().getAge());
    }

    @Test
    public void test_OrderByNameAndAge_UsingComparator() {
        List<Person> personList = SearchListOfObjects.createListOfObjects();
        Comparator<Person> nameAndAgeComparator = Comparator.comparing(Person::getName)
                .thenComparing(Person::getAge);
        List<Person> sortedByNameAndAgeList = personList.stream().sorted(nameAndAgeComparator)
                .toList();
        //System.out.println(sortedByNameAndAgeList);
        Assert.assertEquals(50, personList.getFirst().getAge());
    }

}