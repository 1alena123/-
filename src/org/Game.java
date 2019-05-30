package org;
import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Game
{
    private ArrayList<String> towns = new ArrayList<>();
    public  ArrayList<String> one_player = new ArrayList<>();
    public ArrayList<String> two_player = new ArrayList<>();
    public  int win = 0;
    public  void algortm() {

        ReadingFrom obj=new ReadingFrom();
        File file = new File("src\\города.txt");
        obj.read(file,towns);
        Collections.shuffle(towns);
        char lastChar;
        char firstChar;
        int idx = new Random().nextInt(towns.size());
        String B = (towns.get(idx));
        one_player.add(B);
        lastChar = getLastChar(B);
        towns.remove(B);
        while(true) {

            for (int i = 0; i < towns.size(); i++) {
                B = towns.get(i);
                firstChar = getFirstChar(B);
                if (firstChar == lastChar) {
                    // System.out.println("2 игрок  " + B);
                    two_player.add(B);
                    lastChar = getLastChar(B);
                    towns.remove(B);
                    break;
                }
            }
            //System.out.println("Последняя буква " + lastChar);
            if(!isConsistWordWithFirstChar(lastChar)){
                //System.out.println("Игра окончена выиграл игрок 2");
                win = 2;
                break;
            }

            for (int i = 0; i < towns.size(); i++) {
                B = towns.get(i);
                firstChar = getFirstChar(B);
                if (firstChar == lastChar) {
                    //System.out.println("1 игрок  " + B);
                    one_player.add(B);
                    lastChar = getLastChar(B);
                    towns.remove(B);
                    break;
                }
            }
            //System.out.println("Последняя буква " + lastChar);
            if(!isConsistWordWithFirstChar(lastChar)){
                // System.out.println("Игра окончена выиграл игрок 1");
                win = 1;
                break;
            }
        }
        Output outputList = new Output();
        outputList.graphical_output(one_player,two_player,win);
    }

    public  Character getFirstChar(String town) {
        return town.charAt(0);
    }

    public  Character getLastChar(String town) {
        int value = town.length() - 1;
        char lastChar = town.toUpperCase().charAt(value);
        if (town.toUpperCase().charAt(value) == 'Й') {
            return 'И';
        }
        if (lastChar == 'Ь' || lastChar == 'Ы' || lastChar == 'Ъ') {
            value--;
        }
        return town.toUpperCase().charAt(value);
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
}
