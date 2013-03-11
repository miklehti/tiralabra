package regextulkki;
////////////////////////////////////////////////////////////////////////
// Helsingin yliopisto, tktl, Arto Wikla 27.8.2011
//
// Ponnahdusikkunakirjasto, versio 0.9.
//
// Kursseille Ohjelmoinnin perusteet ja Ohjelmoinnin jatkokurssi
//
// Tarjolla olevat kirjastorutiinit on kuvailtu sivulla
// http://www.cs.helsinki.fi/u/wikla/ohjelmointi/materiaali/01_algoritmeja/
//
////////////////////////////////////////////////////////////////////////

import javax.swing.*;

public class Pop {

//-----------------------------------------------------------------
//  ilmoita(String viesti)
//-----------------------------------------------------------------
  public static void ilmoita(String viesti) {
    JOptionPane.showMessageDialog(null,
        viesti, "", JOptionPane.PLAIN_MESSAGE);
  }
  public static void ilmoita(int viesti)     {ilmoita(""+viesti);}
  public static void ilmoita(double viesti)  {ilmoita(""+viesti);}
  public static void ilmoita(boolean viesti) {ilmoita(""+viesti);}

  public static void tell(String message) {ilmoita(message);}
  public static void tell(int message)     {ilmoita(""+message);}
  public static void tell(double message)  {ilmoita(""+message);}
  public static void tell(boolean message) {ilmoita(""+message);}

//------------------------------------------------------------------
//  kysyString(String kysymys)
//-----------------------------------------------------------------
  public static String kysyString(String kysymys) {
    // MYÃ–S NULL JA TYHJÃ„ KELPAAVAT! NIITÃ„ ON HYVÃ„ ITSE TESTATA.
    return JOptionPane.showInputDialog(kysymys);  
  }
  public static String askString(String question) {return kysyString(question);}

//------------------------------------------------------------------
//  kysyInt(String kysymys)
//-----------------------------------------------------------------
  public static int kysyInt(String kysymys) {
    String tarjokas = "";
    int arvo = 0;
    boolean kunnossa = false;
    do 
      try {
        tarjokas = JOptionPane.showInputDialog(kysymys);  
        arvo = Integer.parseInt(tarjokas);
        kunnossa = true;
      } catch (Exception e) {
        if (tarjokas==null)
          ilmoita("Cancel is not an integer!");
        else
          ilmoita(tarjokas + " is not an integer!");
      }
    while (!kunnossa);

    return arvo;
  }
  public static int askInt(String question) {return kysyInt(question);}

//-----------------------------------------------------------------
//  kysyDouble(String kysymys)
//------------------------------------------------------------------
  public static double kysyDouble(String kysymys) {
    String tarjokas = "";
    double arvo = 0;
    boolean kunnossa = false;
    do 
      try {
        tarjokas = JOptionPane.showInputDialog(kysymys);  
        arvo = Double.parseDouble(tarjokas);
        kunnossa = true;
      } catch (Exception e) {
        if (tarjokas==null)
          ilmoita("Cancel is not a double!");
        else
          ilmoita(tarjokas + " is not a double!");
      }
    while (!kunnossa);

    return arvo;
  }
  public static double askDouble(String question) {return kysyDouble(question);}

//-----------------------------------------------------------------
//  valitseNappula(String kysymys, String... valinnat)
//------------------------------------------------------------------
  public static int valitseNappula(String kysymys, String... valinnat) {
    if (valinnat.length == 0) {
      throw new IllegalArgumentException("No values supplied.");
    }
    return  JOptionPane.showOptionDialog(null,
                                         kysymys,
                                         "",
                                         JOptionPane.DEFAULT_OPTION,
                                         JOptionPane.QUESTION_MESSAGE,
                                         null,
                                         valinnat,
                                         valinnat[0]);
  }
  public static int selectButton(String question, String... selections)
    {return valitseNappula(question, selections);}

//-----------------------------------------------------------------
//  valitseString(String kysymys, String... valinnat)
//------------------------------------------------------------------

  public static String valitseString(String kysymys, String... valinnat) {
    if (valinnat.length == 0) {
      throw new IllegalArgumentException("No values supplied.");
    }
    Object valinta =   JOptionPane.showInputDialog(null,
                                kysymys,
                                "",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                valinnat,
                                valinnat[0]);
    if (valinta == null)   // Temppuilua... 
      return null;         // koska tÃ¤mÃ¤ versio showInputDialogista
    else                   // on Object! (nulli nullina)
      return ""+valinta; 
  }
  public static String selectString(String question, String... selections)
    {return valitseString(question, selections);}

//------------------------------------------------------------------
//  KÃ¤yttÃ¶esimerkki:
//-----------------------------------------------------------------

