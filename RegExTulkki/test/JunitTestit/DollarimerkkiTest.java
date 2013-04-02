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
 *
 * @author lehtimik
 */
public class DollarimerkkiTest {
    
        Parseri parseri;
    StringTaulukko stringtaulukko;

    public DollarimerkkiTest() {
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
    public void pelkkaDollari() {
        stringtaulukko.pilkoStringTaulukkoon("$");
        parseri.kayLapiStringTaulukko();
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getDollariTulkinta());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getDollariSelitys());
        assertEquals(1, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    @Test
    public void dollariJaerikoismerkki() {
        stringtaulukko.pilkoStringTaulukkoon("$+");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0),parseri.getDollariTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1),parseri.getPlusTulkinta());
        
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getDollariSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getPlusSelitys());
        
        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    
    @Test
    public void dollariJastringi() {
        stringtaulukko.pilkoStringTaulukkoon("$a");
        parseri.kayLapiStringTaulukko();
        
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getDollariTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), "a");
        
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getDollariSelitys());
         assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1),"false");
        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
        
    }

    @Test
    public void dollariJaErikoismerkkiErikoismerkki() {
        stringtaulukko.pilkoStringTaulukkoon("$+?");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getDollariTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), parseri.getPlusKysymysmerkkiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2), "false");
        
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getDollariSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getPlusKysymysmerkkiSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(2), "false");

        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    @Test
    public void merkkiErikoismerkkiDollari() {
        stringtaulukko.pilkoStringTaulukkoon("a?$");
        parseri.kayLapiStringTaulukko();
        
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "a");
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), parseri.getKysymysmerkkiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2), parseri.getDollariTulkinta());

        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getKysymysmerkkiSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getDollariSelitys());
        
        
        assertEquals(3, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
    
        @Test
    public void merkkiMerkkiDollari() {
        stringtaulukko.pilkoStringTaulukkoon("aa$");
        parseri.kayLapiStringTaulukko();
        
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "a");
         assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), "a");
         assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2),parseri.getDollariTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(3),"false");

        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getDollariSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), "false");

        assertEquals(3, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
}
