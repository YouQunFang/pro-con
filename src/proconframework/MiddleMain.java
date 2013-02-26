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
public class MiddleMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BoundBuffer buffer1 = new BoundBuffer(5);
        BoundBuffer buffer2 = new BoundBuffer(4);
        Producer producer = new Producer(10, buffer1);
        Consumer consumer = new Consumer(buffer2);
        MiddleMan mm = new MiddleMan(buffer1, buffer2);
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.execute(producer);
        pool.execute(mm);
        pool.execute(consumer);
        
        pool.shutdown();
    }
}
