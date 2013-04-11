
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
        KasitteleStringi kasitteleStringi = new KasitteleStringi(vastaus);
       kasitteleStringi.annaEsimerkkivastauksia();
        PopKysyIlmoita.ilmoita(kasitteleStringi.getTulkinnatTaulukkoon().toString());
        PopKysyIlmoita.ilmoita(kasitteleStringi.getKaytetytRegularExpressionMerkit().toString());
    }


}
