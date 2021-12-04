package ru.mirea.prac7;

public interface ViewObserver {
    void upgradeFirst(Card card);
    void upgradeSecond(Card card);
    void removeFirst();
    void removeSecond();
    void win(String n, int a);
}
