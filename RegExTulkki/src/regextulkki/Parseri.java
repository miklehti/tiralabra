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
    
    StringTaulukko stringTaulukko;
    
    public Parseri(StringTaulukko stringTaulukko){
        this.stringTaulukko = stringTaulukko;
    }
    public void kayLapiStringTaulukko(){
    for (int i = 0; i<stringTaulukko.getAlkioidenLKM()){
        String tutkittava = stringTaulukko.annaTaulukonAlkionArvo(i);
        
    }
}

    public StringTaulukko getStringTaulukko() {
        return stringTaulukko;
    }
    
}
