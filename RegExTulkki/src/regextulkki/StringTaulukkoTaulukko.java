/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package regextulkki;

/**
 *
 * @author lehtimik
 */
public class StringTaulukkoTaulukko {
      /**
     * stringtaulukko-taulukko jota sitten tarvittaessa kasvatetaan
     */
    private StringTaulukko[] taulukko = new StringTaulukko[10];
    
    /**
     * kuinka monta alkiota StringTaulukossa on
     */
    private int alkioidenLKM;
    
       /**
     * missä kohtaa StringTaululukkoa mennään tällä hetkellä kun tutkitaan
     */
    private int tutkittavaIndeksi;
    
      /**
     * Konstruktori uudelle stringtaulukolle.
     */
    public StringTaulukkoTaulukko() {
        alkioidenLKM = 0;
    }

    
          /**
     * Metodi palauttaa alkioiden lukumäärän
     *
     * @return StringTaulukko
     */
    public int getAlkioidenLKM() {
        return alkioidenLKM;
    }
    
        /**
     * Metodi palauttaa StringTaulukon
     *
     * @return StringTaulukko
     */

    public StringTaulukko[] getTaulukko() {
        return taulukko;
    }
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
     * Metodi kopioi luokan StringTaulukon tiedot aputaulukkoon
     *
     * @param aputaulukko taulukko johon kopioidaan luokan taulukon tiedot
     */
    private void kopioiTaulukko(StringTaulukko[] aputaulukko) {
        for (int i = 0; i < taulukko.length; i++) {
            aputaulukko[i] = taulukko[i];
        }

    }
    
        /**
     * Metodi tuplaa luokan StringTaulukon koon ja kopio vanhan taulukon tiedot sinne
     */
    public void tuplaaTaulukonKoko() {
        int koko = taulukko.length;
        koko = koko * 2;
        StringTaulukko[] apuTaulukko = new StringTaulukko[koko];

        kopioiTaulukko(apuTaulukko);

        taulukko = apuTaulukko;

    }
    
           /**
     * Metodi lisää stringtaulukon sellaisenaan taulukon alkioon, jos taulukko loppuu tuplataan taululkon koko ja kopioidaan vanhat sinne
     * @param lisattava lisattava stringi joka pilkotaan
     */

    public void lisaaStringTaulukkoKokonaisenaTaulukkoon(StringTaulukko lisattava) {
        tutkiTarviikoTuplataTaulukko();
        taulukko[alkioidenLKM] = lisattava;
        alkioidenLKM = alkioidenLKM + 1;
    }
    
    /**
     * Metodi palauttaa taulukon alkion arvon tietystä indeksistä
     *
     * @param aloitusIndeksi Käyttäjän antama aloitusindeksi
     * @return StringTaulukon alkio
     */
    public StringTaulukko annaTaulukonAlkionArvo(int taulukonIndeksi) {
        
        if(taulukonIndeksi>=alkioidenLKM | taulukonIndeksi<0){
            return null;
        }
        return taulukko[taulukonIndeksi];
    }
        
        /**
     * Metodi tutkii tarviiko taulukon kokoa tuplata

     *
     */

    public void tutkiTarviikoTuplataTaulukko() {
        if (alkioidenLKM == taulukko.length) {
            tuplaaTaulukonKoko();
        }
    }
    

    
           /**
     * toStringTulostukseen

     *
     */

    @Override
    public String toString() {
        
         String[] tulokset = new String[alkioidenLKM];
         String tulos = "";
        for(int i = 0; i <alkioidenLKM;i++){
            StringTaulukko tulostettava = annaTaulukonAlkionArvo(i);
            String tutkittava = tulostettava.toString();
            if(loytyykoTulosjo(tutkittava, tulokset)==false){
            tulos = tulostettava.toString();
            tulokset[i]=tulos;
            }
        }
        String lopputulos = tulostaArray(tulokset);
        
         return lopputulos;
    }
    
              /**
     * toStringTulostukseen

     *
     */
    public boolean loytyykoTulosjo(String tulos, String[] tulokset){
        for(int i = 0; i <tulokset.length;i++){        
            if(tulokset[i]==null){
                continue;
            }
            if(tulokset[i].equals(tulos)){
                return true;
            }
        }
        return false;
    }
    
                /**
     * toStringTulostukseen

     *
     */
    public String tulostaArray(String[] array){
        String tulos = "";
        for(int i = 0; i<array.length;i++){
            if(array[i]==null){
                continue;
            }
            tulos = tulos + array[i] + "\n";
        }
        return tulos;
    }
    
}
