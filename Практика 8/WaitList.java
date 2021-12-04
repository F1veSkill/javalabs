package ru.mirea.prac8;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

public class WaitList<E> implements  IWaitList<E> {

    protected ConcurrentLinkedQueue<E> content;

    public WaitList(){
        this.content = new ConcurrentLinkedQueue<E>();
    }

    @Override
    public void add(E element) {
        content.add(element);
    }

    @Override
    public E remove() {
        return content.remove();
    }

    @Override
    public boolean contains(E element) {
        return content.contains(element);
    }

    @Override
    public boolean containsAll(Collection<E> collection) {
        return content.containsAll(collection);
    }

    @Override
    public boolean isEmpty() {
        return content.isEmpty();
    }
}
