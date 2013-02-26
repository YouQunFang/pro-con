/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proconframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author youqunfang
 */
public class ProConFramework {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BoundBuffer buffer = new BoundBuffer(10);
        Producer producer = new Producer(30, buffer);
        Consumer consumer = new Consumer(buffer);
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.execute(producer);
        pool.execute(consumer);
        pool.shutdown();
    }
}
