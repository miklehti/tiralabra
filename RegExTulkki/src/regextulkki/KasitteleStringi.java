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
    private static StringTaulukko kaytetytRegularExpressionMerkit = new StringTaulukko();
    /**
     * erikoismerkit lisätään vain kerran kaytetytRegularExpressionMerkit
     * taulukkoon, jos esim. piste on jo siellä on flag false eikäs sitä enää
     * lisätä
     */
    private static boolean lisataankoPiste = true;
    private static boolean lisataankoKysymysmerkki = true;
    private static boolean lisataankoKysymysmerkkiKysymysmerkki = true;
    private static boolean lisataankoDollari = true;
    private static boolean lisataankoTahti = true;
    private static boolean lisataankoTahtiKysymysmerkki = true;
    private static boolean lisataankoTaiMerkki = true;
    private static boolean lisataankoCaret = true;
    private static boolean lisataankoBacklash = true;
    private static boolean lisataankoPlusmerkki = true;
    private static boolean lisataankoPlusmerkkiKysymysmerkki = true;
    private static boolean lisataankoHakasulkumerkki = true;
    private static boolean lisataankoBacklash_W = true;
    private static boolean lisataankoBacklash_w = true;
    private static boolean lisataankoBacklash_D = true;
    private static boolean lisataankoBacklash_d = true;
    private static boolean lisataankoBacklash_S = true;
    private static boolean lisataankoBacklash_s = true;
    private static boolean lisataankoBacklash_t = true;
    private static boolean lisataankoBacklash_b = true;
    private static boolean lisataankoViivamerkki = true;
    private static boolean lisataankoCaretHakasulkumerkki = true;

    /**
     * Konstruktori luo uuden olion
     *
     * @param vastaus käsiteltävä stringi.
     */
    public KasitteleStringi(String vastaus) {
        tulkinnatTaulukkoon = new StringTaulukko();
        stringTaulukko.pilkoStringTaulukkoon(vastaus);

    }

    /**
     * Metodi purkaa stringin parseria varten osiin. Käyttää pinoa apuna
     *
     * @param vastaus käsiteltävä stringi.
     */
    public void annaEsimerkkivastauksia() {
        StringTaulukko tutkittavaPalanen = annaTutkittavaPalanen();
        for(int i = 0; i<stringTaulukko.getAlkioidenLKM();i++){
            if(stringTaulukko.annaTaulukonAlkionArvo(i).equals("(")){
                
               tutkittavaPalanen = annaTutkittavaPalanen();
            }
        Parseri parseri = new Parseri(stringTaulukko, tulkinnatTaulukkoon);
        parseri.kayLapiStringTaulukko();
        }
    }
    
       /**
     * Metodi antaa sulkujen välisen palasen 
     *
     * @param vastaus käsiteltävä stringi.
     */
    public StringTaulukko annaTutkittavaPalanen(){
        StringTaulukko palanen = new StringTaulukko();
        return palanen;
    }

    /**
     * metodi muuttaa hakasulkumerkin arvoa
     *
     * @param lisataankoHakasulkumerkki lisättävä arvo
     */
    public static void setLisataankoHakasulkumerkki(boolean lisataankoHakasulkumerkki) {
        KasitteleStringi.lisataankoHakasulkumerkki = lisataankoHakasulkumerkki;
    }

    /**
     * metodi palautaa hakasulkumerkin boolean arvon
     */
    public static boolean isLisataankoHakasulkumerkki() {
        return lisataankoHakasulkumerkki;
    }

    /**
     * metodi palautaa kenoviivan boolean arvon
     */
    public static boolean isLisataankoBacklash() {
        return lisataankoBacklash;
    }

    /**
     * metodi palautaa \W-merkin boolean arvon
     */
    public static boolean isLisataankoBacklash_W() {
        return lisataankoBacklash_W;
    }

    /**
     * metodi muuttaa \W arvoa
     *
     * @param lisataankoHakasulkumerkki lisättävä arvo
     */
    public static void setLisataankoBacklash_W(boolean lisataankoBacklashWmerkki) {
        KasitteleStringi.lisataankoBacklash_W = lisataankoBacklashWmerkki;
    }

    /**
     * metodi palautaa hattumerkin boolean arvon
     */
    public static boolean isLisataankoCaret() {
        return lisataankoCaret;
    }

    /**
     * metodi palautaa dollarin boolean arvon
     */
    public static boolean isLisataankoDollari() {
        return lisataankoDollari;
    }

    /**
     * metodi palautaa kysymysmerkin boolean arvon
     */
    public static boolean isLisataankoKysymysmerkki() {
        return lisataankoKysymysmerkki;
    }

    /**
     * metodi palautaa ??-merkin boolean arvon
     */
    public static boolean isLisataankoKysymysmerkkiKysymysmerkki() {
        return lisataankoKysymysmerkkiKysymysmerkki;
    }

    /**
     * metodi palautaa piste boolean arvon
     */
    public static boolean isLisataankoPiste() {
        return lisataankoPiste;
    }

    /**
     * metodi palautaa plusmerkin boolean arvon
     */
    public static boolean isLisataankoPlusmerkki() {
        return lisataankoPlusmerkki;
    }

    /**
     * metodi palautaa +?-merkin boolean arvon
     */
    public static boolean isLisataankoPlusmerkkiKysymysmerkki() {
        return lisataankoPlusmerkkiKysymysmerkki;
    }

    /**
     * metodi palautaa *-merkin boolean arvon
     */
    public static boolean isLisataankoTahti() {
        return lisataankoTahti;
    }

    /**
     * metodi palautaa *?-merkin boolean arvon
     */
    public static boolean isLisataankoTahtiKysymysmerkki() {
        return lisataankoTahtiKysymysmerkki;
    }

    /**
     * metodi palautaa |-merkin boolean arvon
     */
    public static boolean isLisataankoTaiMerkki() {
        return lisataankoTaiMerkki;
    }

    /**
     * metodi muuttaa \-merkin arvoa
     *
     * @param lisataankoHakasulkumerkki lisättävä arvo
     */
    public static void setLisataankoBacklash(boolean arvo) {
        lisataankoBacklash = arvo;
    }

    /**
     * metodi muuttaa hattumerkin arvoa
     *
     * @param lisataankoHakasulkumerkki lisättävä arvo
     */
    public static void setLisataankoCaret(boolean arvo) {
        lisataankoCaret = arvo;
    }

    /**
     * metodi muuttaa dollarimerkin arvoa
     *
     * @param lisataankoHakasulkumerkki lisättävä arvo
     */
    public static void setLisataankoDollari(boolean arvo) {
        lisataankoDollari = arvo;
    }

    /**
     * metodi muuttaa kysymysmerkin arvoa
     *
     * @param lisataankoHakasulkumerkki lisättävä arvo
     */
    public static void setLisataankoKysymysmerkki(boolean arvo) {
        lisataankoKysymysmerkki = arvo;
    }

    /**
     * metodi muuttaa ??-merkin arvoa
     *
     * @param lisataankoHakasulkumerkki lisättävä arvo
     */
    public static void setLisataankoKysymysmerkkiKysymysmerkki(boolean arvo) {
        lisataankoKysymysmerkkiKysymysmerkki = arvo;
    }

    /**
     * metodi muuttaa piste-merkin arvoa
     *
     * @param lisataankoHakasulkumerkki lisättävä arvo
     */
    public static void setLisataankoPiste(boolean arvo) {
        lisataankoPiste = arvo;
    }

    /**
     * metodi muuttaa plus-merkin arvoa
     *
     * @param lisataankoHakasulkumerkki lisättävä arvo
     */
    public static void setLisataankoPlusmerkki(boolean arvo) {
        lisataankoPlusmerkki = arvo;
    }

    /**
     * metodi muuttaa +?-merkin arvoa
     *
     * @param lisataankoHakasulkumerkki lisättävä arvo
     */
    public static void setLisataankoPlusmerkkiKysymysmerkki(boolean arvo) {
        lisataankoPlusmerkkiKysymysmerkki = arvo;
    }

    /**
     * metodi muuttaa *-merkin arvoa
     *
     * @param lisataankoHakasulkumerkki lisättävä arvo
     */
    public static void setLisataankoTahti(boolean arvo) {
        lisataankoTahti = arvo;
    }

    /**
     * metodi muuttaa *?-merkikn arvoa
     *
     * @param lisataankoHakasulkumerkki lisättävä arvo
     */
    public static void setLisataankoTahtiKysymysmerkki(boolean arvo) {
        lisataankoTahtiKysymysmerkki = arvo;
    }

    /**
     * metodi muuttaa |-merkin arvoa
     *
     * @param lisataankoHakasulkumerkki lisättävä arvo
     */
    public static void setLisataankoTaiMerkki(boolean arvo) {
        lisataankoTaiMerkki = arvo;
    }

    /**
     * metodi palautaa käytetyt regularexpressionit
     */
    public static StringTaulukko getKaytetytRegularExpressionMerkit() {
        return kaytetytRegularExpressionMerkit;
    }

    /**
     * metodi palautaa tulkinnat
     */
    public StringTaulukko getTulkinnatTaulukkoon() {
        return tulkinnatTaulukkoon;
    }

    /**
     * metodi lisää selityksen käytetyille expressionmerkeille
     */
    public static void lisaakaytetytRegularExpressionMerkkeihin(String selitys) {
        kaytetytRegularExpressionMerkit.lisaaStringKokonaisenaTaulukkoon(selitys);
    }

    /**
     * metodi muuttaa \w arvoa
     *
     * @param lisataankoHakasulkumerkki lisättävä arvo
     */
    public static void setLisataankoBacklash_w(boolean lisataankoBacklash_w) {
        KasitteleStringi.lisataankoBacklash_w = lisataankoBacklash_w;
    }

    /**
     * metodi muuttaa \t-merkin arvoa
     *
     * @param lisataankoHakasulkumerkki lisättävä arvo
     */
    public static void setLisataankoBacklash_t(boolean lisataankoBacklash_t) {
        KasitteleStringi.lisataankoBacklash_t = lisataankoBacklash_t;
    }

    /**
     * metodi muuttaa \s-merkin arvoa
     *
     * @param lisataankoHakasulkumerkki lisättävä arvo
     */
    public static void setLisataankoBacklash_s(boolean lisataankoBacklash_s) {
        KasitteleStringi.lisataankoBacklash_s = lisataankoBacklash_s;
    }

    /**
     * metodi muuttaa \d-merkin arvoa
     *
     * @param lisataankoHakasulkumerkki lisättävä arvo
     */
    public static void setLisataankoBacklash_d(boolean lisataankoBacklash_d) {
        KasitteleStringi.lisataankoBacklash_d = lisataankoBacklash_d;
    }

    /**
     * metodi muuttaa \b-merkin arvoa
     *
     * @param lisataankoHakasulkumerkki lisättävä arvo
     */
    public static void setLisataankoBacklash_b(boolean lisataankoBacklash_b) {
        KasitteleStringi.lisataankoBacklash_b = lisataankoBacklash_b;
    }

    /**
     * metodi muuttaa \S-merkin arvoa
     *
     * @param lisataankoHakasulkumerkki lisättävä arvo
     */
    public static void setLisataankoBacklash_S(boolean lisataankoBacklash_S) {
        KasitteleStringi.lisataankoBacklash_S = lisataankoBacklash_S;
    }

    /**
     * metodi muuttaa \D-merkin arvoa
     *
     * @param lisataankoHakasulkumerkki lisättävä arvo
     */
    public static void setLisataankoBacklash_D(boolean lisataankoBacklash_D) {
        KasitteleStringi.lisataankoBacklash_D = lisataankoBacklash_D;
    }

    /**
     * metodi palautaa \w-merkin boolean arvon
     */
    public static boolean isLisataankoBacklash_w() {
        return lisataankoBacklash_w;
    }

    /**
     * metodi palautaa \t-merkin boolean arvon
     */
    public static boolean isLisataankoBacklash_t() {
        return lisataankoBacklash_t;
    }

    /**
     * metodi palautaa \s-merkin boolean arvon
     */
    public static boolean isLisataankoBacklash_s() {
        return lisataankoBacklash_s;
    }

    /**
     * metodi palautaa \d-merkin boolean arvon
     */
    public static boolean isLisataankoBacklash_d() {
        return lisataankoBacklash_d;
    }

    /**
     * metodi palautaa \b-merkin boolean arvon
     */
    public static boolean isLisataankoBacklash_b() {
        return lisataankoBacklash_b;
    }

    /**
     * metodi palautaa \S-merkin boolean arvon
     */
    public static boolean isLisataankoBacklash_S() {
        return lisataankoBacklash_S;
    }

    /**
     * metodi palautaa \D-merkin boolean arvon
     */
    public static boolean isLisataankoBacklash_D() {
        return lisataankoBacklash_D;
    }

    /**
     * metodi muuttaa viiva-merkin arvoa
     *
     * @param lisataankoHakasulkumerkki lisättävä arvo
     */
    public static void setLisataankoViivamerkki(boolean lisataankoViivamerkki) {
        KasitteleStringi.lisataankoViivamerkki = lisataankoViivamerkki;
    }

    /**
     * metodi muuttaa hattumerkin hakasulkujen sisällä
     *
     * @param lisataankoHakasulkumerkki lisättävä arvo
     */
    public static void setLisataankoCaretHakasulkumerkki(boolean lisataankoCaretHakasulkumerkki) {
        KasitteleStringi.lisataankoCaretHakasulkumerkki = lisataankoCaretHakasulkumerkki;
    }

    /**
     * metodi palautaa viivamerkin boolean arvon
     */
    public static boolean isLisataankoViivamerkki() {
        return lisataankoViivamerkki;
    }

    /**
     * metodi palautaa hattumerkin hakasulkujen sisällä boolean arvon
     */
    public static boolean isLisataankoCaretHakasulkumerkki() {
        return lisataankoCaretHakasulkumerkki;
    }

    /**
     * metodi nollaa staattiset muuttujat
     */
    public static void nollaaStaattisetMuuttujat() {
        kaytetytRegularExpressionMerkit = new StringTaulukko();
        lisataankoPiste = true;
        lisataankoKysymysmerkki = true;
        lisataankoKysymysmerkkiKysymysmerkki = true;
        lisataankoDollari = true;
        lisataankoTahti = true;
        lisataankoTahtiKysymysmerkki = true;
        lisataankoTaiMerkki = true;
        lisataankoCaret = true;
        lisataankoBacklash = true;
        lisataankoPlusmerkki = true;
        lisataankoPlusmerkkiKysymysmerkki = true;
        lisataankoHakasulkumerkki = true;
        lisataankoBacklash_W = true;
        lisataankoBacklash_w = true;
        lisataankoBacklash_D = true;
        lisataankoBacklash_d = true;
        lisataankoBacklash_S = true;
        lisataankoBacklash_s = true;
        lisataankoBacklash_t = true;
        lisataankoBacklash_b = true;
        lisataankoViivamerkki = true;
        lisataankoCaretHakasulkumerkki = true;


    }
}
