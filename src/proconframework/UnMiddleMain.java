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
public class UnMiddleMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UnboundedBuffer buffer1 = new UnboundedBuffer();
        UnboundedBuffer buffer2 = new UnboundedBuffer();
        UnProducer producer = new UnProducer(10, buffer1);
        UnConsumer consumer = new UnConsumer(buffer2);
        UnMiddleMan mm = new UnMiddleMan(buffer1, buffer2);
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.execute(producer);
        pool.execute(mm);
        pool.execute(consumer);
        
        pool.shutdown();
    }
}
