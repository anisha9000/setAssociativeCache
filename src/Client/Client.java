/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import ReplacementAlgorithms.LRU;
import ReplacementAlgorithms.MRU;
import nsetcache.Nsetcache;

/**
 * Sample client program
 *
 * @author anisha
 */
public class Client {

    private static int n, setCount;
    private static ReplacementAlgorithms.ReplacementAlgorithm replacementAlgo;

    public static void main(String[] args) {

        if (args.length < 3) {
            System.out.println("java -jar Client.jar "
                    + "n=<number of blocks in a set> setcount=<no. of sets> "
                    + "algo=<lru/mru/custom> ");
            System.exit(0);
        }

        initializeVariables(args);
        createCache();
        System.exit(0);

    }

    /**
     * initialize input variables from command line
     *
     * @param args command line arguments
     */
    private static void initializeVariables(String[] args) {
        n = 1;
        setCount = 1;
        replacementAlgo = null;

        for (String arg : args) {
            String[] currInput = arg.split("=");
            if (currInput.length < 2) {
                System.out.println("java -jar Client.jar "
                        + "n=<number of blocks in a set> setcount=<no. of sets> "
                        + "algo=<lru/mru/custom> ");
                System.exit(0);
            }
            String command = currInput[0];
            String value = currInput[1];
            switch (command) {
                case "n":
                    n = Integer.parseInt(value);
                    break;
                case "setcount":
                    setCount = Integer.valueOf(value);
                    break;
                case "algo":
                    if(value.equalsIgnoreCase("mru")) {
                        replacementAlgo = new MRU();
                    } else if(value.equalsIgnoreCase("custom")) {
                        replacementAlgo = new CustomReplacementAlgorithm();
                    } else {
                        replacementAlgo = new LRU();
                    }
                    break;

            }
        }

    }

    private static void createCache() {
        Nsetcache clientCache = new Nsetcache(n, setCount, replacementAlgo);
        clientCache.put("December", "Capricorn");
        clientCache.put("November", "Saggitarius");
        clientCache.put("November", "Scorpio");
        System.out.println(clientCache.get("November"));
    }
}
