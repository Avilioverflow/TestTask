package org.avilio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyGUI extends JFrame implements ActionListener{
    private JFrame jFrame;

    private JPanel buttonsPanel;
    // объявление переменных для компонентов
    private JLabel case1, case2, case3, case4;
    private JTextField textCase1, textCase2, textCase3, textCase4;
    private JButton button1, button2, button3, button4;

    private JTextArea outputTextArea;

    // конструктор GUI
    public MyGUI() {

        JFrame jFrame = new JFrame("MyTestCase");
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width/2 - 350,dimension.height/2 - 250,700,500);
        jFrame.setTitle("MyTestCase");


        case1 = new JLabel("Введите число:");
        case2 = new JLabel("Введите имя:");
        case3 = new JLabel("Введите массив чисел через пробел:");
        case4 = new JLabel("Введите скобочную последовательность:");

        textCase1 = new JTextField();
        textCase2 = new JTextField();
        textCase3 = new JTextField();
        textCase4 = new JTextField();

        button1 = new JButton("Запуск");
        button2 = new JButton("Запуск");
        button3 = new JButton("Запуск");
        button4 = new JButton("Запуск");


        outputTextArea = new JTextArea();
        outputTextArea.setBackground(Color.GRAY);
        outputTextArea.setForeground(Color.YELLOW);
        outputTextArea.setFont(outputTextArea.getFont().deriveFont(40f));
        outputTextArea.setEditable(false);
        outputTextArea.setLineWrap(true);
        outputTextArea.setWrapStyleWord(true);
        outputTextArea.setRows(3);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        scrollPane.setPreferredSize(new Dimension(200, 200));

        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(4, 2, 5, 5));
        buttonsPanel.add(case1);
        buttonsPanel.add(textCase1);
        buttonsPanel.add(button1);
        buttonsPanel.add(case2);
        buttonsPanel.add(textCase2);
        buttonsPanel.add(button2);
        buttonsPanel.add(case3);
        buttonsPanel.add(textCase3);
        buttonsPanel.add(button3);
        buttonsPanel.add(case4);
        buttonsPanel.add(textCase4);
        buttonsPanel.add(button4);

        background.add(BorderLayout.CENTER,buttonsPanel);
        background.add(BorderLayout.SOUTH, scrollPane);
        jFrame.getContentPane().add(background);

        jFrame.pack();
        jFrame.setVisible(true);


        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        outputTextArea.setText("");
        Object source = e.getSource();

        if (source == button1){
            String text1 = textCase1.getText();
            textCase1.setText("");
            outputTextArea.setText(Logic.checkForNumber(text1));

        } else if (source == button2){
            String text2 = textCase2.getText();
            textCase2.setText("");
            outputTextArea.setText(Logic.checkForName(text2));

        } else  if (source == button3){
            String text3 = textCase3.getText();
            textCase3.setText("");
            outputTextArea.setText(Logic.outputMultiplesOf3(text3));

        } else {
            String text4 = textCase4.getText();
            textCase4.setText("");
            String correctedSequence = Logic.checkBracketSequence(text4);

            outputTextArea.setText(correctedSequence);

        }
    }

}
