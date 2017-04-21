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
/** PROGRAMMKOPF
  * Zinsrechner
  * Beschreibung
  * Ein Simpler Datum
  *
  * @version 1.0 vom 30.09.2016
  * 
  * Klasse: FS 63
  * Name: Lukas Wüstenhagen
  *
  PROGRAMMKOPF ENDE*/

public class Modul_Buchung {
  public static int[] Datum() {
    int tag = 0, monat = 0, jahr = 0; //Deklarationsteil
    boolean fehler = false, tagpasstzumonat = false;
    char weitermachen;
    
    while (fehler == false) { 
      System.out.print("Bitte geben Sie das Jahr ein: "); //Schreibt den gegebenen Text 
      jahr = Tastatur.liesInt(); //Setzt zahl1 auf den Ausgelesen Wert von der Tastatur
      if (jahr >= 1582 && jahr <= 2499) {
        fehler = true;
      } // end of if
      else {
        System.out.print("Die Eingabe ist Falsch, bitte wiederholen.\n"); //Schreibt den gegebenen Text 
      } // end of if-else
    } // end of while
    fehler = false;
    
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
          if (tag == 29) { //FÜR FEBRUAR NOCH SCHALTJAHRE BERECHNEN
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
    
    if (tagpasstzumonat == true) {
      System.out.printf("Das Datum ist korrekt!\n\n"); //Schreibt den gegebenen Text 
    } // end of if
    else {
      System.out.printf("Das Datum ist falsch!\n\n"); //Schreibt den gegebenen Text 
    } // end of if-else
    
   
    
    int datum[] = {tag,monat,jahr};
    return datum;
  } // end of main  
    
  public static void main(String[] args) {  // Beginn der Hauptfunktion
    int Auswahl = 0;
    int Wohnung = 10;
    int Kundennummer = 365; //Fuer jeden Tag eine Kundenummer
    int Tag,Monat,Jahr;
    String Buchungsdaten[ ][ ] = new String[Wohnung][Kundennummer]; //Vorname, Nachname, Adresse
    Buchungsdaten = Buchungsdaten;
    do {
      
      /*System.out.println("\nWelches Datum will der Kunde? Geben sie den Tag nach dem Format DD ein.\n");
      Tag = Tastatur.liesInt();
      System.out.println("\nGeben sie den Monat nach dem Format MM ein.\n");
      Monat = Tastatur.liesInt();
      System.out.println("\nGeben sie den Monat nach dem Format YYYY ein.\n");
      Jahr = Tastatur.liesInt();
      System.out.println(Tag+ "." + Monat + "." +Jahr);*/
      int datum[] = Modul_Buchung.Datum();
      System.out.println("\n5 zum Beenden des Programmes\n");
      Auswahl = Tastatur.liesInt();
    } while (Auswahl != 5); // end of do-while
    
    //return Buchungsdaten;
  } // Ender der Hauptfunktion
} // end of class EAngestellte
