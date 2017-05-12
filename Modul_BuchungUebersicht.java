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

public class Modul_BuchungUebersicht { 
  public static void menu(int jahr, String[][] Buchungsdaten) {  // Beginn der Hauptfunktion
    char Auswahl;
    
    int anfangsdatum,dauer;
    boolean belegt = false; 

    do { 
      System.out.println("\nAnfangsdatum der Buchung bitte eingeben."); 
      anfangsdatum = Modul_Datumrechner.Datum(jahr);
      belegt = false;
      
    } while (belegt == true); // end of do-while
    
    do {     
      System.out.println("\nWie lange soll gebucht werden?."); 
      dauer = Tastatur.liesInt();
      belegt = false;
      if (dauer <= 0) {
        belegt = true;
        System.out.println("\nDies ist keine gueltiges Datum da es kleiner oder gleich gross als das Anfangsdatum ist.");
      }
      else { 
        int Belegatarray[]= new int [100];
        for (int i=0;i<Buchungsdaten.length ;i++ ) {
          for (int k = anfangsdatum;k<Buchungsdaten[i].length ;k++ ) {
            if (Buchungsdaten[i][k] != null && dauer > 0) {
              dauer--;
              Belegatarray[i] = i;
            }
          } // end of for
        } // end of for
        
        for (int i=0;i<Belegatarray.length ;i++ ) {
          if (Belegatarray[i] != 0) {
            System.out.println("Wohnung " + Belegatarray[i] + " belegt.");
          } // end of if
        } // end of for
        System.out.println("Alle anderen Wohnungen sind in diesem Zeitraum frei.");
      } // end of if-else
    } while (belegt == true); // end of do-while
  } // Ender der Hauptfunktion
} // end of class EAngestellte
