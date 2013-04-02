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
public class TahtiMerkkiTest {
        Parseri parseri;
    StringTaulukko stringtaulukko;

    public TahtiMerkkiTest() {
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
    public void pelkkaTahti() {
        stringtaulukko.pilkoStringTaulukkoon("*");
        parseri.kayLapiStringTaulukko();
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getTahtiTulkinta());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTahtiSelitys());
        assertEquals(1, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
    @Test
    public void pelkkaTahtimerkkiKysymysmerkki() {
        stringtaulukko.pilkoStringTaulukkoon("*?");
        parseri.kayLapiStringTaulukko();
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getTahtiKysymysmerkkiTulkinta());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTahtiKysymysmerkkiSelitys());
        assertEquals(1, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    @Test
    public void tahtiJaerikoismerkki() {
        stringtaulukko.pilkoStringTaulukkoon("*|");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0),parseri.getTahtiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1),parseri.getTaiTulkinta());
        
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTahtiSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getTaiSelitys());
        
        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
        @Test
    public void tahtiKysymysmerkkiJaerikoismerkki() {
        stringtaulukko.pilkoStringTaulukkoon("*?*");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0),parseri.getTahtiKysymysmerkkiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1),parseri.getTahtiTulkinta());
        
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTahtiKysymysmerkkiSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getTahtiSelitys());
        
        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    
    @Test
    public void tahtiJastringi() {
        stringtaulukko.pilkoStringTaulukkoon("*a");
        parseri.kayLapiStringTaulukko();
        
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getTahtiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), "a");
        
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTahtiSelitys());
         assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1),"false");
        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
        
    }
    
        @Test
    public void tahtiKysymysmerkkiJastringi() {
        stringtaulukko.pilkoStringTaulukkoon("*?a");
        parseri.kayLapiStringTaulukko();
        
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getTahtiKysymysmerkkiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), "a");
        
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTahtiKysymysmerkkiSelitys());
         assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1),"false");
        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
        
    }

    @Test
    public void tahtiJaErikoismerkkiErikoismerkki() {
        stringtaulukko.pilkoStringTaulukkoon("*|?");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getTahtiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), parseri.getTaiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2), parseri.getKysymysmerkkiTulkinta());
        
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTahtiSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getTaiSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(2), parseri.getKysymysmerkkiSelitys());

        assertEquals(3, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(3, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
        @Test
    public void tahtiKysymysmerkkiJaErikoismerkkiErikoismerkki() {
        stringtaulukko.pilkoStringTaulukkoon("*?+?");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getTahtiKysymysmerkkiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), parseri.getPlusKysymysmerkkiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2), "false");
        
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTahtiKysymysmerkkiSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1),  parseri.getPlusKysymysmerkkiSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(2), "false");

        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    @Test
    public void merkkiErikoismerkkiTahti() {
        stringtaulukko.pilkoStringTaulukkoon("a|*");
        parseri.kayLapiStringTaulukko();
        
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "a");
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), parseri.getTaiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2), parseri.getTahtiTulkinta());

        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTaiSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getTahtiSelitys());
        
        
        assertEquals(3, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
    
        @Test
    public void merkkiErikoismerkkiTahtiKysymysmerkki() {
        stringtaulukko.pilkoStringTaulukkoon("a|*?");
        parseri.kayLapiStringTaulukko();
        
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "a");
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), parseri.getTaiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2), parseri.getTahtiKysymysmerkkiTulkinta());

        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTaiSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getTahtiKysymysmerkkiSelitys());
        
        
        assertEquals(3, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
    
        @Test
    public void merkkiMerkkiTahti() {
        stringtaulukko.pilkoStringTaulukkoon("aa*");
        parseri.kayLapiStringTaulukko();
        
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "a");
         assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), "a");
         assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2),parseri.getTahtiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(3),"false");

        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTahtiSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), "false");

        assertEquals(3, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
        
                @Test
    public void merkkiMerkkiTahtiKysymysmerkki() {
        stringtaulukko.pilkoStringTaulukkoon("aa*?");
        parseri.kayLapiStringTaulukko();
        
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "a");
         assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), "a");
         assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2),parseri.getTahtiKysymysmerkkiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(3),"false");

        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTahtiKysymysmerkkiSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), "false");

        assertEquals(3, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
}
