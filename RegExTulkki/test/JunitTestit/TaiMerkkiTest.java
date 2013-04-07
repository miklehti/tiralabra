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
public class TaiMerkkiTest {

    Parseri parseri;
    StringTaulukko stringtaulukko;
    private StringTaulukko tulkinnatTaulukkoon;

    public TaiMerkkiTest() {
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
    public void pelkkaTai() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("|");
        parseri.kayLapiStringTaulukko();
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getTaiTulkinta());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTaiSelitys());
        assertEquals(1, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    @Test
    public void taiJaerikoismerkki() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("|+");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getTaiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), parseri.getPlusTulkinta());

        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTaiSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getPlusSelitys());

        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    @Test
    public void taiJastringi() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("|a");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getTaiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), "a");

        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTaiSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), "false");
        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());

    }

    @Test
    public void taiJaErikoismerkkiErikoismerkki() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("|+?");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), parseri.getTaiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), parseri.getPlusKysymysmerkkiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2), "false");

        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTaiSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getPlusKysymysmerkkiSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(2), "false");

        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    @Test
    public void merkkiErikoismerkkiTai() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("a?|");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "a");
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), parseri.getKysymysmerkkiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2), parseri.getTaiTulkinta());

        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getKysymysmerkkiSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getTaiSelitys());


        assertEquals(3, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    @Test
    public void merkkiMerkkiTai() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("aa|");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "a");
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), "a");
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2), parseri.getTaiTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(3), "false");

        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getTaiSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), "false");

        assertEquals(3, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
}
