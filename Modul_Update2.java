import java.io.*;
/**
  *
  * Klasse: FS 63
  * 
  * Author: Nico Fischer, Lukas Wuestenhagen, Daniel Schoenke, Jony Nchamadi
  * AS-Projekt
  * Programmbeschreibung: Verwaltungssystem fuer Ferienwohnungen
  * Modul: Update
  * Modulbeschreibung: Lesen, Schreiben und Erstellen von Daten in Textdateien  
  * 
  */ 
public class Modul_Update2 {
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //Modul um zu ueberpruefen ob Datei existiert, falls nicht diese anlegen
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  public static void checkDB(int jahr){           //Methodenkopf mit Parameteruebergabe
    String data1 = "db/umsaetze_"+jahr+".txt";
    File f = new File(data1);                     //
    if(!f.exists()) {                             //Abfrage ob Datei nicht existiert
      try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(data1));   //BufferedWriter auf Datei erstellen
        for (int i = 0; i < 10; i++) {                                       //For Schleife um Textdatei zu befüllen
          writer.write((i+1)+";");                                           //Schreiben einer Zeile
          writer.write("0;");
          writer.newLine();                                                  //Neue Zeile anfangen
        }
        writer.close();                                                      //Writer schließen
      }
      catch (IOException e) {
        e.printStackTrace();                                                 //Fehlerabfang bei Input/Output
      }
    } 
  }
  
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Modul um die erste Zeile aus einer Textdatei zu lesen und zu speichern
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  public static void getDbANZ(int dbANZ[]){                      //Methodenkopf mit Parameterübergabe
    String dataFwhg = "db/fwohnungen.txt";                       //Festlegen eines Dateipfades auf eine Variable
    BufferedReader br = null;                                    //Deklaration eines neuen Readers
    try {
      br = new BufferedReader(new FileReader(new File(dataFwhg)));                                //Reader auf eine Datei setzen
      String line = null;                                                                         //Stringvariable initialisieren
      line = br.readLine();                                                                       //Variable line auf Zeile 1 setzen
      dbANZ[0] = Integer.valueOf(line);                                                           //Speichern des Textes in einem Array
    } catch(FileNotFoundException e) {
      e.printStackTrace();
    } catch(IOException e) {
      e.printStackTrace();
    }
    
  }
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Modul um alle Textdateien in Arrays zu lesen
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  public static void read(String fwhg[][],String kdata[][],String bdata[][],String umsaetze[][],int jahr){
    String dataFwhg = "db/fwohnungen.txt", dataKunden = "db/kundendaten.txt", dataBuchung = "db/buchungsdaten_"+jahr+".txt", dataUmsaetze = "db/umsaetze_"+jahr+".txt";
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader(new File(dataFwhg)));
      String line = null;
      line = br.readLine();
      for (int i=0;i < fwhg.length;i++ ) {
        line = br.readLine();
        String[] parts = line.split(";"); 
        for (int l = 0;l<fwhg[i].length;l++ ) { 
          fwhg[i][l] = parts[l];
        } // end of for
      } // end of for
    } catch(FileNotFoundException e) {
      e.printStackTrace();
    }catch(IOException e) {
      e.printStackTrace();
    }  
    
    br = null;
    try {
      br = new BufferedReader(new FileReader(new File(dataKunden)));
      String line = null;
      for (int i=0;(line = br.readLine()) != null ;i++ ) {
        String[] parts = line.split(";"); 
        for (int l = 0;l<kdata[i].length;l++ ) { 
          kdata[i][l] = parts[l];
        } // end of for
      } // end of for
    } catch(FileNotFoundException e) {
      e.printStackTrace();
    } catch(IOException e) {
      e.printStackTrace();
    } 
    
    br = null;
    try {
      int whg;
      int tag;
      br = new BufferedReader(new FileReader(new File(dataBuchung)));
      String line = null;
      for (int i=0;(line = br.readLine()) != null ;i++ ) {
        String[] parts = line.split(";"); 
        whg = Integer.parseInt(parts[0]);
        tag = Integer.parseInt(parts[1]); 
        bdata[whg][tag] = parts[2];
      } // end of for
    } catch(FileNotFoundException e) {
      //e.printStackTrace();
      System.out.println("Fuer das Jahr "+jahr+" bestehen bisher noch keine Buchungen!");
    } catch(IOException e) {
      //e.printStackTrace();
    }
    
    br = null;
    try {
      br = new BufferedReader(new FileReader(new File(dataUmsaetze)));
      String line = null;
      for (int i=0;(line = br.readLine()) != null ;i++ ) {
        String[] parts = line.split(";"); 
        for (int l = 0;l<umsaetze[i].length;l++ ) { 
          umsaetze[i][l] = parts[l];
        } // end of for
      } // end of for
    } catch(FileNotFoundException e) {
      e.printStackTrace();
    } catch(IOException e) {
      e.printStackTrace();
    }  
    
  }
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Modul um die Arrays in Textdateien zu schreiben
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  public static void write(String fwhg[][],String kdata[][],String bdata[][],String umsaetze[][],int jahr){
    String dataFwhg = "db/fwohnungen.txt", dataKunden = "db/kundendaten.txt", dataBuchung = "db/buchungsdaten_"+jahr+".txt",dataUmsaetze = "db/umsaetze_"+jahr+".txt";
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(dataFwhg));
      writer.write(String.valueOf(fwhg.length));
      writer.newLine();
      for (int i = 0; i < fwhg.length; i++) {
        for (int j = 0; j < fwhg[i].length; j++) {
          if (fwhg[i][j] != null) {
            writer.write(fwhg[i][j] + ";");  
          } // end of if 
        }
        if (fwhg[i][1] != null) {
          writer.newLine(); 
        } // end of if
      }
      writer.close();
      
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(dataKunden));
      for (int i = 0; i < kdata.length; i++) {
        for (int j = 0; j < kdata[i].length; j++) {
          if (kdata[i][j] != null) {
            writer.write(kdata[i][j] + ";"); 
          } // end of if  
        } 
        if (kdata[i][1] != null) {
          writer.newLine(); 
        } // end of if
      }
      writer.close();
      
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(dataBuchung));
      for (int i = 0; i < bdata.length; i++) {
        for (int j = 0; j < bdata[i].length; j++) {
          if (bdata[i][j] != null) {
            writer.write(i + ";");
            writer.write(j + ";");
            writer.write(bdata[i][j] + ";");
          } // end of if  
          if (bdata[i][j] != null) {
            writer.newLine(); 
          } // end of if
        } 
        
      }
      writer.close();
      
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(dataUmsaetze));
      for (int i = 0; i < umsaetze.length; i++) {
        for (int j = 0; j < umsaetze[i].length; j++) {
          if (fwhg[i][j] != null) {
            writer.write(umsaetze[i][j] + ";");  
          } // end of if 
        }
        if (fwhg[i][1] != null) {
          writer.newLine(); 
        } // end of if
      }
      writer.close();
      
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    
  }
  
  
  
} // end of class Modul_Update2