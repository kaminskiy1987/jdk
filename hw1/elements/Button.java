package jdk.hw1.elements;

import jdk.hw1.Colorica;
import jdk.hw1.iFont;
import javax.swing.*;

public class Button extends JButton implements iFont, Colorica {
    /**
     *
     * @param name имя поля
     * @param width длина
     * @param height высота
     * @param x позиция по оси Х
     * @param y позиция по оси Y
     */

    public void params(String name,int width,int height,int x,int y){
        setText(name);
        setFont(fontText);
        setBackground(colorText);
        setForeground(colorButton);
        setSize(width,height);
        setLocation(x,y);
        setFocusPainted(false);
        setBorderPainted(false);
    }
}