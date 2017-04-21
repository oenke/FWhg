import java.util.*;
/** PROGRAMMKOPF
  * Modul Buchung
  *
  * @version 1.0 vom 20.04.2017
  * 
  * Klasse: FS 63
  * Name: Lukas Wuestenhagen
  *
  PROGRAMMKOPF ENDE*/

public class Modul_Buchung {
  public static int Datum(int jahr) {
    int tag = 0, monat = 0; //Deklarationsteil
    boolean fehler = false, tagpasstzumonat = false;
    char weitermachen;
    
    do {
      /*while (fehler == false) { 
        System.out.print("Bitte geben Sie das Jahr ein: "); //Schreibt den gegebenen Text 
        jahr = Tastatur.liesInt(); //Setzt zahl1 auf den Ausgelesen Wert von der Tastatur
        if (jahr >= 1582 && jahr <= 2499) {
          fehler = true;
        } // end of if
        else {
          System.out.print("Die Eingabe ist Falsch, bitte wiederholen.\n"); //Schreibt den gegebenen Text 
        } // end of if-else
      } // end of while
      fehler = false;*/
      System.out.println("Jahr: " + jahr); //Schreibt den gegebenen Text
      
      while (fehler == false) { 
        System.out.print("Bitte geben Sie den Monat ein: "); //Schreibt den gegebenen Text 
        monat = Tastatur.liesInt(); //Setzt zahl1 auf den Ausgelesen Wert von der Tastatur
        if (monat >= 1 && monat <= 12) {
          fehler = true;
        } // end of if
        else {
          System.out.print("Die Eingabe ist Falsch, bitte wiederholen.\n"); //Schreibt den gegebenen Text 
        } // end of if-else
      } // end of while
      fehler = false;
      
      while (fehler == false) { 
        System.out.print("Bitte geben Sie den Tag ein: "); //Schreibt den gegebenen Text 
        tag = Tastatur.liesInt(); //Setzt zahl1 auf den Ausgelesen Wert von der Tastatur
        if (tag >= 1 && tag <= 31) {
          switch (monat) {
            case  1: 
            if (tag <= 31) {
              tagpasstzumonat = true; 
            } // end of if
            break;
            case  2: 
            if (tag == 29) { //FUER FEBRUAR NOCH SCHALTJAHRE BERECHNEN
              if (jahr % 4 == 0) {
                if (jahr % 100 == 0) {
                  if (jahr % 400 == 0) {
                    tagpasstzumonat = true;
                  } // end of if
                } // end of if
                else {
                  tagpasstzumonat = true;
                } // end of if-else
              } // end of if 
            } // end of if
              else if (tag <= 28) {
                   tagpasstzumonat = true;   
              } // end of if-else
            break;
            case  3: 
            if (tag <= 31) {
              tagpasstzumonat = true;  
            } // end of if
            break;
            case  4: 
            if (tag <= 30) { 
              tagpasstzumonat = true;
            } // end of if
            break;
            case  5: 
            if (tag <= 31) {
              tagpasstzumonat = true;
            } // end of if
            break;
            case  6: 
            if (tag <= 30) {
              tagpasstzumonat = true;
            } // end of if
            break;
            case  7: 
            if (tag <= 31) {
              tagpasstzumonat = true;  
            } // end of if
            break;
            case  8: 
            if (tag <= 31) {
              tagpasstzumonat = true;  
            } // end of if
            break;
            case  9: 
            if (tag >= 30) {
              tagpasstzumonat = true;
            } // end of if
            break;
            case  10: 
            if (tag <= 31) {
              tagpasstzumonat = true;
            } // end of if
            break;
            case  11: 
            if (tag <= 30) {
              tagpasstzumonat = true; 
            } // end of if
            break;
            case  12: 
            if (tag <= 31) {
              tagpasstzumonat = true;  
            } // end of if
            break;
            //System.out.print("Die Eingabe ist Falsch, bitte wiederholen.\n");
          } // end of switch
          fehler = true; 
        } // end of if
        else {
          System.out.print("Die Eingabe ist Falsch, bitte wiederholen.\n"); //Schreibt den gegebenen Text 
        } // end of if-else
      } // end of while
      fehler = false;
      
      if (tag < 10) {
        System.out.printf("Das Datum lautet 0%1d.",tag);
      } // end of if
      else {
        System.out.printf("Das Datum lautet %2d.",tag);
      } // end of if-else
      if (monat < 10) {
        System.out.printf("0%1d.%4d\n",monat,jahr); //Schreibt den gegebenen Text
      } // end of if
      else {
        System.out.printf("%2d.%4d\n",monat,jahr); //Schreibt den gegebenen Text
      } // end of if-else
      //System.out.printf("Das Jahr lautet %2d.%2d.%4d\n",tag,monat,jahr); //Schreibt den gegebenen Text
      
      /*if (tagpasstzumonat == true) {
        System.out.printf("Das Datum ist korrekt!\n\n"); //Schreibt den gegebenen Text 
      } // end of if
      else {
        System.out.printf("Das Datum ist falsch!\n\n"); //Schreibt den gegebenen Text 
      } // end of if-else */
    } while (tagpasstzumonat == false); // end of do-while

    GregorianCalendar beliebigesDatum = new GregorianCalendar(jahr,monat-1,tag,0,0,0);
    int kalendertag =  beliebigesDatum.get( Calendar.DAY_OF_YEAR );
   
    return kalendertag;
  } // end of main  

