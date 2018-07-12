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
 * Lest recently used replacement algorithm
 * @author anisha
 */
public class LRU implements ReplacementAlgorithm {
    
    int cacheMissCount;

    @Override
    public void replace(CacheSet cacheSet, SetElement newElement) {
        // TODO keep track of cache miss to understand if the replacement algorithm suits the current scenario
        HashMap<Object, SetElement> cacheStore = cacheSet.getCacheStoreMap();
        LinkedList<SetElement> cacheQueue = cacheSet.getCacheStoreQueue();
        
        // remove oldest element
        SetElement leastUsedElement = cacheQueue.removeLast();
        cacheStore.remove(leastUsedElement.getKey());
        
        // insert new element
        
        cacheQueue.addFirst(newElement);
        cacheStore.put(newElement.getKey(), newElement);
        
    }

    @Override
    public void update(CacheSet cacheSet, SetElement newElement) {
        HashMap<Object, SetElement> cacheStore = cacheSet.getCacheStoreMap();
        LinkedList<SetElement> cacheQueue = cacheSet.getCacheStoreQueue();
        
        // fetch element
        SetElement elementToUpdate = cacheStore.get(newElement.getKey());
        
        // update key
        
        elementToUpdate.setValue(newElement.getValue());
        
        // put element to first
        cacheQueue.remove(elementToUpdate);
        cacheQueue.addFirst(elementToUpdate);
        
    }
    
}
