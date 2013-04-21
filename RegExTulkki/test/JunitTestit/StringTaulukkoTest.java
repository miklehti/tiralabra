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
import regextulkki.StringTaulukko;
import regextulkki.KasitteleStringi;

/**
 *
 * @author lehtimik
 */
public class StringTaulukkoTest {

    StringTaulukko stringTaulukko;

    public StringTaulukkoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        stringTaulukko = new StringTaulukko();
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void konstruktoriLuoTyhjanTaulukon() {

        assertEquals(10, stringTaulukko.getTaulukko().length);
    }

    @Test
    public void konstruktoriLuoTyhjanTaulukon2() {

        assertEquals(0, stringTaulukko.getAlkioidenLKM());
    }

    @Test
    public void tuplaaTaulukonKoko() {
        stringTaulukko.tuplaaTaulukonKoko();

        assertEquals(20, stringTaulukko.getTaulukko().length);
    }

    @Test
    public void lisaaStringTaulukkoon9kirjainta() {
        String sana = "yhdeksank";
        stringTaulukko.pilkoStringTaulukkoon(sana);
        for (int i = 0; i < sana.length(); i++) {
            String sanaTaulukossa = stringTaulukko.annaTaulukonAlkionArvo(i);
            assertEquals(sana.substring(i, i + 1), sanaTaulukossa);
        }

    }

    @Test
    public void lisaaStringTaulukkoon10kirjainta() {
        String sana = "kymmenenki";
        stringTaulukko.pilkoStringTaulukkoon(sana);
        for (int i = 0; i < sana.length(); i++) {
            String sanaTaulukossa = stringTaulukko.annaTaulukonAlkionArvo(i);
            assertEquals(sana.substring(i, i + 1), sanaTaulukossa);
        }

    }

    @Test
    public void lisaaStringTaulukkoon11kirjainta() {
        String sana = "yksitoistak";
        stringTaulukko.pilkoStringTaulukkoon(sana);
        for (int i = 0; i < sana.length(); i++) {
            String sanaTaulukossa = stringTaulukko.annaTaulukonAlkionArvo(i);
            assertEquals(sana.substring(i, i + 1), sanaTaulukossa);
        }

    }

    @Test
    public void lisaaStringTaulukkoon19kirjainta() {
        String sana = "yhdeksantoistakirja";
        stringTaulukko.pilkoStringTaulukkoon(sana);
        for (int i = 0; i < sana.length(); i++) {
            String sanaTaulukossa = stringTaulukko.annaTaulukonAlkionArvo(i);
            assertEquals(sana.substring(i, i + 1), sanaTaulukossa);
        }

    }

    @Test
    public void lisaaStringTaulukkoon20kirjainta() {
        String sana = "kaksikymmentakirjain";
        stringTaulukko.pilkoStringTaulukkoon(sana);
        for (int i = 0; i < sana.length(); i++) {
            String sanaTaulukossa = stringTaulukko.annaTaulukonAlkionArvo(i);
            assertEquals(sana.substring(i, i + 1), sanaTaulukossa);
        }

    }

    @Test
    public void lisaaStringTaulukkoon21kirjainta() {
        String sana = "kaksikymmentakirjaint";
        stringTaulukko.pilkoStringTaulukkoon(sana);
        for (int i = 0; i < sana.length(); i++) {
            String sanaTaulukossa = stringTaulukko.annaTaulukonAlkionArvo(i);
            assertEquals(sana.substring(i, i + 1), sanaTaulukossa);
        }

    }

    @Test
    public void lisaaStringTaulukkoon21kirjaintaTutkiTaulukonKoko() {
        String sana = "kaksikymmentakirjaint";
        stringTaulukko.pilkoStringTaulukkoon(sana);

        assertEquals(40, stringTaulukko.getTaulukko().length);

    }

    @Test
    public void lisaaKaksiStringia() {
        String ekaSana = "eka";
        String tokaSana = "toka";
        stringTaulukko.pilkoStringTaulukkoon(ekaSana);
        stringTaulukko.pilkoStringTaulukkoon(tokaSana);

        for (int i = 0; i < ekaSana.length(); i++) {
            String sanaTaulukossa = stringTaulukko.annaTaulukonAlkionArvo(i);
            assertEquals(ekaSana.substring(i, i + 1), sanaTaulukossa);
        }

        for (int i = 0; i < tokaSana.length(); i++) {
            String sanaTaulukossa = stringTaulukko.annaTaulukonAlkionArvo(i + 3);
            assertEquals(tokaSana.substring(i, i + 1), sanaTaulukossa);
        }
    }

