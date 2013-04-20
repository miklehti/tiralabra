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
import regextulkki.StringTaulukko;
import regextulkki.RegExTulkki;
import regextulkki.KasitteleStringi;
import regextulkki.StringTaulukkoTaulukko;

/**
 *
 * @author lehtimik
 */
public class RegExTulkkiTest {

    StringTaulukko stringtaulukko;
    KasitteleStringi kasittelestringi;

    public RegExTulkkiTest() {
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

    }

    @After
    public void tearDown() {
    }

    @Test
    public void pelkkaStringi() {
        stringtaulukko.pilkoStringTaulukkoon("aaa");
        RegExTulkki.annaEsimerkkisanat(stringtaulukko);
        assertEquals(1, RegExTulkki.getStringtaulukkotaulukko().getAlkioidenLKM());
    }

    @Test
    public void tasoYksi() {
        RegExTulkki.nollaaStringtaulukkkotaulukko();
        kasittelestringi = new KasitteleStringi("a(b|c)");

        StringTaulukko tulkinnat = kasittelestringi.getTulkinnatTaulukkoon();
        RegExTulkki.annaEsimerkkisanat(tulkinnat);
        StringTaulukko vastaus1 = RegExTulkki.getStringtaulukkotaulukko().annaTaulukonAlkionArvo(0);
        StringTaulukko vastaus2 = RegExTulkki.getStringtaulukkotaulukko().annaTaulukonAlkionArvo(1);
        StringTaulukko vastaus3 = RegExTulkki.getStringtaulukkotaulukko().annaTaulukonAlkionArvo(2);

        assertEquals(3, RegExTulkki.getStringtaulukkotaulukko().getAlkioidenLKM());
        assertEquals("a", vastaus1.annaTaulukonAlkionArvo(0));
        assertEquals("taso0", vastaus1.annaTaulukonAlkionArvo(1));
        assertEquals("b", vastaus2.annaTaulukonAlkionArvo(0));
        assertEquals("taso1", vastaus2.annaTaulukonAlkionArvo(1));
        assertEquals("c", vastaus3.annaTaulukonAlkionArvo(0));
        assertEquals("taso1", vastaus3.annaTaulukonAlkionArvo(1));

    }

    @Test
    public void kysymysmerkki() {
        RegExTulkki.nollaaStringtaulukkkotaulukko();
        kasittelestringi = new KasitteleStringi("ad?b)");

        StringTaulukko tulkinnat = kasittelestringi.getTulkinnatTaulukkoon();
        RegExTulkki.annaEsimerkkisanat(tulkinnat);
        StringTaulukko vastaus1 = RegExTulkki.getStringtaulukkotaulukko().annaTaulukonAlkionArvo(0);
        StringTaulukko vastaus2 = RegExTulkki.getStringtaulukkotaulukko().annaTaulukonAlkionArvo(1);
        StringTaulukko vastaus3 = RegExTulkki.getStringtaulukkotaulukko().annaTaulukonAlkionArvo(2);

        assertEquals(3, RegExTulkki.getStringtaulukkotaulukko().getAlkioidenLKM());
        assertEquals("a", vastaus1.annaTaulukonAlkionArvo(0));
        assertEquals("d", vastaus1.annaTaulukonAlkionArvo(1));
        assertEquals("taso0", vastaus1.annaTaulukonAlkionArvo(2));
        assertEquals("a", vastaus2.annaTaulukonAlkionArvo(0));
        assertEquals("taso0", vastaus2.annaTaulukonAlkionArvo(1));
        assertEquals("b", vastaus3.annaTaulukonAlkionArvo(0));
        assertEquals("taso0", vastaus3.annaTaulukonAlkionArvo(1));

    }

