
package regextulkki;

import java.util.*;

/**
 *
 * @author lehtimik
 */
public class RegExTulkki {


    
           /**
 * Mainmetodi
 * @param args argumentit
 */

    public static void main(String[] args) {
        
        
        String vastaus = PopKysyIlmoita.kysyString("Anna säännöllinen lause");
        String lopputulos = KasitteleStringi.kasitteleStringi(vastaus);
        PopKysyIlmoita.ilmoita(lopputulos);
    }


}
