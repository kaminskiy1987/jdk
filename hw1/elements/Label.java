package jdk.hw1.elements;

import jdk.hw1.Colorica;
import jdk.hw1.iFont;
import javax.swing.*;

public class Label extends JLabel implements Colorica,iFont{
    /**
     *
     * @param width длина
     * @param height высота
     * @param x позиция по оси Х
     * @param y позиция по оси Y
     */

    public void params(int width,int height,int x,int y){
        setFont(fontText);
        setBackground(colorText);
        setForeground(colorButton);
        setSize(width,height);
        setLocation(x,y);
    }
}