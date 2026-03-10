package innerclass.swing.ch07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorFrame extends JFrame implements ActionListener {

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JPanel panel1;


    public  ColorFrame
            () {
        initData();
        setInitLayout();
        addEventListner();
    }

    public  void initData() {
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button1 = new JButton("button1");
        button2 = new JButton("button2");
        button3 = new JButton("button3");
        button4 = new JButton("button4");
        button5 = new JButton("button5");
        button6 = new JButton("button6");
        panel1 = new JPanel();

    }

    public void setInitLayout() {
        setLayout(new BorderLayout());
        panel1.setBackground(Color.green);
        add(panel1);
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);
        panel1.add(button5);
        panel1.add(button6);
        setVisible(true);
    }

    private void addEventListner() {
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("실행");

        if (e.getSource() == button1) {
            panel1.setBackground(Color.red);
        } else if(e.getSource() == button2) {
            panel1.setBackground(Color.orange);
        } else if (e.getSource() == button3) {
            panel1.setBackground(Color.yellow);
        } else if (e.getSource() == button4) {
            panel1.setBackground(Color.green);
        } else if (e.getSource() == button5) {
            panel1.setBackground(Color.blue);
        } else if (e.getSource() == button6) {
            panel1.setBackground(Color.pink);
        }
    }
}

