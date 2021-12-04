package ru.mirea.prac7;

import java.util.EmptyStackException;
import java.util.Stack;

public class Player {
    private final Stack<Card> cards;

    Player(){
        cards = new Stack<>();
    }

    public void addCard(Card card){
        cards.add(0, card);
    }

    public Card removeCard() throws EmptyStackException {
        return cards.pop();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("cards =");
        for (int i = cards.size()-1; i >= 0; i--){
            sb.append(" ").append(cards.get(i));
        }
        return sb.toString();
    }
}