  public static void menu(int jahr, String[][] Buchungsdaten) {  // Beginn der Hauptfunktion
    char Auswahl;
    //int Wohnung = 10;
    //int Datum = 365; //Fuer jeden Tag eine Kundenummer
    //String Buchungsdaten[ ][ ] = new String[Wohnung][Datum]; //Vorname, Nachname, Adresse
    //Buchungsdaten = Buchungsdaten;
    do {
      System.out.println("\nWaehlen Sie die Wohnung aus (1-10):");
      int wohnungswahl = Tastatur.liesInt()-1;
      int anfangsdatum,enddatum;
      boolean belegt = false; 
      
      do { 
        System.out.println("\nAnfangsdatum der Buchung bitte eingeben."); 
        anfangsdatum = Modul_Buchung.Datum(jahr);
        System.out.println("Anfangstag: " + anfangsdatum);
        belegt = false;
        if (Buchungsdaten[wohnungswahl][anfangsdatum] != null) {
          belegt = true;
          System.out.println("\nDie Wohnung ist an diesem Datum schon belegt. Bitte anderes Datum waehlen.");
        } // end of if
        
      } while (belegt == true); // end of do-while
      
      do {
        System.out.println("\nEnddatum der Buchung bitte eingeben."); 
        enddatum = Modul_Buchung.Datum(jahr);
        System.out.println("Anfangs: " + anfangsdatum);
        System.out.println("Endtag: " + enddatum);
        belegt = false;
        if (enddatum <= anfangsdatum) {
          belegt = true;
          System.out.println("\nDies ist keine gueltiges Datum da es kleiner oder gleich gross als das Anfangsdatum ist.");
        }
        else {
          int gesamttag = enddatum - anfangsdatum;
          for (int i=anfangsdatum;i<=enddatum;i++ ) {
            if (Buchungsdaten[wohnungswahl][anfangsdatum] != null) {
              belegt = true;
              System.out.println("\nDie Wohnung ist am " + i + " schon belegt. Anderes Datum waehlen.");
            } // end of if
          } // end of for
          System.out.println("\n" + gesamttag + " Tage wurden gebucht.");
        } // end of if-else
      } while (belegt == true); // end of do-while
      
      for (int i=anfangsdatum;i<=enddatum;i++ ) {
        Buchungsdaten[wohnungswahl][i] = "Belegt";
      } // end of for
      
      System.out.println("\nDruecken Sie 'e' zum beenden des Unterprogrammes.");
      System.out.println("Druecken Sie einen beliebigen Knopf zum wiederholen.");
      Auswahl = Tastatur.liesChar();
    } while (Auswahl != 'e'); // end of do-while
    
    //return Buchungsdaten;
  } // Ender der Hauptfunktion
} // end of class EAngestellte
