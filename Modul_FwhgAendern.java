/**
  *
  * Klasse: FS 63
  * 
  * Author: Nico Fischer, Lukas Wuestenhagen, Daniel Schoenke, Jony Nchamadi
  * AS-Projekt
  * Programmbeschreibung: Verwaltungssystem fuer Ferienwohnungen 
  * 
  * Modul_FhwgAendern by Daniel Schoenke
  * Dieses Modul bietet die Moeglichkeit den Tagespreis bzw. die Groesse einer Ferienwohnung zu aendern.
  * Am Anfang wird dazu als Uebersicht eine Tabelle der Wohnung mit Tagespreisen und Groesse ausgegeben.
  * Anschliessend hat der Benutzer die Moeglichkeit eine Wohnung auszuwaehlen und anzupassen.
  * Fehleingabe wie eine falsche ID, negative Preise und Groessen werden abgefange.
  *
  */ 

public class Modul_FwhgAendern {
  
  public static void aendern(String fwhg[][]) {
    
    int wahl = 0; 
    String s;
    
    System.out.println("\n____________________Managementsystem fuer Ferienwohnungen_______________________");
    System.out.println("                        Aendern der Ferienwohnungen\n");
    
    //Tabellenkopf
    System.out.printf("%3s | %10s | %8s" , s="ID", s="Tagespreis", s="Groesse");
    System.out.printf("\n%s%s%s%s" , s="-------",s,s,s);
    
    // Ausgabe einer Tabelle
    for (int i = 0; i <= 9 ; i++ ) {
      
      System.out.printf("\n%3s | %8.2f Euro | %6.2f qm" , s=fwhg[i][0], Float.parseFloat(fwhg[i][1]), Float.parseFloat(fwhg[i][2]));
      //System.out.print("\n" + fwhg[i][0] + " " + fwhg[i][1] + " " + fwhg[i][2]); 
      
    } // end of for
    
    //Schleife zum Abfangen von Fehleingaben und setzen neuer Werte
    boolean wdh = false;
    do {
      wdh = false;
      System.out.println("\n\nWelche Ferienwohnung moechten Sie aendern? ");
      System.out.println("Zum abbrechen (0) druecken");
      
      wahl = (Tastatur.liesInt() -1);
      float x;
      if (wahl >= 0 && wahl < 10) { //Abfangen falscher Wohnungs-ID
        do {
          x = 0;
          wdh = false;
          System.out.println("Geben Sie bitte den neuen Preis ein: "); 
          x = Tastatur.liesFloat();
          wdh = Modul_FwhgAendern.fehler(x); //Abfangen der Eingabe einer negativen Zahl
        } while (wdh==true); // end of do-while
         fwhg[wahl][1] = String.valueOf(x); //Setzen des neunen Werts
		 
        do {
          x = 0;
          wdh = false;
          System.out.println("Geben Sie bitte die neue Groesse ein: ");
          x = Tastatur.liesFloat();
          wdh = Modul_FwhgAendern.fehler(x); //Abfangen der Eingabe einer negativen Zahl
        } while (wdh==true); // end of do-while 
        fwhg[wahl][2] = String.valueOf(x); //Setzen des neunen Werts
        
      } // end of if
      
      else if (wahl < 0) { //Programm laueft "normal" weiter
      }
      else {
        
        System.out.println("Fehler bei der Eingabe, bitte versuchen Sie es erneut.");
        wdh = true;
        
      } // end of if-else
      
    } while (wdh==true); // end of do-while
    
  }
  
  public static boolean fehler(double x) {
    boolean wdh = false;
    if (x < 0) {
      System.out.println("Fehleingabe");
      wdh = true;
    } // end of if
    else {
      wdh = false;
    } // end of if-else
    
    return wdh;
  }
  
}