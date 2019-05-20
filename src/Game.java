import java.io.IOException;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JTextArea;

 public class Game extends JFrame
{
    private ArrayList<String> towns = new ArrayList<>();
    public  ArrayList<String> one = new ArrayList<>();
    public ArrayList<String> two = new ArrayList<>();
    public  int win=0;
    public  void algortm() {

        ReadingFrom obj=new ReadingFrom();
        File file = new File("src\\города.txt");
        obj.read(file,towns);


        char lastChar;
        char firstChar;
        int idx = new Random().nextInt(towns.size());



        String B = (towns.get(idx));
        one.add(B);
        lastChar = getLastChar(B);
        towns.remove(B);
        while(true) {

            for (int i = 0; i < towns.size(); i++) {
                B = towns.get(i);
                firstChar = getFirstChar(B);
                if (firstChar == lastChar) {
                    System.out.println("2 игрок  " + B);

                    two.add(B);
                    lastChar = getLastChar(B);
                    towns.remove(B);
                    break;
                }
            }

            //System.out.println("Последняя буква " + lastChar);
            if(!isConsistWordWithFirstChar(lastChar)){
                System.out.println("Игра окончена выиграл игрок 2");
                 win = 2;
                break;

            }

            for (int i = 0; i < towns.size(); i++) {
                B = towns.get(i);
                firstChar = getFirstChar(B);
                if (firstChar == lastChar) {
                    System.out.println("1 игрок  " + B);
                    one.add(B);
                    lastChar = getLastChar(B);
                    towns.remove(B);
                    break;
                }

            }

            //System.out.println("Последняя буква " + lastChar);
            if(!isConsistWordWithFirstChar(lastChar)){
                System.out.println("Игра окончена выиграл игрок 1");
                win = 1;
                break;
            }

        }
    }

    public  Character getFirstChar(String city) {
        return city.charAt(0);
    }

    public  Character getLastChar(String city) {
        int pos = city.length() - 1;
        char lastChar = city.toUpperCase().charAt(pos);
        if (city.toUpperCase().charAt(pos) == 'Й') {
            return 'И';
        }
        if (lastChar == 'Ь' || lastChar == 'Ы' || lastChar == 'Ъ') {
            pos--;
        }
        return city.toUpperCase().charAt(pos);
    }

    public  boolean isConsistWordWithFirstChar(char word)
    {
        for (int i = 0; i < towns.size(); i++) {

            if(getFirstChar(towns.get(i)) == word)
            {
                return true;
            }
        }
        return false;
    }

    public void Game1() {

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

        for(int i = 0; i < one.size(); i++)
        {
            area1.append(one.get(i) );
            area1.append("\n");
        }

        for(int i = 0; i < two.size(); i++)
        {
            area2.append(two.get(i) + " ");
            area2.append("\n");
        }
        area2.setLineWrap(true);
        area2.setWrapStyleWord(true);
        area1.setLineWrap(true);
        area1.setWrapStyleWord(true);
        area3.setText("   Выиграл игрок "+ win);
        setSize(500, 300);
        setVisible(true);

    }
}
