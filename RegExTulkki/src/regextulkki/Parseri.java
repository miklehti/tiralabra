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
     * tulkinnat stringmuodossa, nämä lisätään aina tulkinnatTaulukkoon nimiseen
     * StringTaulukkoon kun niihin viitataan tutkittavassa Stringissä, voidaan
     * käyttää monta kertaa
     */
    private String tahtiTulkinta = "(toistetaan edellistä merkkiä 0-n kertaa, ahne versio)";
    private String taiTulkinta = "(tai)";
    private String plusTulkinta = "(toistetaan edellistä merkkiä 1-n kertaa)";
    private String dollariTulkinta = "(etsitään edellistä (<=) stringin lopusta)";
    private String pisteTulkinta = "(mikä tahansa merkki)";
    private String kysymysmerkkiTulkinta = "(edelllä oleva termi(t) ovat vapaaehtoisia, ahne versio)";
    private String caretTulkinta = "((etsitään seuraavaa (=>) stringin alusta))";
    private String kysymysmerkkiKysymysmerkkiTulkinta = "(edelllä oleva termi(t) ovat vapaaehtoisia, laiska versio)";
    private String tahtiKysymysmerkkiTulkinta = "(toistetaan edellistä merkkiä 0-n kertaa, ahne versio)";
    private String plusKysymysmerkkiTulkinta = "(toistetaan edellistä merkkiä 1-n kertaa, ahne versio)";
    /**
     * Selitys kaikille käytetyille regular expressioneille stringmuodossa,
     * käytetään kerran vaikka olisi useampi samaanlainen merkki
     */
    private String tahtiSelitys = "\"*\" Tähti-merkki tarkoittaa että edellinen arvo toistetaan nolla-ääretön kertaa \n Pelkkä tähtimerkki ilman kysymysmerkkiä tarkoittaa että kyseessä on ahne versio. \nAhne versio takoittaa että regeular expression yrittää ensin mahdollisimman monella vaihtoehdolla ja karsii sitten vaihtoehtoja pienemmäksi kunnes ei mahdollisesti löydä etsimäänsä\n";
    private String taiSelitys = "\"|\" tai-merkki\n";
    private String plusSelitys = "\"+\" Plus-merkki tarkoittaa että edellinen arvo toistetaan yksi-ääretön kertaa \n Pelkkä plusmerkki ilman kysymysmerkkiä tarkoittaa että kyseessä on ahne versio. \nAhne versio takoittaa että regeular expression yrittää ensin mahdollisimman monella vaihtoehdolla ja karsii sitten vaihtoehtoja pienemmäksi kunnes ei mahdollisesti löydä etsimäänsä\n";
    private String dollariSelitys = "\"$\" dollari tarkoittaa että tutkitaan jonkun stringin loppua löytyykö sieltä ennen dollari-merkkiä annettua termiä, tai termejä jos sulut ennen dollaria\n";
    private String pisteSelitys = "\".\" piste tarkoittaa että mikä tahansa merkki\n";
    private String kysymysmerkkiSelitys = "\"?\" Kysymysmerkki tarkoittaa että edellinen arvo on valinnainen. \n Yksi kysymysmerkki tarkoittaa että kyseessä on ahne versio. \nAhne versio takoittaa että regeular expression yrittää ensin saada valinnaisen termin onnistumaan ja vasta sitten yrittää että ei onnistu\n";
    private String caretSelitys = "\"^\" hattu-merkki tarkoittaa että etsintää tehdään sanan alusta tätä merkkiä seuraavalla termillä, tai termeillä jos suluissa\n";
    private String kysymysmerkkiKysymysmerkkiSelitys = "\"??\" Tupla-kysymysmerkki tarkoittaa että edellinen arvo on valinnainen. \n Kaksi kysymysmerkkiä tarkoittaa että kyseessä on laiska versio. \nLaiska versio takoittaa että regeular expression yrittää ensin ilman valinnaista termiä ja vasta sitten valinnaisen termin kanssa\n";
    private String tahtiKysymysmerkkiSelitys = "\"*?\" Tähti-kysymysmerkki tarkoittaa että edellinen arvo toistetaan nolla-ääretön kertaa. \n Kysymysmerkki tähden perässä tarkoittaa että kyseessä on laiska versio. \nLaiska versio takoittaa että regeular expression yrittää ensin minimisetillä ja sitten kasvattaa hakukriteeriä kunnes löytyy\n";
    private String plusKysymysmerkkiSelitys = "\"\\\"+?\\\" Plus-kysymysmerkki tarkoittaa että edellinen arvo toistetaan yksi-ääretön kertaa \\n Kysymysmerkki plussan perässä tarkoittaa että kyseessä on laiska versio. \\nLaiska versio takoittaa että regeular expression yrittää ensin minimisetillä ja sitten kasvattaa hakukriteeriä kunnes löytyy\\n\";";
    private String backlashSelitys = "\"\\\" kenoviiva tarkoittaa että seuraava merkki ei olekaan erikoismerkki\n";

    /**
     * Metodi tulkitsee erkoismerkit ja kutsuu sitä vastaavaa metodia
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
                stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + 1);
            }           
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
     */
    public void lisataankoPisteKaytetytRegularExpressionMerkkeihin() {
        if (lisataankoPiste == true) {
            kaytetytRegularExpressionMerkit.lisaaStringKokonaisenaTaulukkoon(pisteSelitys);
            lisataankoPiste = false;
        }
    }

    /**
     * Metodi tutkii onko dollari jo lisätty käytettyihin regexeihin. Jos ei ole
     * niin lisätään ja merkitään lisätyksi.
     */
    public void lisataankoDollariKaytetytRegularExpressionMerkkeihin() {
        if (lisataankoDollari == true) {
            kaytetytRegularExpressionMerkit.lisaaStringKokonaisenaTaulukkoon(dollariSelitys);
            lisataankoDollari = false;
        }
    }

    /**
     * Metodi tutkii onko kenoviiva jo lisätty käytettyihin regexeihin. Jos ei
     * ole niin lisätään ja merkitään lisätyksi.
     */
    public void lisataankoBacklashKaytetytRegularExpressionMerkkeihin() {
        if (lisataankoBacklash == true) {
            kaytetytRegularExpressionMerkit.lisaaStringKokonaisenaTaulukkoon(backlashSelitys);
            lisataankoBacklash = false;
        }
    }

    /**
     * Metodi tutkii onko tai-merkki jo lisätty käytettyihin regexeihin. Jos ei
     * ole niin lisätään ja merkitään lisätyksi.
     */
    public void lisataankoTaiMerkkiKaytetytRegularExpressionMerkkeihin() {
        if (lisataankoTaiMerkki == true) {
            kaytetytRegularExpressionMerkit.lisaaStringKokonaisenaTaulukkoon(taiSelitys);
            lisataankoTaiMerkki = false;
        }
    }

    /**
     * Metodi tutkii onko kysymysmerkki tai tupla-kysymysmerkki merkki jo
     * lisätty käytettyihin regexeihin. Jos ei ole niin lisätään ja merkitään
     * lisätyksi.
     *
     * @param kaksiKysymysmerkkia onko tuplakysymysmerkillä vai ilman
     */
    public void lisataankoKysymysmerkkiKaytetytRegularExpressionMerkkeihin(boolean kaksiKysymysmerkkia) {
        if (kaksiKysymysmerkkia == false) {
            if (lisataankoKysymysmerkki == true) {
                kaytetytRegularExpressionMerkit.lisaaStringKokonaisenaTaulukkoon(kysymysmerkkiSelitys);
                lisataankoKysymysmerkki = false;
            }
        }
        if (kaksiKysymysmerkkia == true) {
            if (lisataankoKysymysmerkkiKysymysmerkki == true) {
                kaytetytRegularExpressionMerkit.lisaaStringKokonaisenaTaulukkoon(kysymysmerkkiKysymysmerkkiSelitys);
                lisataankoKysymysmerkkiKysymysmerkki = false;
            }
        }

    }

    /**
     * Metodi tutkii onko tähti-merkki tai tähti-kysymysmerkki merkki jo lisätty
     * käytettyihin regexeihin. Jos ei ole niin lisätään ja merkitään lisätyksi.
     *
     * @param tahtiKysymysmerkki onko kysymysmerkillä vai ilman
     */
    public void lisataankoTahtiMerkkiKaytetytRegularExpressionMerkkeihin(boolean tahtiKysymysmerkki) {
        if (tahtiKysymysmerkki == false) {
            if (lisataankoTahti == true) {
                kaytetytRegularExpressionMerkit.lisaaStringKokonaisenaTaulukkoon(tahtiSelitys);
                lisataankoTahti = false;
            }
        }
        if (tahtiKysymysmerkki == true) {
            if (lisataankoTahtiKysymysmerkki == true) {
                kaytetytRegularExpressionMerkit.lisaaStringKokonaisenaTaulukkoon(tahtiKysymysmerkkiSelitys);
                lisataankoTahtiKysymysmerkki = false;
            }
        }

    }

    /**
     * Metodi tutkii onko plusmerkki tai plus-kysymysmerkki merkki jo lisätty
     * käytettyihin regexeihin. Jos ei ole niin lisätään ja merkitään lisätyksi.
     *
     * @param PlusKysymysmerkki onko kysymysmerkillä vai ilman
     */
    public void lisataankoPlusMerkkiKaytetytRegularExpressionMerkkeihin(boolean PlusKysymysmerkki) {
        if (PlusKysymysmerkki == false) {
            if (lisataankoPlusmerkki == true) {
                kaytetytRegularExpressionMerkit.lisaaStringKokonaisenaTaulukkoon(plusSelitys);
                lisataankoPlusmerkki = false;
            }
        }
        if (PlusKysymysmerkki == true) {
            if (lisataankoPlusmerkkiKysymysmerkki == true) {
                kaytetytRegularExpressionMerkit.lisaaStringKokonaisenaTaulukkoon(plusKysymysmerkkiSelitys);
                lisataankoPlusmerkkiKysymysmerkki = false;
            }
        }

    }

    /**
     * Metodi tutkii onko hattumerkki jo lisätty käytettyihin regexeihin. Jos ei
     * ole niin lisätään ja merkitään lisätyksi.
     */
    public void lisataankoCaretmerkkiKaytetytRegularExpressionMerkkeihin() {
        if (lisataankoCaret == true) {
            kaytetytRegularExpressionMerkit.lisaaStringKokonaisenaTaulukkoon(caretSelitys);
            lisataankoCaret = false;
        }
    }

    /**
     * Metodi lisää pistettä vastaavan tulkinnan tulkinnatTaulukkoon nimiseen
     * stringTaulukkoon. Samalla metodi kasvatta tutkittavaa kohtaa yhdellä
     */
    public void tutkiPiste() {
        stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + 1);
        tulkinnatTaulukkoon.lisaaStringKokonaisenaTaulukkoon(pisteTulkinta);
    }

    /**
     * Metodi lisää dollaria vastaavan tulkinnan tulkinnatTaulukkoon nimiseen
     * stringTaulukkoon. Samalla metodi kasvatta tutkittavaa kohtaa yhdellä
     */
    public void tutkiDollari() {
        stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + 1);
        tulkinnatTaulukkoon.lisaaStringKokonaisenaTaulukkoon(dollariTulkinta);
    }

    /**
     * Metodi ignooraa kenoviivan se toimii escapena, sille ei ole tulkintaa.
     * Samoin seuraava merkki (joson) lisätään sellaisenaan tulkintaan
     * kirjaimellisesti, ei merkin tulkintaa
     */
    public void tutkiBacklash() {
        String seuraavaMerkki = stringTaulukko.annaTaulukonAlkionArvo((stringTaulukko.getTutkittavaIndeksi() + 1));
        if (!seuraavaMerkki.equals("false")) {
            tulkinnatTaulukkoon.lisaaStringKokonaisenaTaulukkoon(seuraavaMerkki);
            stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + 1);
        }
        stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + 1);

    }

    /**
     * Metodi lisää tähtimerkkiä tai tähti-kysymysmerkkiä vastaavan tulkinnan
     * tulkinnatTaulukkoon nimiseen stringTaulukkoon. Samalla metodi kasvatta
     * tutkittavaa kohtaa yhdellä tai kahdella riippuen kumpi tulkinta tulee.
     *
     * @return palauttaa totuusarvona onko kysymysmerkkiä perässä
     */
    public boolean tutkiTahtiMerkki() {
        if (onkoKysymysmerkkiPerassa()) {
            tulkinnatTaulukkoon.lisaaStringKokonaisenaTaulukkoon(tahtiKysymysmerkkiTulkinta);
            stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + 2);
            return true;
        }
        stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + 1);
        tulkinnatTaulukkoon.lisaaStringKokonaisenaTaulukkoon(tahtiTulkinta);
        return false;
    }

    /**
     * Metodi lisää plusmerkkiä tai plus-kysymysmerkkiä vastaavan tulkinnan
     * tulkinnatTaulukkoon nimiseen stringTaulukkoon. Samalla metodi kasvatta
     * tutkittavaa kohtaa yhdellä tai kahdella riippuen kumpi tulkinta tulee.
     *
     * @return palauttaa totuusarvona onko kysymysmerkkiä perässä
     */
    public boolean tutkiPlusMerkki() {
        if (onkoKysymysmerkkiPerassa()) {
            tulkinnatTaulukkoon.lisaaStringKokonaisenaTaulukkoon(plusKysymysmerkkiTulkinta);
            stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + 2);
            return true;
        }
        stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + 1);
        tulkinnatTaulukkoon.lisaaStringKokonaisenaTaulukkoon(plusTulkinta);
        return false;
    }

    /**
     * Metodi lisää tai-merkkiä vastaavan tulkinnan tulkinnatTaulukkoon nimiseen
     * stringTaulukkoon. Samalla metodi kasvatta tutkittavaa kohtaa yhdellä.
     */
    public void tutkiTaiMerkki() {
        stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + 1);
        tulkinnatTaulukkoon.lisaaStringKokonaisenaTaulukkoon(taiTulkinta);
    }

    /**
     * Metodi lisää kysymysmerkkiä tai tupla-kysymysmerkkiä vastaavan tulkinnan
     * tulkinnatTaulukkoon nimiseen stringTaulukkoon. Samalla metodi kasvatta
     * tutkittavaa kohtaa yhdellä tai kahdella riippuen siitä kumpi kyseessä.
     *
     * @return palauttaa totuusarvona onko kysymysmerkkiä perässä
     */
    public boolean tutkiKysymysmerkki() {
        if (onkoKysymysmerkkiPerassa()) {
            stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + 2);
            tulkinnatTaulukkoon.lisaaStringKokonaisenaTaulukkoon(kysymysmerkkiKysymysmerkkiTulkinta);
            return true;
        }

        stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + 1);
        tulkinnatTaulukkoon.lisaaStringKokonaisenaTaulukkoon(kysymysmerkkiTulkinta);
        return false;
    }

    /**
     * Metodi tutkii onko seuraava tutkittava merkki kysymysmerkki
     *
     * @return palauttaa totuusarvona onko kysymysmerkkiä perässä
     */
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

    /**
     * Metodi tutkii onko merkkejä vielä jäljellä vai ollaanko viimeisessä
     *
     * @param seuraavanTutkittavanIndeksi Taulukon seuraavan tutkittavan alkion
     * indeksi
     * @return palauttaa totuusarvona onko kysymysmerkkiä perässä
     */
    public boolean onkoMerkkejaVielaJaljella(int seuraavanTutkittavanIndeksi) {
        return seuraavanTutkittavanIndeksi <= stringTaulukko.getTaulukko().length;
    }

    /**
     * Metodi lisää hattu-merkkiä vastaavan tulkinnan tulkinnatTaulukkoon
     * nimiseen stringTaulukkoon. Samalla metodi kasvatta tutkittavaa kohtaa
     * yhdellä.
     */
    public void tutkiCaretMerkki() {
        stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + 1);
        tulkinnatTaulukkoon.lisaaStringKokonaisenaTaulukkoon(caretTulkinta);
    }

    /**
     * Metodi palauttaa selityksen kenoviivalle
     */
    public String getBacklashSelitys() {
        return backlashSelitys;
    }

    /**
     * Metodi palauttaa selityksen hattumerkille
     */
    public String getCaretSelitys() {
        return caretSelitys;
    }

    /**
     * Metodi palauttaa tulkinnan hattumerkille
     */
    public String getCaretTulkinta() {
        return caretTulkinta;
    }

    /**
     * Metodi palauttaa selityksen dollarimerkille
     */
    public String getDollariSelitys() {
        return dollariSelitys;
    }

    /**
     * Metodi palauttaa tulkinnan dollarimerkille
     */
    public String getDollariTulkinta() {
        return dollariTulkinta;
    }

    /**
     * Metodi palauttaa selityksen tupla-kysymysmerkille
     */
    public String getKysymysmerkkiKysymysmerkkiSelitys() {
        return kysymysmerkkiKysymysmerkkiSelitys;
    }

    /**
     * Metodi palauttaa tulkinnan tupla-kysymysmerkille
     */
    public String getKysymysmerkkiKysymysmerkkiTulkinta() {
        return kysymysmerkkiKysymysmerkkiTulkinta;
    }

    /**
     * Metodi palauttaa erikoismerkit
     */
    public String getErikoismerkit() {
        return erikoismerkit;
    }

    /**
     * Metodi palauttaa selityksen kysymysmerkille
     */
    public String getKysymysmerkkiSelitys() {
        return kysymysmerkkiSelitys;
    }

    /**
     * Metodi palauttaa tulkinnan kysymysmerkille
     */
    public String getKysymysmerkkiTulkinta() {
        return kysymysmerkkiTulkinta;
    }

    /**
     * Metodi palauttaa selityksen pisteelle
     */
    public String getPisteSelitys() {
        return pisteSelitys;
    }

    /**
     * Metodi palauttaa tulkinnan pisteelle
     */
    public String getPisteTulkinta() {
        return pisteTulkinta;
    }

    /**
     * Metodi palauttaa selityksen plus-kysymysmerkille
     */
    public String getPlusKysymysmerkkiSelitys() {
        return plusKysymysmerkkiSelitys;
    }

    /**
     * Metodi palauttaa tulkinnan plus-kysymysmerkille
     */
    public String getPlusKysymysmerkkiTulkinta() {
        return plusKysymysmerkkiTulkinta;
    }

    /**
     * Metodi palauttaa selituksen plusmerkille
     */
    public String getPlusSelitys() {
        return plusSelitys;
    }

    /**
     * Metodi palauttaa tulkinnan plusmerkille
     */
    public String getPlusTulkinta() {
        return plusTulkinta;
    }

    /**
     * Metodi palauttaa selityksen tähtimerkille
     */
    public String getTahtiKysymysmerkkiSelitys() {
        return tahtiKysymysmerkkiSelitys;
    }

    /**
     * Metodi palauttaa tulkinnan tähtikysymysmerkille
     */
    public String getTahtiKysymysmerkkiTulkinta() {
        return tahtiKysymysmerkkiTulkinta;
    }

    /**
     * Metodi palauttaa selityksen tähtimerkille
     */
    public String getTahtiSelitys() {
        return tahtiSelitys;
    }

    /**
     * Metodi palauttaa tulkinnan tähtimerkille
     */
    public String getTahtiTulkinta() {
        return tahtiTulkinta;
    }

    /**
     * Metodi palauttaa selityksen taimerkille
     */
    public String getTaiSelitys() {
        return taiSelitys;
    }

    /**
     * Metodi palauttaa tulkinnan taimerkille
     */
    public String getTaiTulkinta() {
        return taiTulkinta;
    }
}
