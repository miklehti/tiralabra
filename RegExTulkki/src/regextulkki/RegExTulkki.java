/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package regextulkki;

/**
 *
 * @author lehtimik
 */
public class RegExTulkki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String vastaus = Pop.askString("Anna säännöllinen lause");
        Pop.ilmoita(vastaus);
    }
}
