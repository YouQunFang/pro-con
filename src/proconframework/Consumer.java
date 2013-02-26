/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proconframework;

/**
 *
 * @author youqunfang
 */
public class Consumer implements Runnable {

    private BoundBuffer buffer;

    public Consumer(BoundBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            int result = buffer.take();
            System.out.println("consumer take " + result);
            System.out.flush();
            if (result == Producer.STOP_VALUE) {
                break;
            }

        }
        System.out.println("consumer shutdown ==========");
    }
}
