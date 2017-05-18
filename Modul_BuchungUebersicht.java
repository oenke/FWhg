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
  public static void uebersicht(int jahr, String[][] Buchungsdaten) {  // Beginn der Hauptfunktion
    char Auswahl;
    
    int anfangsdatum,dauer;
    boolean belegt = false; 
    
    do { 
      System.out.println("\nAnfangsdatum der Buchung bitte eingeben."); 
      anfangsdatum = Modul_Datumrechner.Datum(jahr);                                                                          //Abfrage des Datums
      belegt = false;
    } while (belegt == true); // end of do-while
    
    do {     
      System.out.print("\nWie lange soll gebucht werden? "); 
      dauer = Tastatur.liesInt();                                                                                             //Abfrage der Buchungsdauer
      belegt = false;
      boolean  allefrei = true;                                                                                              //Ueberpruefung ob alle Wohnungen frei sind
      if (dauer <= 0) {
        belegt = true;                                                                                                       //Ueberpruefung des angegebenen Datums
        System.out.println("\nDies ist keine gueltiges Datum da es kleiner oder gleich gross als das Anfangsdatum ist.");
      }
      else { 
        int Belegatarray[]= new int [100];
        for (int i=0;i<Buchungsdaten.length ;i++ ) {
          for (int k = anfangsdatum;k<(anfangsdatum+dauer) ;k++ ) {
            if (Buchungsdaten[i][k] != null && dauer > 0) {                                                                                         
              Belegatarray[i] = i+1;                                                                                           //Eintragung der jewilig belegten Wohnung in einem Array, i+1 zur korrekten Ausgabe
            }
          } // end of for
        } // end of for
        System.out.println();  
        for (int i=0;i<Belegatarray.length ;i++ ) {
          if (Belegatarray[i] != 0) {
            System.out.println("Wohnung " + Belegatarray[i] + " belegt.");                                                   //Ausgabe der belegten Wohnungen in diesem Zeitraum
            allefrei = false;                                                                                                //Variable wird false gesetzt da eine Wohnung belegt ist
          } // end of if
        } // end of for
        
        if (allefrei == false) {
          System.out.println("Alle anderen Wohnungen sind in diesem Zeitraum frei.");                                        //Ausgabe falls mindestens eine Wohnung belegt ist
        } // end of if
        else {
          System.out.println("Alle Wohnungen sind in diesem Zeitraum frei.");                                                //Ausgabe falls alle Wohnungen in dem Zeitraum frei sind
        } // end of if-else
      } // end of if-else
    } while (belegt == true); // end of do-while
  } // Ender der Hauptfunktion
} // end of class EAngestellte
