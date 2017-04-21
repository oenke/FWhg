/**
  *
  * Klasse: FS 63
  * 
  * Author: Nico Fischer, Lukas Wuestenhagen, Daniel Schoenke, Jony Nchamadi
  * AS-Projekt
  * Programmbeschreibung: Verwaltungssystem für Ferienwohnungen  
  * 
  */ 

public class Modul_FwhgAendern {
  
  public static String[][] aendern(String fwhg[][]) {
    
    int wahl = 0; 
    String s;
    
    System.out.printf("%3s | %10s | %8s" , s="ID", s="Tagespreis", s="Groesse");
    System.out.printf("\n%s%s%s%s" , s="-------",s,s,s);
    
    for (int i = 0; i <= 9 ; i++ ) {
      
      System.out.printf("\n%3s | %10s | %8s" , s=fwhg[i][0], s=fwhg[i][1] + " Euro", s=fwhg[i][2] + " qm");
      //System.out.print("\n" + fwhg[i][0] + " " + fwhg[i][1] + " " + fwhg[i][2]); 
      
    } // end of for
    
    System.out.println("\nWelche Ferienwohnung möchten Sie aender? ");
    
    wahl = Tastatur.liesInt();
    
    System.out.println("Geben Sie bitte den neuen Preis ein: "); 
    
    fwhg[wahl][1] = String.valueOf(Tastatur.liesInt());
    
    System.out.println("Geben Sie bitte die neue Groeße ein: "); 
    
    fwhg[wahl][2] = String.valueOf(Tastatur.liesInt());
    
    return fwhg;
    
    
  }
}
