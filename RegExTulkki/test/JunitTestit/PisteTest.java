/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JunitTestit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import regextulkki.Parseri;
import regextulkki.StringTaulukko;

/**
 * @author lehtimik
 */
public class PisteTest {
        Parseri parseri;
    StringTaulukko stringtaulukko;

    public PisteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        stringtaulukko = new StringTaulukko();
        parseri = new Parseri(stringtaulukko);
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void pelkkaPiste() {
        stringtaulukko.pilkoStringTaulukkoon(".");
        parseri.kayLapiStringTaulukko();
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getPisteTulkinta());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getPisteSelitys());
        assertEquals(1, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    @Test
    public void pisteJaerikoismerkki() {
        stringtaulukko.pilkoStringTaulukkoon(".+");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0),parseri.getPisteTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1),parseri.getPlusTulkinta());
        
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getPisteSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getPlusSelitys());
        
        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    
    @Test
    public void pisteJastringi() {
        stringtaulukko.pilkoStringTaulukkoon(".a");
        parseri.kayLapiStringTaulukko();
        
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getPisteTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), "a");
        
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getPisteSelitys());
         assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1),"false");
        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
        
    }

    @Test
    public void pisteJaErikoismerkkiErikoismerkki() {
        stringtaulukko.pilkoStringTaulukkoon(".+?");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getPisteTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), parseri.getPlusKysymysmerkkiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2), "false");
        
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getPisteSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getPlusKysymysmerkkiSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(2), "false");

        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    @Test
    public void merkkiErikoismerkkiPiste() {
        stringtaulukko.pilkoStringTaulukkoon("a?.");
        parseri.kayLapiStringTaulukko();
        
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "a");
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), parseri.getKysymysmerkkiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2), parseri.getPisteTulkinta());

        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getKysymysmerkkiSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getPisteSelitys());
        
        
        assertEquals(3, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
    
        @Test
    public void merkkiMerkkiPiste() {
        stringtaulukko.pilkoStringTaulukkoon("aa.");
        parseri.kayLapiStringTaulukko();
        
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "a");
         assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), "a");
         assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2),parseri.getPisteTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(3),"false");

        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getPisteSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), "false");

        assertEquals(3, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
}
