/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import nsetcache.Nsetcache;

/**
 * Sample client program
 * @author anisha
 */
public class Client {
    public static void main(String[] args) {
        Nsetcache clientCache = new Nsetcache(2,2, new CustomReplacementAlgorithm());
        clientCache.put("December", "Capricorn");
        clientCache.put("November", "Saggitarius");
        clientCache.put("November", "Scorpio");
        System.out.println(clientCache.get("November"));
    }
}
