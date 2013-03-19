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
    
        public static String kasitteleStringi(String vastaus) {
        StringTaulukko stringTaulukko = new StringTaulukko();
        stringTaulukko.lisaaStringTaulukkoon(vastaus);
        Parseri parseri = new Parseri(stringTaulukko);
        parseri.kayLapiStringTaulukko();
        String tulos = parseri.getStringTaulukko().toString();
        return tulos;
    }
}
