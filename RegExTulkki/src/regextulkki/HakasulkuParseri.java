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
     * erikoismerkit hakasulkujen sisällä
     */
    private String erikoismerkit = "^-\\]";

    /**
     * Konstruktori. Tarvitsee stringTaulukon.
     *
     * @param stringTaulukko stringTaulukko parsittavaksi.
     * @param tulkinnatTaulukkoon taulukko regex tulkinoille
     */
    public HakasulkuParseri(StringTaulukko stringTaulukko, StringTaulukko tulkinnatTaulukkoon) {
        this.stringTaulukko = stringTaulukko;
        this.tulkinnatTaulukkoon = tulkinnatTaulukkoon;

    }
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
            if (tutkiHakasulunBacklash() == true) {
                lisataankoHakasulunBacklashKaytetytRegularExpressionMerkkeihin();
            }

        }


        if (tutkittava.equals("-")) {

            if (tutkiViivaMerkki()) {
                lisataankoViivaMerkkiKaytetytRegularExpressionMerkkeihin();
            }

        }
        if (tutkittava.equals("^")) {

            if(tutkiHakasulkuCaretMerkki()){
                 lisataankoHakasulkuCaretmerkkiKaytetytRegularExpressionMerkkeihin();
            }
           
        }



    }

    /**
     * metodi lisää merkin tulkintoihin ja kasvattaa tutkittavaa indeksiä
     * yhdellä
     *
     * @param seuraavaMerkki lisattava merkki
     *@param paljonkoKasvatetaan kuinka paljon indeksiä siirretään eteenpäin
     */
    public void lisaaMerkkiSellaisenaanJaKasvataIndeksia(String seuraavaMerkki, int paljonkoKasvatetaan) {
        tulkinnatTaulukkoon.lisaaStringKokonaisenaTaulukkoon(seuraavaMerkki);
        stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + paljonkoKasvatetaan);
    }
    /*
     * Metodi lopettaa tutkimisen ja lisää hakasulun loppumerkinnän
     *
     */

    public void tutkiHakasulkuLoppuMerkki() {
        lisaaMerkkiSellaisenaanJaKasvataIndeksia("]", 1);
    }
    /*
     * Metodi tutkii onko hattumerkki heti [-merkin jälkeen, jos on niin negaatio, jos ei ole niin tulkitaan normaalina hattumerkkinä
     *
     */

    public boolean tutkiHakasulkuCaretMerkki() {
        if (onkoEdellinenmerkkiHakasulunAlkumerkki()) {
            lisaaMerkkiSellaisenaanJaKasvataIndeksia(caretHakasulkuTulkinta, 1);
            return true;
        }
        lisaaMerkkiSellaisenaanJaKasvataIndeksia("^", 1);
        return false;

    }


    /*
     * Metodi tutkii onko seuraava alkio erikoismerkki, jos on niin lisää sen
     * sellaisenaan tulkintaan. Tai jos se on muu kuin erikoismerkki metodi
     * palauttaa sen tulkinnan. Jos ei ole tulkintaa tai on viimeinen merkki tulkitaan kenoviiva kirjaimellisesti
     *
     * @return boolean arvo lisätäänkö backlash tulkinta regular expressioneihin
     */
    public boolean tutkiHakasulunBacklash() {
        String seuraavaMerkki = stringTaulukko.annaTaulukonAlkionArvo((stringTaulukko.getTutkittavaIndeksi() + 1));
        if (seuraavaMerkki.equals("]")) {
            lisaaMerkkiSellaisenaanJaKasvataIndeksia(stringTaulukko.annaTaulukonAlkionArvo((stringTaulukko.getTutkittavaIndeksi())), 1);
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
     * Metodi tutkii oliko edellelinen merkki hakasulun aukaisu
     *
     * @return oliko merkki [
     */
    public boolean onkoEdellinenmerkkiHakasulunAlkumerkki() {
        int edellinenIndeksi = stringTaulukko.getTutkittavaIndeksi() - 1;
        String edellinen = stringTaulukko.annaTaulukonAlkionArvo(edellinenIndeksi);
        if (edellinen.equals("[")) {
            return true;
        }
        return false;
    }

    /**
     * Metodi antaa tulkinnan viivamerkille, huom. jos eka merkki hakasuluissa
     * niin tulkitaan pelkkänä viivana, muuten alueena
     */
    public boolean tutkiViivaMerkki() {

        if (onkoEdellinenmerkkiHakasulunAlkumerkki()) {
            lisaaMerkkiSellaisenaanJaKasvataIndeksia("-", 1);
            return false;
        }
        lisaaMerkkiSellaisenaanJaKasvataIndeksia(viivaHakasulkuTulkinta, 1);
        return true;
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
     * Metodi käy läpi StringTaulukon ja tarkistaa onko tekstissä
     * erikoismerkkejä hakasulkujen sisällä.
     *
     */
    public void kayLapiStringTaulukko() {
        while (onkoAlkioitaVielaJaljella()) {
            String tutkittava = stringTaulukko.annaTaulukonAlkionArvo(stringTaulukko.getTutkittavaIndeksi());
            if (tutkittava.equals("]")) {
                tutkiHakasulkuLoppuMerkki();
                return;
            }
            if (onkoErikoismerkki(tutkittava) == true) {
                tulkitseErikoismerkki(tutkittava, stringTaulukko.getTutkittavaIndeksi());
            } else {
                tulkinnatTaulukkoon.lisaaStringKokonaisenaTaulukkoon(tutkittava);
                stringTaulukko.setTutkittavaIndeksi(stringTaulukko.getTutkittavaIndeksi() + 1);
            }
        }
    }
    
      /**
     * Metodi palauttaa hattumerkin selityksen
     */

    public String getCaretHakasulkuSelitys() {
        return caretHakasulkuSelitys;
    }

      /**
     * Metodi palauttaa hattumerkin tulkinnan
     */
    public String getCaretHakasulkuTulkinta() {
        return caretHakasulkuTulkinta;
    }  
    
      /**
     * Metodi palauttaa viivamerkin selityksen
     */
    public String getViivaHakasulkuSelitys() {
        return viivaHakasulkuSelitys;
    }

      /**
     * Metodi palauttaa viivan tulkinnan
     */
    public String getViivaHakasulkuTulkinta() {
        return viivaHakasulkuTulkinta;
    }

    
      /**
     * Metodi tutkii lisätäänkö viiva-merkki käytettyihin regular expression merkkeihin
     */
  
    public void lisataankoViivaMerkkiKaytetytRegularExpressionMerkkeihin() {
        if (KasitteleStringi.isLisataankoViivamerkki() == true) {
            KasitteleStringi.lisaakaytetytRegularExpressionMerkkeihin(viivaHakasulkuSelitys);
            KasitteleStringi.setLisataankoViivamerkki(false);
        }
    }

    /**
     * Metodi tutkii onko viiva-merkki jo lisätty käytettyihin regexeihin. Jos
     * ei ole niin lisätään ja merkitään lisätyksi.
     */
    public void lisataankoHakasulkuCaretmerkkiKaytetytRegularExpressionMerkkeihin() {
        if (KasitteleStringi.isLisataankoCaretHakasulkumerkki() == true) {
            KasitteleStringi.lisaakaytetytRegularExpressionMerkkeihin(caretHakasulkuSelitys);
            KasitteleStringi.setLisataankoCaretHakasulkumerkki(false);
        }
    }

    /**
     * Metodi tutkii onko kenoviiva jo lisätty käytettyihin regexeihin. Jos ei
     * ole niin lisätään ja merkitään lisätyksi.
     */
    public void lisataankoHakasulunBacklashKaytetytRegularExpressionMerkkeihin() {
        if (KasitteleStringi.isLisataankoBacklash() == true) {
            KasitteleStringi.lisaakaytetytRegularExpressionMerkkeihin(backlashSelitys);
            KasitteleStringi.setLisataankoBacklash(false);
        }
    }
}
