package cache;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
    private final HashMap<Integer, String> data = new HashMap<>();
    private final int capacity;
    private final LinkedList<Integer> order = new LinkedList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public String get(int key) {
        String res = data.get(key);

        if (res != null) {
            order.remove(key);
            order.addFirst(key);

            return res;
        } else {
            return null;
        }
    }

    public void put(int key, String value) {
        if (order.size() >= capacity) {
            int keyRemoved = order.removeLast();
            data.remove(keyRemoved);
        }
        order.addFirst(key);
        data.put(key, value);
    }

    public void display() {

        for (int key : order) {
            System.out.println(key + " => " + data.get(key));
        }
        System.out.println("*****************");
    }
}
