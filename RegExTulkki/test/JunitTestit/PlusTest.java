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
public class PlusTest {
        Parseri parseri;
    StringTaulukko stringtaulukko;

    public PlusTest() {
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
    public void pelkkaPlus() {
        stringtaulukko.pilkoStringTaulukkoon("+");
        parseri.kayLapiStringTaulukko();
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getPlusTulkinta());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getPlusSelitys());
        assertEquals(1, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
    @Test
    public void pelkkaPlusmerkkiKysymysmerkki() {
        stringtaulukko.pilkoStringTaulukkoon("+?");
        parseri.kayLapiStringTaulukko();
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getPlusKysymysmerkkiTulkinta());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getPlusKysymysmerkkiSelitys());
        assertEquals(1, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    @Test
    public void plusJaerikoismerkki() {
        stringtaulukko.pilkoStringTaulukkoon("+*");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0),parseri.getPlusTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1),parseri.getTahtiTulkinta());
        
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getPlusSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getTahtiSelitys());
        
        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
        @Test
    public void plusKysymysmerkkiJaerikoismerkki() {
        stringtaulukko.pilkoStringTaulukkoon("+?*");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0),parseri.getPlusKysymysmerkkiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1),parseri.getTahtiTulkinta());
        
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getPlusKysymysmerkkiSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getTahtiSelitys());
        
        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    
    @Test
    public void plusJastringi() {
        stringtaulukko.pilkoStringTaulukkoon("+a");
        parseri.kayLapiStringTaulukko();
        
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getPlusTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), "a");
        
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getPlusSelitys());
         assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1),"false");
        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
        
    }
    
        @Test
    public void plusKysymysmerkkiJastringi() {
        stringtaulukko.pilkoStringTaulukkoon("+?a");
        parseri.kayLapiStringTaulukko();
        
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getPlusKysymysmerkkiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), "a");
        
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getPlusKysymysmerkkiSelitys());
         assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1),"false");
        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
        
    }

    @Test
    public void plusJaErikoismerkkiErikoismerkki() {
        stringtaulukko.pilkoStringTaulukkoon("+|?");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getPlusTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), parseri.getTaiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2), parseri.getKysymysmerkkiTulkinta());
        
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getPlusSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getTaiSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(2), parseri.getKysymysmerkkiSelitys());

        assertEquals(3, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(3, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
        @Test
    public void plusKysymysmerkkiJaErikoismerkkiErikoismerkki() {
        stringtaulukko.pilkoStringTaulukkoon("+?+?");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getPlusKysymysmerkkiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), parseri.getPlusKysymysmerkkiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2), "false");
        
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getPlusKysymysmerkkiSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), "false");
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(2), "false");

        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    @Test
    public void merkkiErikoismerkkiPlus() {
        stringtaulukko.pilkoStringTaulukkoon("a|+");
        parseri.kayLapiStringTaulukko();
        
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "a");
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), parseri.getTaiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2), parseri.getPlusTulkinta());

        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTaiSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getPlusSelitys());
        
        
        assertEquals(3, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
    
        @Test
    public void merkkiErikoismerkkiPlusKysymysmerkki() {
        stringtaulukko.pilkoStringTaulukkoon("a|+?");
        parseri.kayLapiStringTaulukko();
        
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "a");
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), parseri.getTaiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2), parseri.getPlusKysymysmerkkiTulkinta());

        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTaiSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getPlusKysymysmerkkiSelitys());
        
        
        assertEquals(3, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
    
        @Test
    public void merkkiMerkkiPlus() {
        stringtaulukko.pilkoStringTaulukkoon("aa+");
        parseri.kayLapiStringTaulukko();
        
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "a");
         assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), "a");
         assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2),parseri.getPlusTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(3),"false");

        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getPlusSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), "false");

        assertEquals(3, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
        
                @Test
    public void merkkiMerkkiPlusKysymysmerkki() {
        stringtaulukko.pilkoStringTaulukkoon("aa+?");
        parseri.kayLapiStringTaulukko();
        
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "a");
         assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), "a");
         assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2),parseri.getPlusKysymysmerkkiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(3),"false");

        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getPlusKysymysmerkkiSelitys());
        assertEquals(parseri.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), "false");

        assertEquals(3, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
}
