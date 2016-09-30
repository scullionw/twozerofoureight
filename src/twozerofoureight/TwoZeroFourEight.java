/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twozerofoureight;

import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;
// import java.io.*;

/**
 *
 * @author williamscullion KNOWN BUGS: 1- takes any input 2- move count wrong on endgame
 *
 */
public class TwoZeroFourEight {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //new GameDisplay();
        GameBoard g1 = new GameBoard(4);
        MovementBoard m1 = new MovementBoard(4);
        UserInput u1 = new UserInput();
        boolean testbool;
        boolean stopgame = false;
        g1.randomInsert();
        g1.randomInsert();
        g1.printBoard();
        System.out.println();
        String useranswer = u1.readUser();
        while ((!(useranswer.equals("x"))) && (!stopgame)) {

            System.out.println("\n\n");
            m1.resetMovement();
            m1.importer(g1, useranswer);
            m1.arraycopy(g1);
            m1.nextState();
            m1.exporter(g1, useranswer);
            testbool = m1.diffarray(g1);
            if (testbool) {
                g1.randomInsert();
            }
            if (!testbool) {
                u1.nbmoves--;
            }
            m1.printScore(u1);
            g1.printBoard();
            if (g1.endgametest) {
                if (g1.noMoves()) {
                    stopgame = true;
                }
            }
                
            if (!stopgame) {
            useranswer = u1.readUser();
            }
        }
        if (stopgame) {
            System.out.println("\nGame Over!\n");
            m1.printScore(u1);
        }
        else if (useranswer.equals("x")) {
            System.out.println("\nYou quit the game!\n");
            m1.printScore(u1);
        }

    }

}
