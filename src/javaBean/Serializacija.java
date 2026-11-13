package javaBean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class Serializacija {
	
	
	
	// ========== Serializācija ==========
	static void Serializet(Students[] studentuMas, String fName) {
		try {
			FileOutputStream fos = new FileOutputStream(fName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(studentuMas);
			oos.close();
			
		}catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Netika atrasts fails!" + e, "Kļūda", JOptionPane.ERROR_MESSAGE);
		} catch(Exception io) {
			JOptionPane.showMessageDialog(null, "Kļūda serializējot datus!" + io, "Kļūda", JOptionPane.ERROR_MESSAGE);
		}
	}// Serializacija
	
	
	
	
	
	
	
	// ========== Deserializēt ==========
	static Students[] Deserializet(String fName) {
		Students[] studentuMasivs = new Students[100];
		
		try {
			FileInputStream fis = new FileInputStream(fName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			studentuMasivs = (Students[]) ois.readObject();
			ois.close();
		} catch(IOException io) {
			JOptionPane.showMessageDialog(null, "Kļūda nolasot datus!" + io, "Kļūda", JOptionPane.ERROR_MESSAGE);
		} catch(ClassNotFoundException c) {
			JOptionPane.showMessageDialog(null, "Netika atrasta klase!" + c, "Kļūda", JOptionPane.ERROR_MESSAGE);
		}
		return studentuMasivs;
	}// Deserializet
	
	
	
	
}// class
