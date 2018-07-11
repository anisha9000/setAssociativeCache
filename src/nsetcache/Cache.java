/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsetcache;

/**
 * Cache interface defining the operations for a cache
 * @author anisha
 */
public interface Cache {
    
    /**
     * put the key value pair into the cache.
     * @param key
     * @param value
     * @return true if successfully put into the cache, false instead
     */
    public boolean put(Object key, Object value);
    
    /**
     * Gets the value corresponding to the key
     * @param key
     * @return value if present, null otherwise 
     */
    public Object get(Object key);
}
