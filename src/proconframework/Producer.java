/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proconframework;

/**
 *
 * @author youqunfang
 */
public class Producer implements Runnable {

    private int max;
    private BoundBuffer buffer;
    public static final int STOP_VALUE = Integer.MIN_VALUE;

    public Producer(int max, BoundBuffer buffer) {
        this.max = max;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < max; i++) {
            buffer.put(i);
            System.out.println("producer insert " + i);
            System.out.flush();
        }
        buffer.put(STOP_VALUE);
        System.out.println("producer shutdown======");

    }
}
