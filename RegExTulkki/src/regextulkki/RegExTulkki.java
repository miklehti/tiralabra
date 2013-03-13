/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package regextulkki;
import java.util.*;

/**
 *
 * @author lehtimik
 */
public class RegExTulkki {

    /**
     * @param args the command line arguments
     */
    public static   ArrayList<String> lopputulos = new ArrayList<String>();
        

    public static void main(String[] args) {
        // TODO code application logic here
        String vastaus = Pop.askString("Anna säännöllinen lause");
        
               String lopputulos = kasitteleStringi(vastaus);
        Pop.ilmoita(lopputulos);
    }

    public static String kasitteleStringi(String vastaus) {
        for (int i = 0; i<vastaus.length();i++){
            String kasiteltavaKirjain = vastaus.substring(i, i+1);
      
        lopputulos.add(kasiteltavaKirjain);
    }
        return "a";
    }
}
