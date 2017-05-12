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
    } while (tagpasstzumonat == false); // end of do-while

    GregorianCalendar beliebigesDatum = new GregorianCalendar(jahr,monat-1,tag,0,0,0);
    int kalendertag =  beliebigesDatum.get( Calendar.DAY_OF_YEAR );
   
    return kalendertag;
  } // end of datum  
  
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  public static void menu(int jahr, String[][] Buchungsdaten, String [][] Kundendaten,String[][] fwohnungen,String[][] umsaetze) {  // Beginn der Hauptfunktion
    char Auswahl;
    
    System.out.println("\nWaehlen Sie die Wohnung aus (1-10):");
    int wohnungswahl = Tastatur.liesInt()-1;
    int anfangsdatum,enddatum;
    boolean belegt = false; 
    
  
    
    do { 
      System.out.println("\nAnfangsdatum der Buchung bitte eingeben."); 
      anfangsdatum = Modul_Buchung.Datum(jahr);
      belegt = false;
      if (Buchungsdaten[wohnungswahl][anfangsdatum] != null) {
        belegt = true;
        System.out.println("\nDie Wohnung ist an diesem Datum schon belegt. Bitte anderes Datum waehlen.");
      } // end of if
      
    } while (belegt == true); // end of do-while
    
    do {
      System.out.println("\nEnddatum der Buchung bitte eingeben."); 
      enddatum = Modul_Buchung.Datum(jahr);
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
        
        int foo = Integer.valueOf(fwohnungen[wohnungswahl][1]);
        double gesamtpreis = Modul_Preisberechnung.berechnung(gesamttag,foo); //PREISBERECHNUNG
        System.out.println("\nDen Preis annehmen? j zum Fortfahren, andere Eingabe zum abbrechen");   //FALLS ANGENOMMEN FORTFAHREN ANSONSTEN ABBRECHEN
        char Wahlo = Tastatur.liesChar();
        if (Wahlo != 'j') {
          return;
        }else{
          umsaetze[wohnungswahl][1] = umsaetze[wohnungswahl][1] + gesamtpreis;
        }// end of if
         
      } // end of if-else
    } while (belegt == true); // end of do-while
    
    int KundNmr;
    do {
      System.out.println("\nBitte die Kundennummer eingeben."); 
      System.out.println("\nZur Ausgabe aller Kunden einmal 0 eingeben.");
      System.out.println("\nZum abbrechen des Programms 999 eingeben.");
      KundNmr = Tastatur.liesInt();
      if (KundNmr == 0) {
        for (int t=0;t<50; t++) {
        if (Kundendaten[t][0] != null) {
          for (int k=0;k<3;k++) {
              System.out.println((t+1)+". "+Kundendaten[t][k]);
            } // end of for
            System.out.println("____________________");
          } // end of if
        } // end of for
      }
      else if (KundNmr==999) {
        return; 
      } // end of if-else
      else {
        System.out.println(Kundendaten[KundNmr-1][0]);
        if (Kundendaten[KundNmr-1][0] == null) {
          KundNmr = 0;
          System.out.println("\nKeine gueltige Kundenummer, moeglicherweise ist der Kunde noch nicht angelegt."); 
        } // end of if
      } // end of if-else
    } while (KundNmr == 0); // end of do-while
    
    for (int i=anfangsdatum;i<=enddatum;i++ ) {  
      String strI = Integer.toString(KundNmr-1);
      Buchungsdaten[wohnungswahl][i] = strI;
    } // end of for 
  } // Ender der Hauptfunktion
} // end of class EAngestellte
