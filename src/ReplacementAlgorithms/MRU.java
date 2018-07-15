/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReplacementAlgorithms;

import java.util.HashMap;
import java.util.LinkedList;
import nsetcache.CacheSet;
import nsetcache.SetElement;

/**
 * Most recently used replacement algorithm
 * @author anisha
 */
public class MRU implements ReplacementAlgorithm {
    
    static int cacheMissCount;

    /**
     * if the cache is full, replace the latest entry with the new one
     * @param cacheSet
     * @param newElement 
     */
    @Override
    public void replace(CacheSet cacheSet, SetElement newElement) {
        HashMap<Object, SetElement> cacheStore = cacheSet.getCacheStoreMap();
        LinkedList<SetElement> cacheQueue = cacheSet.getCacheStoreQueue();
        
        // remove oldest element
        SetElement leastUsedElement = cacheQueue.removeFirst();
        cacheStore.remove(leastUsedElement.getKey());
        
        // insert new element
        
        cacheQueue.addFirst(newElement);
        cacheStore.put(newElement.getKey(), newElement);
        
        cacheMissCount++;
        // Send to a log file for analytics
        System.out.println("Cache miss for data:"+ newElement.getValue().toString());
    }

    /**
     * if the cache contains the element, update the content
     * @param cacheSet
     * @param newElement 
     */
    @Override
    public void update(CacheSet cacheSet, SetElement newElement) {
        HashMap<Object, SetElement> cacheStore = cacheSet.getCacheStoreMap();
        LinkedList<SetElement> cacheQueue = cacheSet.getCacheStoreQueue();
        
        // fetch element
        SetElement elementToUpdate = cacheStore.get(newElement.getKey());
        
        // update key
        elementToUpdate.setValue(newElement.getValue());
        
        // put element to begining of the queue
        cacheQueue.remove(elementToUpdate);
        cacheQueue.addFirst(elementToUpdate);
        
    }
    
    /**
     * Return the number of cachemiss till now. This is more for 
     * performance evaluation of the current algorithm
     * @return 
     */
    public int getMissCount() {
        return cacheMissCount;
    }
    
}
