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
public class Nsetcache implements Cache{
    
    private final int n;
    private final int setCount;
    private final ReplacementAlgorithm replacementAlgo;
    private List<CacheSet> cacheSets;
    
    // TODO make the cache thread safe
    
    public Nsetcache() {
        this(1,1,new LRU());
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
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    @Override
    public boolean put(Object key, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void initiateCache() {
        for(int i = 0; i<setCount; i++) {
            cacheSets.add(new CacheSet(n, replacementAlgo));
        }
    }
    
    public void invalidateCache() {
        cacheSets.clear();
    }
    
}
