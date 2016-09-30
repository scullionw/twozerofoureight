/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twozerofoureight;

import java.util.Arrays;

/**
 *
 * @author williamscullion
 */
public class MovementBoard {

    int movearray[][];
    int temparray[][];
    int size; // Find a way to not redeclare size!!
    public int maxtile = 0;
    public int score = 0;

    public MovementBoard(int a) {
        size = a;
        movearray = new int[size][size + 1];
        temparray = new int[size][size];
        for (int i = 0; i < size; i++) { //useless to define zeros..
            for (int j = 0; j < (size + 1); j++) {
                movearray[i][j] = 0;
            }
        }
    }

    public void resetMovement() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < (size + 1); j++) {
                movearray[i][j] = 0;
            }
        }
    }

    public void importer(GameBoard ob, String s) {
        if (s.equals("a")) {
            for (int i = 0; i < size; i++) {
                int t = 0;
                for (int j = 0; j < size; j++) {
                    if (ob.gamearray[i][j] != 0) {
                        movearray[i][t] = ob.gamearray[i][j];
                        t++;
                    }
                }
            }

        }
        if (s.equals("d")) {
            for (int i = 0; i < size; i++) {
                int t = 0;
                for (int j = size - 1; j >= 0; j--) {
                    if (ob.gamearray[i][j] != 0) {
                        movearray[i][t] = ob.gamearray[i][j];
                        t++;
                    }
                }
            }

        }
        if (s.equals("w")) {
            for (int i = 0; i < size; i++) {
                int t = 0;
                for (int j = 0; j < size; j++) {
                    if (ob.gamearray[j][i] != 0) {
                        movearray[i][t] = ob.gamearray[j][i];
                        t++;
                    }
                }
            }

        }
        if (s.equals("s")) {
            for (int i = 0; i < size; i++) {
                int t = 0;
                for (int j = size - 1; j >= 0; j--) {
                    if (ob.gamearray[j][i] != 0) {
                        movearray[i][t] = ob.gamearray[j][i];
                        t++;
                    }
                }
            }

        }

    }

    public void nextState() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((movearray[i][j] != 0) && (movearray[i][j] == movearray[i][j + 1])) {
                    movearray[i][j] = movearray[i][j] + movearray[i][j + 1];
                    score = score + movearray[i][j];
                    if (movearray[i][j] > maxtile) {
                        maxtile = movearray[i][j];
                    }
                    for (int k = j + 1; k < size; k++) {
                        movearray[i][k] = movearray[i][k + 1];
                    }

                }
            }
        }

    }

    public void arraycopy(GameBoard ob) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                temparray[i][j] = ob.gamearray[i][j];
            }
        }
    }

    public boolean diffarray(GameBoard ob) {
        boolean diff = false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!diff) {
                    if (ob.gamearray[i][j] != temparray[i][j]) {
                        diff = true;                       
                    }
                }
            }
        }
        return diff;
    }

    public void exporter(GameBoard ob, String s) {
        if (s.equals("a")) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    ob.gamearray[i][j] = movearray[i][j];
                }
            }
        }
        if (s.equals("d")) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    ob.gamearray[i][(size - 1) - j] = movearray[i][j];
                }
            }
        }
        if (s.equals("w")) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    ob.gamearray[j][i] = movearray[i][j];
                }
            }
        }
        if (s.equals("s")) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    ob.gamearray[(size - 1) - j][i] = movearray[i][j];
                }
            }
        }
    }

    public void printBoard2() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size + 1; j++) {
                System.out.print(movearray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printScore(UserInput ob) {
        System.out.println("Score: " + score + "   Maxtile: " + maxtile + "   Moves: " + ob.nbmoves + "\n\n");
    }
}
