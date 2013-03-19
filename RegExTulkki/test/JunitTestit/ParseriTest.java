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

    StringTaulukko stringTaulukko;
    Parseri parseri;

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
        stringTaulukko = new StringTaulukko();
       
    }

    @After
    public void tearDown() {
    }

    @Test
    public void kayLapiStringTaulukkoTest() {
        stringTaulukko.lisaaStringTaulukkoon("a.?a$aa+a^a|a*aaa\\");
         parseri = new Parseri(stringTaulukko);
         parseri.kayLapiStringTaulukko();
        assertEquals(20, stringTaulukko.getTaulukko().length);
    }
    
        @Test
    public void getStringTaulukkoTest() {
        stringTaulukko.lisaaStringTaulukkoon("a.?a$aa+a^a|a*aaa\\");
         parseri = new Parseri(stringTaulukko);
         StringTaulukko tulos = parseri.getStringTaulukko();
          assertEquals(20, tulos.getTaulukko().length);
    }
}
