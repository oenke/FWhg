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

public class Modul_Datumrechner {
  public static int Datum(int jahr) {
    int tag = 0, monat = 0; //Deklarationsteil
    boolean fehler = false, tagpasstzumonat = false;
    char weitermachen;
    
    do {
      System.out.println("Jahr: " + jahr); //Schreibt den gegebenen Text
      
      while (fehler == false) { 
        System.out.print("Bitte geben Sie den Monat ein: "); //Schreibt den gegebenen Text 
        monat = Tastatur.liesInt(); //Setzt zahl1 auf den Ausgelesen Wert von der Tastatur
        if (monat >= 1 && monat <= 12) {
          fehler = true;
        } // end of if
        else {
          System.out.print("Die Eingabe ist Falsch, bitte wiederholen.\n"); //Schreibt den gegebenen Text 
        } // end of if-else
      } // end of while
      fehler = false;
      
      while (fehler == false) { 
        System.out.print("Bitte geben Sie den Tag ein: "); //Schreibt den gegebenen Text 
        tag = Tastatur.liesInt(); //Setzt zahl1 auf den Ausgelesen Wert von der Tastatur
        if (tag >= 1 && tag <= 31) {
          switch (monat) {
            case  1: 
            if (tag <= 31) {
              tagpasstzumonat = true; 
            } // end of if
            break;
            case  2: 
            if (tag == 29) { //FUER FEBRUAR NOCH SCHALTJAHRE BERECHNEN
              if (jahr % 4 == 0) {
                if (jahr % 100 == 0) {
                  if (jahr % 400 == 0) {
                    tagpasstzumonat = true;
                  } // end of if
                } // end of if
                else {
                  tagpasstzumonat = true;
                } // end of if-else
              } // end of if 
            } // end of if
            else if (tag <= 28) {
              tagpasstzumonat = true;   
            } // end of if-else
            break;
            case  3: 
            if (tag <= 31) {
              tagpasstzumonat = true;  
            } // end of if
            break;
            case  4: 
            if (tag <= 30) { 
              tagpasstzumonat = true;
            } // end of if
            break;
            case  5: 
            if (tag <= 31) {
              tagpasstzumonat = true;
            } // end of if
            break;
            case  6: 
            if (tag <= 30) {
              tagpasstzumonat = true;
            } // end of if
            break;
            case  7: 
            if (tag <= 31) {
              tagpasstzumonat = true;  
            } // end of if
            break;
            case  8: 
            if (tag <= 31) {
              tagpasstzumonat = true;  
            } // end of if
            break;
            case  9: 
            if (tag <= 30) {
              tagpasstzumonat = true;
            } // end of if
            break;
            case  10: 
            if (tag <= 31) {
              tagpasstzumonat = true;
            } // end of if
            break;
            case  11: 
            if (tag <= 30) {
              tagpasstzumonat = true; 
            } // end of if
            break;
            case  12: 
            if (tag <= 31) {
              tagpasstzumonat = true;  
            } // end of if
            break;
            //System.out.print("Die Eingabe ist Falsch, bitte wiederholen.\n");
          } // end of switch
          fehler = true; 
        } // end of if
        else {
          System.out.print("Die Eingabe ist Falsch, bitte wiederholen.\n"); //Schreibt den gegebenen Text 
        } // end of if-else
      } // end of while
      fehler = false;
      
      if (tag < 10) {
        System.out.printf("Das Datum lautet 0%1d.",tag);
      } // end of if
      else {
        System.out.printf("Das Datum lautet %2d.",tag);
      } // end of if-else
      if (monat < 10) {
        System.out.printf("0%1d.%4d\n",monat,jahr); //Schreibt den gegebenen Text
      } // end of if
      else {
        System.out.printf("%2d.%4d\n",monat,jahr); //Schreibt den gegebenen Text
      } // end of if-else
    } while (tagpasstzumonat == false); // end of do-while
    
    GregorianCalendar beliebigesDatum = new GregorianCalendar(jahr,monat-1,tag,0,0,0);
    int kalendertag =  beliebigesDatum.get( Calendar.DAY_OF_YEAR );
    
    return kalendertag;
  } // end of datum 
  
  //Funktion um das gewaehlte Jahr auf ein Schaltjahr zu pruefen
  public static int schaltjahr(int jahr)  {
    int Datum;
    if (new GregorianCalendar().isLeapYear(jahr)==true) {
    Datum = 366; }
    else {
      Datum = 365;  
    } // end of if-else 
    return(Datum);
  }   
} 