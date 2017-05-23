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
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //Modul zur Buchung von Ferienwohnungen
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
        belegt = true;                                                                                                   //Zur Ueberpruefung ob das Datum an diesem mit der eingegeben Wohnung schon belegt ist
        System.out.println("\nDie Wohnung ist an diesem Datum schon belegt. Bitte anderes Datum waehlen.");              //Ansonsten Eingabe wiederholen
      } // end of if                                                                                                     
      
    } while (belegt == true); // end of do-while
    
    do {
      System.out.println("\nEnddatum der Buchung bitte eingeben."); 
      enddatum = Modul_Datumrechner.Datum(jahr);
      belegt = false;
      if (enddatum <= anfangsdatum) {                                                                                     
        belegt = true;                                                                                                    //Zur Ueberpruefung ob das Enddatum groesser ist als das Anfangsdatum
        System.out.println("\nDies ist keine gueltiges Datum da es kleiner oder gleich gross als das Anfangsdatum ist."); //Ansonsten Eingabe wiederholen
      }                                                                                                                   
      else {
        int gesamttag = enddatum - anfangsdatum;                                                                          //Dauer der gesamten Buchung
        for (int i=anfangsdatum;i<=enddatum;i++ ) {
          if (Buchungsdaten[wohnungswahl][i-1] != null) {
            belegt = true;                                                                                                //Ueberpruefung ob Enddatum schon belegt ist
            System.out.println("\nDie Wohnung ist am " + i + ". Tag schon belegt. Anderes Datum bitte waehlen.");         //ansonsten belegt und Datumeingabe wiederholen
          } // end of if
        } // end of for
        if (belegt == false) {
          System.out.println("\n" + gesamttag + " Naechte werden gebucht.");                                                  //Ausgabe wieviele Tage gebucht wurden
          
          int preis = Integer.valueOf(fwohnungen[wohnungswahl][1]);                                                        //String als Integer vom Preis der Wohnung
          double gesamtpreis = Modul_Preisberechnung.berechnung(gesamttag,preis); //PREISBERECHNUNG
          System.out.println("\nDen Preis annehmen? <j> zum Fortfahren, andere Eingabe zum abbrechen");                    //Fall angenommen wird, wird die Buchung fortgesetzt, ansonsten abgebrochen
          char Wahlo = Tastatur.liesChar();
          if (Wahlo != 'j') {
            return;
          }else{
            double help = Double.parseDouble(umsaetze[wohnungswahl][1]) + gesamtpreis;                                     //Wert der Umsaetze als double speichern
            umsaetze[wohnungswahl][1] = String.valueOf(help);                                                              //Wert in der Uumsaetze datenbank eintragen
          }// end of if
        } // end of if
      } // end of if-else
    } while (belegt == true); // end of do-while
    
    int KundNmr;
    do {
      System.out.println("Zur Ausgabe aller Kunden einmal <0> eingeben.");                                                //Zum abbruch falls Kunde nicht vorhanden sind
      System.out.println("Zum abbrechen des Programms <999> eingeben."); 
      System.out.print("\nBitte die Kundennummer eingeben:");                                                             //Eingabe der KundenID
      
      KundNmr = Tastatur.liesInt()-1;
      if (KundNmr == 0) {
        for (int t=0;t<50; t++) {
          if (Kundendaten[t][0] != null) {
            for (int k=0;k<3;k++) {
              System.out.println((t+1)+". "+Kundendaten[t][k]);                                                            //Gibt alle bisher angelegten Kunden aus
            } // end of for
            System.out.println("____________________");
          } // end of if
        } // end of for
      }
      else if (KundNmr==999) {
        return;                                                                                                            //Bricht das Buchungs Modul ab
      } // end of if-else
      else {
        if (KundNmr < 0 || Kundendaten[KundNmr][0] == null ) {
          KundNmr = 0;                                                                                                     //Bei ungueltiger Kundenummer wird die Eingabe wiederholt, wenn z.B. Kunde nicht vorhanden ist
          System.out.println("\nKeine gueltige Kundenummer, moeglicherweise ist der Kunde noch nicht angelegt."); 
        } // end of if
      } // end of if-else
    } while (KundNmr == 0); // end of do-while
    System.out.println("Fuer " + Kundendaten[KundNmr][0] + " " + Kundendaten[KundNmr][1] + " wurde die Wohnung " + (wohnungswahl+1) + " gebucht."); //Ausgabe was gebucht wurde fuer welchen Kunden
    for (int i=anfangsdatum;i<=enddatum;i++ ) {  
      String strI = Integer.toString(KundNmr);                                                                            //Umwandlung des Integers der Kundennummer in eines Strings zur Speicherung
      Buchungsdaten[wohnungswahl][i-1] = strI;                                                                              //Sicherung in den Buchungsdaten
    } // end of for 
  } // Ender der Hauptfunktion
} // end of class EAngestellte
