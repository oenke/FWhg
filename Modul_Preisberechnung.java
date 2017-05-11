public class Modul_Preisberechnung {
  public static double berechnung(int gesamttage, int fpreis) {
    
    double  rabatt, gpreis ;
    double  rabattw = 0.10;
    if (gesamttage > 8) {
      rabatt = fwohnung [fwohnungZ-1]* gesamttage * rabattw; //0.10;
      gpreis = fwohnung [fwohnungZ-1]* gesamttage - rabatt;
      System.out.printf("Der Preis fuer die Ferienwohnung beträgt %6.2f Euro.",gpreis);
    } 
    else {
      gpreis =fwohnung [fwohnungZ-1]* gesamttage;
      System.out.printf("Der Preis fuer die Ferienwohnung beträgt %6.2f Euro.",gpreis);
    } 
    
    return gpreis;
  }
}
       
       
     