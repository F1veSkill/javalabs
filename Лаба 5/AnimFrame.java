package ru.mirea.lab5;

import javax.swing.*;
import java.awt.*;

public class AnimFrame extends JFrame {

    private static final String path = "Be.gif";

    public AnimFrame(){
        super("Lab5");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel imageLabel = new JLabel();
        Icon imageIcon = new ImageIcon(getClass().getResource(path));
        imageLabel.setIcon(imageIcon);
        add(imageLabel, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

}
