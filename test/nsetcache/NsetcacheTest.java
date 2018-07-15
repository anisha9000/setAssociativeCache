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

    @Test
    public void testCachePut() {
        Nsetcache instance = new Nsetcache(2,2);
        boolean result;
        result = instance.put(1, "value1");
        assertEquals(true, result);
        result = instance.put(3, "value2");
        Object valuePut = instance.get(3);
        assertEquals(true, result);
        assertEquals("value2", valuePut);
        result = instance.put(5, "value3");
        assertEquals(true, result);
    }
    
    @Test
    public void testCacheUpdate() {
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
    
    @Test
    public void testCacheReplace() {
        Nsetcache instance = new Nsetcache(2,2);
        boolean result;
        result = instance.put(1, "value1");
        assertEquals(true, result);
        result = instance.put(3, "value2");
        assertEquals(true, result);
        result = instance.put(5, "value3");
        assertEquals(true, result);
        Object updatedValue = instance.get(1);
        assertEquals(null, updatedValue);
        updatedValue = instance.get(3);
        assertEquals( "value2", updatedValue);
        updatedValue = instance.get(5);
        assertEquals( "value3", updatedValue);
    }
    
}