    @Test
    public void lisaaKaksiStringiaPlusTuplaus() {
        String ekaSana = "eka";
        String tokaSana = "tokasana";
        stringTaulukko.pilkoStringTaulukkoon(ekaSana);
        stringTaulukko.pilkoStringTaulukkoon(tokaSana);

        for (int i = 0; i < ekaSana.length(); i++) {
            String sanaTaulukossa = stringTaulukko.annaTaulukonAlkionArvo(i);
            assertEquals(ekaSana.substring(i, i + 1), sanaTaulukossa);
        }

        for (int i = 0; i < tokaSana.length(); i++) {
            String sanaTaulukossa = stringTaulukko.annaTaulukonAlkionArvo(i + 3);
            assertEquals(tokaSana.substring(i, i + 1), sanaTaulukossa);
        }
    }

    @Test
    public void lisaaKaksiStringiaTaulukonKoko() {
        String ekaSana = "eka";
        String tokaSana = "tokasana";
        stringTaulukko.pilkoStringTaulukkoon(ekaSana);
        stringTaulukko.pilkoStringTaulukkoon(tokaSana);

        assertEquals(20, stringTaulukko.getTaulukko().length);

    }

    @Test
    public void poistaEkaMerkki() {
        String ekaSana = "eka";
        stringTaulukko.pilkoStringTaulukkoon(ekaSana);
        stringTaulukko.poistaMerkkejaTaulukosta(0, 1);
        String tulos = "ka";
        assertEquals("ka", stringTaulukko.toString());
        assertEquals(2, stringTaulukko.getAlkioidenLKM());
        for (int i = 0; i < 2; i++) {
            assertEquals(tulos.substring(i, i + 1), stringTaulukko.annaTaulukonAlkionArvo(i));
        }

    }

    @Test
    public void poistaVikaMerkki() {
        String ekaSana = "eka";
        stringTaulukko.pilkoStringTaulukkoon(ekaSana);
        stringTaulukko.poistaMerkkejaTaulukosta(2, 1);
        String tulos = "ek";

        assertEquals("ek", stringTaulukko.toString());
        assertEquals(2, stringTaulukko.getAlkioidenLKM());
        for (int i = 0; i < 2; i++) {
            assertEquals(tulos.substring(i, i + 1), stringTaulukko.annaTaulukonAlkionArvo(i));
        }
    }

    @Test
    public void poistaTokaMerkki() {
        String ekaSana = "eka";
        stringTaulukko.pilkoStringTaulukkoon(ekaSana);
        stringTaulukko.poistaMerkkejaTaulukosta(1, 1);
        String tulos = "ea";

        assertEquals("ea", stringTaulukko.toString());
        assertEquals(2, stringTaulukko.getAlkioidenLKM());
        for (int i = 0; i < 2; i++) {
            assertEquals(tulos.substring(i, i + 1), stringTaulukko.annaTaulukonAlkionArvo(i));
        }
    }

    @Test
    public void poistaKaikkiMerkit() {
        String ekaSana = "eka";
        stringTaulukko.pilkoStringTaulukkoon(ekaSana);
        stringTaulukko.poistaMerkkejaTaulukosta(0, 3);

        assertEquals("", stringTaulukko.toString());
        assertEquals(0, stringTaulukko.getAlkioidenLKM());

    }

    @Test
    public void poistaKaikkiPaitsiEkaMerkki() {
        String ekaSana = "eka";
        stringTaulukko.pilkoStringTaulukkoon(ekaSana);
        stringTaulukko.poistaMerkkejaTaulukosta(1, 2);

        assertEquals("e", stringTaulukko.toString());
        assertEquals(1, stringTaulukko.getAlkioidenLKM());

    }

    @Test
    public void poistaKaikkiPaitsiVikaMerkki() {
        String ekaSana = "eka";
        stringTaulukko.pilkoStringTaulukkoon(ekaSana);
        stringTaulukko.poistaMerkkejaTaulukosta(0, 2);

        assertEquals("a", stringTaulukko.toString());
        assertEquals(1, stringTaulukko.getAlkioidenLKM());

    }
    //todo testit jos 10 tai 11 pitkä sana

    @Test
    public void poistaEkaMerkki10kirjainta() {
        String ekaSana = "kymmenenki";
        stringTaulukko.pilkoStringTaulukkoon(ekaSana);
        stringTaulukko.poistaMerkkejaTaulukosta(0, 1);
        String tulos = "ymmenenki";
        assertEquals("ymmenenki", stringTaulukko.toString());
        assertEquals(9, stringTaulukko.getAlkioidenLKM());
        for (int i = 0; i < 9; i++) {
            assertEquals(tulos.substring(i, i + 1), stringTaulukko.annaTaulukonAlkionArvo(i));
        }

    }

