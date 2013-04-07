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
import regextulkki.KasitteleStringi;

/**
 *
 * @author lehtimik
 */
public class CaretTest {

    Parseri parseri;
    StringTaulukko stringtaulukko;
    private StringTaulukko tulkinnatTaulukkoon;

    public CaretTest() {
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void pelkkaCaret() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("^");
        parseri.kayLapiStringTaulukko();
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getCaretTulkinta());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getCaretSelitys());
        assertEquals(1, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    @Test
    public void caretJaerikoismerkki() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("^+");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getCaretTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), parseri.getPlusTulkinta());

        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getCaretSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getPlusSelitys());

        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    @Test
    public void caretJastringi() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("^a");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getCaretTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), "a");

        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getCaretSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), "false");
        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());

    }

    @Test
    public void caretJaErikoismerkkiErikoismerkki() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("^+?");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getCaretTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), parseri.getPlusKysymysmerkkiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2), "false");

        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getCaretSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getPlusKysymysmerkkiSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(2), "false");

        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    @Test
    public void merkkiErikoismerkkiCaret() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("a?^");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "a");
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), parseri.getKysymysmerkkiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2), parseri.getCaretTulkinta());

        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getKysymysmerkkiSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getCaretSelitys());


        assertEquals(3, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    @Test
    public void merkkiMerkkiCaret() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("aa^");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "a");
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), "a");
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2), parseri.getCaretTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(3), "false");

        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getCaretSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), "false");

        assertEquals(3, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
}
