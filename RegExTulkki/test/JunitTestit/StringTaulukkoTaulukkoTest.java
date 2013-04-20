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
import regextulkki.StringTaulukkoTaulukko;

/**
 *
 * @author lehtimik
 */
public class StringTaulukkoTaulukkoTest {

    StringTaulukkoTaulukko stringTaulukkoTaulukkoTaulukko;
    StringTaulukko stringTaulukko1 = new StringTaulukko();
    StringTaulukko stringTaulukko2 = new StringTaulukko();
    StringTaulukko stringTaulukko3 = new StringTaulukko();
    StringTaulukko stringTaulukko4 = new StringTaulukko();
    StringTaulukko stringTaulukko5 = new StringTaulukko();
    StringTaulukko stringTaulukko6 = new StringTaulukko();
    StringTaulukko stringTaulukko7 = new StringTaulukko();
    StringTaulukko stringTaulukko8 = new StringTaulukko();
    StringTaulukko stringTaulukko9 = new StringTaulukko();
    StringTaulukko stringTaulukko10 = new StringTaulukko();
    StringTaulukko stringTaulukko11 = new StringTaulukko();
    StringTaulukko stringTaulukko12 = new StringTaulukko();
    StringTaulukko stringTaulukko13 = new StringTaulukko();
    StringTaulukko stringTaulukko14 = new StringTaulukko();
    StringTaulukko stringTaulukko15 = new StringTaulukko();
    StringTaulukko stringTaulukko16 = new StringTaulukko();
    StringTaulukko stringTaulukko17 = new StringTaulukko();
    StringTaulukko stringTaulukko18 = new StringTaulukko();
    StringTaulukko stringTaulukko19 = new StringTaulukko();
    StringTaulukko stringTaulukko20 = new StringTaulukko();
    StringTaulukko stringTaulukko21 = new StringTaulukko();

    public StringTaulukkoTaulukkoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        stringTaulukkoTaulukkoTaulukko = new StringTaulukkoTaulukko();
        String sana1 = "1";
        String sana2 = "2";
        String sana3 = "3";
        String sana4 = "4";
        String sana5 = "5";
        String sana6 = "6";
        String sana7 = "7";
        String sana8 = "8";
        String sana9 = "9";
        String sana10 = "10";
        String sana11 = "11";
        String sana12 = "12";
        String sana13 = "13";
        String sana14 = "14";
        String sana15 = "15";
        String sana16 = "16";
        String sana17 = "17";
        String sana18 = "18";
        String sana19 = "19";
        String sana20 = "20";
        String sana21 = "21";
        stringTaulukko1.lisaaStringKokonaisenaTaulukkoon(sana1);
        stringTaulukko1.lisaaStringKokonaisenaTaulukkoon(sana2);
        stringTaulukko1.lisaaStringKokonaisenaTaulukkoon(sana3);
        stringTaulukko1.lisaaStringKokonaisenaTaulukkoon(sana4);
        stringTaulukko1.lisaaStringKokonaisenaTaulukkoon(sana5);
        stringTaulukko1.lisaaStringKokonaisenaTaulukkoon(sana7);
        stringTaulukko1.lisaaStringKokonaisenaTaulukkoon(sana6);
        stringTaulukko1.lisaaStringKokonaisenaTaulukkoon(sana8);
        stringTaulukko1.lisaaStringKokonaisenaTaulukkoon(sana9);
        stringTaulukko1.lisaaStringKokonaisenaTaulukkoon(sana10);
        stringTaulukko1.lisaaStringKokonaisenaTaulukkoon(sana11);
        stringTaulukko1.lisaaStringKokonaisenaTaulukkoon(sana12);
        stringTaulukko1.lisaaStringKokonaisenaTaulukkoon(sana13);
        stringTaulukko1.lisaaStringKokonaisenaTaulukkoon(sana14);
        stringTaulukko1.lisaaStringKokonaisenaTaulukkoon(sana15);
        stringTaulukko1.lisaaStringKokonaisenaTaulukkoon(sana16);
        stringTaulukko1.lisaaStringKokonaisenaTaulukkoon(sana17);
        stringTaulukko1.lisaaStringKokonaisenaTaulukkoon(sana18);
        stringTaulukko1.lisaaStringKokonaisenaTaulukkoon(sana19);
        stringTaulukko1.lisaaStringKokonaisenaTaulukkoon(sana20);
        stringTaulukko1.lisaaStringKokonaisenaTaulukkoon(sana21);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriLuoTyhjanTaulukon() {

        assertEquals(10, stringTaulukkoTaulukkoTaulukko.getTaulukko().length);
    }

