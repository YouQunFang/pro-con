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
public class UnProConFramework {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UnboundedBuffer unboundedBuffer = new UnboundedBuffer();
        UnProducer unProducer = new UnProducer(10, unboundedBuffer);
        UnConsumer unConsumer = new UnConsumer(unboundedBuffer);
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.execute(unConsumer);
        pool.execute(unProducer);
        pool.shutdown();
    }
}
