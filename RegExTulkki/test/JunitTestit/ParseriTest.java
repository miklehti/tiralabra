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
import regextulkki.Parseri;

/**
 *
 * @author lehtimik
 */
public class ParseriTest {

       Parseri parseri;
    StringTaulukko stringtaulukko;
    private StringTaulukko tulkinnatTaulukkoon;

    public ParseriTest() {
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
    public void kayLapiStringTaulukkoTest() {
        stringtaulukko.pilkoStringTaulukkoon("a.?a$aa+a^a|a*aaa\\");
         parseri = new Parseri(stringtaulukko,tulkinnatTaulukkoon);
         parseri.kayLapiStringTaulukko();
        assertEquals(20, stringtaulukko.getTaulukko().length);
    }
    
        @Test
    public void getStringTaulukkoTest() {
        stringtaulukko.pilkoStringTaulukkoon("a.?a$aa+a^a|a*aaa\\");
         parseri = new Parseri(stringtaulukko, tulkinnatTaulukkoon);
         StringTaulukko tulos = parseri.getStringTaulukko();
          assertEquals(20, tulos.getTaulukko().length);
    }
}