  public static void main(String[] args) {

     Pop.ilmoita("Ilmoitus on tÃ¤llainen." + "\n" +
                 "Se on kuitattava ok-nappulalla.");

     Pop.ilmoita("Ilmoituksessa voi olla useitakin rivejÃ¤" + "\n" +
             "Rivinvaidot pitÃ¤Ã¤ itse ilmaista \\n-merkillÃ¤."  + "\n" +
             "PitkiÃ¤kin rivejÃ¤ voi kirjoittaa. " +
             "PitkiÃ¤kin rivejÃ¤ voi kirjoittaa. " +
             "PitkiÃ¤kin rivejÃ¤ voi kirjoittaa. " + "\n" +
             "Tuohon tyyliin.."
     );

     String vastaus = Pop.kysyString("Anna jokin merkkijono!");
     Pop.ilmoita("Se oli: " + vastaus);
     if (vastaus==null) 
       Pop.ilmoita("Vastaaminen keskeytettiin cancel-nappulalla.");
     else 
     if (vastaus.length() ==0 ) 
       Pop.ilmoita("Annettiin tyhjÃ¤ merkkijono.");

     int vast = Pop.valitseNappula("KyllÃ¤ vai ei?", "kyllÃ¤", "ei");
     if (vast == 0)
       Pop.ilmoita("Vastaus oli kyllÃ¤.");
     else
       Pop.ilmoita("Vastaus oli ei.");

     vastaus = Pop.kysyString("MyÃ¶s kysymyksessÃ¤ voi olla useita rivejÃ¤." + "\n" +
             "Rivinvaihdot pitÃ¤Ã¤ itse ilmaista \\n-merkillÃ¤."  + "\n" +
             "Samoin kuin ilmoituksessa.");
     if (vastaus==null) 
       Pop.ilmoita("Vastaus keskeytettiin cancel-nappulalla.");
     else 
     if (vastaus.length() ==0 ) 
       Pop.ilmoita("Vastaus oli tyhjÃ¤ merkkijono.");
     else
       Pop.ilmoita("Se oli: " + vastaus);

     int luku = Pop.kysyInt("Anna kokonaisluku.");
     Pop.ilmoita("Luku oli " + luku);

     double liuku = Pop.kysyDouble("Anna desimaaliluku.");
     Pop.ilmoita("Luku oli " + liuku);

     int lemmikki = Pop.valitseNappula("MikÃ¤ on lemmikkisi?",
                                       "kissa", "hiiri", "koira");
     Pop.ilmoita("Valintasi indeksi on " + lemmikki);
     if (lemmikki==-1) 
       Pop.ilmoita("Vastaaminen keskeytettiin cancel-nappulalla.");

     String lemmik = Pop.valitseString("MikÃ¤ on lemmikkisi?",
                                       "kissa", "hiiri", "koira");
     Pop.ilmoita("Valintasi on " + lemmik);
     if (lemmik==null) 
       Pop.ilmoita("Vastaaminen keskeytettiin cancel-nappulalla.");

     int oikea = Pop.valitseNappula("Vaihtoehdoton \"valinta\"", "Ainoa oikea");
     Pop.ilmoita("Valintasi indeksi on " + oikea + ". Kuinkas muutenkaan.");

     int maa = Pop.valitseNappula("MikÃ¤ maa?", 
       "Suomi", "Ruotsi", "VenÃ¤jÃ¤", "Norja", "Tanska", "Islanti",
       "Saksa", "Ranska", "Hollanti", "Belgia", "Puola", "ItÃ¤valta",
       "Sveitsi", "Italia", "Espanja");
     Pop.ilmoita("Valintasi indeksi on " + maa);

     String v = Pop.valitseString("MikÃ¤ maa?", 
       "Suomi", "Ruotsi", "VenÃ¤jÃ¤", "Norja", "Tanska", "Islanti",
       "Saksa", "Ranska", "Hollanti", "Belgia", "Puola", "ItÃ¤valta",
       "Sveitsi", "Italia", "Espanja");
     Pop.ilmoita("Valintasi on " + v);
  }
}
