/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package regextulkki;

/**
 *
 * @author lehtimik
 */
public class BacklashTulkinta {
    
     /**
     * Tulkinnat eri kenoviiva-merkki arvoille
     */

    private static String backlash_WTulkinta = "(ei ole mikään word character eli a-zA-Z0-9)";
    private static String backlash_WSelitys = "\\W tarkoittaa että etsittävä ei ole mikään word character eli a-z tai A-Z tai 0-9";
    private static String backlash_wTulkinta = "(joku word character eli a-zA-Z0-9)";
    private static String backlash_wSelitys = "\\w tarkoittaa että etsittävä on jokine word character eli a-z tai A-Z tai 0-9";
    private static String backlash_DTulkinta = "(ei ole numero)";
    private static String backlash_DSelitys = "\\D tarkoittaa että etsittävä ei ole mikään numero eli ei 0-9";
    private static String backlash_dTulkinta = "(joku numero)";
    private static String backlash_dSelitys = "\\d tarkoittaa että etsittävä on jokin numero eli 0-9";
    private static String backlash_STulkinta = "(ei ole whitespace (tab, space, rivinloppu))";
    private static String backlash_SSelitys = "\\S tarkoittaa että etsittävä ei ole whitespace eli tab, space, rivinloppu";
    private static String backlash_sTulkinta = "(whitespace eli tab, space, rivinloppu)";
    private static String backlash_sSelitys = "\\s tarkoittaa että etsittävä on tab, space tai rivinloppu";
    private static String backlash_tTulkinta = "(tab)";
    private static String backlash_tSelitys = "\\t tarkoittaa että etsittävä on tab-merkki";
    private static String backlash_bTulkinta = "(backspace-merkki)";
    private static String backlash_bSelitys = "\\b tarkoittaa että etsittävä on backspace-merkki";

    /**
     * Metodi tutkii mikä kirjain on liitetty kenoviivan jatkeeksi ja palauttaa
     * oikean tulkinnan
     *
     * @param kirjain mikä kirjain on liitettu backlash tulkintaan.
     * @return tulkinta kenoviiva-kirjain merkille
     */
    public static String tutkiBacklash(String kirjain) {
        if (kirjain.equals("W")) {
            lisataankoBacklash_WKaytetytRegularExpressionMerkkeihin();
            return backlash_WTulkinta;
        }
        if (kirjain.equals("w")) {
            lisataankoBacklash_wKaytetytRegularExpressionMerkkeihin();
            return backlash_wTulkinta;
        }
        if (kirjain.equals("D")) {
            lisataankoBacklash_DKaytetytRegularExpressionMerkkeihin();
            return backlash_DTulkinta;
        }
        if (kirjain.equals("d")) {
            lisataankoBacklash_dKaytetytRegularExpressionMerkkeihin();
            return backlash_dTulkinta;
        }

        if (kirjain.equals("S")) {
            lisataankoBacklash_SKaytetytRegularExpressionMerkkeihin();
            return backlash_STulkinta;
        }
        if (kirjain.equals("s")) {
            lisataankoBacklash_sKaytetytRegularExpressionMerkkeihin();
            return backlash_sTulkinta;
        }

        if (kirjain.equals("t")) {
            lisataankoBacklash_tKaytetytRegularExpressionMerkkeihin();
            return backlash_tTulkinta;
        }
        if (kirjain.equals("b")) {
            lisataankoBacklash_bKaytetytRegularExpressionMerkkeihin();
            return backlash_bTulkinta;
        }
        return "false";
    }

    /**
     * Metodi tutkii onko \W -merkki jo lisätty käytettyihin regexeihin. Jos ei
     * ole niin lisätään ja merkitään lisätyksi.
     */
    public static void lisataankoBacklash_WKaytetytRegularExpressionMerkkeihin() {

        if (KasitteleStringi.isLisataankoBacklash_W() == true) {
            KasitteleStringi.lisaakaytetytRegularExpressionMerkkeihin(backlash_WSelitys);
            KasitteleStringi.setLisataankoBacklash_W(false);
        }
    }

    /**
     * Metodi tutkii onko \w -merkki jo lisätty käytettyihin regexeihin. Jos ei
     * ole niin lisätään ja merkitään lisätyksi.
     */
    public static void lisataankoBacklash_wKaytetytRegularExpressionMerkkeihin() {

        if (KasitteleStringi.isLisataankoBacklash_w() == true) {
            KasitteleStringi.lisaakaytetytRegularExpressionMerkkeihin(backlash_wSelitys);
            KasitteleStringi.setLisataankoBacklash_w(false);
        }
    }

    /**
     * Metodi tutkii onko \D -merkki jo lisätty käytettyihin regexeihin. Jos ei
     * ole niin lisätään ja merkitään lisätyksi.
     */
    public static void lisataankoBacklash_DKaytetytRegularExpressionMerkkeihin() {

        if (KasitteleStringi.isLisataankoBacklash_D() == true) {
            KasitteleStringi.lisaakaytetytRegularExpressionMerkkeihin(backlash_DSelitys);
            KasitteleStringi.setLisataankoBacklash_D(false);
        }
    }

