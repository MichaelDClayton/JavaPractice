package cache;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LRUCacheTest {
    @Test
    public void test_LRUCache() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        Assert.assertNull(cache.get(1));
    }

}
