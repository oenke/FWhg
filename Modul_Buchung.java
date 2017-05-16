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
  public static void menu(int jahr, String[][] Buchungsdaten, String [][] Kundendaten,String[][] fwohnungen,String[][] umsaetze) {  // Beginn der Hauptfunktion
    char Auswahl;
    int wohnungswahl;
    do{
      System.out.println("\nWaehlen Sie die Wohnung aus (1-10):");
      wohnungswahl = Tastatur.liesInt()-1;
    }while(wohnungswahl > 9 || wohnungswahl < 0);
    int anfangsdatum,enddatum;
    boolean belegt = false; 

    do { 
      System.out.println("\nAnfangsdatum der Buchung bitte eingeben."); 
      anfangsdatum = Modul_Datumrechner.Datum(jahr);
      belegt = false;
      if (Buchungsdaten[wohnungswahl][anfangsdatum] != null) {
        belegt = true;
        System.out.println("\nDie Wohnung ist an diesem Datum schon belegt. Bitte anderes Datum waehlen.");
      } // end of if
      
    } while (belegt == true); // end of do-while
    
    do {
      System.out.println("\nEnddatum der Buchung bitte eingeben."); 
      enddatum = Modul_Datumrechner.Datum(jahr);
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
        System.out.println("\n" + gesamttag + " Naechte wurden gebucht.");
        
        int foo = Integer.valueOf(fwohnungen[wohnungswahl][1]);
        double gesamtpreis = Modul_Preisberechnung.berechnung(gesamttag,foo); //PREISBERECHNUNG
        System.out.println("\nDen Preis annehmen? j zum Fortfahren, andere Eingabe zum abbrechen");   //FALLS ANGENOMMEN FORTFAHREN ANSONSTEN ABBRECHEN
        char Wahlo = Tastatur.liesChar();
        if (Wahlo != 'j') {
          return;
        }else{
          double help = Double.parseDouble(umsaetze[wohnungswahl][1]) + gesamtpreis;
          umsaetze[wohnungswahl][1] = String.valueOf(help);
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
      Buchungsdaten[wohnungswahl][(i-1)] = strI;
    } // end of for 
  } // Ender der Hauptfunktion
} // end of class EAngestellte
