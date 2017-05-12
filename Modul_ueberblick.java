/**
  *
  * Klasse: FS 63
  * 
  * Author: Nico Fischer, Lukas Wuestenhagen, Daniel Schoenke, Jony Nchamadi
  * AS-Projekt
  * Programmbeschreibung: Verwaltungssystem fuer Ferienwohnungen  
  * Modul zur Anzeige eines Ueberblicks der Auslastung und Einnahmen der Ferienwohnungen
  */ 
  
public class Modul_ueberblick {
  
  public static void uebersicht(String Buchungsdaten[][], String umsaetze[][]) {
    
    String s;
    int x;
    int y = 0;
    float z = 0;
    int auslas[] = new int[Buchungsdaten.length];
    
    System.out.printf("%4s | %4s | %7s | %12s", s="ID", s="Tage", s="Prozent", s="Jahresumsatz");
    System.out.printf("\n%s" , s="-------------------------------------");
    
    for (int i=0; i < Buchungsdaten.length ; i++ ) {
      x = 0;
      Buchungsdaten[i][0] = String.valueOf(i+1);
      for (int j=1; j < Buchungsdaten[0].length ; j++ ) {
        
        if (Buchungsdaten[i][j] != null) {
          
          x = x + 1;
          y = y + 1;
          
          
        } // end of if
        
      } // end of for
      auslas[i] = x;
      String abc = umsaetze[i][1];
      z = z + Float.parseFloat(abc);
    }                     
    
    for (int i=0; i < auslas.length ; i++ ) {
      
      System.out.printf("\n%4d | %4d | %5.2f %% | %6.2f Euro" , (i+1), auslas[i], (((float)auslas[i]*100)/(float)(Buchungsdaten[0].length)), Float.parseFloat(umsaetze[i][1])) ;
      
    } // end of for
    System.out.printf("\n%s" , s="-------------------------------------");
    System.out.printf("\nSumme| %4d | %5.2f %% | %6.2f Euro" , y, (float)y*100/(float)(Buchungsdaten.length * Buchungsdaten[0].length), z);
    
    System.out.printf("\n\n\n\n");
  }
}
