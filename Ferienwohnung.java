/**
  *
  * Klasse: FS 63
  * 
  * Author: Nico Fischer, Lukas Wuestenhagen, Daniel Schoenke, Jony Nchamadi
  * AS-Projekt
  * Programmbeschreibung: Verwaltungssystem für Ferienwohnungen  
  * 
  */ 

public class Ferienwohnung {
  
  public static void main(String[] args) {
    
    int wahl;
    int wahl2;
    boolean wdh = true;
    int AnzahlKunden = 50;  // Modul Kundendaten
    String Kundendaten [] [] = new String [AnzahlKunden][3]; // Modul Kundendaten ArrayParameter
    
    System.out.println("____________________Managementsystem fuer Ferienwohnungen_______________________");
    do{
      //Modul_Update('g',......);
      System.out.println("\n1 - Uebersicht der Ferienwohnungen");
      System.out.println("2 - Erstellen,einsehen, und bearbeiten von Kundendaten");
      System.out.println("3 - Buchung von Ferienwohnung");
      System.out.println("4 - Preisberechnung (Kunden)");
      System.out.println("5 - Update aller Daten");
      System.out.println("6 - Preisbearbeitung für Ferienwohnungen ");
      System.out.println("7 - Programm beenden");
      System.out.print("\nBitte geben sie ein Menuepunkt an, um fortzufahren : ");
      wahl = Tastatur.liesInt();
      
      switch (wahl) {
        case  1: 
        System.out.println( "1 - Ausgabe einer bzw aller Auslastung(en) der Ferienwohnung(en)  "); // -> Modul Uebersicht
        
        break;
        case  2: 
          Modul_Kundendaten.main(args,Kundendaten);
          // Modul_Kundendaten.Menu(Kundendaten,AnzahlKunden);
          // Kundendaten werden geladen....
        break;
        case 3:
        // Module_Buchung.main();
        
        break;
        case 4:
        // ->Modul_KPreisberechnung.main();
        break;                             
        case 5:
        // Modul_Update.main();
        break;
        case 6:
        // Modul_FPreisbearbeitung.main();
        break;
        case 7:
        System.out.println( "Beenden des Programms...");
        break;
        default:
        System.out.println("Fehleingabe");
        
      } 
    }while(wahl != 7);  
    
  } 
}
  

