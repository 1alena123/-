package org;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTextArea;
public class Output extends JFrame{

    public void graphical_output( ArrayList<String> one_player,ArrayList<String> two_player,int win) {

        setTitle("Игра в города");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextArea area1 = new JTextArea(10, 15);
        JTextArea area2 = new JTextArea(10, 15);
        JTextArea area3 = new JTextArea(3, 20);
        JLabel area4 = new JLabel("1 Игрок");
        JLabel area5 = new JLabel("2 Игрок");

        JPanel contents = new JPanel();
        contents.add(new JScrollPane(area4));
        contents.add(new JScrollPane(area1));
        contents.add(new JScrollPane(area5));
        contents.add(new JScrollPane(area2));
        contents.add(new JScrollPane(area3));

        setContentPane(contents);

        for(int i = 0; i < one_player.size(); i++)
        {
            area1.append(one_player.get(i) );
            area1.append("\n");
        }

        for(int i = 0; i < two_player.size(); i++)
        {
            area2.append(two_player.get(i) + " ");
            area2.append("\n");
        }
        area2.setLineWrap(true);
        area2.setWrapStyleWord(true);
        area1.setLineWrap(true);
        area1.setWrapStyleWord(true);
        area3.setText("\tВыиграл игрок "+ win + "!!!");
        setSize(500, 300);
        setVisible(true);

    }
}
