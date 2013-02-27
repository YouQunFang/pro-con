/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proconframework;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author youqunfang
 */
public class UnboundedBuffer implements Buffer{

    
    private Queue<Integer> buffer = new LinkedList<>();

    
    @Override
    public synchronized void put(int element) {
       
        buffer.add(element);
        if (/*buffer.size() == capacity - 1*/buffer.size() == 1) {
            notifyAll();
        }
    }

    @Override
    public synchronized int take() {
        while (buffer.size() == 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        int result = buffer.remove();
        
        return result;
    }
}
