package ru.mirea.prac8;

public class UnfairWaitList<E> extends WaitList<E> {

    public UnfairWaitList(){
        UnfairLinkedListRegistry.getInstance().put(this);
    }

    public void moveToBack (E element){
        if (element != null) {
            boolean flag = UnfairLinkedListRegistry.getInstance().check(this, element);
            if (flag) {
                System.out.println("Нет не буду");
            } else {
                content.add(element);
                System.out.println("Буду");
            }
        } else {
            content.add(content.remove());
        }
    }

    public void remove(E element) {
        content.remove(element);
        UnfairLinkedListRegistry.getInstance().add(this, element);
    }
}
