import java.util.*;
/** PROGRAMMKOPF
  * Kundendaten Modul
  *
  * @version 1.0 vom 25.11.2016
  * 
  * Klasse: FS 63
  * Name: Lukas Wuestenhagen
  *
  PROGRAMMKOPF ENDE*/

public class Modul_Kundendaten {
  public static void KundenEingabe(String[][] Kundendaten, int AnzahlKunden, int Eintrage) {  // Eingabe neuer Kundendaten in einem 
    if (Eintrage >= AnzahlKunden) {
      System.out.print("Zu viele Eintraege.");
    } // end of if
    else {
      int k = 0;
      while (Kundendaten[k][0] != null) {            
        k++;                                                                                 //KundenID erhöhen solange KundeID schon vorhanden ist
      } // end of while
      
      for (int i=0;i<3;i++) {
        switch (i) {                                                                         //Eingabe der relevanten Daten
          case  0: 
            System.out.print("Bitte geben Sie den Vornamen ein: ");
            Kundendaten[k][i] = Tastatur.liesString();                                         
            break;
          case  1: 
            System.out.print("Bitte geben Sie den Nachnamen ein: ");
            Kundendaten[k][i] = Tastatur.liesString();
            break;
          case  2: 
            System.out.print("Bitte geben Sie die Adresse ein: ");
            Kundendaten[k][i] = Tastatur.liesString();
            break;
          default: 
            
        } // end of switch
      } // end of for
      
      Eintrage++;
    } // end of if-else
  } 
  
  public static void KundenVeraender(String[][] Kundendaten, int AnzahlKunden, int Eintrage) {  //Veraenderung von Kundendaten
    System.out.print("Bitte geben Sie den Datensatz ein den Sie veraendern wollen: ");
    int Ausgabewahl2 = Tastatur.liesInt()-1;
    if (Ausgabewahl2 < 0 || Ausgabewahl2 > AnzahlKunden) {
      System.out.println("Datensatz nicht vorhanden.");                                          //Fehlerausgabe bei KundeID's auersserhalb des Spektrums
    } // end of if
    else {
      if (Kundendaten[Ausgabewahl2][0] != null) {
        for (int i=0;i<3 ;i++ ) {
          System.out.println("\n"+(Ausgabewahl2+1)+". "+Kundendaten[Ausgabewahl2][i]);           //Bereits vorhandene Daten printen
        } // end of for
      } // end of if
      for (int i=0;i<3;i++) {
        switch (i) {                                                                             //Eingabe der relevanten Daten
          case  0: 
            System.out.print("Bitte geben Sie den Vornamen ein: ");
            Kundendaten[Ausgabewahl2][i] = Tastatur.liesString();
            break;
          case  1: 
            System.out.print("Bitte geben Sie den Nachnamen ein: ");
            Kundendaten[Ausgabewahl2][i] = Tastatur.liesString();
            break;
          case  2: 
            System.out.print("Bitte geben Sie die Adresse ein: ");
            Kundendaten[Ausgabewahl2][i] = Tastatur.liesString();
            break;
          default: 
            
        } // end of switch
      } // end of for 
    }
  }
  
  public static void AusgabeEinzel(String[][] Kundendaten, int AnzahlKunden, int Eintrage) {  //Einzelne Ausgabe eines Kundendatensatzes
    System.out.print("Bitte geben Sie den Datensatz ein: ");
    int Ausgabewahl = Tastatur.liesInt()-1;
    if (Ausgabewahl < 0 || Ausgabewahl > AnzahlKunden) {
      System.out.println("Datensatz nicht vorhanden.");                                       //Fehlerausgabe bei KundeID's auersserhalb des Spektrums
    } // end of if
    else {
      for (int i=0;i<3 ;i++ ) {
        System.out.println("\n"+(Ausgabewahl+1)+". "+Kundendaten[Ausgabewahl][i]);            //Ausgabe des Datensatzes
      } // end of for
    } // end of if-else
  }
  
  public static void AusgabeAlle(String[][] Kundendaten, int AnzahlKunden, int Eintrage) {  // Ausgabe aller Kundendatensaetze
    System.out.println();
    for (int t=0;t<AnzahlKunden; t++) {
      if (Kundendaten[t][0] != null) {
        for (int i=0;i<3;i++) {
          System.out.println((t+1)+". "+Kundendaten[t][i]);                                 // Ausgabe der Datensaetze mittels Schleife
        } // end of for
        System.out.println("____________________");
      } // end of if
    } // end of for
  }
  
