public class Modul_Preisberechnung {
  public static double berechnung(int gesamttage, int fpreis) {
    
    double  rabatt, gpreis ;
    double  rabattw = 0.10;
    if (gesamttage > 8) {
      rabatt = fpreis * gesamttage * rabattw; //0.10;
      gpreis = fpreis * gesamttage - rabatt;
      System.out.printf("Der Preis fuer die Ferienwohnung betraegt %6.2f Euro.",gpreis);
    } 
    else {
      gpreis =fpreis * gesamttage;
      System.out.printf("Der Preis fuer die Ferienwohnung betraegt %6.2f Euro.",gpreis);
    } 
    
    return gpreis;
  }
}
       
       
     