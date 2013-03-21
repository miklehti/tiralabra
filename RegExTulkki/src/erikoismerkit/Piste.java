/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erikoismerkit;

import regextulkki.StringTaulukko;

/**
 *
 * @author lehtimik
 */
public class Piste {
    public static void tutkiPiste(StringTaulukko stringtaulukko, StringTaulukko tulkinnat){
        stringtaulukko.setTutkittavaIndeksi(stringtaulukko.getTutkittavaIndeksi()+1);
        tulkinnat.lisaaStringKokonaisenaTaulukkoon("(mikä tahansa merkki)");
    }
}
