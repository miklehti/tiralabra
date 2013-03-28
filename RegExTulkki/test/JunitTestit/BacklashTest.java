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
/**
 *
 * @author lehtimik
 */
public class BacklashTest {
    Parseri parseri;
    StringTaulukko stringtaulukko;
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
       
        stringtaulukko = new StringTaulukko(); 
         parseri = new Parseri(stringtaulukko);
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void pelkkaBacklash() {
         stringtaulukko.pilkoStringTaulukkoon("\\");
         parseri.kayLapiStringTaulukko();
         String[] tulokset = new String[2];
         tulokset[0] = parseri.getTulkinnatTaulukkoon().toString();
         tulokset[1] = parseri.getKaytetytRegularExpressionMerkit().toString();
         assertEquals("", tulokset[0]);
         assertEquals("\"\\\" kenoviiva tarkoittaa että seuraava merkki ei olekaan erikoismerkki\n",tulokset[1]);
         assertEquals(0, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
         assertEquals(1, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
     }
          @Test
     public void backlashJaerikoismerkki() {
         stringtaulukko.pilkoStringTaulukkoon("\\+");
         parseri.kayLapiStringTaulukko();
         String[] tulokset = new String[2];
         tulokset[0] = parseri.getTulkinnatTaulukkoon().toString();
         tulokset[1] = parseri.getKaytetytRegularExpressionMerkit().toString();
         assertEquals("+", tulokset[0]);
         assertEquals("\"\\\" kenoviiva tarkoittaa että seuraava merkki ei olekaan erikoismerkki\n",tulokset[1]);
         assertEquals(1, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
         assertEquals(1, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
     }
          
          //*****************korvattavakunbacklashkunnossa*****************************
               @Test
     public void backlashJastringi() {
         stringtaulukko.pilkoStringTaulukkoon("\\a");
         parseri.kayLapiStringTaulukko();
         String[] tulokset = new String[2];
         tulokset[0] = parseri.getTulkinnatTaulukkoon().toString();
         tulokset[1] = parseri.getKaytetytRegularExpressionMerkit().toString();
         assertEquals("a", tulokset[0]);
         assertEquals("\"\\\" kenoviiva tarkoittaa että seuraava merkki ei olekaan erikoismerkki\n",tulokset[1]);
         assertEquals(1, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
         assertEquals(1, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
          //*****************korvattavakunbacklashkunnossa*****************************
     }
                  @Test
     public void backlashJaerikoismerkkiErikoismerkki() {
         stringtaulukko.pilkoStringTaulukkoon("\\+?");
         parseri.kayLapiStringTaulukko();
         String[] tulokset = new String[2];
         tulokset[0] = parseri.getTulkinnatTaulukkoon().toString();
         tulokset[1] = parseri.getKaytetytRegularExpressionMerkit().toString();
         assertEquals("+(edelllä oleva termi(t) ovat vapaaehtoisia, ahne versio)", tulokset[0]);
         assertEquals("\"\\\" kenoviiva tarkoittaa että seuraava merkki ei olekaan erikoismerkki\"?\" Kysymysmerkki tarkoittaa että edellinen arvo on valinnainen. \n Yksi kysymysmerkki tarkoittaa että kyseessä on ahne versio. \nAhne versio takoittaa että regeular expression yrittää ensin saada valinnaisen termin onnistumaan ja vasta sitten yrittää että ei onnistu\n",tulokset[1]);
         assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
         assertEquals(2, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
     }
                                    @Test
     public void merkkiErikoismerkkiBacklash() {
         stringtaulukko.pilkoStringTaulukkoon("a?\\");
         parseri.kayLapiStringTaulukko();
         String[] tulokset = new String[2];
         tulokset[0] = parseri.getTulkinnatTaulukkoon().toString();
         tulokset[1] = parseri.getKaytetytRegularExpressionMerkit().toString();
         assertEquals("a(edelllä oleva termi(t) ovat vapaaehtoisia, ahne versio)", tulokset[0]);
         assertEquals("\"?\" Kysymysmerkki tarkoittaa että edellinen arvo on valinnainen. \n Yksi kysymysmerkki tarkoittaa että kyseessä on ahne versio. \nAhne versio takoittaa että regeular expression yrittää ensin saada valinnaisen termin onnistumaan ja vasta sitten yrittää että ei onnistu\n\"\\\" kenoviiva tarkoittaa että seuraava merkki ei olekaan erikoismerkki\n",tulokset[1]);
         assertEquals(2, parseri.getTulkinnatTaulukkoon().getAlkioidenLKM());
         assertEquals(2, parseri.getKaytetytRegularExpressionMerkit().getAlkioidenLKM());
     }
}
