package entity;

import java.util.ArrayList;
import java.util.List;

public class SearchListOfObjects {




    public static List<Person> createListOfObjects(){
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person("Mike", 50);
        Person person2 = new Person("Suzy", 32);
        Person person3 = new Person("James", 34);
        Person person4 = new Person("Mike", 60);

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

        return personList;

    }



}