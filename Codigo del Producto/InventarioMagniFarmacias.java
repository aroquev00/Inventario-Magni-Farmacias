/*Armando Roque Villasana A01138717
Ultima edicion: 10/9/2017
Clase InventarioMagniFarmacias (Main)
*/

import java.io.*;
import javax.swing.JFrame;

public class InventarioMagniFarmacias{
  
  //Main
  public static void main(String[] args) throws IOException{
    
    //Se crea la ventana al ejecutarse el programa
    JFrame frame = new Ventana();
    frame.setLocationRelativeTo(null); 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
      
  }

}
