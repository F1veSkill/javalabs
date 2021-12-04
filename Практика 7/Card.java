package ru.mirea.prac7;

import java.util.Objects;

public class Card implements Comparable<Card> {

    private final Integer value;

    public Integer getValue() {
        return value;
    }

    public Card(Integer value){
        this.value = value;
    }

    @Override
    public int compareTo(Card o) {
        if (this.getValue() == 0 && o.getValue() == 9){
            return 1;
        }
        else if(this.getValue() == 9 && o.getValue() == 0){
            return -1;
        }
        return Integer.compare(this.value, o.value);
    }

    @Override
    public String toString() {
        return value.toString();
    }


    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Card card = (Card) o;
        return this.value.equals(card.value);
    }

    @Override
    public int hashCode() {
        return value;
    }
}
