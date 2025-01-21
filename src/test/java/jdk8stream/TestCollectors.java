package jdk8stream;

import entity.Person;
import entity.SearchListOfObjects;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@RunWith(JUnit4.class)
public class TestCollectors {


    @Test
    public void test_minBy(){
        List<Person> personList = SearchListOfObjects.createListOfObjects();
        //System.out.println(personList);
        Optional<Person> min =
                personList.stream().min(Comparator.comparing(Person::getAge));
        min.ifPresent(person -> Assert.assertEquals(32, person.getAge()));
    }

    @Test
    public void test_partitionBy(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        Map<Boolean, List<Integer>> mapPartitionedBy = numbers.stream().collect(Collectors.partitioningBy(p->p % 2 ==0));
        int sizeOfTrue = mapPartitionedBy.get(true).size();
        Assert.assertEquals(3, sizeOfTrue);
    }

    @Test
    public void test_partitionByWithCustomObjects(){
        List<Person> personList = SearchListOfObjects.createListOfObjects();
        System.out.println(personList);
        Map<Boolean, List<Person>> mapPartitionedBy = personList.stream().collect(Collectors.partitioningBy(p->p.getAge()>50));
        int sizeOfTrue = mapPartitionedBy.get(true).size();
        Assert.assertEquals(1, sizeOfTrue);
    }

    @Test
    public void test_groupByCounting(){
        List<String> colors = Arrays.asList("Green", "Blue", "Green", "White", "Purple");
        Map<String, Long> colorMap = colors.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Assert.assertEquals(Long.valueOf(2), colorMap.get("Green"));
    }

}
