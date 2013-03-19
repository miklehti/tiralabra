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
        stringTaulukko.lisaaStringTaulukkoon(sana);
        for (int i = 0; i < sana.length(); i++) {
            String sanaTaulukossa = stringTaulukko.annaTaulukonAlkionArvo(i);
            assertEquals(sana.substring(i, i + 1), sanaTaulukossa);
        }

    }

    @Test
    public void lisaaStringTaulukkoon10kirjainta() {
        String sana = "kymmenenki";
        stringTaulukko.lisaaStringTaulukkoon(sana);
        for (int i = 0; i < sana.length(); i++) {
            String sanaTaulukossa = stringTaulukko.annaTaulukonAlkionArvo(i);
            assertEquals(sana.substring(i, i + 1), sanaTaulukossa);
        }

    }

    @Test
    public void lisaaStringTaulukkoon11kirjainta() {
        String sana = "yksitoistak";
        stringTaulukko.lisaaStringTaulukkoon(sana);
        for (int i = 0; i < sana.length(); i++) {
            String sanaTaulukossa = stringTaulukko.annaTaulukonAlkionArvo(i);
            assertEquals(sana.substring(i, i + 1), sanaTaulukossa);
        }

    }

    @Test
    public void lisaaStringTaulukkoon19kirjainta() {
        String sana = "yhdeksantoistakirja";
        stringTaulukko.lisaaStringTaulukkoon(sana);
        for (int i = 0; i < sana.length(); i++) {
            String sanaTaulukossa = stringTaulukko.annaTaulukonAlkionArvo(i);
            assertEquals(sana.substring(i, i + 1), sanaTaulukossa);
        }

    }

    @Test
    public void lisaaStringTaulukkoon20kirjainta() {
        String sana = "kaksikymmentakirjain";
        stringTaulukko.lisaaStringTaulukkoon(sana);
        for (int i = 0; i < sana.length(); i++) {
            String sanaTaulukossa = stringTaulukko.annaTaulukonAlkionArvo(i);
            assertEquals(sana.substring(i, i + 1), sanaTaulukossa);
        }

    }

    @Test
    public void lisaaStringTaulukkoon21kirjainta() {
        String sana = "kaksikymmentakirjaint";
        stringTaulukko.lisaaStringTaulukkoon(sana);
        for (int i = 0; i < sana.length(); i++) {
            String sanaTaulukossa = stringTaulukko.annaTaulukonAlkionArvo(i);
            assertEquals(sana.substring(i, i + 1), sanaTaulukossa);
        }

    }

    @Test
    public void lisaaStringTaulukkoon21kirjaintaTutkiTaulukonKoko() {
        String sana = "kaksikymmentakirjaint";
        stringTaulukko.lisaaStringTaulukkoon(sana);

        assertEquals(40, stringTaulukko.getTaulukko().length);

    }

    @Test
    public void lisaaKaksiStringia() {
        String ekaSana = "eka";
        String tokaSana = "toka";
        stringTaulukko.lisaaStringTaulukkoon(ekaSana);
        stringTaulukko.lisaaStringTaulukkoon(tokaSana);

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
        stringTaulukko.lisaaStringTaulukkoon(ekaSana);
        stringTaulukko.lisaaStringTaulukkoon(tokaSana);

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
        stringTaulukko.lisaaStringTaulukkoon(ekaSana);
        stringTaulukko.lisaaStringTaulukkoon(tokaSana);

        assertEquals(20, stringTaulukko.getTaulukko().length);

    }

    @Test
    public void poistaEkaMerkki() {
        String ekaSana = "eka";
        stringTaulukko.lisaaStringTaulukkoon(ekaSana);
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
        stringTaulukko.lisaaStringTaulukkoon(ekaSana);
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
        stringTaulukko.lisaaStringTaulukkoon(ekaSana);
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
        stringTaulukko.lisaaStringTaulukkoon(ekaSana);
        stringTaulukko.poistaMerkkejaTaulukosta(0, 3);

        assertEquals("", stringTaulukko.toString());
        assertEquals(0, stringTaulukko.getAlkioidenLKM());

    }

    @Test
    public void poistaKaikkiPaitsiEkaMerkki() {
        String ekaSana = "eka";
        stringTaulukko.lisaaStringTaulukkoon(ekaSana);
        stringTaulukko.poistaMerkkejaTaulukosta(1, 2);

        assertEquals("e", stringTaulukko.toString());
        assertEquals(1, stringTaulukko.getAlkioidenLKM());

    }

    @Test
    public void poistaKaikkiPaitsiVikaMerkki() {
        String ekaSana = "eka";
        stringTaulukko.lisaaStringTaulukkoon(ekaSana);
        stringTaulukko.poistaMerkkejaTaulukosta(0, 2);

        assertEquals("a", stringTaulukko.toString());
        assertEquals(1, stringTaulukko.getAlkioidenLKM());

    }
    //todo testit jos 10 tai 11 pitkä sana

    @Test
    public void poistaEkaMerkki10kirjainta() {
        String ekaSana = "kymmenenki";
        stringTaulukko.lisaaStringTaulukkoon(ekaSana);
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
        stringTaulukko.lisaaStringTaulukkoon(ekaSana);
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
        stringTaulukko.lisaaStringTaulukkoon(ekaSana);
        stringTaulukko.poistaMerkkejaTaulukosta(0, 10);

        assertEquals("", stringTaulukko.toString());
        assertEquals(0, stringTaulukko.getAlkioidenLKM());

    }

    @Test
    public void poistaKaikkiPaitsiEkaMerkki10kirjainta() {
        String ekaSana = "kymmenenki";
        stringTaulukko.lisaaStringTaulukkoon(ekaSana);
        stringTaulukko.poistaMerkkejaTaulukosta(1, 9);

        assertEquals("k", stringTaulukko.toString());
        assertEquals(1, stringTaulukko.getAlkioidenLKM());

    }

    @Test
    public void poistaKaikkiPaitsiVikaMerkki10kirjainta() {
        String ekaSana = "kymmenenki";
        stringTaulukko.lisaaStringTaulukkoon(ekaSana);
        stringTaulukko.poistaMerkkejaTaulukosta(0, 9);

        assertEquals("i", stringTaulukko.toString());
        assertEquals(1, stringTaulukko.getAlkioidenLKM());


    }

    @Test
    public void poistaEkaMerkki11kirjainta() {
        String ekaSana = "yksitoistak";
        stringTaulukko.lisaaStringTaulukkoon(ekaSana);
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
        stringTaulukko.lisaaStringTaulukkoon(ekaSana);
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
        stringTaulukko.lisaaStringTaulukkoon(ekaSana);
        stringTaulukko.poistaMerkkejaTaulukosta(0, 11);

        assertEquals("", stringTaulukko.toString());
        assertEquals(0, stringTaulukko.getAlkioidenLKM());
        assertEquals(0, stringTaulukko.getAlkioidenLKM());

    }

    @Test
    public void poistaKaikkiPaitsiEkaMerkki11kirjainta() {
        String ekaSana = "yksitoistak";
        stringTaulukko.lisaaStringTaulukkoon(ekaSana);
        stringTaulukko.poistaMerkkejaTaulukosta(1, 10);

        assertEquals("y", stringTaulukko.toString());
        assertEquals(1, stringTaulukko.getAlkioidenLKM());

    }

    @Test
    public void poistaKaikkiPaitsiVikaMerkki11kirjainta() {
        String ekaSana = "yksitoistak";
        stringTaulukko.lisaaStringTaulukkoon(ekaSana);
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
    public void setTaulukko() {
         String[] taulukko = new String[10];
        stringTaulukko.setTaulukko(taulukko);
        
 assertEquals(10, stringTaulukko.getTaulukko().length);

    }
        @Test
    public void poiistaLiikaa() {
            stringTaulukko.lisaaStringTaulukkoon("a");
            stringTaulukko.lisaaStringTaulukkoon("b");
            stringTaulukko.lisaaStringTaulukkoon("c");
            stringTaulukko.lisaaStringTaulukkoon("d");
            
        boolean onnaako = stringTaulukko.poistaMerkkejaTaulukosta(0, 5);
      
        
 assertEquals(onnaako,false);

    }
    
}
