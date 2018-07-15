/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsetcache;

import ReplacementAlgorithms.LRU;
import ReplacementAlgorithms.ReplacementAlgorithm;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author anisha
 */
public class Nsetcache implements Cache {

    private final int n;
    private final int setCount;
    private final ReplacementAlgorithm replacementAlgo;
    private List<CacheSet> cacheSets;

    Timer invalidateTimer;

    // TODO make the cache thread safe
    /**
     * Default Constructor
     */
    public Nsetcache() {
        this(1, 1, new LRU());
    }

    /**
     * Default replacement algorithm as LRU for the cache implementation
     *
     * @param n
     * @param setCount
     */
    public Nsetcache(int n, int setCount) {
        this(n, setCount, new LRU());
    }

    /**
     * Custom replacement algorithm used for the cache
     *
     * @param n
     * @param setCount
     * @param replacementAlgo
     */
    public Nsetcache(int n, int setCount, ReplacementAlgorithm replacementAlgo) {
        this.n = n;
        this.setCount = setCount;
        this.replacementAlgo = replacementAlgo;
        cacheSets = new ArrayList<>(setCount);
        initiateCache();
    }

    /**
     * Add an entry to the cache
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public boolean put(Object key, Object value) {
        if (key == null) {
            return false;
        }
        //TODO make hashcode custom?
        int setIndex = getSetIndex(key);
        // check if the key is already present. If yes, then update the entry
        Object currValue = get(key);
        cacheSets.get(setIndex).put(key, value);
        return true;
        // TODO try the next avaialble set where the data can be stored
    }

    /**
     * Retrieve an entry from the cache
     *
     * @param key
     * @return
     */
    @Override
    public Object get(Object key) {
        if (key == null) {
            return false;
        }
        int setIndex = getSetIndex(key);
        Object value = cacheSets.get(setIndex).get(key);
        //TODO if value == null, fecth from memory and put it in cache
        return value;
    }

    /**
     * Initialize cache objects
     */
    private void initiateCache() {
        for (int i = 0; i < setCount; i++) {
            cacheSets.add(new CacheSet(n, replacementAlgo));
        }
        invalidateTimer = new Timer();
        invalidateTimer.schedule(new Invalidator(cacheSets), 5000);
    }

    /**
     * Get the set number where the key should be stored
     *
     * @param key
     * @return
     */
    private int getSetIndex(Object key) {
        if (key == null) {
            return -1;
        }
        return Math.abs(key.hashCode()) % setCount;
    }

    /**
     * Invalidate cache periodically to ensure stale entries are updated
     */
    class Invalidator extends TimerTask {

        List<CacheSet> cacheSet;

        public Invalidator(List<CacheSet> cacheSet) {
            this.cacheSet = cacheSet;
        }

        @Override
        public void run() {
            cacheSets.clear();
        }
    }

    /**
     * Stop the timer thread and delete the resources when the cache is destroyed
     * @throws Throwable 
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        invalidateTimer.cancel();
    }
}
