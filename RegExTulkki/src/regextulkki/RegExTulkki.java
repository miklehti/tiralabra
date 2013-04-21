package regextulkki;

import java.util.*;

/**
 *
 * @author lehtimik
 */
public class RegExTulkki {
    
    /**
     * Luokkamuuttuja jonne tallennetaan pilkotut string taulukota
     */

    private static StringTaulukkoTaulukko stringtaulukkotaulukko = new StringTaulukkoTaulukko();
    
     /**
     * Luokkamuuttuja jonne tallennetaan lopputuloksena syntyvät string taulukota
     */
    private static StringTaulukkoTaulukko lopputulokset = new StringTaulukkoTaulukko();

    /**
     * Mainmetodi
     *
     * @param args argumentit
     */
    public static void main(String[] args) {


        String vastaus = PopKysyIlmoita.kysyString("Anna säännöllinen lause");
        KasitteleStringi kasitteleStringi;
        kasitteleStringi = new KasitteleStringi(vastaus);

        PopKysyIlmoita.ilmoita(kasitteleStringi.getTulkinnatTaulukkoon().toString());
        PopKysyIlmoita.ilmoita(kasitteleStringi.getKaytetytRegularExpressionMerkit().toString());

        stringtaulukkotaulukko = new StringTaulukkoTaulukko();
        StringTaulukko tulkinnat = kasitteleStringi.getTulkinnatTaulukkoon();
        annaEsimerkkisanat(tulkinnat);
        stringtaulukkotaulukkoTulostettavaanMuotoon();
       
        PopKysyIlmoita.ilmoita(lopputulokset.toString());

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
                taso = taso - 1;

                continue;
            }
            lisattava.lisaaStringKokonaisenaTaulukkoon(tutkittava);



        }
        if (lisattava.getAlkioidenLKM() > 0) {
            stringtaulukkotaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(lisattava);
        }

        //  stringtaulukkotaulukko.toString();
    }

    /**
     * Metodi ottaa syötteenäään stringtaulukon ja tutkii onko seuraava
     * käsiteltävä merkki kysymysmerkki
     *
     * @return boolean tulos
     * @param tulkinnat tutkittava syöte
     * @param i käsiteltävä indeksi
     */
    public static boolean onkoSeuraavaMerkkiKysymysmerkki(StringTaulukko tulkinnat, int i) {
        if (tulkinnat.annaTaulukonAlkionArvo(i + 1).equals("{edelllä oleva termi{t} ovat vapaaehtoisia, ahne versio}")) {
            return true;
        }
        return false;
    }

    /**
     * Metodi ottaa syötteenäään stringtaulukon, onko kyseessä kysymysmerkki ja
     * tason jossa liikutaan
     *
     * @param boolean lisattava Stringtaulukko
     * @param onkoKysymysmerkkiKunLisataan mikä merkki lisätään
     * @param taso millä tasolla liikutaan
     */
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

    /**
     * metodi tulostaa stringtaulukkotaulukkon
     */
    public static void stringtaulukkotaulukkoTulostettavaanMuotoon() {
        int[] tasot = poistaTasotIntArrayn();
        sulautaYlemmatTasotAlempiin(tasot);
        
//        lopputulokset.toString();
    }
    
      /**
     * metodi poistaa stringin perässä olevat "taso2"-kommentit int arrayseen
     * @return tasot palauttaa int[] jossa on kaikki stringtaulukot tasoittain
     */

    public static int[] poistaTasotIntArrayn() {
        int[] tasot = new int[stringtaulukkotaulukko.getAlkioidenLKM()];
        for (int i = 0; i < stringtaulukkotaulukko.getAlkioidenLKM(); i++) {
            StringTaulukko tutkittava = stringtaulukkotaulukko.annaTaulukonAlkionArvo(i);
            String taso = tutkittava.annaTaulukonAlkionArvo(tutkittava.getAlkioidenLKM() - 1);
            tutkittava.poistaMerkkejaTaulukosta(tutkittava.getAlkioidenLKM() - 1, 1);
            int lisattavaTaso = Integer.parseInt(taso.substring(taso.length() - 1, taso.length()));
            tasot[i] = lisattavaTaso;
        }
        //tulostaIntArray(tasot);
        return tasot;

    }
    
//       /**
//     * metodi tulostaa int arrrayn
//     * @param array tulostaa int arrayn
//     */
//
//    public static void tulostaIntArray(int[] array) {
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }
//    }
    
       /**
     * metodi tutkii onko seuraavan sanan taso sama, alempi vai ylempi
     * @return 0 seuraavan sanan taso on sama
     * @return 1 seuraavan sanan taso on pienempi
     * @return -1 seuraavan sanan taso on suurempi
     */

    public static int mikaOnSeuraavaTaso(int[] tasot, int i) {
        if(i==tasot.length-1){
            return -1;
        }
        if (tasot[i] < tasot[i + 1]) {
            return 1;
        }
        if (tasot[i] > tasot[i + 1]) {
            return -1;
        }

        return 0;

    }
    

      /**
     * metodi etsii sulautettavia sanoja ja kun löytyy kutsuu yhdistaYlemmanTasonSanaAlempiin-metodia
     * @param tasot taulukko seuraavien sanojen tasoista
     */

    public static void sulautaYlemmatTasotAlempiin(int[] tasot) {
        for (int i = 0; i < stringtaulukkotaulukko.getAlkioidenLKM()-1; i++) {
            int seuraavaTaso = mikaOnSeuraavaTaso(tasot, i);
            if(seuraavaTaso>0){
                int missaMennaan = yhdistaYlemmanTasonSanaAlempiin(tasot, i);
                i = missaMennaan;
            }
        }
    }
    
      /**
     * metodi sulauttaa sulkujen sisällä oleviin sanoihin sulun ulkona olevan sanan
     * @param tasot taulukko seuraavien sanojen tasoista
     * @param i indeksi missä mennään
     */
    
    public static int yhdistaYlemmanTasonSanaAlempiin(int[] tasot, int i){
        int j = i;
        String muistissa = "";
        do{
           
          
            StringTaulukko tutkittva = stringtaulukkotaulukko.annaTaulukonAlkionArvo(i); 
            String tutkittavaSana = tutkittva.annaStringKokonaisenaTaulukosta(); //reg
            StringTaulukko lisattava = stringtaulukkotaulukko.annaTaulukonAlkionArvo(j+1);
            String yhdistettySana = muistissa +tutkittavaSana + lisattava.annaStringKokonaisenaTaulukosta();
            StringTaulukko lopputulos = new StringTaulukko();
            lopputulos.lisaaStringKokonaisenaTaulukkoon(yhdistettySana);
            lopputulokset.lisaaStringTaulukkoKokonaisenaTaulukkoon(lopputulos);
            j = j+1;
              if(mikaOnSeuraavaTaso(tasot, j)>0){
                  i= j;
              muistissa = muistissa + tutkittavaSana;
            }
        }while (mikaOnSeuraavaTaso(tasot, j)>=0);
        return j;
    }
}
