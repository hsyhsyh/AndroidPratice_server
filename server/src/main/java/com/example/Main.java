package com.example;


import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Main extends JFrame{
    private JTextArea area;

    public Main(JTextArea area) {
        this.area = area;
        add(this.area);
    }

    public void setText(String str){
        this.area.append(str);
    }

    public static void main(String[] args) {
        JTextArea area = new JTextArea();
        Main main = new Main(area);
        Server server = new Server(main);

        main.setLocation(100, 100);
        main.setSize(500, 500);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setVisible(true);
    }

}