package jdk8stream;

import entity.Person;
import entity.SearchListOfObjects;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RunWith(JUnit4.class)
public class TestListToMap {

   @Test
    public void test_ListToMap(){
       List<Person> personList = SearchListOfObjects.createListOfObjects();
       System.out.println(personList);
       Map<String, Person> map = personList.stream()
               .collect(Collectors.toMap(Person::getName, Function.identity()));
       Assert.assertNotNull(map.get("Mike"));
   }
}
