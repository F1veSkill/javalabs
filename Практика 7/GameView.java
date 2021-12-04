package ru.mirea.prac7;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameView implements ViewObserver{
    private final IGame game;

    private final JFrame frame;
    private final ImageComponent[] firstPlayerCards;
    private final ImageComponent[] secondPlayerCards;

    private int indexFirst;
    private int indexSecond;

    private volatile boolean isGame;

    private JLabel textField;


    public GameView(IGame game){
        this.game = game;
        frame = new JFrame("123");
        frame.setLayout(new GridLayout(3, 10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        firstPlayerCards = new ImageComponent[10];
        secondPlayerCards = new ImageComponent[10];

        initCardLabels(true, firstPlayerCards);
        initCardLabels(false, secondPlayerCards);

        initButton();

        indexFirst = 0;
        indexSecond = 0;
        isGame = true;

        game.registerViewObserver(this);

        frame.setBounds(50, 50, 300, 300);
        frame.setVisible(true);
    }

    public void initCardLabels(boolean isTop, ImageComponent[] labels){
        Box back =  new Box(BoxLayout.X_AXIS);
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new ImageComponent();
            back.add(labels[i]);
        }
        frame.add(isTop ? BorderLayout.NORTH : BorderLayout.SOUTH, back);

    }

    public void initButton(){
        Box back =  new Box(BoxLayout.X_AXIS);
        JButton next = new JButton("next step");
        next.addActionListener((event)-> game.move());
        back.add(next);
        frame.add(BorderLayout.CENTER, back);

        JButton speed = new JButton("Speed");
        speed.addActionListener((event)->{
            while (isGame){
                game.move();
            }
        });
        back.add(speed);

        textField = new JLabel();
        back.add(textField);

    }

    @Override
    public void upgradeFirst(Card card) {
        firstPlayerCards[indexFirst].setImage(Utils.getCardPath(card));
        indexFirst++;
    }

    @Override
    public void upgradeSecond(Card card) {
        secondPlayerCards[indexSecond].setImage(Utils.getCardPath(card));
        indexSecond++;
    }

    @Override
    public void removeFirst() {
        for (int i = 0; i < indexFirst; i++) {
            firstPlayerCards[i].setImage(firstPlayerCards[i+1].image);
            firstPlayerCards[i].repaint();
        }
        indexFirst--;
    }

    @Override
    public void removeSecond() {
        for (int i = 0; i < indexSecond; i++) {
            secondPlayerCards[i].setImage(secondPlayerCards[i+1].image);
            secondPlayerCards[i].repaint();
        }
        indexSecond--;
    }

    @Override
    public void win(String n, int a) {
        isGame = false;
        if (n.equals("botva"))
            textField.setText(n);
        else
            textField.setText(n + " " + a);
        System.out.println(a);
    }


    static class ImageComponent extends JPanel
    {
        ImageComponent(){
        }

        public void setImage(String file) {
            try{
                image = ImageIO.read(getClass().getResource(file));
            }
            catch(IOException ignored) {}
            repaint();
        }

        public void setImage(Image image) {
            this.image = image;
        }

        public void paintComponent(Graphics g)
        {
            if (image == null){
                g.fillRect(0, 0, getWidth(), getHeight());
            }
            g.drawImage(image, 0, 0, null);
        }
        private Image image;
    }
}
