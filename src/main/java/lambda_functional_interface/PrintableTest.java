package lambda_functional_interface;

import java.util.ArrayList;
import java.util.List;

public class PrintableTest {
    public static void main(String[] args) {
        printThing(() ->
            System.out.println("Hellow World!")
        );
        List<String> textNums = new ArrayList<>();
        textNums.add("1");
        textNums.add("3");
        textNums.add("2");
        List<Integer> numsList = textNums.stream().map(Integer::parseInt).toList();

        numsList.stream().sorted().forEach(System.out::println);

    }


    public static void printThing(Printable printable) {
        printable.print();
    }
}