    @Test
    public void konstruktoriLuoTyhjanTaulukon2() {

        assertEquals(0, stringTaulukkoTaulukkoTaulukko.getAlkioidenLKM());
    }

    @Test
    public void tuplaaTaulukonKoko() {
        stringTaulukkoTaulukkoTaulukko.tuplaaTaulukonKoko();

        assertEquals(20, stringTaulukkoTaulukkoTaulukko.getTaulukko().length);
    }

    @Test
    public void lisaaStringTaulukkoTaulukkoon9stringTaulukkoa() {


        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko1);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko2);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko3);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko4);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko5);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko6);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko7);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko8);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko9);



        assertEquals(stringTaulukkoTaulukkoTaulukko.getAlkioidenLKM(), 9);
        assertEquals(stringTaulukkoTaulukkoTaulukko.getTaulukko().length, 10);


    }

    @Test
    public void lisaaStringTaulukkoTaulukkoon10stringTaulukkoa() {
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko1);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko2);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko3);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko4);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko5);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko6);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko7);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko8);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko9);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko10);



        assertEquals(stringTaulukkoTaulukkoTaulukko.getAlkioidenLKM(), 10);
        assertEquals(stringTaulukkoTaulukkoTaulukko.getTaulukko().length, 10);

    }

    @Test
    public void lisaaStringTaulukkoTaulukkoon11stringTaulukkoa() {
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko1);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko2);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko3);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko4);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko5);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko6);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko7);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko8);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko9);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko10);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko11);



        assertEquals(stringTaulukkoTaulukkoTaulukko.getAlkioidenLKM(), 11);
        assertEquals(stringTaulukkoTaulukkoTaulukko.getTaulukko().length, 20);

    }

    @Test
    public void lisaaStringTaulukkoTaulukkoon19stringTaulukkoa() {
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko1);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko2);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko3);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko4);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko5);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko6);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko7);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko8);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko9);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko10);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko11);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko12);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko13);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko14);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko15);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko16);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko17);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko18);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko19);
     



        assertEquals(stringTaulukkoTaulukkoTaulukko.getAlkioidenLKM(), 19);
        assertEquals(stringTaulukkoTaulukkoTaulukko.getTaulukko().length, 20);

    }

    @Test
    public void lisaaStringTaulukkoTaulukkoon20stringTaulukkoa() {
       stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko1);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko2);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko3);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko4);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko5);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko6);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko7);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko8);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko9);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko10);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko11);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko12);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko13);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko14);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko15);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko16);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko17);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko18);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko19);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko20);



        assertEquals(stringTaulukkoTaulukkoTaulukko.getAlkioidenLKM(), 20);
        assertEquals(stringTaulukkoTaulukkoTaulukko.getTaulukko().length, 20);

    }

    @Test
    public void lisaaStringTaulukkoTaulukkoon21stringTaulukkoa() {
       stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko1);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko2);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko3);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko4);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko5);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko6);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko7);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko8);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko9);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko10);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko11);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko12);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko13);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko14);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko15);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko16);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko17);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko18);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko19);
        stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko20);
            stringTaulukkoTaulukkoTaulukko.lisaaStringTaulukkoKokonaisenaTaulukkoon(stringTaulukko21);



        assertEquals(stringTaulukkoTaulukkoTaulukko.getAlkioidenLKM(), 21);
        assertEquals(stringTaulukkoTaulukkoTaulukko.getTaulukko().length, 40);

    }





}
