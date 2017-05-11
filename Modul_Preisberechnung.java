public class Modul_Preisberechnung {
  public static void menu(int fwohnungZ,int gesamttage) {
    
    double  rabatt, gpreis ;
    double fwohnung []  = { 5,5,5,5,6,6,7,7,7,7};
    double  rabattw = 0.10;
    /*System.out.println("Fuer welche Wohnung soll der Preis berechnet werden? Geben sie die Wohnungsnummer an (zwischen 1-10) an! "); 
    System.out.print("Wohnungsnummer:");
    fwohnungZ = Tastatur.liesInt ();
    
    System.out.println( "Gesamttage? ");
    gesamttage = Tastatur.liesInt ();*/
    
    if (gesamttage > 8) {
      rabatt = fwohnung [fwohnungZ-1]* gesamttage * rabattw; //0.10;
      gpreis = fwohnung [fwohnungZ-1]* gesamttage - rabatt;
      System.out.printf("Der Preis fuer die Ferienwohnung beträgt %6.2f Euro.",gpreis);
    } 
    else {
      gpreis =fwohnung [fwohnungZ-1]* gesamttage;
      System.out.printf("Der Preis fuer die Ferienwohnung beträgt %6.2f Euro.",gpreis);
    } // end of if-else
  }
}
       
       
     