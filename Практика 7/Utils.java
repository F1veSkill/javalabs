package ru.mirea.prac7;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    private static final Map<Card, String> cards = initMap();

    public static String getCardPath(Card card){
        return cards.get(card);
    }

    private static Map<Card, String> initMap(){
        Map<Card, String> map = new HashMap<>();
        map.put(new Card(0), "two_spades.png");
        map.put(new Card(1), "three_spades.png");
        map.put(new Card(2), "four_spades.png");
        map.put(new Card(3), "five_spades.png");
        map.put(new Card(4), "six_spades.png");
        map.put(new Card(5), "seven_spades.png");
        map.put(new Card(6), "eight_spades.png");
        map.put(new Card(7), "nine_spades.png");
        map.put(new Card(8), "ten_spades.png");
        map.put(new Card(9), "jack_spades.png");
        return map;
    }
}
