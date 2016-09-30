/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twozerofoureight;

import java.util.Scanner;

/**
 *
 * @author williamscullion
 */
public class UserInput {

    Scanner sc = new Scanner(System.in);
    public int nbmoves = 0;

    public String readUser() {
        System.out.println("a:left, d:right, w:up, s:down, or x: to quit");
        System.out.print(": ");
        String s = sc.nextLine();
        nbmoves++;
        return s;
    }
}
