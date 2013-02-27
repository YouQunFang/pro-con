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
public class UnboundedBuffer {

    private int capacity;
    private Queue<Integer> buffer = new LinkedList<>();

    public UnboundedBuffer(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(int element) {

        buffer.add(element);

    }

    public synchronized int take() {

        int result = buffer.remove();

        return result;
    }
}
