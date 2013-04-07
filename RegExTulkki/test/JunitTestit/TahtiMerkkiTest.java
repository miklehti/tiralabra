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
import regextulkki.KasitteleStringi;
import regextulkki.Parseri;
import regextulkki.StringTaulukko;

/**
 *
 * @author lehtimik
 */
public class TahtiMerkkiTest {
       Parseri parseri;
    StringTaulukko stringtaulukko;
    private StringTaulukko tulkinnatTaulukkoon;

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
        
    tulkinnatTaulukkoon = new StringTaulukko();
        stringtaulukko = new StringTaulukko();
        parseri = new Parseri(stringtaulukko, tulkinnatTaulukkoon);
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void pelkkaTahti() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("*");
        parseri.kayLapiStringTaulukko();
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getTahtiTulkinta());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTahtiSelitys());
        assertEquals(1, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
    @Test
    public void pelkkaTahtimerkkiKysymysmerkki() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("*?");
        parseri.kayLapiStringTaulukko();
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getTahtiKysymysmerkkiTulkinta());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTahtiKysymysmerkkiSelitys());
        assertEquals(1, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    @Test
    public void tahtiJaerikoismerkki() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("*|");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0),parseri.getTahtiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1),parseri.getTaiTulkinta());
        
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTahtiSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getTaiSelitys());
        
        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
        @Test
    public void tahtiKysymysmerkkiJaerikoismerkki() {
            KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("*?*");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0),parseri.getTahtiKysymysmerkkiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1),parseri.getTahtiTulkinta());
        
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTahtiKysymysmerkkiSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getTahtiSelitys());
        
        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    
    @Test
    public void tahtiJastringi() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("*a");
        parseri.kayLapiStringTaulukko();
        
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getTahtiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), "a");
        
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTahtiSelitys());
         assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1),"false");
        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
        
    }
    
        @Test
    public void tahtiKysymysmerkkiJastringi() {
            KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("*?a");
        parseri.kayLapiStringTaulukko();
        
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getTahtiKysymysmerkkiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), "a");
        
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTahtiKysymysmerkkiSelitys());
         assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1),"false");
        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
        
    }

    @Test
    public void tahtiJaErikoismerkkiErikoismerkki() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("*|?");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getTahtiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), parseri.getTaiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2), parseri.getKysymysmerkkiTulkinta());
        
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTahtiSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getTaiSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(2), parseri.getKysymysmerkkiSelitys());

        assertEquals(3, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(3, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
        @Test
    public void tahtiKysymysmerkkiJaErikoismerkkiErikoismerkki() {
            KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("*?+?");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getTahtiKysymysmerkkiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), parseri.getPlusKysymysmerkkiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2), "false");
        
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTahtiKysymysmerkkiSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1),  parseri.getPlusKysymysmerkkiSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(2), "false");

        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    @Test
    public void merkkiErikoismerkkiTahti() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("a|*");
        parseri.kayLapiStringTaulukko();
        
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "a");
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), parseri.getTaiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2), parseri.getTahtiTulkinta());

        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTaiSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getTahtiSelitys());
        
        
        assertEquals(3, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
    
        @Test
    public void merkkiErikoismerkkiTahtiKysymysmerkki() {
            KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("a|*?");
        parseri.kayLapiStringTaulukko();
        
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "a");
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), parseri.getTaiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2), parseri.getTahtiKysymysmerkkiTulkinta());

        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTaiSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getTahtiKysymysmerkkiSelitys());
        
        
        assertEquals(3, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
    
        @Test
    public void merkkiMerkkiTahti() {
            KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("aa*");
        parseri.kayLapiStringTaulukko();
        
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "a");
         assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), "a");
         assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2),parseri.getTahtiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(3),"false");

        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTahtiSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), "false");

        assertEquals(3, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
        
                @Test
    public void merkkiMerkkiTahtiKysymysmerkki() {
                    KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("aa*?");
        parseri.kayLapiStringTaulukko();
        
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "a");
         assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), "a");
         assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2),parseri.getTahtiKysymysmerkkiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(3),"false");

        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTahtiKysymysmerkkiSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), "false");

        assertEquals(3, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
}
