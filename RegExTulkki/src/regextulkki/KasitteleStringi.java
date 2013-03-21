/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package regextulkki;

/**
 *
 * @author lehtimik
 */
public class KasitteleStringi {
    
     /**
 * Metodi purkaa stringin parseria varten osiin. KESKEN
 * @param vastaus käsiteltävä stringi.
 */
    
        public static String[] kasitteleStringi(String vastaus) {
            String[] tulokset = new String[2];
            
        StringTaulukko stringTaulukko = new StringTaulukko();
        stringTaulukko.pilkoStringTaulukkoon(vastaus);
        Parseri parseri = new Parseri(stringTaulukko);
        parseri.kayLapiStringTaulukko();
         tulokset[0] = parseri.getTulkinnatTaulukkoon().toString();
         tulokset[1] = parseri.getKaytetytRegularExpressionMerkit().toString();
        return tulokset;
    }
}
