package jdk.hw1;

import jdk.hw1.elements.Button;
import jdk.hw1.elements.Label;
import jdk.hw1.elements.TextArea;
import jdk.hw1.elements.TextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class ChatWindows extends JFrame implements Colorica{
    private static final int WINDOW_HEIGHT = 500;
    private static final int WINDOW_WIDTH = 380;
    private static final int WINDOW_POSX = 700;
    private static final int WINDOW_POSY = 200;

    private Container container;

    ChatWindows() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("iMolvitsa");
        setResizable(false);
        getContentPane().setBackground(background);
        container = getContentPane();
        container.setLayout(null);

        Label name= new Label();
        name.params(150,30,180,10);
        container.add(name);
        name.setVisible(false);

        Label error= new Label();
        error.params(200,30,20,110);
        error.setForeground(Color.RED);
        container.add(error);
        error.setVisible(false);

        TextField login =new TextField();
        login.params("login",150,30,20,30);
        container.add(login);

        TextField pass = new TextField();
        pass.params("pass",150,30,20,70);
        container.add(pass);

        TextField ip = new TextField();
        ip.params("ip",150,30,190,30);
        container.add(ip);

        TextField port = new TextField();
        port.params("port",150,30,190,70);
        container.add(port);

        TextField message = new TextField();
        message.params("message",256,30,20,400);
        message.setEnabled(false);
        container.add(message);

        Button btnConnect = new Button();
        btnConnect.params("Connect",100,30,240,110);
        container.add(btnConnect);

        Button btnDisconnect = new Button();
        btnDisconnect.params("Disconnect",100,30,240,10);
        btnDisconnect.setVisible(false);
        container.add(btnDisconnect);

        Button btnSend = new Button();
        btnSend.params("Send",65,30,275,400);
        btnSend.setEnabled(false);
        container.add(btnSend);

        TextArea fieldChat= new TextArea();
        fieldChat.params(320,251,20,150);
        fieldChat.setEditable(false);
        container.add(fieldChat);

        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                login.setText("");
            }

        });

        pass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pass.setText("");
            }
        });

        ip.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ip.setText("");
            }
        });

        port.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                port.setText("");
            }
        });

        btnConnect.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (login.getText().equals("") || pass.getText().equals("")
                        || ip.getText().equals("") || port.getText().equals("")){
                    error.setText("Error filling out registration fields!");
                    error.setVisible(true);
                }
                else if(port.getText().equals("8000")){
                    error.setVisible(false);
                    login.setVisible(false);
                    pass.setVisible(false);
                    ip.setVisible(false);
                    port.setVisible(false);
                    btnDisconnect.setVisible(true);
                    btnConnect.setVisible(false);
                    btnSend.setEnabled(true);
                    error.setVisible(false);
                    name.setVisible(true);
                    name.setText(login.getText());
                    fieldChat.setSize(320,351);;
                    fieldChat.setLocation(20,50);

                    try {
                        SaveChat.read(fieldChat);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    message.setEnabled(true);
                }
                else {error.setText("Port error!");
                   error.setVisible(true);}

            }
        });

        btnDisconnect.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                login.setVisible(true);
                pass.setVisible(true);
                ip.setVisible(true);
                port.setVisible(true);
                btnDisconnect.setVisible(false);
                btnConnect.setVisible(true);
                btnSend.setEnabled(false);
                name.setVisible(false);
                fieldChat.setSize(320,251);;
                fieldChat.setLocation(20,150);
                message.setEnabled(false);

                try {
                    SaveChat.write(fieldChat);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                fieldChat.setText("");

            }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(fieldChat, name, message);
            }
        });

        message.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                message.setText("");
            }
        });
            message.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode()==KeyEvent.VK_ENTER) {
                        sendMessage(fieldChat, name, message);
                    };

                }

                @Override
                public void keyReleased(KeyEvent e) {
                }
            });
            setVisible(true);
    }


    public static void sendMessage(TextArea fieldChat, Label name,TextField fieldMessage){
        fieldChat.append(name.getText()+": "+fieldMessage.getText() + String.format("%n"));
        fieldMessage.setText("");
    }
}