  public static void BuchungDerKundenID(String[][] Kundendaten, int AnzahlKunden, int Eintrage, String[][] Buchungsdaten ) {  // Ueberpruefung der Buchungen eines Kunden mittels seiner ID
    System.out.print("Bitte geben Sie die KundenID ein: ");
    int Eingabe = Tastatur.liesInt() -1;
    System.out.println("");//Leerzeile
    boolean Treffer = false;
    int helper = 0,helper2 = 0,whg=0;                                                                                                           //Bei einem Treffer zur Ausgabe verschiedener Texte
    if (Eingabe > 0 && Eingabe < AnzahlKunden) {
      for (int i=0;i<Buchungsdaten.length;i++ ) {
        for (int k = 0;k<Buchungsdaten[i].length;k++ ) {
          if (Buchungsdaten[i][k] == null) {
            helper = 0;                          //Reset der Zähler bei einem Leeren Arrayfeld
            helper2 = 0;                          //Reset der Zähler bei einem Leeren Arrayfeld
            whg=0;                                //Reset der Zähler bei einem Leeren Arrayfeld
          } // end of if
          if (Buchungsdaten[i][k] != null && Integer.parseInt(Buchungsdaten[i][k]) == Eingabe ) {
            helper2 = helper2 + 1;         //Anfangstag bis zum Endtag hochzählen
            if (helper == 0) {
              helper = k + 1;       //Anfangstag setzen
              helper2 = k + 1;     //Anfangstag setzen
              whg = i+1;      //Welche Wohnung wurde gebucht ?
            } // end of if       
            Treffer = true;
            if (k == (Buchungsdaten[i].length-1)) {
              System.out.println(Kundendaten[Eingabe][0] + " " + Kundendaten[Eingabe][1] + " hat die Wohnung "+whg+" vom Tag "+helper+" bis zum Tag "+helper2+" gebucht!");  //Ausgabe bei gebuchter Wohnung      
            }else{
              if (Treffer && Buchungsdaten[i][(k+1)] == null ) {     //Wenn Treffer und das nächste Feld Leer ist ausgeben
                System.out.println(Kundendaten[Eingabe][0] + " " + Kundendaten[Eingabe][1] + " hat die Wohnung "+whg+" vom Tag "+helper+" bis zum Tag "+helper2+" gebucht!");  //Ausgabe bei gebuchter Wohnung
              } // end of if
            }                                                                                                      //Bis eine KundenID gefunden wurde die mit der Eingabe passt, dann printen.
          }
        } // end of for
      } // end of for
      if (!Treffer) {
        System.out.println("\nDer Kunde mit der ID: " + (Eingabe+1) + " hat bisher noch nichts gebucht.");                                  //Bei keinem Treffer wird nur die ID erneut ausgegeben
      } // end of if-else
    } // end of if
    else {
      System.out.println("Ungültige Eingabe!");
    } // end of if-else
  }
  
  public static void menu(String[][] Kundendaten, int AnzahlKunden, int Eintrage, String[][] Buchungsdaten ) {  // Beginn der Hauptfunktion
    int Auswahl;
    do {
      System.out.println("\nBitte Waehlen Sie eine Option aus:\n"); //Schreibt den gegebenen Text
      System.out.println("1 - Fuer Eingabe neuer Kundendaten");
      System.out.println("2 - Zum Veraendern von Kundendaten.");
      System.out.println("3 - Fuer Ausgabe eines bestimmter Kundendaten.");
      System.out.println("4 - Fuer die Ausgabe aller Kundendaten.");
      System.out.println("5 - Buchungsabfrage mittels KundenID.");
      System.out.println("6 - Zurueckkehren zum Hauptprogramm.");
      Auswahl = Tastatur.liesInt(); 
      
      switch (Auswahl) {                                                                         //Verschiedene Cases fuer unterschiedliche Untermodule
        case  1:
          Modul_Kundendaten.KundenEingabe(Kundendaten,AnzahlKunden,Eintrage);
          break;
        case  2:
          Modul_Kundendaten.KundenVeraender(Kundendaten,AnzahlKunden,Eintrage);
          break;
        case  3:
          Modul_Kundendaten.AusgabeEinzel(Kundendaten,AnzahlKunden,Eintrage);
          break;
        case  4:
          Modul_Kundendaten.AusgabeAlle(Kundendaten,AnzahlKunden,Eintrage);
          break;
        case  5:
          Modul_Kundendaten.BuchungDerKundenID(Kundendaten,AnzahlKunden,Eintrage,Buchungsdaten);
          break;
        default: 
          System.out.println("\nKeine gueltige Eingabe!");
      } // end of switch
    } while (Auswahl != 6); // end of do-while
    
    //return Kundendaten;
  } // Ender der Hauptfunktion
} // end of class EAngestellte