    @Test
    public void vaikea() {
        RegExTulkki.nollaaStringtaulukkkotaulukko();
        kasittelestringi = new KasitteleStringi("reg(ular expre?ssions?|ex(p|es)?aa)|bb?");

        StringTaulukko tulkinnat = kasittelestringi.getTulkinnatTaulukkoon();
        RegExTulkki.annaEsimerkkisanat(tulkinnat);
        StringTaulukko vastaus1 = RegExTulkki.getStringtaulukkotaulukko().annaTaulukonAlkionArvo(0);
        StringTaulukko vastaus2 = RegExTulkki.getStringtaulukkotaulukko().annaTaulukonAlkionArvo(1);
        StringTaulukko vastaus3 = RegExTulkki.getStringtaulukkotaulukko().annaTaulukonAlkionArvo(2);
        StringTaulukko vastaus4 = RegExTulkki.getStringtaulukkotaulukko().annaTaulukonAlkionArvo(3);
        StringTaulukko vastaus5 = RegExTulkki.getStringtaulukkotaulukko().annaTaulukonAlkionArvo(4);
        StringTaulukko vastaus6 = RegExTulkki.getStringtaulukkotaulukko().annaTaulukonAlkionArvo(5);
        StringTaulukko vastaus7 = RegExTulkki.getStringtaulukkotaulukko().annaTaulukonAlkionArvo(6);
        StringTaulukko vastaus8 = RegExTulkki.getStringtaulukkotaulukko().annaTaulukonAlkionArvo(7);
        StringTaulukko vastaus9 = RegExTulkki.getStringtaulukkotaulukko().annaTaulukonAlkionArvo(8);
        StringTaulukko vastaus10 = RegExTulkki.getStringtaulukkotaulukko().annaTaulukonAlkionArvo(9);
        StringTaulukko vastaus11 = RegExTulkki.getStringtaulukkotaulukko().annaTaulukonAlkionArvo(10);
        StringTaulukko vastaus12 = RegExTulkki.getStringtaulukkotaulukko().annaTaulukonAlkionArvo(11);

        assertEquals(12, RegExTulkki.getStringtaulukkotaulukko().getAlkioidenLKM());
        assertEquals("r", vastaus1.annaTaulukonAlkionArvo(0));
        assertEquals("e", vastaus1.annaTaulukonAlkionArvo(1));
        assertEquals("g", vastaus1.annaTaulukonAlkionArvo(2));
        assertEquals("taso0", vastaus1.annaTaulukonAlkionArvo(3));

        assertEquals("u", vastaus2.annaTaulukonAlkionArvo(0));
        assertEquals("l", vastaus2.annaTaulukonAlkionArvo(1));
        assertEquals("a", vastaus2.annaTaulukonAlkionArvo(2));
        assertEquals("r", vastaus2.annaTaulukonAlkionArvo(3));
        assertEquals(" ", vastaus2.annaTaulukonAlkionArvo(4));
        assertEquals("e", vastaus2.annaTaulukonAlkionArvo(5));
        assertEquals("x", vastaus2.annaTaulukonAlkionArvo(6));
        assertEquals("p", vastaus2.annaTaulukonAlkionArvo(7));
        assertEquals("r", vastaus2.annaTaulukonAlkionArvo(8));
        assertEquals("e", vastaus2.annaTaulukonAlkionArvo(9));
        assertEquals("taso1", vastaus2.annaTaulukonAlkionArvo(10));

        assertEquals("u", vastaus3.annaTaulukonAlkionArvo(0));
        assertEquals("l", vastaus3.annaTaulukonAlkionArvo(1));
        assertEquals("a", vastaus3.annaTaulukonAlkionArvo(2));
        assertEquals("r", vastaus3.annaTaulukonAlkionArvo(3));
        assertEquals(" ", vastaus3.annaTaulukonAlkionArvo(4));
        assertEquals("e", vastaus3.annaTaulukonAlkionArvo(5));
        assertEquals("x", vastaus3.annaTaulukonAlkionArvo(6));
        assertEquals("p", vastaus3.annaTaulukonAlkionArvo(7));
        assertEquals("r", vastaus3.annaTaulukonAlkionArvo(8));
        assertEquals("taso1", vastaus3.annaTaulukonAlkionArvo(9));

        assertEquals("s", vastaus4.annaTaulukonAlkionArvo(0));
        assertEquals("s", vastaus4.annaTaulukonAlkionArvo(1));
        assertEquals("i", vastaus4.annaTaulukonAlkionArvo(2));
        assertEquals("o", vastaus4.annaTaulukonAlkionArvo(3));
        assertEquals("n", vastaus4.annaTaulukonAlkionArvo(4));
        assertEquals("s", vastaus4.annaTaulukonAlkionArvo(5));
        assertEquals("taso1", vastaus4.annaTaulukonAlkionArvo(6));

        assertEquals("s", vastaus5.annaTaulukonAlkionArvo(0));
        assertEquals("s", vastaus5.annaTaulukonAlkionArvo(1));
        assertEquals("i", vastaus5.annaTaulukonAlkionArvo(2));
        assertEquals("o", vastaus5.annaTaulukonAlkionArvo(3));
        assertEquals("n", vastaus5.annaTaulukonAlkionArvo(4));
        assertEquals("taso1", vastaus5.annaTaulukonAlkionArvo(5));

        assertEquals("e", vastaus6.annaTaulukonAlkionArvo(0));
        assertEquals("x", vastaus6.annaTaulukonAlkionArvo(1));
        assertEquals("taso1", vastaus6.annaTaulukonAlkionArvo(2));
        
          assertEquals("p", vastaus7.annaTaulukonAlkionArvo(0));
        assertEquals("taso2", vastaus7.annaTaulukonAlkionArvo(1));
        
 assertEquals("e", vastaus8.annaTaulukonAlkionArvo(0));
        assertEquals("s", vastaus8.annaTaulukonAlkionArvo(1));
        assertEquals("taso2", vastaus8.annaTaulukonAlkionArvo(2));
        
         assertEquals("taso2", vastaus9.annaTaulukonAlkionArvo(0));
         
          assertEquals("a", vastaus10.annaTaulukonAlkionArvo(0));
        assertEquals("a", vastaus10.annaTaulukonAlkionArvo(1));
        assertEquals("taso1", vastaus10.annaTaulukonAlkionArvo(2));
        
        assertEquals("b", vastaus11.annaTaulukonAlkionArvo(0));
        assertEquals("b", vastaus11.annaTaulukonAlkionArvo(1));
        assertEquals("taso0", vastaus11.annaTaulukonAlkionArvo(2));
        
           assertEquals("b", vastaus12.annaTaulukonAlkionArvo(0));
        assertEquals("taso0", vastaus12.annaTaulukonAlkionArvo(1));
    

    }
}
