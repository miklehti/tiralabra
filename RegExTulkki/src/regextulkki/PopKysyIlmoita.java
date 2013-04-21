/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package regextulkki;

import javax.swing.JOptionPane;

/**
 *
 * @author lehtimik
 */
public class PopKysyIlmoita {
    
 /**
 * Metodi ilmoittaa viestin
 * @param viesti ilmoitettava viesti
 */
      public static void ilmoita(String viesti) {
    JOptionPane.showMessageDialog(null,viesti, "", JOptionPane.PLAIN_MESSAGE);
  }
       /**
 * Metodi kysyy käyttäjältä regexiä
 * @param kysymys mitä kysytään
 * @return palauttaa tutkittavan regexin
 */
        public static String kysyString(String kysymys) {
    return JOptionPane.showInputDialog(kysymys);  
  }
}
