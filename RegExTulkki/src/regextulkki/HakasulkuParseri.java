/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package regextulkki;

/**
 *
 * @author lehtimik
 */
public class HakasulkuParseri {

    /**
     * Tutkittava StringTaulukko
     */
    private StringTaulukko stringTaulukko;
    /**
     * tutkitut tulokset tähän taulukkoon
     */
    private StringTaulukko tulkinnatTaulukkoon;
    /**
     * listataan mitä merkkejä hakasulun sisällä on tutkittu
     */
    private StringTaulukko kaytetytRegularExpressionMerkit;
    /**
     * erikoismerkit hakasulkujen sisällä
     */
    private String erikoismerkit = "^-\\";

    /**
     * Konstruktori. Tarvitsee stringTaulukon.
     *
     * @param stringTaulukko stringTaulukko parsittavaksi.
     */
    public HakasulkuParseri(StringTaulukko stringTaulukko) {
        this.stringTaulukko = stringTaulukko;
        tulkinnatTaulukkoon = new StringTaulukko();
        kaytetytRegularExpressionMerkit = new StringTaulukko();
    }
    /**
     * erikoismerkit lisätään vain kerran kaytetytRegularExpressionMerkkeihin
     */
    private boolean lisataankoCaret = true;
    private boolean lisataankoViiva = true;
    private boolean lisataankoBacklash = true;
    /**
     * tulkinnat stringmuodossa, nämä lisätään aina tulkinnatTaulukkoon nimiseen
     * StringTaulukkoon kun niihin viitataan tutkittavassa hakasulukustringissä,
     * voidaan käyttää monta kertaa
     */
    private String caretHakasulkuTulkinta = "(ei mitään seuraavista merkeistä:)";
    private String viivaHakasulkuTulkinta = "(viiva)";
    /**
     * Selitys kaikille käytetyille regular expressioneille hakasulkujen sisällä
     * stringmuodossa, käytetään kerran vaikka olisi useampi samaanlainen merkki
     */
    private String caretHakasulkuSelitys = "\t\"^\" hattu-merkki hakasulkujen alussa tarkoittaa negaatiota, eli kaikki muut merkit paitsi mitä on hakasulkujen sisällä\n";
    private String viivaHakasulkuSelitys = "\t\"-\" viiva-merkki hakasulkujen sisällä tarkoittaa aluetta esim. a-z tarkoittaa kaikkia pieniä kirjaimia.\n";

    /**
     * Metodi tulkitsee erkoismerkit ja kutsuu sitä vastaavaa metodia
     *
     * @param tutkittava tutkittava teksti
     * @param indeksi missä kohtaa stringTaulukkoa mennään kun törmättiin
     * merkkiin.
     */
    public void tulkitseErikoismerkki(String tutkittava, int indeksi) {
        if (tutkittava.equals("\\")) {
            tutkiHakasulunBacklash();
            lisataankoHakasulunBacklashKaytetytRegularExpressionMerkkeihin();
        }
       
        
        if (tutkittava.equals("-")) {
            tutkiViivaMerkki();
            lisataankoViivaMerkkiKaytetytRegularExpressionMerkkeihin();
        }
        if (tutkittava.equals("^")) {
            tutkiHakasulkuCaretMerkki();
            lisataankoHakasulkuCaretmerkkiKaytetytRegularExpressionMerkkeihin();
        }
       

    }
    
     /**
     * Metodi käy läpi StringTaulukon ja tarkistaa onko tekstissä
     * erikoismerkkejä hakasulkujen sisällä.
     *
     */
    public void kayLapiStringTaulukko() {
        while (onkoAlkioitaVielaJaljella()) {
            String tutkittava = stringTaulukko.annaTaulukonAlkionArvo(stringTaulukko.getTutkittavaIndeksi());
            if (onkoErikoismerkki(tutkittava) == true) {
                tulkitseErikoismerkki(tutkittava, stringTaulukko.getTutkittavaIndeksi());
            } else {
                tulkinnatTaulukkoon.lisaaStringKokonaisenaTaulukkoon(tutkittava);
                stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + 1);
            }           
        }
}
