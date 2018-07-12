/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReplacementAlgorithms;

import nsetcache.CacheSet;
import nsetcache.SetElement;

/**
 * Replacement Algorithm interface
 * @author anisha
 */
public interface ReplacementAlgorithm {
    /**
     * Replace an entry if the cache is full
     * @param cacheSet
     * @param newElement 
     */
    public void replace(CacheSet cacheSet, SetElement newElement);
    
    /**
     * Update the entry if the key is already present in the cache
     * @param cacheSet
     * @param newElement 
     */
    public void update(CacheSet cacheSet, SetElement newElement);
}
