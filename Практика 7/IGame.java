package ru.mirea.prac7;

public interface IGame {
    void dealCard();
    void move();
    void registerViewObserver(ViewObserver v);
    void removeViewObserver(ViewObserver v);
    void notifyFirst(Card card);
    void notifySecond(Card card);
    void deleteFirst();
    void deleteSecond();
}
