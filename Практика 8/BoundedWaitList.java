package ru.mirea.prac8;


public class BoundedWaitList<E> extends WaitList<E> {
    private final int capacity;

    public BoundedWaitList(int capacity)
    {
        super();
        this.capacity = capacity;
    }

    public int getCapacity()
    {
        return capacity;
    }

    @Override
    public void add(E element) {

        if (capacity < content.size())
        {
            super.add(element);
        }
        else
        {
            throw new RuntimeException("Bounded wait list overflow");
        }
    }
}
