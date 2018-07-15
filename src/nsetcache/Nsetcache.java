/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsetcache;

import ReplacementAlgorithms.LRU;
import ReplacementAlgorithms.ReplacementAlgorithm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author anisha
 */
public class Nsetcache implements Cache {

    private final int n;
    private final int setCount;
    private final ReplacementAlgorithm replacementAlgo;
    private List<CacheSet> cacheSets;

    // TODO make the cache thread safe
    public Nsetcache() {
        this(1, 1, new LRU());
    }

    public Nsetcache(int n, int setCount) {
        this(n, setCount, new LRU());
    }

    public Nsetcache(int n, int setCount, ReplacementAlgorithm replacementAlgo) {
        this.n = n;
        this.setCount = setCount;
        this.replacementAlgo = replacementAlgo;
        cacheSets = new ArrayList<>(setCount);
        initiateCache();
    }

    @Override
    public boolean put(Object key, Object value) {
        if (key == null) {
            return false;
        }
        //TODO make hashcode custom?
        int setIndex = getSetIndex(key);
        // check if the key is already present. If yes, then update the entry
        Object currValue = get(key);
        if (currValue != null) {
            cacheSets.get(setIndex).put(key, value);
            return true;
        } else if (cacheSets.get(setIndex).isSpace()) {
            cacheSets.get(setIndex).put(key, value);
            return true;
        }
        // TODO try the next avaialble set where the data can be stored
        return false;
    }

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

    private void initiateCache() {
        for (int i = 0; i < setCount; i++) {
            cacheSets.add(new CacheSet(n, replacementAlgo));
        }
    }

    //TODO schedule to be called every custom time window
    public void invalidateCache() {
        cacheSets.clear();
    }

    private int getSetIndex(Object key) {
        if (key == null) {
            return -1;
        }
        return Math.abs(key.hashCode()) % setCount;
    }

}
