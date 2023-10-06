package jdk.hw1.elements;

import javax.swing.*;
import org.jdk.lesson1.Colorica;
import org.jdk.lesson1.iFont;

public class TextField extends JTextField implements Colorica, iFont{
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
        setSize(width,height);
        setFont(fontText);
        setBackground(textFieldColor);
        setForeground(colorText);
        setBorder((BorderFactory.createLineBorder(colorBorder)));
        setLocation(x,y);
    }
}