    /**
     * Metodi tutkii onko \d -merkki jo lisätty käytettyihin regexeihin. Jos ei
     * ole niin lisätään ja merkitään lisätyksi.
     */
    public static void lisataankoBacklash_dKaytetytRegularExpressionMerkkeihin() {

        if (KasitteleStringi.isLisataankoBacklash_d() == true) {
            KasitteleStringi.lisaakaytetytRegularExpressionMerkkeihin(backlash_dSelitys);
            KasitteleStringi.setLisataankoBacklash_d(false);
        }
    }

    /**
     * Metodi tutkii onko \S -merkki jo lisätty käytettyihin regexeihin. Jos ei
     * ole niin lisätään ja merkitään lisätyksi.
     */
    public static void lisataankoBacklash_SKaytetytRegularExpressionMerkkeihin() {

        if (KasitteleStringi.isLisataankoBacklash_S() == true) {
            KasitteleStringi.lisaakaytetytRegularExpressionMerkkeihin(backlash_SSelitys);
            KasitteleStringi.setLisataankoBacklash_S(false);
        }
    }

    /**
     * Metodi tutkii onko \s -merkki jo lisätty käytettyihin regexeihin. Jos ei
     * ole niin lisätään ja merkitään lisätyksi.
     */
    public static void lisataankoBacklash_sKaytetytRegularExpressionMerkkeihin() {

        if (KasitteleStringi.isLisataankoBacklash_s() == true) {
            KasitteleStringi.lisaakaytetytRegularExpressionMerkkeihin(backlash_sSelitys);
            KasitteleStringi.setLisataankoBacklash_s(false);
        }
    }
    
    
    /**
     * Metodi tutkii onko \t -merkki jo lisätty käytettyihin regexeihin. Jos ei
     * ole niin lisätään ja merkitään lisätyksi.
     */
    public static void lisataankoBacklash_tKaytetytRegularExpressionMerkkeihin() {

        if (KasitteleStringi.isLisataankoBacklash_t() == true) {
            KasitteleStringi.lisaakaytetytRegularExpressionMerkkeihin(backlash_tSelitys);
            KasitteleStringi.setLisataankoBacklash_t(false);
        }
    }
    
        /**
     * Metodi tutkii onko \b -merkki jo lisätty käytettyihin regexeihin. Jos ei
     * ole niin lisätään ja merkitään lisätyksi.
     */
    public static void lisataankoBacklash_bKaytetytRegularExpressionMerkkeihin() {

        if (KasitteleStringi.isLisataankoBacklash_b() == true) {
            KasitteleStringi.lisaakaytetytRegularExpressionMerkkeihin(backlash_bSelitys);
            KasitteleStringi.setLisataankoBacklash_b(false);
        }
    }

          /**
     * Metodi palauttaa \D-selityksen
     */
    
    public static String getBacklash_DSelitys() {
        return backlash_DSelitys;
    }

    
         /**
     * Metodi palauttaa \D-tulkinnan
     */
    public static String getBacklash_DTulkinta() {
        return backlash_DTulkinta;
    }
    
           /**
     * Metodi palauttaa \S-selityksen
     */

    public static String getBacklash_SSelitys() {
        return backlash_SSelitys;
    }
    
        /**
     * Metodi palauttaa \S-tulkinnan
     */

    public static String getBacklash_STulkinta() {
        return backlash_STulkinta;
    }
           /**
     * Metodi palauttaa \W-selityksen
     */

    public static String getBacklash_WSelitys() {
        return backlash_WSelitys;
    }
        /**
     * Metodi palauttaa \W-tulkinnan
     */

    public static String getBacklash_WTulkinta() {
        return backlash_WTulkinta;
    }
    
           /**
     * Metodi palauttaa \v-selityksen
     */

    public static String getBacklash_bSelitys() {
        return backlash_bSelitys;
    }
    
        /**
     * Metodi palauttaa \b-tulkinnan
     */

    public static String getBacklash_bTulkinta() {
        return backlash_bTulkinta;
    }
    
           /**
     * Metodi palauttaa \d-selityksen
     */

    public static String getBacklash_dSelitys() {
        return backlash_dSelitys;
    }
    /**
     * Metodi palauttaa \d-tulkinnan
     */
    public static String getBacklash_dTulkinta() {
        return backlash_dTulkinta;
    }
    
           /**
     * Metodi palauttaa \s-selityksen
     */

    public static String getBacklash_sSelitys() {
        return backlash_sSelitys;
    }
    
        /**
     * Metodi palauttaa \s-tulkinnan
     */

    public static String getBacklash_sTulkinta() {
        return backlash_sTulkinta;
    }

           /**
     * Metodi palauttaa \t-selityksen
     */
    public static String getBacklash_tSelitys() {
        return backlash_tSelitys;
    }
    
        /**
     * Metodi palauttaa \t-tulkinnan
     */

    public static String getBacklash_tTulkinta() {
        return backlash_tTulkinta;
    }
    
           /**
     * Metodi palauttaa \w-selityksen
     */

    public static String getBacklash_wSelitys() {
        return backlash_wSelitys;
    }
    
        /**
     * Metodi palauttaa \w-tulkinnan
     */

    public static String getBacklash_wTulkinta() {
        return backlash_wTulkinta;
    }
    
}