    @Test
    public void poistaVikaMerkki10kirjainta() {
        String ekaSana = "kymmenenki";
        stringTaulukko.pilkoStringTaulukkoon(ekaSana);
        stringTaulukko.poistaMerkkejaTaulukosta(9, 1);
        String tulos = "kymmenenk";

        assertEquals("kymmenenk", stringTaulukko.toString());
        assertEquals(9, stringTaulukko.getAlkioidenLKM());
        for (int i = 0; i < 9; i++) {
            assertEquals(tulos.substring(i, i + 1), stringTaulukko.annaTaulukonAlkionArvo(i));
        }
    }

    @Test
    public void poistaKaikkiMerkit10kirjainta() {
        String ekaSana = "kymmenenki";
        stringTaulukko.pilkoStringTaulukkoon(ekaSana);
        stringTaulukko.poistaMerkkejaTaulukosta(0, 10);

        assertEquals("", stringTaulukko.toString());
        assertEquals(0, stringTaulukko.getAlkioidenLKM());

    }

    @Test
    public void poistaKaikkiPaitsiEkaMerkki10kirjainta() {
        String ekaSana = "kymmenenki";
        stringTaulukko.pilkoStringTaulukkoon(ekaSana);
        stringTaulukko.poistaMerkkejaTaulukosta(1, 9);

        assertEquals("k", stringTaulukko.toString());
        assertEquals(1, stringTaulukko.getAlkioidenLKM());

    }

    @Test
    public void poistaKaikkiPaitsiVikaMerkki10kirjainta() {
        String ekaSana = "kymmenenki";
        stringTaulukko.pilkoStringTaulukkoon(ekaSana);
        stringTaulukko.poistaMerkkejaTaulukosta(0, 9);

        assertEquals("i", stringTaulukko.toString());
        assertEquals(1, stringTaulukko.getAlkioidenLKM());


    }

    @Test
    public void poistaEkaMerkki11kirjainta() {
        String ekaSana = "yksitoistak";
        stringTaulukko.pilkoStringTaulukkoon(ekaSana);
        stringTaulukko.poistaMerkkejaTaulukosta(0, 1);
        String tulos = "ksitoistak";
        assertEquals("ksitoistak", stringTaulukko.toString());
        assertEquals(10, stringTaulukko.getAlkioidenLKM());
        for (int i = 0; i < 10; i++) {
            assertEquals(tulos.substring(i, i + 1), stringTaulukko.annaTaulukonAlkionArvo(i));
        }

    }

    @Test
    public void poistaVikaMerkki11kirjainta() {
        String ekaSana = "yksitoistak";
        stringTaulukko.pilkoStringTaulukkoon(ekaSana);
        stringTaulukko.poistaMerkkejaTaulukosta(10, 1);
        String tulos = "yksitoista";
        assertEquals("yksitoista", stringTaulukko.toString());
        assertEquals(10, stringTaulukko.getAlkioidenLKM());
        for (int i = 0; i < 10; i++) {
            assertEquals(tulos.substring(i, i + 1), stringTaulukko.annaTaulukonAlkionArvo(i));
        }
    }

    @Test
    public void poistaKaikkiMerkit11kirjainta() {
        String ekaSana = "yksitoistak";
        stringTaulukko.pilkoStringTaulukkoon(ekaSana);
        stringTaulukko.poistaMerkkejaTaulukosta(0, 11);

        assertEquals("", stringTaulukko.toString());
        assertEquals(0, stringTaulukko.getAlkioidenLKM());
        assertEquals(0, stringTaulukko.getAlkioidenLKM());

    }

    @Test
    public void poistaKaikkiPaitsiEkaMerkki11kirjainta() {
        String ekaSana = "yksitoistak";
        stringTaulukko.pilkoStringTaulukkoon(ekaSana);
        stringTaulukko.poistaMerkkejaTaulukosta(1, 10);

        assertEquals("y", stringTaulukko.toString());
        assertEquals(1, stringTaulukko.getAlkioidenLKM());

    }

    @Test
    public void poistaKaikkiPaitsiVikaMerkki11kirjainta() {
        String ekaSana = "yksitoistak";
        stringTaulukko.pilkoStringTaulukkoon(ekaSana);
        stringTaulukko.poistaMerkkejaTaulukosta(0, 10);

        assertEquals("k", stringTaulukko.toString());
        assertEquals(1, stringTaulukko.getAlkioidenLKM());

    }

