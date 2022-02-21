import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.io.*;
import java.util.Scanner;

public class SimpleDotComGame {
    public static void main (String [] args) {
        int numOfGuess = 0;
        GameHelper helper = new GameHelper();
        DotCom theDotCom = new DotCom();
        int randomNum = (int)(Math.random() * 5);
        ArrayList<String> locations = new ArrayList<>();
        locations.add(String.valueOf(randomNum));
        locations.add(String.valueOf(randomNum + 1));
        locations.add(String.valueOf(randomNum + 2));
        theDotCom.SetLocationCells(locations);
        boolean isAlive = true;

        while (isAlive == true) {
            String guess = helper.getUserInput("Put your number :");

            String result = theDotCom.checkYourself(guess);
            numOfGuess++;
            if (result.equals("Done")) {
                isAlive = false;
                System.out.println("You use" + numOfGuess + " guess");
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
    }
}

class ArrayOperations {
    public static void reverseElements(int[][] twoDimArray) {
        int line = twoDimArray.length;
        int row = twoDimArray[0].length - 1;
        for (int i = 0; i < line; i++) {
            for (int j = 0; j <= row / 2; j++) {
                int swap = twoDimArray[i][j];
                twoDimArray[i][j] = twoDimArray[i][row - i];
                twoDimArray[i][row - i] = swap;
            }
        }
    }
}

