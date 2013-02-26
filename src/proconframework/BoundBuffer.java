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
public class BoundBuffer {

    private int capacity;
    private Queue<Integer> buffer = new LinkedList<>();

    public BoundBuffer(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(int element) {
        while (buffer.size() >= capacity) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        buffer.add(element);
        if (/*buffer.size() == capacity - 1*/buffer.size() == 1) {
            notifyAll();
        }
    }

    public synchronized int take() {
        while (buffer.size() == 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        int result = buffer.remove();
        if (/*buffer.size() == 1*/buffer.size() == capacity - 1) {
            notifyAll();
        }
        return result;
    }
}
