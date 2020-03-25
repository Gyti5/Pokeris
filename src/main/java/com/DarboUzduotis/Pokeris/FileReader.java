package com.DarboUzduotis.Pokeris;
//perskaitomas pasirinktas failas,

import java.io.File;
import java.util.Scanner;

public class FileReader {
  private String path;
  private int winnerP1 = 0, winnerP2 = 0;

  public FileReader(String path, String name){
      this.path = path;
      read();
  }
  private void read(){
      File file = new File(path);
      try {
          Scanner sc = new Scanner(file, "UTF-8");
          while (sc.hasNextLine()) {
        	  String reformatedValues;
        	  reformatedValues = reformatString(sc.nextLine());
              HandChecker handChecker = new HandChecker(reformatedValues);
              if(handChecker.getWinner()==1) this.winnerP1++;
              if(handChecker.getWinner()==2) this.winnerP2++;
          }
          sc.close();
      }
      catch (Exception e){
      System.out.println(e.getStackTrace());
      }
  }
  /*
   *reformatuotas kortu rankoje sarasas, tam kad butu galima paprasciau isrikiuoti.
   *dauguma pokerio kombinaciju pasimato isrikiavus kortas didejimo tvarka, todel kombinacijos
   *susidaro is gretimu kortu, taip tampa paprasciau aptikti koki stipriausia derini
   *zmogus turi rankoje.
   */
  private String reformatString(String scannerValue) {
	  scannerValue = scannerValue.replace('2', 'm');
	  scannerValue = scannerValue.replace('3', 'l');
	  scannerValue = scannerValue.replace('4', 'k');
	  scannerValue = scannerValue.replace('5', 'j');
	  scannerValue = scannerValue.replace('6', 'i');
	  scannerValue = scannerValue.replace('7', 'h');
	  scannerValue = scannerValue.replace('8', 'g');
	  scannerValue = scannerValue.replace('9', 'f');
	  scannerValue = scannerValue.replace('T', 'e');
	  scannerValue = scannerValue.replace('J', 'd');
	  scannerValue = scannerValue.replace('Q', 'c');
	  scannerValue = scannerValue.replace('K', 'b');
	  scannerValue = scannerValue.replace('A', 'a');

	  return scannerValue;
  }
  public int getWinner() {
	  return winnerP1;
  }
}