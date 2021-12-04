package ru.mirea.prac7;

import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Stack;

public class Game implements IGame{

    int d;

    ViewObserver viewObserver;

    private final Player first;
    private final Player second;

    private final Stack<Card> deck;

    public Game(){
        first = new Player();
        second = new Player();
        deck = new Stack<>();
        this.viewObserver = new GameView(this);
    }

    @Override
    public void dealCard() {

        for (int i = 0; i <10; i++){
            deck.push(new Card(i));
        }

        Collections.shuffle(deck);
        Card card;
        for (int i = 0; i <5; i++){
            card = deck.pop();
            first.addCard(card);
            notifyFirst(card);
            card = deck.pop();
            second.addCard(card);
            notifySecond(card);

        }
    }

    @Override
    public void move() {
        Card o1, o2;

        try {
             o1 = first.removeCard();
        }
        catch (EmptyStackException ignored){
            viewObserver.win("second", d);
            return;
        }

        try {
            o2 = second.removeCard();
        }
        catch (EmptyStackException ignored){
            viewObserver.win("first", d);
            return;
        }

        if (d == 106){
            viewObserver.win("botva", d);
            return;
        }

        if (o1.compareTo(o2) > 0){
            giveToPlayer(first, o1, o2);
            deleteFirst();
            deleteSecond();
            notifyFirst(o1);
            notifyFirst(o2);
        } else {
            giveToPlayer(second, o2, o1);
            deleteFirst();
            deleteSecond();
            notifySecond(o2);
            notifySecond(o1);
        }

        d++;

        System.out.println(this);
    }

    @Override
    public void registerViewObserver(ViewObserver v) {
        viewObserver = v;
    }

    @Override
    public void removeViewObserver(ViewObserver v) {}

    @Override
    public void notifyFirst(Card card) {
        viewObserver.upgradeFirst(card);
    }

    @Override
    public void notifySecond(Card card) {
        viewObserver.upgradeSecond(card);
    }

    @Override
    public void deleteFirst() {
        viewObserver.removeFirst();
    }

    @Override
    public void deleteSecond() {
        viewObserver.removeSecond();
    }

    private void giveToPlayer(Player player, Card o1, Card o2) {
        player.addCard(o1);
        player.addCard(o2);
    }

    @Override
    public String toString() {
        return "first " + first +
                ", second " + second;
    }
}
