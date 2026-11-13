package javaBean;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Metodes {
	static String virknesParbaude(String zinojums, String noklusejums) {
		String virkne;
		do {
			virkne = JOptionPane.showInputDialog(zinojums, noklusejums);
			if(virkne == null)
				return null;
			virkne = virkne.trim();
		} while(!Pattern.matches("^[\\p{L} ]+$", virkne));
		
		return virkne;
	}
	
	static String pkParbaude(String zinojums, String noklusejums) {
		String virkne;
		do {
			virkne = JOptionPane.showInputDialog(zinojums, noklusejums);
			if(virkne == null)
				return null;
			virkne = virkne.trim();
		} while(!Pattern.matches("^[0-9]{6}-[0-9]{5}$", virkne));
		
		return virkne;
	}
	
	static String talrParbaude(String zinojums, String noklusejums) {
		String virkne;
		do {
			virkne = JOptionPane.showInputDialog(zinojums, noklusejums);
			if(virkne == null)
				return null;
			virkne = virkne.trim();
		} while(!Pattern.matches("^[2, 6]{1}[0-9]{7}$", virkne));
		
		return virkne;
	}
	
	static int skaitlaParbaude(String zinojums, int min, int max) {
		String ievade;
		int skaitlis;
		 while(true) {
			 ievade = JOptionPane.showInputDialog(zinojums, min);
			 if(ievade == null)
				 return -1;
			 
			 try {
				 skaitlis = Integer.parseInt(ievade);
				 if(skaitlis < min || skaitlis > max) {
					 JOptionPane.showMessageDialog(null, "Ievadītais skaitlis nav atļautajā intervālā!", 
								"Brīdinājums", JOptionPane.WARNING_MESSAGE); 
				 	continue;
				 }
				 
				 return skaitlis;
			 } catch(NumberFormatException e) {
				 JOptionPane.showMessageDialog(null, "Netika ievadīts derīgs skaitlis!", 
							"Kļūda", JOptionPane.ERROR_MESSAGE);
			 }
		 }
	}
	
	static String generetNr() {
		Random rand = new Random();
		String nr = "";
		char s;
		int c;
		for (int i=0; i<3; i++) {
			s = (char)(rand.nextInt(26) + 'a');
			nr += s;
			c = rand.nextInt(10) + 0;
			nr += c;
		}
		JOptionPane.showMessageDialog(null, "Piešķirts apliecības nr.: "+nr, 
				"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
		return nr;
	}// generetNr
	
	static int meklet(Students[] studentuMas, String aplNr) {
		for (int i=0; i<studentuMas.length; i++) {
			if(studentuMas[i] != null && studentuMas[i].getAplNr().equals(aplNr)) {
				return i;
			}
		}
		JOptionPane.showMessageDialog(null, "Students ar apliecības nr.: "+aplNr+" netika atrasts!", 
				"Brīdinājums", JOptionPane.WARNING_MESSAGE);
		return -1;
	}// meklet
	
	
	public static void select(Students[] studentuMas) {

		String[] SMTH = new String[studentuMas.length];
		
		for(int i = 0; i < studentuMas.length; i++) {
			if(studentuMas[i] != null) {
				SMTH[i] =  
				studentuMas[i].getVards() + " " + studentuMas[i].getUzvards() + " "+ studentuMas[i].getStudProg() + " " +  studentuMas[i].getKurss() + ". kurss";
			}
		}
		
		String selected = (String) JOptionPane.showInputDialog(
	            null,
	            "Studentu saraksts",
	            "Saraksts",
	            JOptionPane.QUESTION_MESSAGE,
	            null,
	            SMTH,
	            
	            SMTH
	    );
	   
	}// select
	
	
	
}