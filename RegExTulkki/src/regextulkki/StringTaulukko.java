
package regextulkki;


public class StringTaulukko {

    /**
     * taulukko jota sitten tarvittaessa kasvatetaan
     */
    private String[] taulukko = new String[10];
    /**
     * kuinka monta alkiota taulukossa on
     */
    private int alkioidenLKM;
    /**
     * missä kohtaa taulukkoa mennään tällä hetkellä kun tutkitaan
     */
    private int tutkittavaIndeksi;

    /**
     * Metodi asettaa uuden arvon tutkittavaIndeksi
     *
     * @param tutkittavaIndeksi Käyttäjän antama indeksi
     */
    public void setTutkittavaIndeksi(int tutkittavaIndeksi) {
        this.tutkittavaIndeksi = tutkittavaIndeksi;
    }

    /**
     * Metodi palauttaa tutkittavaIndeksi arvon
     *
     * @return tutkittavaIndeksi arvo
     */
    public int getTutkittavaIndeksi() {
        return tutkittavaIndeksi;
    }

    /**
     * Konstruktori uudelle taulukolle.
     */
    public StringTaulukko() {
        alkioidenLKM = 0;
    }

    /**
     * Metodi kopioi luokan taulukon tiedot aputaulukkoon
     *
     * @param aputaulukko taulukko johon kopioidaan luokan taulukon tiedot
     */
    private void kopioiTaulukko(String[] aputaulukko) {
        for (int i = 0; i < taulukko.length; i++) {
            aputaulukko[i] = taulukko[i];
        }

    }

    /**
     * Metodi tuplaa luokan taulukon koon ja kopio vanhan taulukon tiedot sinne
     */
    public void tuplaaTaulukonKoko() {
        int koko = taulukko.length;
        koko = koko * 2;
        String[] apuTaulukko = new String[koko];

        kopioiTaulukko(apuTaulukko);

        taulukko = apuTaulukko;

    }

    /**
     * Metodi pilkkoo jokaisen kirjaimen omaan alkioon taulukossa, jos taulukko loppuu tuplataan taululkon koko ja kopioidaan vanhat sinne
     * @param lisattava lisattava stringi joka pilkotaan
     */
    public void pilkoStringTaulukkoon(String lisattava) {

        for (int i = 0; i < lisattava.length(); i++) {
            tutkiTarviikoTuplataTaulukko();
            taulukko[alkioidenLKM] = lisattava.substring(i, i + 1);
            alkioidenLKM = alkioidenLKM + 1;
        }

    }
    
       /**
     * Metodi lisää stringin sellaisenaan taulukon alkioon, jos taulukko loppuu tuplataan taululkon koko ja kopioidaan vanhat sinne
     * @param lisattava lisattava stringi joka pilkotaan
     */

    public void lisaaStringKokonaisenaTaulukkoon(String lisattava) {
        tutkiTarviikoTuplataTaulukko();
        taulukko[alkioidenLKM] = lisattava;
        alkioidenLKM = alkioidenLKM + 1;
    }

    /**
     * Metodi poistaa merkkejä taulukosta siirtämällä loppuja merkkejä alkuun
     * päin.
     *
     * @param aloitusIndeksi Käyttäjän antama aloitusindeksi
     * @param montakoPoistetaan Kuinka monta merkkiä poistetaan
     * @return onnistuiko poisto
     */
    public boolean poistaMerkkejaTaulukosta(int aloitusIndeksi, int montakoPoistetaan) {
        if (montakoPoistetaan > alkioidenLKM) {
            return false;
        }
        if (aloitusIndeksi < 0 | aloitusIndeksi > alkioidenLKM) {
            return false;
        }
        String[] aputaulukko = kopioiTaulukonAlkuUuteenTaulukkoon(aloitusIndeksi);
        kopioiPoistettavanJalkeisetAlkiotUuteenTaulukkoon(aloitusIndeksi, montakoPoistetaan, aputaulukko);
        taulukko = aputaulukko;
        alkioidenLKM = alkioidenLKM - montakoPoistetaan;
        return true;
    }

    /**
     * Metodi palauttaa taulukon alkion arvon tietystä indeksistä
     *
     * @param aloitusIndeksi Käyttäjän antama aloitusindeksi
     * @return StringTaulukon alkio
     */
    public String annaTaulukonAlkionArvo(int taulukonIndeksi) {
        return taulukko[taulukonIndeksi];
    }

    /**
     * toString() metodi tulostukseen
     *
     * @return tulostettava stringi
     */
    public String toString() {
        String tulostettava = "";
        for (int i = 0; i < alkioidenLKM; i++) {
            tulostettava = tulostettava + taulukko[i];
        }
        return tulostettava;
    }

    /**
     * Metodi palauttaa string taulukon
     *
     * @return String taulukko
     */
    public String[] getTaulukko() {
        return taulukko;
    }

    /**
     * Metodi palauttaa taulukon alkioiden lukumäärän
     *
     * @return alkioiden lukumäärä
     */
    public int getAlkioidenLKM() {
        return alkioidenLKM;
    }

    /**
     * Metodi asettaa alkioiden lukumäärän tietyksi
     *
     * @param alkioiden lukumäärä
     */
    public void setAlkioidenLKM(int alkioidenLKM) {
        this.alkioidenLKM = alkioidenLKM;
    }

    /**
     * Metodi asettaa taulukon tietyksi
     *
     * @param taulukko uusi taulukko
     */
    public void setTaulukko(String[] taulukko) {
        this.taulukko = taulukko;
    }

    /**
     * Metodi kopioi tiettyyn indeksiin asti taulukon uuteen taulukkoon
     *
     * @param lopetusIndeksi mihin kohtaan asti kopioidaan
     * @return aputaulukko jossa luokan taulukon alkuosa
     */
    public String[] kopioiTaulukonAlkuUuteenTaulukkoon(int lopetusIndeksi) {
        String[] aputaulukko = new String[taulukko.length];
        for (int i = 0; i < lopetusIndeksi; i++) {
            aputaulukko[i] = taulukko[i];
        }
        return aputaulukko;
    }

    /**
     * Metodi kopioi tiettystä indeksistä lähtien loput taulukosta
     *
     * @param aloitusIndeksi mihin kohdasta lähtien kopioidaan
     *
     */
    public void kopioiPoistettavanJalkeisetAlkiotUuteenTaulukkoon(int aloitusIndeksi, int montakoPoistetaan, String[] aputaulukko) {
        for (int j = aloitusIndeksi + montakoPoistetaan; j < alkioidenLKM; j++) {
            aputaulukko[j - montakoPoistetaan] = taulukko[j];
        }
    }

    public void tutkiTarviikoTuplataTaulukko() {
        if (alkioidenLKM == taulukko.length) {
            tuplaaTaulukonKoko();
        }
    }
}
