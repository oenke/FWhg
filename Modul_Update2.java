import java.io.*;
/**
  *
  * Klasse: FS 63
  * 
  * Author: Nico Fischer, Lukas Wuestenhagen, Daniel Schoenke, Jony Nchamadi
  * AS-Projekt
  * Programmbeschreibung: Verwaltungssystem fuer Ferienwohnungen  
  * 
  */ 
public class Modul_Update2 {
  public static void checkDB(int jahr){
    String data1 = "db/umsaetze_"+jahr+".txt";
    File f = new File(data1);
    if(!f.exists()) { 
      try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(data1));
        for (int i = 0; i < 10; i++) {
          writer.write((i+1)+";");
          writer.write("0;");
          writer.newLine(); 
        }
        writer.close();
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
    
  }
  public static void getDbANZ(int dbANZ[]){
    String dataFwhg = "db/fwohnungen.txt";
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader(new File(dataFwhg)));
      String line = null;
      line = br.readLine();
      dbANZ[0] = Integer.valueOf(line);
    } catch(FileNotFoundException e) {
      e.printStackTrace();
    } catch(IOException e) {
      e.printStackTrace();
    }
    
  }
  
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