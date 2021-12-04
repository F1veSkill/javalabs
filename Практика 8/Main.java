package ru.mirea.prac8;

public class Main {

    public static void main(String[] args) {
        UnfairWaitList<Integer> list = new UnfairWaitList<>();
        list.moveToBack(3);
        list.remove(3);
        list.moveToBack(3);

        UnfairWaitList<String> list2 = new UnfairWaitList<>();
        list2.moveToBack("3");
        list2.moveToBack("4");
        list2.moveToBack(null);
        list2.remove("4");
        list2.moveToBack("4");
    }
}
