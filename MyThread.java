/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rant
 */


public class MyThread extends Thread {
   private int sleep;
    File f = new File("C://Users//rant//Desktop//ja.txt");
      File ff = new File("C://Users//rant//Desktop//va.txt");
   @Override
   public void run() {    
       try {
	     super.run();
	Scanner sc = new Scanner(f);
        Scanner scs = new Scanner(ff);
		while (sc.hasNextLine() || scs.hasNextLine()){
			System.out.println(sc.nextLine()+"\n");
			 System.out.println(scs.nextLine()+"\n");}
                Thread.sleep(sleep);
	     
	}catch (InterruptedException e) {
		e.printStackTrace();
		} catch (FileNotFoundException ex) {
           Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
       }
	}
	public MyThread(int sleep) {
		super();
		this.sleep = sleep;
   }


    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyThread t3 = new MyThread(10);
        MyThread t4 = new MyThread(10);
        t3.start();
        t4.start();
       
       
       

    }

    
    
}
