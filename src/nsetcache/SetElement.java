/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsetcache;

/**
 * The data bundle saved in the cache
 * @author anisha
 */
public class SetElement {
    Object key;
    Object value;
    long timestamp;
    
    /**
     * Constructor
     * @param key
     * @param value 
     */
    public SetElement(Object key, Object value) {
        this.key = key;
        this.value = value;
        timestamp = System.currentTimeMillis();        
    }
    
    public Object getKey() {
        return key;
    }
    
    public Object getValue() {
        return value;
    }
    
    public long getTimeStamp() {
        return timestamp;
    }
    
    public void setValue(Object value) {
        this.value = value;
        timestamp = System.currentTimeMillis();
    }
}
