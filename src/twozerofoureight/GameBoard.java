/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twozerofoureight;

/**
 *
 * @author williamscullion
 */
public class GameBoard {

    public int gamearray[][];
    private int endcheckarray[][];
    public int size;
    public boolean endgametest = false;

    public GameBoard(int a) {
        size = a;
        gamearray = new int[size][size];
        endcheckarray = new int[size + 2][size + 2];
        for (int i = 0; i < size; i++) { //useless to define zeros
            for (int j = 0; j < size; j++) {
                gamearray[i][j] = 0;
            }
        }

    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (gamearray[i][j] != 0) {
                    System.out.print(gamearray[i][j] + "      ");
                } else {
                    System.out.print("-" + "      ");
                }

            }
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }

    public void randomInsert() { // Bug: will insert even if board is full?
        double p2 = 0.90; // 90% Chance qu'un 2 apparaisse
        double p4 = 0.10; // 10% Chance qu'un 1 apparaisse (pas nécessaire)
        int numtoinsert = 0;
        int zerocount = 0;
        int randomlocs[][] = new int[size * size][2]; // Positions en i,j des zéros du gameboard
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (gamearray[i][j] == 0) {
                    zerocount = zerocount + 1;
                    randomlocs[zerocount - 1][0] = i;
                    randomlocs[zerocount - 1][1] = j;
                }
            }
        }
        if (zerocount == 1) {
            endgametest = true;
        }
        int spawnat = (int) Math.floor(Math.random() * zerocount + 1);
        int spawnloc[] = new int[2];
        for (int i = 0; i < 2; i++) {
            spawnloc[i] = randomlocs[spawnat - 1][i];
        }
        double twofour = Math.random();
        if (twofour <= p2) {
            numtoinsert = 2;
        } else {
            numtoinsert = 4;
        }
        /*
         if zerocount==1
         useranswer='z';
         end
         */
        gamearray[spawnloc[0]][spawnloc[1]] = numtoinsert;
    }

    public boolean noMoves() {
        boolean canmove = false;
        for (int i = 1; i < (size + 1); i++) {
            for (int j = 1; j < (size + 1); j++) {
                endcheckarray[i][j] = gamearray[i - 1][j - 1];
            }
        }
        for (int i = 1; i < (size + 1); i++) {
            for (int j = 1; j < (size + 1); j++) {
                boolean a = endcheckarray[i][j] == endcheckarray[i - 1][j];
                boolean b = endcheckarray[i][j] == endcheckarray[i + 1][j];
                boolean c = endcheckarray[i][j] == endcheckarray[i][j - 1];
                boolean d = endcheckarray[i][j] == endcheckarray[i][j + 1];
                if (a || b || c || d) {
                    canmove = true;
                }
            }
        }
        return !canmove;
    }
}
