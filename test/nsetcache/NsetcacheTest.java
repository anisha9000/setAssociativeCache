/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsetcache;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anisha
 */
public class NsetcacheTest {
    
    public NsetcacheTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of put method, of class Nsetcache.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        Object key = null;
        Object value = null;
        Nsetcache instance = new Nsetcache();
        boolean expResult = false;
        boolean result = instance.put(key, value);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of get method, of class Nsetcache.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        Object key = null;
        Nsetcache instance = new Nsetcache();
        Object expResult = false;
        Object result = instance.get(key);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of invalidateCache method, of class Nsetcache.
     */
    @Test
    public void testInvalidateCache() {
        System.out.println("invalidateCache");
        Nsetcache instance = new Nsetcache();
        instance.invalidateCache();
        
    }
    
    @Test
    public void testCachePut() {
        Nsetcache instance = new Nsetcache(2,2);
        boolean result;
        result = instance.put(1, "value1");
        assertEquals(true, result);
        result = instance.put(3, "value2");
        assertEquals(true, result);
        result = instance.put(5, "value3");
        assertEquals(false, result);
    }
    
    @Test
    public void testCacheReplace() {
        Nsetcache instance = new Nsetcache(2,2);
        boolean result;
        result = instance.put(1, "value1");
        assertEquals(true, result);
        result = instance.put(3, "value2");
        assertEquals(true, result);
        result = instance.put(1, "value3");
        assertEquals(true, result);
        Object updatedValue = instance.get(1);
        assertEquals("value3", updatedValue);
    }
    
    @Test
    public void testCacheGet() {
        Nsetcache instance = new Nsetcache(2,2);
        boolean result;
        result = instance.put(1, "value1");
        Object getValue = instance.get(1);
        assertEquals("value1", getValue);
        getValue = instance.get(2);
        assertEquals(null, getValue);
    }
    
}
