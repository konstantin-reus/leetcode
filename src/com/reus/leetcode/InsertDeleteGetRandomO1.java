package com.reus.leetcode;

import java.util.Random;

public class InsertDeleteGetRandomO1 {
    Bucket[] buckets;
    int added = 0;

    /**
     * Initialize your data structure here.
     */
    public InsertDeleteGetRandomO1() {
        buckets = new Bucket[1000]; //TODO auto resize with load factor, rehashing
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        int bucketNum = Math.abs(val % buckets.length);
        added++;
        return addToBucket(bucketNum, val);
    }

    private boolean addToBucket(int bucketNum, int val) {
        Bucket bucket = buckets[bucketNum];
        if (bucket == null) {
            Bucket bucketToAdd = new Bucket();
            bucketToAdd.value = val;
            buckets[bucketNum] = bucketToAdd;
            return true;
        } else {
            if (bucket.value == val) {
                return false;
            } else {
                Bucket lastBucket = bucket;
                while (bucket != null) {
                    lastBucket = bucket;
                    bucket = bucket.next;
                    if (bucket != null && bucket.value == val) return false;
                }
                Bucket bucketToAdd = new Bucket();
                bucketToAdd.value = val;
                bucketToAdd.prev = lastBucket;
                lastBucket.next = bucketToAdd;
                return true;
            }
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        int bucketIndex = Math.abs(val % buckets.length);
        Bucket bucket = buckets[bucketIndex];
        if (bucket == null) {
            return false;
        } else {
            if (bucket.value == val) {
                buckets[bucketIndex] = bucket.next;
                return true;
            } else {
                while (bucket != null) {
                    bucket = bucket.next;
                    if (bucket != null && bucket.value == val) {
                        bucket.prev.next = bucket.next;
                        if (bucket.next != null) {
                            bucket.next.prev = bucket.prev;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        if (added == 0) {
            return -1;
        }
        Bucket bucket = null;
        while (bucket == null) {
            bucket = buckets[new Random().nextInt(buckets.length)];
        }
        return bucket.value;

    }

    private static class Bucket {
        int value;
        Bucket next;
        Bucket prev;
    }
}
