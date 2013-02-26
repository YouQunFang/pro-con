/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proconframework;

/**
 *
 * @author youqunfang
 */
public class MiddleMan implements Runnable {

    private BoundBuffer takebuffer;
    private BoundBuffer putbuffer;

    public MiddleMan(BoundBuffer takebuffer, BoundBuffer putbuffer) {
        this.takebuffer = takebuffer;
        this.putbuffer = putbuffer;
    }

    @Override
    public void run() {

        while (true) {
            int items = takebuffer.take();
            putbuffer.put(items);
            if (items == Producer.STOP_VALUE) {
                break;
            }
//            System.out.println("middleman : " + items);

        }
        System.out.println("middleman shtudown");


    }
}
