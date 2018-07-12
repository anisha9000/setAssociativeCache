/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsetcache;

import ReplacementAlgorithms.LRU;
import ReplacementAlgorithms.ReplacementAlgorithm;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 *
 * @author anisha
 */
public class CacheSet {
    
    private HashMap<Object, SetElement> cacheStoreMap;
    private LinkedList<SetElement> cacheStoreQueue;
    
    int capacity;
    ReplacementAlgorithm replaceAlgorithm;
    
    public CacheSet(int capacity) {
        this(capacity, new LRU());
    }

    CacheSet(int n, ReplacementAlgorithm replacementAlgo) {
        this.capacity = n;
        this.replaceAlgorithm = replacementAlgo;
        cacheStoreMap = new HashMap<>();
        cacheStoreQueue = new LinkedList<>();
    }
    
    
    public boolean isSpace() {
        return cacheStoreMap.size() < capacity;
    }
    
    public void put(Object key, Object value) {
        // the replacement logic comes here
    }
    
    public Object get(Object key) {
        if(cacheStoreMap.containsKey(key)) {
            // update replacement algorithm parameters
            return cacheStoreMap.get(key);        
        }
        return null;
    }
    
    public HashMap<Object, SetElement> getCacheStoreMap(){
        return cacheStoreMap;
    }
    
    public LinkedList<SetElement> getCacheStoreQueue(){
        return cacheStoreQueue;
    }
    
    
    
}
