package lambdasyntax;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(JUnit4.class)
public class TestLambdaAndStreamWithHashMap {

    @Test
    public void testHashMapFiltering(){
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Johnny");
        hashMap.put(2, "Mary");
        hashMap.put(3, "Pauline");
        hashMap.put(4, "Samantha");

        Map<Integer, String> filteredMap =  hashMap.entrySet().stream()
                .filter(e -> e.getKey() > 2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        Assert.assertEquals(2, filteredMap.size());

    }

    @Test
    public void testConvertHashMapToList(){
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Johnny");
        hashMap.put(2, "Mary");
        hashMap.put(3, "Pauline");
        hashMap.put(4, "Samantha");

        List<String> list = hashMap.values().stream().toList();
        Assert.assertEquals(4, list.size());

    }

    @Test
    public void testConvertTwoListsToHashMap(){
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<String> list2 = Arrays.asList("Tom", "Dick", "Harry");

        HashMap<Integer, String> map =
                (HashMap<Integer, String>) IntStream.range(0, list1.size())
                .boxed()
                .collect(Collectors.toMap(list1::get, list2::get));
        Assert.assertEquals("Tom", map.get(1));
    }


}
