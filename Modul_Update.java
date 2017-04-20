 import java.io.*;
public class Modul_Update {

  public static void main(char opt,String fwhg[][],int fanz,String kdata[][],int kanz){
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
        
        break;
      default: 
        System.out.println("Fehler!");
        
    } // end of switch
  } 

  }