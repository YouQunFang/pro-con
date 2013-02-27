/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proconframework;

/**
 *
 * @author youqunfang
 */
public class Duplicator implements Runnable {

    private BoundBuffer frombuffer;
    private BoundBuffer tobuffer1;
    private BoundBuffer tobuffer2;

    public Duplicator(BoundBuffer frombuffer, BoundBuffer tobuffer1, BoundBuffer tobuffer2) {
        this.frombuffer = frombuffer;
        this.tobuffer1 = tobuffer1;
        this.tobuffer2 = tobuffer2;
    }

    @Override
    public void run() {
        while (true) {
            int items = frombuffer.take();
            tobuffer1.put(items);
            tobuffer2.put(items);
            System.out.println("duplicator : " + items);
            if (items == Producer.STOP_VALUE) {
                break;
            }
        }
    }
}
