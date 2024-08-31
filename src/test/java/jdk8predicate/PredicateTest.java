package jdk8predicate;

import entity.Person;
import entity.SearchListOfObjects;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
import java.util.function.Predicate;

@RunWith(JUnit4.class)
public class PredicateTest {
    @Test
    public void test_SimplePredicate() {
        Predicate<Integer> greaterThan10 = p -> (p > 10);
        boolean result = greaterThan10.test(12);
        assert (result);
    }

    @Test
    public void test_PredicateWithTwoConditions() {
        Predicate<String> startsWithA = p -> (p.startsWith("A"));
        Predicate<String> endsWithB = p -> (p.endsWith("b"));
        boolean result = startsWithA.and(endsWithB).test("Arab");
        assert (result);
    }

    @Test
    public void test_PredicateWithFilter() {
        Predicate<String> startsWIthM = p -> (p.startsWith("M"));
        Predicate<Integer> overAge25 = p -> (p > 25);

        List<Person> personList = SearchListOfObjects.createListOfObjects();
        List<Person> result = personList.stream().filter(p -> startsWIthM.test(p.getName()))
                .filter(p -> overAge25.test(p.getAge())).toList();
        assert (result.size() == 2);
    }
}
