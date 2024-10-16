package jdk8stream;

import entity.Person;
import entity.SearchListOfObjects;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class TestListToMap {

   @Test
    public void test_ListToMap(){
       List<Person> personList = SearchListOfObjects.createListOfObjects();
   }
}
