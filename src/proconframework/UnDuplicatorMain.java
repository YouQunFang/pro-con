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
public class UnDuplicatorMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UnboundedBuffer buffer1 = new UnboundedBuffer();
        UnboundedBuffer buffer2 = new UnboundedBuffer();
        UnboundedBuffer buffer3 = new UnboundedBuffer();
        UnProducer producer = new UnProducer(10, buffer1);
        UnConsumer consumer1 = new UnConsumer(buffer2);
        UnConsumer consumer2 = new UnConsumer(buffer3);
        UnDuplicator du = new UnDuplicator(buffer1, buffer2, buffer3);
        ExecutorService pool = Executors.newFixedThreadPool(4);
        pool.execute(producer);
        pool.execute(du);
        pool.execute(consumer1);
        pool.execute(consumer2);
        
        pool.shutdown();
    }
}
