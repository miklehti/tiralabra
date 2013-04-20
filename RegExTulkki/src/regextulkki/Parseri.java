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
     * erikoismerkit regexissä
     */
    private String erikoismerkit = "[+$.|^*?\\(";

    /**
     * Konstruktori. Tarvitsee kolme StringTaulukkoa.
     *
     * @param stringTaulukko stringTaulukko parsittavaksi.
     * @param stringTaulukko stringTaulukko parsittavaksi.
     * @param kaytetytRegularExpressionMerkit stringTaulukko käytetyistä
     * regularexpressioneista.
     */
    public Parseri(StringTaulukko stringTaulukko, StringTaulukko tulkinnatTaulukkoon) {
        this.stringTaulukko = stringTaulukko;
        this.tulkinnatTaulukkoon = tulkinnatTaulukkoon;

    }
    /**
     * tulkinnat stringmuodossa, nämä lisätään aina tulkinnatTaulukkoon nimiseen
     * StringTaulukkoon kun niihin viitataan tutkittavassa Stringissä, voidaan
     * käyttää monta kertaa
     */
    private String tahtiTulkinta = "{toistetaan edellistä merkkiä 0-n kertaa, ahne versio}";
    private String taiTulkinta = "{tai}";
    private String plusTulkinta = "{toistetaan edellistä merkkiä 1-n kertaa}";
    private String dollariTulkinta = "{etsitään edellistä {<=} stringin lopusta}";
    private String pisteTulkinta = "{mikä tahansa merkki}";
    private String kysymysmerkkiTulkinta = "{edelllä oleva termi{t} ovat vapaaehtoisia, ahne versio}";
    private String caretTulkinta = "{etsitään seuraavaa {=>}stringin alusta}";
    private String kysymysmerkkiKysymysmerkkiTulkinta = "{edelllä oleva termi{t} ovat vapaaehtoisia, laiska versi}";
    private String tahtiKysymysmerkkiTulkinta = "{toistetaan edellistä merkkiä 0-n kertaa, ahne versio}";
    private String plusKysymysmerkkiTulkinta = "{toistetaan edellistä merkkiä 1-n kertaa, ahne versio}";
    private String hakasulkuTulkinta = "[yksi seuraavista:";
    private String sulkuTulkinta = "{ryhmästä:";
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
    private String hakasulkuSelitys = "[] hakasulut tarkoittavat joukkoa josta valitaan yksi vaihtoehto";
    private String sulkuSelitys = "() sulut ryhmittelevät regex lauseita\n";

    /**
     * Metodi tulkitsee erkoismerkit ja kutsuu sitä vastaavaa metodia
     *
     * @param tutkittava tutkittava teksti
     * @param indeksi missä kohtaa stringTaulukkoa mennään kun törmättiin
     * merkkiin.
     */
    public void tulkitseErikoismerkki(String tutkittava, int indeksi) {
        if (tutkittava.equals("\\")) {
            if (tutkiBacklash() == true) {
                lisataankoBacklashKaytetytRegularExpressionMerkkeihin();
            }


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
        if (tutkittava.equals("[")) {
            lisataankoHakasulkuMerkkiKaytetytRegularExpressionMerkkeihin();
            tutkiHakasulkuMerkki();

        }
        if (tutkittava.equals("(")) {
            lisataankoSulkumerkkiKaytetytRegularExpressionMerkkeihin();
            tutkiSulkumerkki();

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
                lisaaMerkkiSellaisenaanJaKasvataIndeksia(tutkittava, 1);
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
        if (KasitteleStringi.isLisataankoPiste() == true) {
            KasitteleStringi.lisaakaytetytRegularExpressionMerkkeihin(pisteSelitys);
            KasitteleStringi.setLisataankoPiste(false);
        }
    }

    /**
     * Metodi tutkii onko dollari jo lisätty käytettyihin regexeihin. Jos ei ole
     * niin lisätään ja merkitään lisätyksi.
     */
    public void lisataankoDollariKaytetytRegularExpressionMerkkeihin() {
        if (KasitteleStringi.isLisataankoDollari() == true) {
            KasitteleStringi.lisaakaytetytRegularExpressionMerkkeihin(dollariSelitys);
            KasitteleStringi.setLisataankoDollari(false);
        }
    }

    /**
     * Metodi tutkii onko kenoviiva jo lisätty käytettyihin regexeihin. Jos ei
     * ole niin lisätään ja merkitään lisätyksi.
     */
    public void lisataankoBacklashKaytetytRegularExpressionMerkkeihin() {
        if (KasitteleStringi.isLisataankoBacklash() == true) {
            KasitteleStringi.lisaakaytetytRegularExpressionMerkkeihin(backlashSelitys);
            KasitteleStringi.setLisataankoBacklash(false);
        }
    }

    /**
     * Metodi tutkii onko tai-merkki jo lisätty käytettyihin regexeihin. Jos ei
     * ole niin lisätään ja merkitään lisätyksi.
     */
    public void lisataankoTaiMerkkiKaytetytRegularExpressionMerkkeihin() {
        if (KasitteleStringi.isLisataankoTaiMerkki() == true) {
            KasitteleStringi.lisaakaytetytRegularExpressionMerkkeihin(taiSelitys);
            KasitteleStringi.setLisataankoTaiMerkki(false);
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
            if (KasitteleStringi.isLisataankoKysymysmerkki() == true) {
                KasitteleStringi.lisaakaytetytRegularExpressionMerkkeihin(kysymysmerkkiSelitys);
                KasitteleStringi.setLisataankoKysymysmerkki(false);
            }
        }
        if (kaksiKysymysmerkkia == true) {
            if (KasitteleStringi.isLisataankoKysymysmerkkiKysymysmerkki() == true) {
                KasitteleStringi.lisaakaytetytRegularExpressionMerkkeihin(kysymysmerkkiKysymysmerkkiSelitys);
                KasitteleStringi.setLisataankoKysymysmerkkiKysymysmerkki(false);
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
            if (KasitteleStringi.isLisataankoTahti() == true) {
                KasitteleStringi.lisaakaytetytRegularExpressionMerkkeihin(tahtiSelitys);
                KasitteleStringi.setLisataankoTahtiKysymysmerkki(false);
            }
        }
        if (tahtiKysymysmerkki == true) {
            if (KasitteleStringi.isLisataankoTahtiKysymysmerkki() == true) {
                KasitteleStringi.lisaakaytetytRegularExpressionMerkkeihin(tahtiKysymysmerkkiSelitys);
                KasitteleStringi.setLisataankoTahtiKysymysmerkki(false);
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
            if (KasitteleStringi.isLisataankoPlusmerkki() == true) {
                KasitteleStringi.lisaakaytetytRegularExpressionMerkkeihin(plusSelitys);
                KasitteleStringi.setLisataankoPlusmerkki(false);
            }
        }
        if (PlusKysymysmerkki == true) {
            if (KasitteleStringi.isLisataankoPlusmerkkiKysymysmerkki() == true) {
                KasitteleStringi.lisaakaytetytRegularExpressionMerkkeihin(plusKysymysmerkkiSelitys);
                KasitteleStringi.setLisataankoPlusmerkkiKysymysmerkki(false);
            }
        }

    }

    /**
     * Metodi tutkii onko hattumerkki jo lisätty käytettyihin regexeihin. Jos ei
     * ole niin lisätään ja merkitään lisätyksi.
     */
    public void lisataankoCaretmerkkiKaytetytRegularExpressionMerkkeihin() {
        if (KasitteleStringi.isLisataankoCaret() == true) {
            KasitteleStringi.lisaakaytetytRegularExpressionMerkkeihin(caretSelitys);
            KasitteleStringi.setLisataankoCaret(false);
        }
    }
    
        /**
     * Metodi tutkii onko sulkumerkki jo lisätty käytettyihin regexeihin. Jos ei
     * ole niin lisätään ja merkitään lisätyksi.
     */
    public void lisataankoSulkumerkkiKaytetytRegularExpressionMerkkeihin() {
        if (KasitteleStringi.isLisataankoSulkumerkki() == true) {
            KasitteleStringi.lisaakaytetytRegularExpressionMerkkeihin(sulkuSelitys);
            KasitteleStringi.setLisataankoSulkumerkki(false);
        }
    }

    /**
     * Metodi tutkii onko hakasulkumerkki jo lisätty käytettyihin regexeihin.
     * Jos ei ole niin lisätään ja merkitään lisätyksi.
     */
    public void lisataankoHakasulkuMerkkiKaytetytRegularExpressionMerkkeihin() {
        if (KasitteleStringi.isLisataankoHakasulkumerkki() == true) {
            KasitteleStringi.lisaakaytetytRegularExpressionMerkkeihin(hakasulkuSelitys);
            KasitteleStringi.setLisataankoCaret(false);
        }
    }

    /**
     * Metodi lisää pistettä vastaavan tulkinnan tulkinnatTaulukkoon nimiseen
     * stringTaulukkoon. Samalla metodi kasvatta tutkittavaa kohtaa yhdellä
     */
    public void tutkiPiste() {
        lisaaMerkkiSellaisenaanJaKasvataIndeksia(pisteTulkinta, 1);
    }

    /**
     * Metodi lisää dollaria vastaavan tulkinnan tulkinnatTaulukkoon nimiseen
     * stringTaulukkoon. Samalla metodi kasvatta tutkittavaa kohtaa yhdellä
     */
    public void tutkiDollari() {
        lisaaMerkkiSellaisenaanJaKasvataIndeksia(dollariTulkinta, 1);
    }
        /**
     * Metodi lisää sulkumerkin vastaavan tulkinnan tulkinnatTaulukkoon nimiseen
     * stringTaulukkoon. Samalla metodi kasvatta tutkittavaa kohtaa yhdellä
     */
    public void tutkiSulkumerkki() {
        lisaaMerkkiSellaisenaanJaKasvataIndeksia(sulkuTulkinta, 1);
    }

    /**
     * Metodi käsittelee kenoviivaa. Jos se on viimeinen merkki se tulkitaan
     * kirjaimellisesti ja lisätään sellaisenaan. Jos sen jälkeen on
     * erikoismerkki, vain erikoismerkki lisätään sellaisenaan, ei kenoviivaa
     * Jos kenoviivan jälkeen on kirjain, etsitään kenoviiva-kirjainyhditelmälle
     * tulkinta. Jos tulkintaa ei ole tulkitaan kenoviiva-kirjain
     * kirjaimellisesti.
     */
    public boolean tutkiBacklash() {
        String seuraavaMerkki = stringTaulukko.annaTaulukonAlkionArvo((stringTaulukko.getTutkittavaIndeksi() + 1));
        if (seuraavaMerkki.equals("false")) {
            lisaaMerkkiSellaisenaanJaKasvataIndeksia(stringTaulukko.annaTaulukonAlkionArvo(stringTaulukko.getTutkittavaIndeksi()), 1);
            return false;
        }
        if (onkoErikoismerkki(seuraavaMerkki)) {
            lisaaMerkkiSellaisenaanJaKasvataIndeksia(seuraavaMerkki, 2);
            return true;
        }


        String tulkinta = BacklashTulkinta.tutkiBacklash(seuraavaMerkki);
        if (tulkinta.equals("false")) {
            lisaaMerkkiSellaisenaanJaKasvataIndeksia(stringTaulukko.annaTaulukonAlkionArvo((stringTaulukko.getTutkittavaIndeksi())), 1);
            return false;
        }
        lisaaMerkkiSellaisenaanJaKasvataIndeksia(tulkinta, 2);
        return false;

    }

    /**
     * metodi lisää merkin tulkintoihin ja kasvattaa tutkittavaa indeksiä
     * yhdellä
     *
     * @param seuraavaMerkki lisattava merkki
     *
     */
    public void lisaaMerkkiSellaisenaanJaKasvataIndeksia(String seuraavaMerkki, int paljonkoKasvatetaan) {
        tulkinnatTaulukkoon.lisaaStringKokonaisenaTaulukkoon(seuraavaMerkki);
        stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + paljonkoKasvatetaan);
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
            lisaaMerkkiSellaisenaanJaKasvataIndeksia(tahtiKysymysmerkkiTulkinta, 2);
            return true;
        }
        lisaaMerkkiSellaisenaanJaKasvataIndeksia(tahtiTulkinta, 1);
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
            lisaaMerkkiSellaisenaanJaKasvataIndeksia(plusKysymysmerkkiTulkinta, 2);
            return true;
        }
        lisaaMerkkiSellaisenaanJaKasvataIndeksia(plusTulkinta, 1);
        return false;
    }

    /**
     * Metodi lisää tai-merkkiä vastaavan tulkinnan tulkinnatTaulukkoon nimiseen
     * stringTaulukkoon. Samalla metodi kasvatta tutkittavaa kohtaa yhdellä.
     */
    public void tutkiTaiMerkki() {
        lisaaMerkkiSellaisenaanJaKasvataIndeksia(taiTulkinta, 1);
    }

    /**
     * Metodi lisää hakasulku-merkkiä vastaavan tulkinnan omassa oliossa ja
     * lisää tulkinnat tulkinnatTaulukkoon nimiseen stringTaulukkoon. Samalla
     * metodi kasvatta tutkittavaa kohtaa siihen kohtaan missä on
     * sulkevahakasulku+1.
     */
    public void tutkiHakasulkuMerkki() {
        lisaaMerkkiSellaisenaanJaKasvataIndeksia(hakasulkuTulkinta, 1);

        HakasulkuParseri hakasulkuParseri = new HakasulkuParseri(stringTaulukko, tulkinnatTaulukkoon);
        hakasulkuParseri.kayLapiStringTaulukko();
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
            lisaaMerkkiSellaisenaanJaKasvataIndeksia(kysymysmerkkiKysymysmerkkiTulkinta, 2);
            return true;
        }
        lisaaMerkkiSellaisenaanJaKasvataIndeksia(kysymysmerkkiTulkinta, 1);
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
        lisaaMerkkiSellaisenaanJaKasvataIndeksia(caretTulkinta, 1);
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

    /**
     * Metodi palauttaa hakasulun selityksen
     */
    public String getHakasulkuSelitys() {
        return hakasulkuSelitys;
    }

    /**
     * Metodi palauttaa hakasulun tulkinnan
     */
    public String getHakasulkuTulkinta() {
        return hakasulkuTulkinta;
    }

     /**
     * Metodi palauttaa sulun selityksen
     */
    public String getSulkuSelitys() {
        return sulkuSelitys;
    }

     /**
     * Metodi palauttaa sulun tulkinnan
     */
    public String getSulkuTulkinta() {
        return sulkuTulkinta;
    }
    
    
}
