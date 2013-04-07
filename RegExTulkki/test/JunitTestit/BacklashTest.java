package JunitTestit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import regextulkki.Parseri;
import regextulkki.StringTaulukko;
import regextulkki.KasitteleStringi;
import regextulkki.BacklashTulkinta;

/**
 *
 * @author lehtimik
 */
public class BacklashTest {

    Parseri parseri;
    StringTaulukko stringtaulukko;
    private StringTaulukko tulkinnatTaulukkoon;

    public BacklashTest() {
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
    public void pelkkaBacklash() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("\\");
        parseri.kayLapiStringTaulukko();
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "\\");
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), "false");
        assertEquals(1, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(0, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    @Test
    public void backlashJaerikoismerkki() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("\\+");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "+");
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getBacklashSelitys());
        assertEquals(1, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    @Test
    public void backlashJastringi() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("\\a");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "\\");
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), "a");
        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(0, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());

    }

    @Test
    public void backlashJaErikoismerkkiErikoismerkki() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("\\+?");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "+");
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), parseri.getKysymysmerkkiTulkinta());

        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getBacklashSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getKysymysmerkkiSelitys());

        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    @Test
    public void merkkiErikoismerkkiBacklash() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("a?\\");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "a");
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), parseri.getKysymysmerkkiTulkinta());

        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), parseri.getKysymysmerkkiSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), "false");

        assertEquals(3, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(1, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    @Test
    public void merkkiMerkkiBacklash() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("aa\\");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "a");
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), "a");
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2), "\\");

        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), "false");
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), "false");

        assertEquals(3, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(0, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    @Test
    public void backlashErikoistulkinnat() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("\\D\\d\\S\\s\\W\\w\\t\\b");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), BacklashTulkinta.getBacklash_DTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), BacklashTulkinta.getBacklash_dTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2), BacklashTulkinta.getBacklash_STulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(3), BacklashTulkinta.getBacklash_sTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(4), BacklashTulkinta.getBacklash_WTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(5), BacklashTulkinta.getBacklash_wTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(6), BacklashTulkinta.getBacklash_tTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(7), BacklashTulkinta.getBacklash_bTulkinta());

        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), BacklashTulkinta.getBacklash_DSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), BacklashTulkinta.getBacklash_dSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(2), BacklashTulkinta.getBacklash_SSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(3), BacklashTulkinta.getBacklash_sSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(4), BacklashTulkinta.getBacklash_WSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(5), BacklashTulkinta.getBacklash_wSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(6), BacklashTulkinta.getBacklash_tSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(7), BacklashTulkinta.getBacklash_bSelitys());


        assertEquals(8, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(8, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    @Test
    public void backlashTulkintamerkki() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("\\D+");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), BacklashTulkinta.getBacklash_DTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), parseri.getPlusTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2), "false");

        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), BacklashTulkinta.getBacklash_DSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getPlusSelitys());

        assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(2, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }

    @Test
    public void backlashTulkintamerkkierikoismerkki() {
        KasitteleStringi.nollaaStaattisetMuuttujat();
        stringtaulukko.pilkoStringTaulukkoon("\\a\\D\\+?");
        parseri.kayLapiStringTaulukko();

        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(0), "\\");
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(1), "a");
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(2), BacklashTulkinta.getBacklash_DTulkinta());
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(3), "+");
        assertEquals(parseri.getTulkinnatTaulukkoon().annaTaulukonAlkionArvo(4), parseri.getKysymysmerkkiTulkinta());

        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(0), BacklashTulkinta.getBacklash_DSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(1), parseri.getBacklashSelitys());
        assertEquals(KasitteleStringi.getKaytetytRegularExpressionMerkit().annaTaulukonAlkionArvo(2), parseri.getKysymysmerkkiSelitys());

        assertEquals(5, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
        assertEquals(3, KasitteleStringi.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
    }
    

}
