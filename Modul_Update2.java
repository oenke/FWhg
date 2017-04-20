 import java.io.*;
public class Modul_Update2 {
  
  public static void main(String[] args) {
    /* int pkat = 3;
    int fanz = 4;
    int kanz = 3;
    String fwohnungen[][] = new String[pkat][fanz];
    String kundendaten[][] = new String[50][3]; 
    update('g',fwohnungen,fanz,kundendaten,kanz);
    
    fwohnungen[0][0] = "Z";
    fwohnungen[1][0] = "O";
    fwohnungen[0][1] = "10";
    fwohnungen[1][3] = "20";
    
    update('s',fwohnungen,fanz,kundendaten,kanz);
    
    
     */
    
    
  } // end of main
  
  public static void update(char opt,String fwhg[][],int fanz,String kdata[][],int kanz){
    switch (opt) {
      case 'g': 
      BufferedReader br = null;
      try {
        br = new BufferedReader(new FileReader(new File("fwohnungen.txt")));
        String line = null;
        for (int i=0;(line = br.readLine()) != null ;i++ ) {
          String[] parts = line.split(";"); 
          for (int l = 0;l<fanz;l++ ) {
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
          for (int l = 0;l<kanz;l++ ) {
            kdata[i][l] = parts[l];
          } // end of for
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
          writer.newLine(); 
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
          writer.newLine(); 
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
