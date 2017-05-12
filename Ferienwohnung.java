import java.util.*;
/**
  *
  * Klasse: FS 63
  * 
  * Author: Nico Fischer, Lukas Wuestenhagen, Daniel Schoenke, Jony Nchamadi
  * AS-Projekt
  * Programmbeschreibung: Verwaltungssystem fuer Ferienwohnungen  
  * 
  */ 
public class Ferienwohnung {
  
  public static void main(String[] args) {
    int wahl;
    Calendar cal = new GregorianCalendar();
    int jahr = cal.get(Calendar.YEAR);
    
    int dbANZ[] = new int [3];    // 0 = FWHG
    Modul_Update2.getDbANZ(dbANZ);
    int AnzahlKunden = 50;  // Modul Kundendaten
    int Eintrage = 3;
    String Kundendaten [] [] = new String [AnzahlKunden][Eintrage]; // Modul Kundendaten ArrayParameter
    
    int Wohnung = dbANZ[0]; //Modul Buchungsdaten
    int Datum = 365; //Fuer jeden Tag eine Kundenummer
    String Buchungsdaten[ ][ ] = new String[Wohnung][Datum];
    
    String fwohnungen[][] = new String[Wohnung][3]; 
    String umsaetze[][] = new String[Wohnung][2]; 
    
    do{
      Modul_Update2.getDbANZ(dbANZ);
      Wohnung = dbANZ[0];
      Modul_Update2.checkDB(jahr);
      Modul_Update2.read(fwohnungen,Kundendaten,Buchungsdaten,umsaetze,jahr);
      System.out.println("____________________Managementsystem fuer Ferienwohnungen_______________________");
      System.out.println("                    Sie befinden sich aktuell im Jahr "+jahr);
      System.out.println("\n1 - Uebersicht der Ferienwohnungen");
      System.out.println("2 - Erstellen,einsehen und bearbeiten von Kundendaten");
      System.out.println("3 - Belegungsabfrage");
      System.out.println("4 - Buchung von Ferienwohnung");
      System.out.println("5 - Update aller Daten");
      System.out.println("6 - Preisbearbeitung fuer Ferienwohnungen ");
      System.out.println("7 - Jahr aendern");
      System.out.println("8 - Programm beenden");
      System.out.print("\nBitte geben sie ein Menuepunkt an, um fortzufahren : ");
      wahl = Tastatur.liesInt();
      
      switch (wahl) {
        case  1: 
        Modul_ueberblick.uebersicht(Buchungsdaten, umsaetze);
        break;
        case  2: 
        Modul_Kundendaten.menu(Kundendaten, AnzahlKunden, Eintrage);
        break;
        case 3:
          Modul_BuchungUebersicht.uebersicht(jahr,Buchungsdaten);    //Buchungsabfrage freie Plaetze
        break;
        case 4:
        Modul_Buchung.menu(jahr,Buchungsdaten,Kundendaten,fwohnungen,umsaetze);
        break;                          
        case 5:
        try{
          Modul_Update2.write(fwohnungen,Kundendaten,Buchungsdaten,umsaetze,jahr);
          Modul_Update2.read(fwohnungen,Kundendaten,Buchungsdaten,umsaetze,jahr);
          System.out.println("Die Daten wurden erfolgreich aktualisiert!");
          
        }catch(Exception e) {
          System.out.println("Es ist ein Fehler beim Aktualisieren der Daten aufgetreten!");
        }
        break;
        case 6:
        Modul_FwhgAendern.aendern(fwohnungen);
        break;
        case 7:
        System.out.println("Welches Jahr wollen Sie verwenden? ");
        System.out.print("Jahr: ");
        jahr = Tastatur.liesInt();     
        Buchungsdaten = new String[Wohnung][Datum];
        umsaetze = new String[Wohnung][2];
        break;
        case 8:
        System.out.println( "Das Programm wird beendet...");
        break;
        default:
        System.out.println("Fehleingabe");
        
      }
      if (wahl != 7) {
        Modul_Update2.write(fwohnungen,Kundendaten,Buchungsdaten,umsaetze,jahr);
      } // end of if
    }while(wahl != 8);  
    
  } 
}
