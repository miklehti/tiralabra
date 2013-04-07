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
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author lehtimik
 */
public class Suorituskykytesti {

       Parseri parseri;
    StringTaulukko stringtaulukko;
    private StringTaulukko tulkinnatTaulukkoon;
    private static Scanner lukija = new Scanner(System.in);

    public Suorituskykytesti() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void suorituskykytestiParserille() throws FileNotFoundException, InterruptedException {
        String syottoTiedosto = "C:\\Users\\Public\\Documents\\Omat\\tiralabra\\RegEx\\tiralabra\\Sk_testaus_parseri_input.txt";
        File syottoTiedostoKahva = new File(syottoTiedosto);
        Scanner syottotiedosto = new Scanner(syottoTiedostoKahva);

        String tulosTiedostoNimi = "C:\\Users\\Public\\Documents\\Omat\\tiralabra\\RegEx\\tiralabra\\Sk_testaus_parseri_output.txt";
        File tulosTiedostoKahva = new File(tulosTiedostoNimi);
        PrintWriter tulosTiedosto = new PrintWriter(tulosTiedostoKahva);
        long startTimePilkoString;
        long endTimePilkoString;
        long durationPilkoString;

        long startTimeKayLapiTaulukko;
        long endTimeKayLapiTaulukko;
        long durationKayLapiTaulukko;

        while (syottotiedosto.hasNextLine()) {
            stringtaulukko = new StringTaulukko();
            parseri = new Parseri(stringtaulukko,tulkinnatTaulukkoon);
            String rivi = syottotiedosto.nextLine();
            int rivinPituus = rivi.length();

            startTimePilkoString = System.nanoTime();
            stringtaulukko.pilkoStringTaulukkoon(rivi);
            endTimePilkoString = System.nanoTime();

            durationPilkoString = endTimePilkoString - startTimePilkoString;
            tulosTiedosto.println("pilkoStringTaulukkoon " + rivinPituus + " merkillä kesti " + durationPilkoString + " nanosekuntia");

            startTimeKayLapiTaulukko = System.nanoTime();
            parseri.kayLapiStringTaulukko();
            endTimeKayLapiTaulukko = System.nanoTime();
            
            System.out.println(startTimeKayLapiTaulukko);
            System.out.println(endTimePilkoString);
            durationKayLapiTaulukko = endTimeKayLapiTaulukko - startTimeKayLapiTaulukko;
            System.out.println(durationKayLapiTaulukko);
            tulosTiedosto.println("kayLapiStringTaulukko " + rivinPituus + " merkillä kesti " + durationKayLapiTaulukko + " nanosekuntia");

        }
        tulosTiedosto.close();
        syottotiedosto.close();
    }
}
