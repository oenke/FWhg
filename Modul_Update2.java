 import java.io.*;
public class Modul_Update2 {
    
  public static void update(char opt,String fwhg[][],String kdata[][],String bdata[][]){
    switch (opt) {
      case 'g': 
      BufferedReader br = null;
      try {
        br = new BufferedReader(new FileReader(new File("fwohnungen.txt")));
        String line = null;
        for (int i=0;(line = br.readLine()) != null ;i++ ) {
          String[] parts = line.split(";"); 
          for (int l = 0;l<fwhg[i].length;l++ ) {
            fwhg[i][l] = parts[l];
          } // end of for
        } // end of for
      } catch(FileNotFoundException e) {
        e.printStackTrace();
      } catch(IOException e) {
        e.printStackTrace();
      }
      
      br = null;
      try {
        br = new BufferedReader(new FileReader(new File("kundendaten.txt")));
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
        br = new BufferedReader(new FileReader(new File("buchungsdaten.txt")));
        String line = null;
        for (int i=0;(line = br.readLine()) != null ;i++ ) {
          String[] parts = line.split(";"); 
          whg = Integer.parseInt(parts[0]);
          tag = Integer.parseInt(parts[1]); 
          bdata[whg][tag] = parts[2];
        } // end of for
      } catch(FileNotFoundException e) {
        e.printStackTrace();
      } catch(IOException e) {
        e.printStackTrace();
      }   
      break;
      case 's': 
      try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("fwohnungen.txt"));
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
        BufferedWriter writer = new BufferedWriter(new FileWriter("kundendaten.txt"));
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
        BufferedWriter writer = new BufferedWriter(new FileWriter("buchungsdaten.txt"));
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
      
      break;
      default: 
      System.out.println("Fehler!");
      
    } // end of switch
  } 
  
} // end of class Modul_Update2