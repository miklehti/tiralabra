/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package regextulkki;

import erikoismerkit.TahtiMerkki;
import erikoismerkit.Piste;
import erikoismerkit.Dollarimerkki;
import erikoismerkit.Caret;
import erikoismerkit.Kysymysmerkki;
import erikoismerkit.Backlash;
import erikoismerkit.TaiMerkki;

/**
 *
 * @author lehtimik
 */
public class Parseri {

    
    
/**
 * Tutkittava StringTaulukko
 */
    private StringTaulukko stringTaulukko;
    /**
 * tutkitut tulokset tulevat tähän StringTaulukkoon
 */
    private StringTaulukko tulkinnatTaulukkoon;
 /**
 * listataan mitä regexejä on tulkittu
 */
    private StringTaulukko kaytetytRegularExpressionMerkit;
    
     /**
 *erikoismerkit regexissä
 */
    private String erikoismerkit = "[()$.|^*?\\";

         /**
 * Konstruktori. Tarvitsee stringTaulukon.
 * @param stringTaulukko stringTaulukko parsittavaksi.
 */
    public Parseri(StringTaulukko stringTaulukko) {
        this.stringTaulukko = stringTaulukko;
        tulkinnatTaulukkoon = new StringTaulukko();
        kaytetytRegularExpressionMerkit = new StringTaulukko();
    }
    
    
 /**
 * Metodi tulkitsee erkoismerkit ja kutsuu sitä vastaavaa luokkametodia
 * @param tutkittava tutkittava teksti
 * @param indeksi missä kohtaa stringTaulukkoa mennään kun törmättiin merkkiin.
 */

    public void tulkitseErikoismerkki(String tutkittava, int indeksi) {
        if (tutkittava.equals("\\")) {
            Backlash.tutkiBacklash(stringTaulukko);
        }
        if (tutkittava.equals("$")) {
            Dollarimerkki.tutkiDollarimerkki(stringTaulukko);
        }
        if (tutkittava.equals(".")) {
            Piste.tutkiPiste(stringTaulukko);
        }
        if (tutkittava.equals("|")) {
            TaiMerkki.tutkiTaiMerkki(stringTaulukko);
        }
        if (tutkittava.equals("^")) {
           Caret.tutkiCaretmerkki(stringTaulukko);
        }
        if (tutkittava.equals("?")) {
            Kysymysmerkki.tutkiKysymysmerkki(stringTaulukko);
        }
        if (tutkittava.equals("*")) {
            TahtiMerkki.tutkiTahtismerkki(stringTaulukko);
        }
   



    }
    
        
 /**
 * Metodi käy läpi StringTaulukon ja tarkistaa onko tekstissä erikoismerkkejä
 * 
 */

    public void kayLapiStringTaulukko() {
        while (onkoAlkioitaVielaJaljella()) {
            String tutkittava = stringTaulukko.annaTaulukonAlkionArvo(stringTaulukko.getTutkittavaIndeksi());
            if (onkoErikoismerkki(tutkittava) == true) {
                tulkitseErikoismerkki(tutkittava, stringTaulukko.getTutkittavaIndeksi());
            }
            stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + 1);
        }
    }
 /**
 * Metodi palauttaa luokan yksityisen stringtaulukon
 * @return palauttaa luokan StringTaulukon
 */
    public StringTaulukko getStringTaulukko() {
        return stringTaulukko;
    }

     /**
 * Metodi tutkii onko kirjain erikoismerkki
 * @return palauttaa totuusarvon
 */
    public boolean onkoErikoismerkki(String s) {
        for (int i = 0; i < erikoismerkit.length(); i++) {
            if (erikoismerkit.substring(i, i + 1).equals(s)) {
                return true;
            }

        }
        return false;
    }

         /**
 * Metodi tutkii onko alkioita vielä käsittelemättä taulukossa
 * @return palauttaa totuusarvon
 */
    public boolean onkoAlkioitaVielaJaljella() {
        return stringTaulukko.getTutkittavaIndeksi() < stringTaulukko.getAlkioidenLKM();
    }
}
