/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twozerofoureight;
import java.awt.GridLayout;
import javax.swing.*;
/**
 *
 * @author williamscullion
 */
public class GameDisplay extends JFrame {
    int size; // declared too many times
    JPanel p = new JPanel();
    public GameDisplay(int a) {
        super("twozerofoureight");
        size = a;
        Tile tiles[] = new Tile[size*size];
        setSize(400,400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        p.setLayout(new GridLayout(size,size));
        
        for (int i = 0; i<(size*size); i++) {
            tiles[i] = new Tile();
            p.add(tiles[i]);
        }
        add(p);
        setVisible(true);
    }
    
    
    
}
