package flatmap;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(JUnit4.class)
public class TestFlatMap {

    @Test
    public void test_FlatMap_Using_List(){
        List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1,2),Arrays.asList(3,4),Arrays.asList(5,6));
        //List<Integer> flattenedMap = listOfLists.stream().flatMap(list->list.stream()).toList();
        List<Integer> flattenedMap = listOfLists.stream().flatMap(Collection::stream).toList();
        Assert.assertEquals(6, flattenedMap.size());
    }


}
