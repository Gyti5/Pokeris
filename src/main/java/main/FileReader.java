package main;
//perskaitomas pasirinktas failas,

import java.io.File;
import java.util.Scanner;

public class FileReader {
private String path;
@SuppressWarnings("unused")
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
        	  ReformatHand reformatHand = new ReformatHand(sc.nextLine());
              HandChecker handChecker = new HandChecker(reformatHand.getReformatedHand());
              if(handChecker.getWinner()==1) this.winnerP1++;
              if(handChecker.getWinner()==2) this.winnerP2++;
          }
          sc.close();
      }
      catch (Exception e){
      System.out.println(e.getStackTrace());
      }
  }
 
  public int getWinner() {
	  return winnerP1;
  }
}