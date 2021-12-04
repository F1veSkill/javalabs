package ru.mirea.lab6;

import javax.swing.*;
import java.awt.*;

public class FontFrame extends JFrame {
    JTextField jta = new JTextField(25);

    FontFrame() {

        super("Example");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new FlowLayout());
        setSize(new Dimension(400, 200));

        JButton timesNewRoman = new JButton("Times New Roman");
        JButton msSansSerif = new JButton( "MS Sans Serif");
        JButton courierNew = new JButton("Courier New");
        JButton blue = new JButton("Blue");
        JButton black = new JButton("Black");
        JButton red = new JButton("Red");

        add(jta, BorderLayout.CENTER);
        add(timesNewRoman, BorderLayout.EAST);
        add(msSansSerif, BorderLayout.EAST);
        add(courierNew, BorderLayout.EAST);
        add(blue, BorderLayout.WEST);
        add(black, BorderLayout.WEST);
        add(red, BorderLayout.WEST);

        timesNewRoman.addActionListener(e -> {
            Font font = new Font("Times new roman", Font.BOLD, 20);
            jta.setFont(font);
        });
        msSansSerif.addActionListener(e -> {
            Font font = new Font("MS Sans Serif", Font.BOLD, 20);
            jta.setFont(font);
        });
        courierNew.addActionListener(e -> {
            Font font = new Font("Courier New", Font.BOLD, 20);
            jta.setFont(font);
        });
        blue.addActionListener(e -> jta.setForeground(Color.BLUE));
        black.addActionListener(e -> jta.setForeground(Color.black));
        red.addActionListener(e -> jta.setForeground(Color.RED));

        setVisible(true);
    }

    public static void main(String[] args) {
        new FontFrame();
    }
}
