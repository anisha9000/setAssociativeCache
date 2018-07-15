/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import nsetcache.CacheSet;
import nsetcache.SetElement;

/**
 * Custom replacement algorithm implementation goes here
 * @author anisha
 */
public class CustomReplacementAlgorithm implements 
        ReplacementAlgorithms.ReplacementAlgorithm{

    @Override
    public void replace(CacheSet cacheSet, SetElement newElement) {
        // custome replace logic
    }

    @Override
    public void update(CacheSet cacheSet, SetElement newElement) {
        // custom update logic
    }
    
}
