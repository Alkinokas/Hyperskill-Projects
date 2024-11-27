package tictactoe;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here

        Scanner scanner = new Scanner(System.in);

        // Set string input into matrix (2D array)
        char[][] array = new char[3][3];

        int k = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = ' ';
            }
        }

        // Print empty grid
        System.out.println("---------");
        for (int m = 0; m < array.length; m++) {
            System.out.printf("| ");
            for (int n = 0; n < array[m].length; n++) {
                System.out.printf("%c ", array[m][n]);
            }
            System.out.printf("|\n");
        }
        System.out.println("---------");


        // Game conditions first set

        int userRow = 0;
        int userColumn = 0;
        boolean xWins = false;
        boolean oWins = false;

        while (k < 9){
            while (true) {

                try {
                    userRow = scanner.nextInt();
                    userColumn = scanner.nextInt();
                    userRow--;
                    userColumn--;

                    if (array[userRow][userColumn] == ' '){
                        if(k % 2 == 0 ){
                            array[userRow][userColumn] = 'X';
                        } else {
                            array[userRow][userColumn] = 'O';
                        }
                        break;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                } catch (InputMismatchException e){
                    System.out.println("You should enter numbers!");
                    scanner.nextLine();
                } catch (ArrayIndexOutOfBoundsException e){
                    if (userRow > 2 || userColumn > 2 || userRow < 0 || userColumn < 0) {
                        System.out.println("Coordinates should be from 1 to 3!");
                    }
                    scanner.nextLine();
                }
            }

            // Game conditions (to determine the winner)

            for (int var = 0; var < array.length; var++){
                if (array[var][0] == array[var][1] && array[var][0] == array[var][2]){
                    if (array[var][0] == 'X'){
                        xWins = true;
                        k = 9;
                        break;
                    }
                    if (array[var][0] == 'O'){
                        oWins = true;
                        k = 9;
                        break;
                    }
                }
                if (array[0][var] == array[1][var] && array[0][var] == array[2][var]){
                    if (array[0][var] == 'X'){
                        xWins = true;
                        k = 9;
                        break;
                    }
                    if (array[0][var] == 'O'){
                        oWins = true;
                        k = 9;
                        break;
                    }
                }
            }

            if ((array[1][1] == array[0][0] && array[1][1] == array[2][2] && array[1][1] == 'X') ||
                (array[1][1] == array[0][2] && array[1][1] == array[2][0] && array[1][1] == 'X')){
                xWins = true;
                k = 9;
            }
            if ((array[1][1] == array[0][0] && array[1][1] == array[2][2] && array[1][1] == 'O') ||
                    (array[1][1] == array[0][2] && array[1][1] == array[2][0] && array[1][1] == 'O')){
                oWins = true;
                k = 9;
            }

            // Prints the whole 2D array

            System.out.println("---------");
            for (int v = 0; v < array.length; v++) {
                System.out.printf("| ");
                for (int z = 0; z < array[v].length; z++) {
                    System.out.printf("%c ", array[v][z]);
                }
                System.out.printf("|\n");
            }
            System.out.println("---------");

            k++;
        }

        if (xWins){
            System.out.println("X wins");
        } else if (oWins) {
            System.out.println("O wins");
        } else {
            System.out.println("Draw");
        }
    }
}