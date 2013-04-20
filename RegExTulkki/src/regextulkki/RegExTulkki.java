package regextulkki;

import java.util.*;

/**
 *
 * @author lehtimik
 */
public class RegExTulkki {

    private static StringTaulukkoTaulukko stringtaulukkotaulukko = new StringTaulukkoTaulukko();

    /**
     * Mainmetodi
     *
     * @param args argumentit
     */
    public static void main(String[] args) {


        String vastaus = PopKysyIlmoita.kysyString("Anna säännöllinen lause");
        KasitteleStringi kasitteleStringi;
        kasitteleStringi = new KasitteleStringi(vastaus);

//        PopKysyIlmoita.ilmoita(kasitteleStringi.getTulkinnatTaulukkoon().toString());
//        PopKysyIlmoita.ilmoita(kasitteleStringi.getKaytetytRegularExpressionMerkit().toString());

        stringtaulukkotaulukko = new StringTaulukkoTaulukko();
        StringTaulukko tulkinnat = kasitteleStringi.getTulkinnatTaulukkoon();
        annaEsimerkkisanat(tulkinnat);


    }

    /**
     * Metodi ottaa syötteenäään stringtaulukon ja purkaa sen pinomaisesti eri
     * tasoihin
     *
     * @param tulkinnat tutkittava syöte
     */
    public static void annaEsimerkkisanat(StringTaulukko tulkinnat) {
        String tutkittava;
        int taso = 0;
        StringTaulukko lisattava = new StringTaulukko();
        for (int i = 0; i < tulkinnat.getAlkioidenLKM(); i++) {
            tutkittava = tulkinnat.annaTaulukonAlkionArvo(i);

            if (tutkittava.equals("{ryhmästä:")) {

                lisaaStringTaulukkoTaulukkoon(lisattava, false, taso);

                tutkittava = "";
                lisattava = new StringTaulukko();
                taso = taso + 1;
                continue;
            }
            if (tutkittava.equals("{edelllä oleva termi{t} ovat vapaaehtoisia, ahne versio}")) {
                lisaaStringTaulukkoTaulukkoon(lisattava, true, taso);
                tutkittava = "";
                lisattava = new StringTaulukko();
                continue;
            }
            if (tutkittava.equals("{tai}")) {
                lisaaStringTaulukkoTaulukkoon(lisattava, false, taso);
                tutkittava = "";
                lisattava = new StringTaulukko();
                continue;
            }
            if (tutkittava.equals(")")) {
                lisaaStringTaulukkoTaulukkoon(lisattava, false, taso);
                if (onkoSeuraavaMerkkiKysymysmerkki(tulkinnat, i)) {
                    String lisattvaTaso = "taso" + taso;
                    StringTaulukko tyhja = new StringTaulukko();
                    tyhja.lisaaStringKokonaisenaTaulukkoon(lisattvaTaso);
                    stringtaulukkotaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(tyhja);
                    i = i + 1;
                }
                tutkittava = "";
                lisattava = new StringTaulukko();
                taso=taso-1;

                continue;
            }
            lisattava.lisaaStringKokonaisenaTaulukkoon(tutkittava);



        }
        if (lisattava.getAlkioidenLKM() > 0) {
            stringtaulukkotaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(lisattava);
        }

        stringtaulukkotaulukko.toString();
    }

    public static boolean onkoSeuraavaMerkkiKysymysmerkki(StringTaulukko tulkinnat, int i) {
        if (tulkinnat.annaTaulukonAlkionArvo(i + 1).equals("{edelllä oleva termi{t} ovat vapaaehtoisia, ahne versio}")) {
            return true;
        }
        return false;
    }

    public static void lisaaStringTaulukkoTaulukkoon(StringTaulukko lisattava, boolean onkoKysymysmerkkiKunLisataan, int taso) {

        if (onkoKysymysmerkkiKunLisataan == true) {
            //kopioidaan lisattava toiseen Stringtaulukkoon
            StringTaulukko toinenLisattava = new StringTaulukko();
            String lisays = "";
            for (int i = 0; i < lisattava.getAlkioidenLKM(); i++) {
                lisays = lisays + lisattava.annaTaulukonAlkionArvo(i);
            }
            toinenLisattava.pilkoStringTaulukkoon(lisays);
            toinenLisattava.poistaMerkkejaTaulukosta(lisattava.getAlkioidenLKM() - 1, 1);

            String lisattvaTaso = "taso" + taso;
            lisattava.lisaaStringKokonaisenaTaulukkoon(lisattvaTaso);
            toinenLisattava.lisaaStringKokonaisenaTaulukkoon(lisattvaTaso);

            stringtaulukkotaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(lisattava);
            stringtaulukkotaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(toinenLisattava);

        }
        if (onkoKysymysmerkkiKunLisataan == false) {
            if (lisattava.getAlkioidenLKM() == 0) {
                return;
            }
            String lisattvaTaso = "taso" + taso;
            lisattava.lisaaStringKokonaisenaTaulukkoon(lisattvaTaso);
            stringtaulukkotaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(lisattava);
        }
    }

    /**
     * Metodi palauttaa StringTaulukkoTaulukon.
     *
     * @param args argumentit
     */
    public static StringTaulukkoTaulukko getStringtaulukkotaulukko() {
        return stringtaulukkotaulukko;
    }

    /**
     * metodi nollaa Stringtaulukkotaulukko
     */
    public static void nollaaStringtaulukkkotaulukko() {
        StringTaulukkoTaulukko uusi = new StringTaulukkoTaulukko();
        stringtaulukkotaulukko = uusi;
    }
}
