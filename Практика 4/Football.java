package ru.mirea.prac4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Football extends JFrame {

    private Integer totalMilan = 0;
    private Integer totalMadrid = 0;

    JLabel result;
    JLabel lastScorer;
    Label winner;

    public Football(){
        super("football");
        setSize(300,300);

        initComponents();

        addButton(this,BorderLayout.WEST, "Real Madrid", (event)->{
            ++totalMadrid;
            lastScorer.setText("Last Scorer: Real Madrid");
            result.setText(getStringResult());
            compareResult();
        });
        addButton(this,BorderLayout.EAST,"AC Milan", (event)->{
            ++totalMilan;
            lastScorer.setText("Last Scorer: AC Milan");
            result.setText(getStringResult());
            compareResult();
        });
        addComponents();
        pack();
    }

    private void initComponents(){
        winner = new Label("Winner: DRAW");
        lastScorer = new JLabel("Last Scorer: N/A");
        result = new JLabel("Result: 0 X 0");
    }

    private void addComponents(){
        add(BorderLayout.NORTH, lastScorer);
        add(BorderLayout.SOUTH, result);
        add(BorderLayout.CENTER, winner);
    }

    private void addButton(Container container, String pos, String text, ActionListener listener){
        JButton button = new JButton(text);
        container.add(pos, button);
        button.addActionListener(listener);
    }

    private void compareResult(){
        if(totalMadrid < totalMilan){
            winner.setText("Winner: AC Milan");
        }
        else if (totalMilan.equals(totalMadrid)) {
            winner.setText("Winner: DRAW");
        }
        else {
            winner.setText("Winner: Real Madrid");
        }
    }

    private String getStringResult(){
        return "Result: " + totalMadrid + " X " + totalMilan;
    }


    public static void main(String[] args) {
        new Football().setVisible(true);
    }
}
