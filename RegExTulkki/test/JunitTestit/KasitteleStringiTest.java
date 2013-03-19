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
import regextulkki.StringTaulukko;

/**
 *
 * @author lehtimik
 */
public class KasitteleStringiTest {
    
    StringTaulukko stringTaulukko;
    
    public KasitteleStringiTest() {
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
    public void kasitteleStringiTestEttaToimii() {
        String testi = "testi";
        KasitteleStringi.kasitteleStringi(testi);
        assertEquals(testi, "testi");
    }
}
