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
import regextulkki.PopKysyIlmoita;
import regextulkki.StringTaulukkoTaulukko;
import regextulkki.RegExTulkki;

/**
 *
 * @author lehtimik
 */
public class Suorituskykytesti {

       Parseri parseri;
       StringTaulukkoTaulukko stringtaulukkotaulukko;
        KasitteleStringi kasitteleStringi;
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
    public void suorituskykytestiRegexille() throws FileNotFoundException, InterruptedException {
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
            
            String rivi = syottotiedosto.nextLine();
            int rivinPituus = rivi.length();
             
            kasitteleStringi = new KasitteleStringi(rivi);
             stringtaulukkotaulukko = new StringTaulukkoTaulukko();
             
              StringTaulukko tulkinnat = kasitteleStringi.getTulkinnatTaulukkoon();
       
             
            startTimePilkoString = System.nanoTime();
             RegExTulkki.annaEsimerkkisanat(tulkinnat);
        
            endTimePilkoString = System.nanoTime();

            durationPilkoString = endTimePilkoString - startTimePilkoString;
            tulosTiedosto.println("annaEsimerkkisanat " + rivinPituus + " merkillä kesti " + durationPilkoString + " nanosekuntia");

         

        }
        tulosTiedosto.close();
        syottotiedosto.close();
    }
}
