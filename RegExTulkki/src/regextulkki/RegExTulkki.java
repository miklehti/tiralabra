
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
        String[] lopputulokset = KasitteleStringi.kasitteleStringi(vastaus);
        PopKysyIlmoita.ilmoita(lopputulokset[0]);
        PopKysyIlmoita.ilmoita(lopputulokset[1]);
    }


}
