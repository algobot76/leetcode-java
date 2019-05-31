package com.algobot76.leetcode._380;

import java.util.*;

public class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int idx = map.remove(val);
        int last = list.remove(list.size() - 1);
        if (val != last) {
            list.set(idx, last);
            map.put(last, idx);
        }
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
