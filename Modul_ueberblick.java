/**
  *
  * Klasse: FS 63
  * 
  * Author: Nico Fischer, Lukas Wuestenhagen, Daniel Schoenke, Jony Nchamadi
  * AS-Projekt
  * Programmbeschreibung: Verwaltungssystem fuer Ferienwohnungen  
  *
  * Modul_ueberblick by Daniel Schoenke
  * Dieses Modul bietet einen Ueberblick ueber die jaehrliche Auslastung und die jaehrlichen Einnahmen der aller Ferienwohnungen
  * Es wird dazu eine Tabelle angezeigt
  */ 
  
public class Modul_ueberblick {
  
  public static void uebersicht(String Buchungsdaten[][], String umsaetze[][]) {
    
    String s;
    int x;			//Hilfsvariable
    int y = 0;		//Hilfsvariable
    float z = 0;	//Hilfsvariable
    int auslas[] = new int[Buchungsdaten.length]; //Hilfsarray
    
	//Tabellenkopf
    System.out.printf("%4s | %4s | %7s | %12s", s="ID", s="Tage", s="Prozent", s="Jahresumsatz");
    System.out.printf("\n%s" , s="-------------------------------------");
    
	//Zählschleife, um die belgten Tage auszuzaehlen
    for (int i=0; i < Buchungsdaten.length ; i++ ) {
      x = 0;
      Buchungsdaten[i][0] = String.valueOf(i+1);
      for (int j=1; j < Buchungsdaten[0].length ; j++ ) {
        
        if (Buchungsdaten[i][j] != null) { // Abfangen von Fehlern, falls ein Array leer ist
         
          x = x + 1;	// Anzahl der belegten Tage fuer die Wohnung i
          y = y + 1;	// Summe aller belegten Tage
          
        } // end of if
        
      } // end of for
      auslas[i] = x;
      String abc = umsaetze[i][1];
      z = z + Float.parseFloat(abc);
    }                     
    
	//Tabelle
    for (int i=0; i < auslas.length ; i++ ) {
      
      System.out.printf("\n%4d | %4d | %5.2f %% | %6.2f Euro" , (i+1), auslas[i], (((float)auslas[i]*100)/(float)(Buchungsdaten[0].length)), Float.parseFloat(umsaetze[i][1])) ;
      
    } // end of for
    System.out.printf("\n%s" , s="-------------------------------------");
    System.out.printf("\nSumme| %4d | %5.2f %% | %6.2f Euro" , y, (float)y*100/(float)(Buchungsdaten.length * Buchungsdaten[0].length), z);
    
    System.out.printf("\n\n\n\n");
  }
}
