package generics;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RunWith(JUnit4.class)
public class TestGenerics {

    @Test
    public void testGetList() {
        String[] letters = {"A", "B", "C"};
        List<String> fromNumsToStrings = getList(letters);
        Assert.assertNotNull(fromNumsToStrings);

        Character[] characters = {'a','b','c'};
        List<Character> fromCharsToStrings = getList(characters);
        Assert.assertNotNull(fromCharsToStrings);
    }

    @Test
    public void testConvertList(){
        Integer[] numbers = {1, 2, 3};
        Function<Object, String> mapper = Object::toString;;
        List<String> fromIntToString = convertList(numbers, mapper);
        Assert.assertEquals("1", String.valueOf(fromIntToString.getFirst()));

        Double[] doubles = {22.0, 43.34, 56.65};
        Function<Double, String> mapFromDoubleToString = Object::toString;
        List<String> fromDoubleToString = convertList(doubles, mapFromDoubleToString);
        Assert.assertEquals("22.0", fromDoubleToString.getFirst());
    }

    public static <T> List<T> getList(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }

    public static <T, G> List<G> convertList(T[] a, Function<T, G> mapperFunction) {
        return Arrays.stream(a).map(mapperFunction).collect(Collectors.toList());
    }
}