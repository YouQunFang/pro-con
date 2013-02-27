/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proconframework;

/**
 *
 * @author youqunfang
 */
public class UnDuplicator implements Runnable {

    private UnboundedBuffer frombuffer;
    private UnboundedBuffer tobuffer1;
    private UnboundedBuffer tobuffer2;

    public UnDuplicator(UnboundedBuffer frombuffer, UnboundedBuffer tobuffer1, UnboundedBuffer tobuffer2) {
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
