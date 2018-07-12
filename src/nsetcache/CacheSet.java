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

/**
 * The operations responsible for every set
 * @author anisha
 */
public class CacheSet {
    
    private HashMap<Object, SetElement> cacheStoreMap;
    private LinkedList<SetElement> cacheStoreQueue;
    
    int capacity;
    ReplacementAlgorithm replaceAlgorithm;
    
    /**
     * Constructor
     * @param capacity 
     */
    public CacheSet(int capacity) {
        this(capacity, new LRU());
    }

    /**
     * Constructor
     * @param n
     * @param replacementAlgo 
     */
    CacheSet(int n, ReplacementAlgorithm replacementAlgo) {
        this.capacity = n;
        this.replaceAlgorithm = replacementAlgo;
        cacheStoreMap = new HashMap<>();
        cacheStoreQueue = new LinkedList<>();
    }
    
    /**
     * Does the set has capacity to store more elements
     * @return 
     */
    public boolean isSpace() {
        return cacheStoreMap.size() < capacity;
    }
    
    /**
     * Add value to the set
     * @param key
     * @param value 
     */
    public void put(Object key, Object value) {
        if(cacheStoreMap.containsKey(key)) {
            replaceAlgorithm.update(this, new SetElement(key, value));
        } else {
            SetElement newElement = new SetElement(key, value);
            if(isSpace()) {
                cacheStoreMap.put(key, newElement);
                cacheStoreQueue.addFirst(newElement);
            } else {
                replaceAlgorithm.replace(this, newElement);
            }
        }
    }
    
    /**
     * get value from the set
     * @param key
     * @return 
     */
    public Object get(Object key) {
        if(cacheStoreMap.containsKey(key)) {
            SetElement fetchedData = cacheStoreMap.get(key);
            cacheStoreQueue.remove(fetchedData);
            cacheStoreQueue.addFirst(fetchedData);
            return fetchedData.getValue();        
        }
        return null;
    }
    
    /**
     * Fetch cachemap
     * @return 
     */
    public HashMap<Object, SetElement> getCacheStoreMap(){
        return cacheStoreMap;
    }
    
    /**
     * Fetch the setElement Queue
     * @return 
     */
    public LinkedList<SetElement> getCacheStoreQueue(){
        return cacheStoreQueue;
    }
    
    
    
}
