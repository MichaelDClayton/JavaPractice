package cache;

public class LRUCacheRunner {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        cache.display();
        cache.put(4, "four");
        cache.display();
        cache.put(5, "five");
        cache.display();

    }
}
