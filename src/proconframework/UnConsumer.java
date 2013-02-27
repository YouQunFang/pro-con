/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proconframework;

/**
 *
 * @author youqunfang
 */
public class UnConsumer implements Runnable {

    private UnboundedBuffer buffer;

    public UnConsumer(UnboundedBuffer buffer) {
        this.buffer = buffer;
    }

    

    @Override
    public void run() {
        while (true) {
            int result = buffer.take();
            if (result == Producer.STOP_VALUE) {
                break;
            }
            System.out.println("consumer take " + result);
            System.out.flush();


        }
        System.out.println("consumer shutdown ==========");
    }
}
