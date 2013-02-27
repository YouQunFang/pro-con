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
public class DuplicatorMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BoundBuffer buffer1 = new BoundBuffer(4);
        BoundBuffer buffer2 = new BoundBuffer(4);
        BoundBuffer buffer3 = new BoundBuffer(4);
        Producer producer = new Producer(10, buffer1);
        Consumer consumer1 = new Consumer(buffer2);
        Consumer consumer2 = new Consumer(buffer3);
        Duplicator du = new Duplicator(buffer1, buffer2, buffer3);
        ExecutorService pool = Executors.newFixedThreadPool(4);
        pool.execute(producer);
        pool.execute(du);
        pool.execute(consumer1);
        pool.execute(consumer2);
        
        pool.shutdown();
    }
}
