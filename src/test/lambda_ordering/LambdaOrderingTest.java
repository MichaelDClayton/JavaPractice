package lambda_ordering;

import entity.Person;
import entity.SearchListOfObjects;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

public class LambdaOrderingTest {


   @Test
    public void test_order_by_name() {
       List<Person> personList = SearchListOfObjects.createListOfObjects();
       //System.out.println(personList);
       personList.sort((p1, p2) -> p2.getAge() - p1.getAge());
       System.out.println(personList);
       Assert.assertEquals(personList.getFirst().getAge(), 60);
   }

    @Test
    public void test_order_by_name_and_age() {
        List<Person> personList = SearchListOfObjects.createListOfObjects();
        Comparator<Person> nameAndAgeComparator = Comparator.comparing(Person::getName)
                .thenComparing(Person::getAge);
        List<Person> sortedByNameAndAgeList = personList.stream().sorted(nameAndAgeComparator)
                        .toList();
        System.out.println(sortedByNameAndAgeList);
        Assert.assertEquals(personList.getFirst().getAge(), 50);
    }
}
