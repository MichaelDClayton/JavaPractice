package lambdasyntax;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@RunWith(JUnit4.class)
public class LambdaSyntaxTest {
public interface IntegerFunction{
    Integer run(Integer x);
}

    @Test
    public void test_LambdaSyntax() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        Consumer<Integer> integerConsumer = System.out::println;
        numbers.forEach(integerConsumer);
    }

    @Test
    public void test_LambdaSyntaxWithMultiply(){
        IntegerFunction add = (n) -> n * 10;
        Integer result = add.run(10);
        Assert.assertEquals(Optional.of(100), Optional.of(result));
    }

}