package jdk8consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@RunWith(JUnit4.class)
public class ConsumerTest {

    @Test
    public void test_SimpleConsumer() {
        Consumer<String> printer = System.out::println;
        printer.accept("Mike");
    }

    @Test
    public void test_ListConsumer(){
        Consumer<List<Integer>> display = System.out::println;
        Consumer<List<Integer>> collect = list->
        {
            list.replaceAll(integer -> integer * 2);
        };
        List<Integer> numbers = Arrays.asList(1,2,3,4);
        collect.accept(numbers);
        display.accept(numbers);

        assert (numbers.getFirst()==2);
        assert (numbers.getLast()==8);
        
    }
}
