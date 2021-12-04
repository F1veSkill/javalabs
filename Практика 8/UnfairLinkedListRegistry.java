package ru.mirea.prac8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class UnfairLinkedListRegistry<E>{


    public Map<UnfairWaitList<E>, ArrayList<E>> elements;
    private static volatile UnfairLinkedListRegistry instance;

    private UnfairLinkedListRegistry(){
        elements = new HashMap<>();
    }

    public static UnfairLinkedListRegistry getInstance() {
        if (instance == null){
            synchronized (UnfairLinkedListRegistry.class){
                instance = new UnfairLinkedListRegistry<>();
            }
        }
        return instance;
    }

    public void add(UnfairWaitList<E> list, E element){
        elements.get(list).add(element);
    }

    public void put(UnfairWaitList<E> list){
        elements.put(list, new ArrayList<>());
    }

    public boolean check(UnfairWaitList<E> list, E element){
        return elements.get(list).contains(element);
    }

}
