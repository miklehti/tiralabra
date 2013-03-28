/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package regextulkki;

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
     * erikoismerkit regexissä
     */
    private String erikoismerkit = "[()+$.|^*?\\";

    /**
     * Konstruktori. Tarvitsee stringTaulukon.
     *
     * @param stringTaulukko stringTaulukko parsittavaksi.
     */
    public Parseri(StringTaulukko stringTaulukko) {
        this.stringTaulukko = stringTaulukko;
        tulkinnatTaulukkoon = new StringTaulukko();
        kaytetytRegularExpressionMerkit = new StringTaulukko();
    }
    /**
     * erikoismerkit lisätään vain kerran kaytetytRegularExpressionMerkit
     * taulukkoon, jos esim. piste on jo siellä on flag false eikäs sitä enää
     * lisätä
     */
    private boolean lisataankoPiste = true;
    private boolean lisataankoKysymysmerkki = true;
    private boolean lisataankoKysymysmerkkiKysymysmerkki = true;
    private boolean lisataankoDollari = true;
    private boolean lisataankoTahti = true;
    private boolean lisataankoTahtiKysymysmerkki = true;
    private boolean lisataankoTaiMerkki = true;
    private boolean lisataankoCaret = true;
    private boolean lisataankoBacklash = true;
    private boolean lisataankoPlusmerkki = true;
    private boolean lisataankoPlusmerkkiKysymysmerkki = true;
    
      /**
     * tulkinnat stringmuodossa, nämä lisätään aina tulkinnatTaulukkoon nimiseen StringTaulukkoon kun niihin viitataan tutkittavassa Stringissä
     */
    private String tahtiTulkinta = "(toistetaan edellistä merkkiä 0-n kertaa)";
    private String taiTulkinta = "(tai)";
    private String plusTulkinta = "(toistetaan edellistä merkkiä 1-n kertaa)";
    private String dollariTulkinta = "(etsitään edellistä (<=) stringin lopusta)";
    private String pisteTulkinta = "(mikä tahansa merkki)";
    private String kysymysmerkkiTulkinta = "(edelllä oleva termi(t) ovat vapaaehtoisia, ahne versio)";
    private String caretTulkinta = "((etsitään seuraavaa (=>) stringin alusta))";
  

    /**
     * Metodi tulkitsee erkoismerkit ja kutsuu sitä vastaavaa luokkametodia
     *
     * @param tutkittava tutkittava teksti
     * @param indeksi missä kohtaa stringTaulukkoa mennään kun törmättiin
     * merkkiin.
     */
    public void tulkitseErikoismerkki(String tutkittava, int indeksi) {
        if (tutkittava.equals("\\")) {
            tutkiBacklash();
            lisataankoBacklashKaytetytRegularExpressionMerkkeihin();
        }
        if (tutkittava.equals("$")) {
            tutkiDollari();
            lisataankoDollariKaytetytRegularExpressionMerkkeihin();
        }
        if (tutkittava.equals(".")) {
            tutkiPiste();
            lisataankoPisteKaytetytRegularExpressionMerkkeihin();

        }
        if (tutkittava.equals("|")) {
            tutkiTaiMerkki();
            lisataankoTaiMerkkiKaytetytRegularExpressionMerkkeihin();
        }
        if (tutkittava.equals("^")) {
            tutkiCaretMerkki();
            lisataankoCaretmerkkiKaytetytRegularExpressionMerkkeihin();
        }
        if (tutkittava.equals("?")) {
            boolean kaksiKysymysmerkkia = tutkiKysymysmerkki();
            lisataankoKysymysmerkkiKaytetytRegularExpressionMerkkeihin(kaksiKysymysmerkkia);
        }
        if (tutkittava.equals("*")) {
            boolean tahtiKysymysmerkki = tutkiTahtiMerkki();
            lisataankoTahtiMerkkiKaytetytRegularExpressionMerkkeihin(tahtiKysymysmerkki);
        }
        if (tutkittava.equals("+")) {
            boolean PlusKysymysmerkki = tutkiPlusMerkki();
            lisataankoPlusMerkkiKaytetytRegularExpressionMerkkeihin(PlusKysymysmerkki);
        }




    }

    /**
     * Metodi käy läpi StringTaulukon ja tarkistaa onko tekstissä
     * erikoismerkkejä.
     *
     */
    public void kayLapiStringTaulukko() {
        while (onkoAlkioitaVielaJaljella()) {
            String tutkittava = stringTaulukko.annaTaulukonAlkionArvo(stringTaulukko.getTutkittavaIndeksi());
            if (onkoErikoismerkki(tutkittava) == true) {
                tulkitseErikoismerkki(tutkittava, stringTaulukko.getTutkittavaIndeksi());
            } else {
                tulkinnatTaulukkoon.lisaaStringKokonaisenaTaulukkoon(tutkittava);
            }
            stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + 1);
        }
    }

    /**
     * Metodi palauttaa luokan yksityisen stringtaulukon
     *
     * @return palauttaa luokan StringTaulukon
     */
    public StringTaulukko getStringTaulukko() {
        return stringTaulukko;
    }

    /**
     * Metodi tutkii onko kirjain erikoismerkki
     *
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
     *
     * @return palauttaa totuusarvon
     */
    public boolean onkoAlkioitaVielaJaljella() {
        return stringTaulukko.getTutkittavaIndeksi() < stringTaulukko.getAlkioidenLKM();
    }

    /**
     * Metodi palauttaa kaytetyt regex merrkit
     *
     * @return palauttaa StringTaulukon kaikista käytetyistä luokista
     */
    public StringTaulukko getKaytetytRegularExpressionMerkit() {
        return kaytetytRegularExpressionMerkit;
    }

    /**
     * Metodi palauttaa tulkinnat regex lauseesta
     *
     * @return palauttaa StringTaulukon regex tulkinnoista
     */
    public StringTaulukko getTulkinnatTaulukkoon() {
        return tulkinnatTaulukkoon;
    }

    /**
     * Metodi tutkii onko piste jo lisätty käytettyihin regexeihin. Jos ei ole
     * niin lisätään ja merkitään lisätyksi.
     *
     * @return palauttaa StringTaulukon regex tulkinnoista
     */
    public void lisataankoPisteKaytetytRegularExpressionMerkkeihin() {
        if (lisataankoPiste == true) {
            kaytetytRegularExpressionMerkit.lisaaStringKokonaisenaTaulukkoon("\".\" piste tarkoittaa että mikä tahansa merkki\n");
            lisataankoPiste = false;
        }
    }

    public void lisataankoDollariKaytetytRegularExpressionMerkkeihin() {
        if (lisataankoDollari == true) {
            kaytetytRegularExpressionMerkit.lisaaStringKokonaisenaTaulukkoon("\"$\" dollari tarkoittaa että tutkitaan jonkun stringin loppua löytyykö sieltä ennen dollari-merkkiä annettua termiä, tai termejä jos sulut ennen dollaria\n");
            lisataankoDollari = false;
        }
    }

    public void lisataankoBacklashKaytetytRegularExpressionMerkkeihin() {
        if (lisataankoBacklash == true) {
            kaytetytRegularExpressionMerkit.lisaaStringKokonaisenaTaulukkoon("\"\\\" kenoviiva tarkoittaa että seuraava merkki ei olekaan erikoismerkki\n");
            lisataankoBacklash = false;
        }
    }

    public void lisataankoTaiMerkkiKaytetytRegularExpressionMerkkeihin() {
        if (lisataankoTaiMerkki == true) {
            kaytetytRegularExpressionMerkit.lisaaStringKokonaisenaTaulukkoon("\"|\" tai-merkki\n");
            lisataankoTaiMerkki = false;
        }
    }

    public void lisataankoKysymysmerkkiKaytetytRegularExpressionMerkkeihin(boolean kaksiKysymysmerkkia) {
        if (kaksiKysymysmerkkia == false) {
            if (lisataankoKysymysmerkki == true) {
                kaytetytRegularExpressionMerkit.lisaaStringKokonaisenaTaulukkoon("\"?\" Kysymysmerkki tarkoittaa että edellinen arvo on valinnainen. \n Yksi kysymysmerkki tarkoittaa että kyseessä on ahne versio. \nAhne versio takoittaa että regeular expression yrittää ensin saada valinnaisen termin onnistumaan ja vasta sitten yrittää että ei onnistu\n");
                lisataankoKysymysmerkki = false;
            }
        }
        if (kaksiKysymysmerkkia == true) {
            if (lisataankoKysymysmerkkiKysymysmerkki == true) {
                kaytetytRegularExpressionMerkit.lisaaStringKokonaisenaTaulukkoon("\"??\" Tupla-kysymysmerkki tarkoittaa että edellinen arvo on valinnainen. \n Kaksi kysymysmerkkiä tarkoittaa että kyseessä on laiska versio. \nLaiska versio takoittaa että regeular expression yrittää ensin ilman valinnaista termiä ja vasta sitten valinnaisen termin kanssa\n");
                lisataankoKysymysmerkkiKysymysmerkki = false;
            }
        }

    }

    public void lisataankoTahtiMerkkiKaytetytRegularExpressionMerkkeihin(boolean tahtiKysymysmerkki) {
        if (tahtiKysymysmerkki == false) {
            if (lisataankoTahti == true) {
                kaytetytRegularExpressionMerkit.lisaaStringKokonaisenaTaulukkoon("\"*\" Tähti-merkki tarkoittaa että edellinen arvo toistetaan nolla-ääretön kertaa \n Pelkkä tähtimerkki ilman kysymysmerkkiä tarkoittaa että kyseessä on ahne versio. \nAhne versio takoittaa että regeular expression yrittää ensin mahdollisimman monella vaihtoehdolla ja karsii sitten vaihtoehtoja pienemmäksi kunnes ei mahdollisesti löydä etsimäänsä\n");
                lisataankoTahti = false;
            }
        }
        if (tahtiKysymysmerkki == true) {
            if (lisataankoTahtiKysymysmerkki == true) {
                kaytetytRegularExpressionMerkit.lisaaStringKokonaisenaTaulukkoon("\"*?\" Tähti-kysymysmerkki tarkoittaa että edellinen arvo toistetaan nolla-ääretön kertaa. \n Kaksi kysymysmerkkiä tarkoittaa että kyseessä on laiska versio. \nLaiska versio takoittaa että regeular expression yrittää ensin minimisetillä ja sitten kasvattaa hakukriteeriä kunnes löytyy\n");
                lisataankoTahtiKysymysmerkki = false;
            }
        }

    }

    public void lisataankoPlusMerkkiKaytetytRegularExpressionMerkkeihin(boolean PlusKysymysmerkki) {
        if (PlusKysymysmerkki == false) {
            if (lisataankoPlusmerkki == true) {
                kaytetytRegularExpressionMerkit.lisaaStringKokonaisenaTaulukkoon("\"+\" Plus-merkki tarkoittaa että edellinen arvo toistetaan yksi-ääretön kertaa \n Pelkkä tähtimerkki ilman kysymysmerkkiä tarkoittaa että kyseessä on ahne versio. \nAhne versio takoittaa että regeular expression yrittää ensin mahdollisimman monella vaihtoehdolla ja karsii sitten vaihtoehtoja pienemmäksi kunnes ei mahdollisesti löydä etsimäänsä\n");
                lisataankoPlusmerkki = false;
            }
        }
        if (PlusKysymysmerkki == true) {
            if (lisataankoPlusmerkkiKysymysmerkki == true) {
                kaytetytRegularExpressionMerkit.lisaaStringKokonaisenaTaulukkoon("\"*?\" Tähti-kysymysmerkki tarkoittaa että edellinen arvo toistetaan yksi-ääretön kertaa. \n Kaksi kysymysmerkkiä tarkoittaa että kyseessä on laiska versio. \nLaiska versio takoittaa että regeular expression yrittää ensin minimisetillä ja sitten kasvattaa hakukriteeriä kunnes löytyy\n");
                lisataankoPlusmerkkiKysymysmerkki = false;
            }
        }

    }

    public void lisataankoCaretmerkkiKaytetytRegularExpressionMerkkeihin() {
        if (lisataankoCaret == true) {
            kaytetytRegularExpressionMerkit.lisaaStringKokonaisenaTaulukkoon("\"^\" hattu-merkki tarkoittaa että etsintää tehdään sanan alusta tätä merkkiä seuraavalla termillä, tai termeillä jos suluissa\n");
            lisataankoCaret = false;
        }
    }

    public void tutkiPiste() {
        stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + 1);
        tulkinnatTaulukkoon.lisaaStringKokonaisenaTaulukkoon();
    }

    public void tutkiDollari() {
        stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + 1);
        tulkinnatTaulukkoon.lisaaStringKokonaisenaTaulukkoon();
    }

    public void tutkiBacklash() {
        String seuraavaMerkki = stringTaulukko.annaTaulukonAlkionArvo((stringTaulukko.getTutkittavaIndeksi() + 1));
        if(!seuraavaMerkki.equals("false")){
        tulkinnatTaulukkoon.lisaaStringKokonaisenaTaulukkoon(seuraavaMerkki);
        stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + 1);
        }
       

    }

    public boolean tutkiTahtiMerkki() {
        if (onkoKysymysmerkkiPerassa()) {
            return true;
        }
        stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + 1);
        tulkinnatTaulukkoon.lisaaStringKokonaisenaTaulukkoon();
        return false;
    }

    public boolean tutkiPlusMerkki() {
        if (onkoKysymysmerkkiPerassa()) {
            return true;
        }
        stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + 1);
        tulkinnatTaulukkoon.lisaaStringKokonaisenaTaulukkoon();
        return false;
    }

    public void tutkiTaiMerkki() {
        stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + 1);
        tulkinnatTaulukkoon.lisaaStringKokonaisenaTaulukkoon();
    }

    public boolean tutkiKysymysmerkki() {
        if (onkoKysymysmerkkiPerassa()) {
            stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + 2);
            tulkinnatTaulukkoon.lisaaStringKokonaisenaTaulukkoon();
            return true;
        }

        stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + 1);
        tulkinnatTaulukkoon.lisaaStringKokonaisenaTaulukkoon();
        return false;
    }

    public boolean onkoKysymysmerkkiPerassa() {
        int seuraavanTutkittavanIndeksi = stringTaulukko.getTutkittavaIndeksi() + 1;
        if (onkoMerkkejaVielaJaljella(seuraavanTutkittavanIndeksi)) {
            String seuraavaTutkittava = stringTaulukko.annaTaulukonAlkionArvo(seuraavanTutkittavanIndeksi);
            if (seuraavaTutkittava.equals("?")) {

                return true;
            }
        }
        return false;
    }

    public boolean onkoMerkkejaVielaJaljella(int seuraavanTutkittavanIndeksi) {
        return seuraavanTutkittavanIndeksi <= stringTaulukko.getTaulukko().length;
    }

    public void tutkiCaretMerkki() {
        stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + 1);
        tulkinnatTaulukkoon.lisaaStringKokonaisenaTaulukkoon();
    }
}