    @Test
    public void getSetAlkioidenLKM() {
        stringTaulukko.setAlkioidenLKM(10);
        int lkm = stringTaulukko.getAlkioidenLKM();
        assertEquals(10, stringTaulukko.getAlkioidenLKM());
        assertEquals(lkm, stringTaulukko.getAlkioidenLKM());


    }

    @Test
    public void getSetTutkittavaIndeksi() {
        stringTaulukko.setTutkittavaIndeksi(5);
        int lkm = stringTaulukko.getTutkittavaIndeksi();
        assertEquals(5, stringTaulukko.getTutkittavaIndeksi());
        assertEquals(lkm, stringTaulukko.getTutkittavaIndeksi());


    }

    @Test
    public void annaTaulukonArvoKunIndeksiVaarin() {
        String vastaus1 = stringTaulukko.annaTaulukonAlkionArvo(-1);
        String vastaus2 = stringTaulukko.annaTaulukonAlkionArvo(11);
        assertEquals("false", vastaus1);
        assertEquals("false", vastaus2);


    }


    @Test
    public void annaStringikokonaisena() {
        stringTaulukko.pilkoStringTaulukkoon("Mikko");
        String vastaus = stringTaulukko.annaStringKokonaisenaTaulukosta();
        assertEquals("Mikko", vastaus);

    }

    @Test
    public void setTaulukko() {
        String[] taulukko = new String[10];
        stringTaulukko.setTaulukko(taulukko);

        assertEquals(10, stringTaulukko.getTaulukko().length);

    }

    @Test
    public void poiistaLiikaa() {
        stringTaulukko.pilkoStringTaulukkoon("a");
        stringTaulukko.pilkoStringTaulukkoon("b");
        stringTaulukko.pilkoStringTaulukkoon("c");
        stringTaulukko.pilkoStringTaulukkoon("d");

        boolean onnaako = stringTaulukko.poistaMerkkejaTaulukosta(0, 5);


        assertEquals(onnaako, false);

    }

    @Test
    public void poiistaVaarin() {
        stringTaulukko.pilkoStringTaulukkoon("a");
        stringTaulukko.pilkoStringTaulukkoon("b");
        stringTaulukko.pilkoStringTaulukkoon("c");
        stringTaulukko.pilkoStringTaulukkoon("d");

        boolean onnaako = stringTaulukko.poistaMerkkejaTaulukosta(-1, 1);
        boolean onnaako2 = stringTaulukko.poistaMerkkejaTaulukosta(5, 1);


        assertEquals(onnaako, false);
        assertEquals(onnaako2, false);

    }

    @Test
    public void lisaaStringKokonaisenaTaulukkoonTest() {
        stringTaulukko.lisaaStringKokonaisenaTaulukkoon("a");
        stringTaulukko.lisaaStringKokonaisenaTaulukkoon("ab");
        stringTaulukko.lisaaStringKokonaisenaTaulukkoon("abc");
        stringTaulukko.lisaaStringKokonaisenaTaulukkoon("abcdd");

        int alkioidenLKM = stringTaulukko.getAlkioidenLKM();
        int taulunPituus1 = stringTaulukko.getTaulukko().length;

        assertEquals(alkioidenLKM, 4);
        assertEquals(taulunPituus1, 10);
        stringTaulukko.lisaaStringKokonaisenaTaulukkoon("abcde");
        stringTaulukko.lisaaStringKokonaisenaTaulukkoon("abcdef");
        stringTaulukko.lisaaStringKokonaisenaTaulukkoon("abcdefg");
        stringTaulukko.lisaaStringKokonaisenaTaulukkoon("abcdefgh");
        int taulunPituus2 = stringTaulukko.getTaulukko().length;
        int alkioidenLKM2 = stringTaulukko.getAlkioidenLKM();
        assertEquals(alkioidenLKM2, 8);
        assertEquals(taulunPituus2, 10);
        stringTaulukko.lisaaStringKokonaisenaTaulukkoon("abcdefgh");
        stringTaulukko.lisaaStringKokonaisenaTaulukkoon("abcdefgh");
        int taulunPituus3 = stringTaulukko.getTaulukko().length;
        int alkioidenLKM3 = stringTaulukko.getAlkioidenLKM();
        assertEquals(alkioidenLKM3, 10);
        assertEquals(taulunPituus3, 10);
        stringTaulukko.lisaaStringKokonaisenaTaulukkoon("abcdefgh");
        int taulunPituus4 = stringTaulukko.getTaulukko().length;
        int alkioidenLKM4 = stringTaulukko.getAlkioidenLKM();
        assertEquals(alkioidenLKM4, 11);
        assertEquals(taulunPituus4, 20);

    }
}