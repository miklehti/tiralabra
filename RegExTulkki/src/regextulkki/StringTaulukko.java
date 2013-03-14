/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package regextulkki;

/**
 *
 * @author lehtimik
 */
public class StringTaulukko {

    private String[] taulukko = new String[10];
    private int alkioidenLKM;

    public StringTaulukko() {
        alkioidenLKM = 0;
    }

    private void kopioiTaulukko(String[] aputaulukko) {
        for (int i = 0; i < taulukko.length; i++) {
            aputaulukko[i] = taulukko[i];
        }

    }

    public void tuplaaTaulukonKoko() {
        int koko = taulukko.length;
        koko = koko * 2;
        String[] apuTaulukko = new String[koko];

        kopioiTaulukko(apuTaulukko);

        taulukko = apuTaulukko;

    }

    public void lisaaStringTaulukkoon(String lisattava) {

        for (int i = 0; i < lisattava.length(); i++) {
            if (alkioidenLKM == taulukko.length) {
                tuplaaTaulukonKoko();
            }
            taulukko[alkioidenLKM] = lisattava.substring(i, i + 1);
            alkioidenLKM = alkioidenLKM + 1;
        }

    }
    
    public boolean poistaMerkkejaTaulukosta(int aloitusIndeksi, int montakoPoistetaan){
        if(montakoPoistetaan>alkioidenLKM){
            return false;
        }
        String[] aputaulukko = new String[taulukko.length];
        for (int i = 0; i<aloitusIndeksi;i++){
            aputaulukko[i]=taulukko[i];
        }
        for (int j = aloitusIndeksi+montakoPoistetaan;j<alkioidenLKM;j++){
             aputaulukko[j]=taulukko[j];
        }
        taulukko = aputaulukko;
        alkioidenLKM  =alkioidenLKM-montakoPoistetaan;
        return true;
    }

    public String annaTaulukonAlkionArvo(int taulukonIndeksi) {
        return taulukko[taulukonIndeksi];
    }

    public String toString() {
        String tulostettava = "";
        for (int i = 0; i < alkioidenLKM; i++) {
            tulostettava = tulostettava + taulukko[i];
        }
        return tulostettava;
    }

    public String[] getTaulukko() {
        return taulukko;
    }

    public int getAlkioidenLKM() {
        return alkioidenLKM;
    }

    public void setAlkioidenLKM(int alkioidenLKM) {
        this.alkioidenLKM = alkioidenLKM;
    }

    public void setTaulukko(String[] taulukko) {
        this.taulukko = taulukko;
    }
}
