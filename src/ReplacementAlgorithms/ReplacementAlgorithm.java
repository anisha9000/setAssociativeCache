/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReplacementAlgorithms;

import nsetcache.CacheSet;
import nsetcache.SetElement;

/**
 *
 * @author anisha
 */
public interface ReplacementAlgorithm {
    public void replace(CacheSet cacheSet, SetElement newElement);
    
    public void update(CacheSet cacheSet, SetElement newElement);
}
